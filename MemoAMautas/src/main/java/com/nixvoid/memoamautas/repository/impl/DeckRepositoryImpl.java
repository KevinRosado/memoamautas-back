package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.dto.cards.Deck;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Session;
import com.nixvoid.memoamautas.dto.user.Person;
import com.nixvoid.memoamautas.repository.DeckRepository;
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
public class DeckRepositoryImpl implements DeckRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Deck> getByAutor(Person person) {
        List<Deck> decks = new ArrayList<>();
        String sql = "with t2 as (with t1 as (select * from memo_amautas.mazo where cod_autor = ?) " +
                "select t1.*, mazo_general.cod_curso, mazo_general.cod_sesion from t1 " +
                "inner join memo_amautas.mazo_general on mazo_general.cod_mazo = t1.id_mazo) " +
                "select t2.*, curso.nombre_curso from t2 inner join memo_amautas.curso on curso.id_curso = t2.cod_curso";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, person.getId());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Deck deck = new Deck();
                deck.setId(resultado.getInt("cod_mazo"));
                deck.setNombre(resultado.getString("nombre_mazo"));
                deck.setCant_visitas(resultado.getInt("cant_visitas"));
                deck.setCant_votos(resultado.getInt("cant_votos"));
                deck.setCod_autor(resultado.getInt("cod_autor"));
                deck.setNombre_autor(resultado.getString("nombre"));
                deck.setCod_curso(resultado.getString("cod_curso"));
                deck.setNombre_curso(resultado.getString("nombre_curso"));
                deck.setEs_default(resultado.getBoolean("mazo_default"));
                deck.setCod_sesion(resultado.getString("cod_sesion"));
                decks.add(deck);
            }
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return decks;
    }

    @Override
    public List<Deck> obtenerMazos(Course course) {
        return null;
    }

    @Override
    public List<Deck> getByCurso(Course course) {
        List<Deck> decks = new ArrayList<>();
        String sql = "with t3 as (with t2 as (with t1 as (select nombre_curso, id_curso from memo_amautas.curso where id_curso = ?) " +
                "select mazo_general.cod_curso, mazo_general.cod_mazo, mazo_general.cod_sesion, t1.nombre_curso from memo_amautas.mazo_general " +
                "inner join t1 on t1.id_curso = mazo_general.cod_curso) " +
                "select t2.*, mazo.cod_autor, mazo.nombre_mazo, mazo.cant_vistas, mazo.cant_votos, mazo.cod_autor, mazo.mazo_default from t2 " +
                "inner join memo_amautas.mazo on t2.cod_mazo = mazo.id_mazo) " +
                "select persona.nombre, t3.* from t3 inner join memo_amautas.persona on t3.cod_autor = persona.id_persona order by t3.cant_votos";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, course.getId());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Deck deck = new Deck();
                deck.setId(resultado.getInt("cod_mazo"));
                deck.setNombre(resultado.getString("nombre_mazo"));
                deck.setCant_visitas(resultado.getInt("cant_visitas"));
                deck.setCant_votos(resultado.getInt("cant_votos"));
                deck.setCod_autor(resultado.getInt("cod_autor"));
                deck.setNombre_autor(resultado.getString("nombre"));
                deck.setCod_curso(resultado.getString("cod_curso"));
                deck.setNombre_curso(resultado.getString("nombre_curso"));
                deck.setEs_default(resultado.getBoolean("mazo_default"));
                deck.setCod_sesion(resultado.getString("cod_sesion"));
                decks.add(deck);
            }
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return decks;
    }

    @Override
    public List<Deck> getBySesion(Session session) {
        List<Deck> decks = new ArrayList<>();
        String sql = "with t1 as (select cod_mazo, cod_sesion, cod_curso from memo_amautas.mazo_general where cod_sesion = ?) " +
                "select t1.cod_sesion, t1.cod_curso, mazo.* from t1 inner join memo_amautas.mazo on mazo.id_mazo = t1.cod_mazo";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, session.getId());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Deck deck = new Deck();
                deck.setId(resultado.getInt("cod_mazo"));
                deck.setNombre(resultado.getString("nombre_mazo"));
                deck.setCant_visitas(resultado.getInt("cant_visitas"));
                deck.setCant_votos(resultado.getInt("cant_votos"));
                deck.setCod_autor(resultado.getInt("cod_autor"));
                deck.setNombre_autor(resultado.getString("nombre"));
                deck.setCod_curso(resultado.getString("cod_curso"));
                deck.setEs_default(resultado.getBoolean("mazo_default"));
                deck.setCod_sesion(resultado.getString("cod_sesion"));
                decks.add(deck);
            }
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return decks;
    }

    @Override
    public void crearMazo(Deck deck) {

    }
}
