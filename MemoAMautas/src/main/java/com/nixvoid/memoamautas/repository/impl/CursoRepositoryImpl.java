package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import com.nixvoid.memoamautas.exception.ApiRequestException;
import com.nixvoid.memoamautas.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;

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
        String sql = "with t1 as (select id_curso, nombre_curso, creditos from memo_amautas.curso where nombre_curso = ?) " +
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
    public Modulo obtenerSesiones(Modulo modulo) {
        return null;
    }
}
