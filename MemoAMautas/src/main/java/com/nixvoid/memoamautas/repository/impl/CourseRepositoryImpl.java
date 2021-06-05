package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.domain.CourseWithTag;
import com.nixvoid.memoamautas.domain.SingleTaggedCourse;
import com.nixvoid.memoamautas.domain.TaggedCourse;
import com.nixvoid.memoamautas.domain.EnrolledCourse;
import com.nixvoid.memoamautas.dto.courses.*;
import com.nixvoid.memoamautas.dto.courses.Module;
import com.nixvoid.memoamautas.dto.user.Person;
import com.nixvoid.memoamautas.repository.CourseRepository;
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
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TaggedCourse> getCourses(String tag) {
        List<TaggedCourse> taggedCourses = new ArrayList<>();
        String sql = "select id_etiqueta, nombre_etiqueta, nombre_tipo_etiqueta, nombre_curso from memo_amautas.tipo_etiqueta te " +
                "inner join (select * from memo_amautas.etiqueta where cod_tipo_etiqueta = ?) e " +
                "on te.id_tipo_etiqueta = e.cod_tipo_etiqueta " +
                "inner join (select nombre_etiqueta, id_etiqueta from memo_amautas.valor_etiqueta) ve " +
                "on ve.id_etiqueta = e.cod_etiqueta " +
                "inner join memo_amautas.etiqueta_curso ec " +
                "on (ec.cod_etiqueta, ec.cod_tipo_etiqueta) = (e.cod_etiqueta, e.cod_tipo_etiqueta) " +
                "inner join (select id_curso, nombre_curso from memo_amautas.curso) c " +
                "on c.id_curso = ec.cod_curso order by id_etiqueta asc";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, tag);
            ResultSet resultado = sentencia.executeQuery();
            List<SingleTaggedCourse> singleTaggedCourses = new ArrayList<>();
            while(resultado.next()){
                SingleTaggedCourse st = new SingleTaggedCourse();
                st.setTag_name(resultado.getString("nombre_etiqueta"));
                st.setTag_type(resultado.getString("nombre_tipo_etiqueta"));
                CourseWithTag c = new CourseWithTag();
                c.setCourse_name(resultado.getString("nombre_curso"));
                st.setCourse(c);
                singleTaggedCourses.add(st);
            }
            resultado.close();
            cn.close();
            List<String> tags = new ArrayList<>();
            String value = "";
            for(SingleTaggedCourse course: singleTaggedCourses){
                if(!course.getTag_name().equals(value)){
                    tags.add(course.getTag_name());
                }
                value = course.getTag_name();
            }
            for (String tag1: tags) {
                TaggedCourse taggedCourse = new TaggedCourse();
                List<CourseWithTag> courses = new ArrayList<>();
                taggedCourse.setTag_name(tag1);
                for(SingleTaggedCourse course: singleTaggedCourses){
                    taggedCourse.setTag_type(course.getTag_type());
                    if(course.getTag_name().equals(tag1)){
                        courses.add(course.getCourse());
                    }
                }
                taggedCourse.setCourses(courses);
                taggedCourses.add(taggedCourse);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return taggedCourses;
    }

    @Override
    public Course getCourseDetails(Course course) {
        Course course1 = new Course();
        String sql = "with t1 as (select id_curso, nombre_curso, creditos, descripcion from memo_amautas.curso where nombre_curso = ?) " +
                "select modulo.*, t1.* from t1 " +
                "inner join memo_amautas.modulo on modulo.cod_curso = t1.id_curso";
        String sql1 = "select id_sesion, cod_modulo, tema_sesion, orden from memo_amautas.sesion";
        List<Module> modules = new ArrayList<>();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, course.getName());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Module m = new Module();
                List<Session> sessions = new ArrayList<>();
                course1.setId(resultado.getString("id_curso"));
                course1.setName(resultado.getString("nombre_curso"));
                course1.setCredits(resultado.getInt("creditos"));
                course1.setDescription(resultado.getString("descripcion"));
                m.setId(resultado.getString("id_modulo"));
                m.setTopic(resultado.getString("tema_modulo"));
                m.setOrder(resultado.getInt("orden"));
                m.setSessions(sessions);
                modules.add(m);
            }
            resultado.close();
            PreparedStatement ps = cn.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                for(Module m: modules){
                    if(m.getId().equals(rs.getString("cod_modulo"))){
                        Session s = new Session();
                        s.setId(rs.getString("id_sesion"));
                        s.setTema(rs.getString("tema_sesion"));
                        s.setOrden(rs.getInt("orden"));
                        s.setId_modulo(rs.getString("cod_modulo"));
                        m.getSessions().add(s);
                    }
                }
            }
            rs.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        course1.setModules(modules);
        return course1;
    }

    @Override
    public Course enrollCourse(EnrolledCourse enrolledCourse) {
        Course courseDetails = new Course();
        String sql = "insert into memo_amautas.curso_matriculado (cod_curso, cod_persona, fecha_inscripcion, progreso_curso) values (?,?,?,?);";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, enrolledCourse.getId_curso());
            sentencia.setString(2, enrolledCourse.getId_persona());
            sentencia.setString(3, enrolledCourse.getFecha_inscripcion().toString());
            sentencia.setString(4, enrolledCourse.getProgreso_curso().toString());
            sentencia.executeUpdate();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        courseDetails.setId(enrolledCourse.getId_curso());
        courseDetails.setName(enrolledCourse.getNombre_curso());
        return getCourseDetails(courseDetails);
    }

    @Override
    public Course getCourseInfo(Course course) {
        Course courseInfo =  new Course();
        List<Person> profesores = new ArrayList<>();
        List<Module> modules = new ArrayList<>();
        String sql = "with t2 as (with t1 as (select creditos, descripcion, nombre_curso, id_curso from memo_amautas.curso where id_curso = ?) " +
                "select t1.*, curso_matriculado.cod_persona from t1 " +
                "inner join memo_amautas.curso_matriculado on t1.id_curso = curso_matriculado.cod_curso) " +
                "select t2.*, persona.nombre, persona.ape_pat, persona.ape_mat from t2 " +
                "inner join memo_amautas.persona on t2.cod_persona = persona.id_persona ";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, course.getId());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                Person profesor = new Person();
                courseInfo.setId(resultado.getString("id_curso"));
                courseInfo.setName(resultado.getString("nombre_curso"));
                courseInfo.setCredits(resultado.getInt("creditos"));
                courseInfo.setDescription(resultado.getString("descripcion"));
                profesor.setId(resultado.getString("cod_persona"));
                profesor.setNombre(resultado.getString("nombre"));
                profesor.setApe_pat(resultado.getString("ape_pat"));
                profesor.setApe_mat(resultado.getString("ape_mat"));
                profesores.add(profesor);
            }
            courseInfo.setModules(modules);
            courseInfo.setTeachers(profesores);
            resultado.close();
            cn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return courseInfo;
    }

}
