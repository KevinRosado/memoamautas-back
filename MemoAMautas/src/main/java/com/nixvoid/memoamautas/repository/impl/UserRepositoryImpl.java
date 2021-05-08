package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public LoginResponse loginUsuario(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        String sql = "with t1 as (SELECT * from memo_amautas.persona where id_persona in (select cod_persona from memo_amautas.usuario where username = ? and contrasenia = ?))" +
                "select t1.*, memo_amautas.rol.nombre_rol from t1 inner join memo_amautas.rol on t1.rol_persona= memo_amautas.rol.id_rol";

        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, loginRequest.getUsuario());
            sentencia.setString(2, loginRequest.getPassword());
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                loginResponse.setNombre(resultado.getString("nombre"));
                loginResponse.setApe_pat(resultado.getString("ape_pat"));
                loginResponse.setApe_mat(resultado.getString("ape_mat"));
                loginResponse.setFecha_nac(resultado.getDate("fecha_nac"));
                loginResponse.setUsername(loginRequest.getUsuario());
                loginResponse.setPassword(loginRequest.getPassword());
                loginResponse.setRol(resultado.getString("nombre_rol"));
            }
            resultado.close();
            cn.close();
        }catch (SQLException throwables){
            throw new ApiRequestException("USER_NOT_EXISTS");
        }
        return loginResponse;
    }

    @Override
    public RegisterResponse registerUsuario(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        String sql = "insert into memo_amautas.usuario(username,contrasenia) values (?,?)";
        String sql1 = "insert into memo_amautas.persona(nombre, ape_pat, ape_mat, fecha_nac, rol_persona) values (?,?,?,?,?)";
        String sql2 = "with t1 as (select * from memo_amautas.usuario where username = ? and contrasenia = ?) " +
                "select memo_amautas.persona.*, t1.username, t1.contrasenia from t1 " +
                "inner join memo_amautas.persona on t1.cod_persona = memo_amautas.persona.id_persona ";
        String sql3 = "SELECT nombre_rol from memo_amautas.rol where id_rol in (SELECT rol_persona from memo_amautas.persona where id_persona = ?)";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, registerRequest.getPassword());
            ps.setString(2, registerRequest.getUsername());
            ResultSet rs = ps.executeQuery();
            rs.close();

            PreparedStatement ps1 = cn.prepareStatement(sql1);
            ResultSet rs1 = ps1.executeQuery();
            rs1.close();
            cn.close();

            Connection cn2 = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps2 = cn2.prepareStatement(sql2);
            ps2.setString(1, registerRequest.getUsername());
            ps2.setString(2, registerRequest.getPassword());
            ResultSet rs2 = ps2.executeQuery();
            PreparedStatement ps3 = cn2.prepareStatement(sql3);
            ps3.setString(1, rs2.getString("rol_persona"));
            ResultSet resultSet = ps3.executeQuery();
            while(rs2.next()){
                registerResponse.setNombre(rs2.getString("nombre"));
                registerResponse.setApe_pat(rs2.getString("ape_pat"));
                registerResponse.setApe_mat(rs2.getString("ape_mat"));
                registerResponse.setFecha_nac(rs2.getDate("fecha_nac"));
                registerResponse.setRol(resultSet.getString("nombre_rol"));
                registerResponse.setUsername(rs2.getString("username"));
                registerResponse.setPassword(rs2.getString("contrasenia"));
            }

        }catch (SQLException throwables){
            throw new ApiRequestException("USER_ALREADY_EXISTS");
        }
        return registerResponse;
    }

    @Override
    public LoginRequest ForgetPassword(LoginRequest loginRequest) {
        String sql = "SELECT username, contrasenia from memo_amautas.usuario where username = ? ";
        LoginRequest loginRequest1 = new LoginRequest();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, loginRequest.getUsuario());
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()){
                loginRequest1.setUsuario(resultado.getString("email"));
                loginRequest1.setPassword(resultado.getString("contrasenia"));
            }
            cn.close();
            if(loginRequest1.getUsuario() == null){
                throw new SQLException("");
            }
        }catch (SQLException throwables){
            throw new ApiRequestException("NOT_FOUND");
        }
        return loginRequest1;
    }
}
