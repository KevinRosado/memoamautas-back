package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.domain.CursoMatriculado;
import com.nixvoid.memoamautas.dto.courses.*;
import com.nixvoid.memoamautas.dto.user.Persona;
import com.nixvoid.memoamautas.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CursoRepositoryImpl implements CursoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CursoEtiquetado obtenerCursos(Etiqueta etiqueta) {
        CursoEtiquetado cursoEtiquetado = new CursoEtiquetado();
        String sql = "with t2 as (with t1 as (select id_etiqueta, tipo_etiqueta, nombre_etiqueta from memo_amautas.etiqueta where nombre_etiqueta = ?) " +
                "select etiqueta_curso.cod_curso, t1.tipo_etiqueta, t1.nombre_etiqueta from t1 " +
                "inner join  memo_amautas.etiqueta_curso on t1.id_etiqueta = etiqueta_curso.cod_etiqueta) " +
                "select nombre_curso, id_curso, t2.tipo_etiqueta, t2.nombre_etiqueta from t2 " +
                "inner join memo_amautas.curso on t2.cod_curso = curso.id_curso";
        List<Curso> cursos = new ArrayList<>();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, etiqueta.getNombre());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Curso c = new Curso();
                cursoEtiquetado.setValor_etiqueta(resultado.getString("nombre_etiqueta"));
                cursoEtiquetado.setTipo_etiqueta(resultado.getString("tipo_etiqueta"));
                c.setNombre(resultado.getString("nombre_curso"));
                c.setId(resultado.getString("id_curso"));
                cursos.add(c);
            }
            cursoEtiquetado.setCursos(cursos);
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cursoEtiquetado;
    }

    @Override
    public Curso obtenerCursoDetails(Curso curso) {
        Curso curso1 = new Curso();
        String sql = "with t1 as (select id_curso, nombre_curso, creditos, descripcion from memo_amautas.curso where nombre_curso = ?) " +
                "select modulo.*, t1.* from t1 " +
                "inner join memo_amautas.modulo on modulo.cod_curso = t1.id_curso";
        String sql1 = "select id_sesion, cod_modulo, tema_sesion, orden from memo_amautas.sesion";
        List<Modulo> modulos = new ArrayList<>();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, curso.getNombre());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Modulo m = new Modulo();
                List<Sesion> sesions = new ArrayList<>();
                curso1.setId(resultado.getString("id_curso"));
                curso1.setNombre(resultado.getString("nombre_curso"));
                curso1.setCreditos(resultado.getInt("creditos"));
                curso1.setDescripcion(resultado.getString("descripcion"));
                m.setId(resultado.getString("id_modulo"));
                m.setTema(resultado.getString("tema_modulo"));
                m.setOrden(resultado.getInt("orden"));
                m.setSesiones(sesions);
                modulos.add(m);
            }
            resultado.close();
            PreparedStatement ps = cn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                for(Modulo m: modulos){
                    if(m.getId().equals(rs.getString("cod_modulo"))){
                        Sesion s = new Sesion();
                        s.setId(rs.getString("id_sesion"));
                        s.setTema(rs.getString("tema_sesion"));
                        s.setOrden(rs.getInt("orden"));
                        s.setId_modulo(rs.getString("cod_modulo"));
                        m.getSesiones().add(s);
                    }
                }
            }
            rs.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        curso1.setModulos(modulos);
        return curso1;
    }

    @Override
    public Curso inscribirCurso(CursoMatriculado cursoMatriculado) {
        Curso cursoDetails = new Curso();
        String sql = "insert into memo_amautas.curso_matriculado (cod_curso, cod_persona, fecha_inscripcion, progreso_curso) values (?,?,?,?);";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, cursoMatriculado.getId_curso());
            sentencia.setString(2, cursoMatriculado.getId_persona());
            sentencia.setString(3, cursoMatriculado.getFecha_inscripcion().toString());
            sentencia.setString(4, cursoMatriculado.getProgreso_curso().toString());
            ResultSet resultado = sentencia.executeQuery();
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        cursoDetails.setId(cursoMatriculado.getId_curso());
        cursoDetails.setNombre(cursoMatriculado.getNombre_curso());
        return obtenerCursoDetails(cursoDetails);
    }

    @Override
    public Curso obtenerInfo(Curso curso) {
        Curso cursoInfo =  new Curso();
        List<Persona> profesores = new ArrayList<>();
        List<Modulo> modulos = new ArrayList<>();
        String sql = "with t2 as (with t1 as (select creditos, descripcion, nombre_curso, id_curso from memo_amautas.curso where id_curso = ?) " +
                "select t1.*, curso_matriculado.cod_persona from t1 " +
                "inner join memo_amautas.curso_matriculado on t1.id_curso = curso_matriculado.cod_curso) " +
                "select t2.*, persona.nombre, persona.ape_pat, persona.ape_mat from t2 " +
                "inner join memo_amautas.persona on t2.cod_persona = persona.id_persona ";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, curso.getId());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Persona profesor = new Persona();
                cursoInfo.setId(resultado.getString("id_curso"));
                cursoInfo.setNombre(resultado.getString("nombre_curso"));
                cursoInfo.setCreditos(resultado.getInt("creditos"));
                cursoInfo.setDescripcion(resultado.getString("descripcion"));
                profesor.setId(resultado.getString("cod_persona"));
                profesor.setNombre(resultado.getString("nombre"));
                profesor.setApe_pat(resultado.getString("ape_pat"));
                profesor.setApe_mat(resultado.getString("ape_mat"));
                profesores.add(profesor);
            }
            cursoInfo.setModulos(modulos);
            cursoInfo.setProfesores(profesores);
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cursoInfo;
    }

}
