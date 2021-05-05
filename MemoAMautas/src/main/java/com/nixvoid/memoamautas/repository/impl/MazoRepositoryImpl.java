package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.dto.cards.Mazo;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;
import com.nixvoid.memoamautas.dto.user.Persona;
import com.nixvoid.memoamautas.repository.MazoRepository;
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
public class MazoRepositoryImpl implements MazoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Mazo> getByAutor(Persona persona) {
        return null;
    }

    @Override
    public List<Mazo> obtenerMazos(Curso curso) {
        return null;
    }

    @Override
    public List<Mazo> getByCurso(Curso curso) {
        List<Mazo> mazos = new ArrayList<>();
        String sql = "with t3 as (with t2 as (with t1 as (select nombre_curso, id_curso from memo_amautas.curso where id_curso = ?) " +
                "select mazo_general.cod_curso, mazo_general.cod_mazo, mazo_general.cod_sesion, t1.nombre_curso from memo_amautas.mazo_general " +
                "inner join t1 on t1.id_curso = mazo_general.cod_curso) " +
                "select t2.*, mazo.cod_autor, mazo.nombre_mazo, mazo.cant_vistas, mazo.cant_votos, mazo.cod_autor, mazo.mazo_default from t2 " +
                "inner join memo_amautas.mazo on t2.cod_mazo = mazo.id_mazo) " +
                "select persona.nombre, t3.* from t3 inner join memo_amautas.persona on t3.cod_autor = persona.id_persona";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, curso.getId());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Mazo mazo = new Mazo();
                mazo.setId(resultado.getInt("cod_mazo"));
                mazo.setNombre(resultado.getString("nombre_mazo"));
                mazo.setCant_visitas(resultado.getInt("cant_visitas"));
                mazo.setCant_votos(resultado.getInt("cant_votos"));
                mazo.setCod_autor(resultado.getInt("cod_autor"));
                mazo.setNombre_autor(resultado.getString("nombre"));
                mazo.setCod_curso(resultado.getString("cod_curso"));
                mazo.setNombre_curso(resultado.getString("nombre_curso"));
                mazo.setEs_default(resultado.getBoolean("mazo_default"));
                mazo.setCod_sesion(resultado.getString("cod_sesion"));
                mazos.add(mazo);
            }
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return mazos;
    }

    @Override
    public List<Mazo> getBySesion(Sesion sesion) {
        return null;
    }
}
