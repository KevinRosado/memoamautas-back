package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.domain.UserDetailsImpl;
import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.exception.AlreadyExistsException;
import com.nixvoid.memoamautas.exception.UserNotFoundException;
import com.nixvoid.memoamautas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Qualifier("CorePasswordEncoder")
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse registerPerson(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        String sql = "insert into memo_amautas.persona(nombre, ape_pat, ape_mat, fecha_nac, email, rol_persona) values (?,?,?,?,?,?)";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, registerRequest.getName());
            ps.setString(2, registerRequest.getFirst_surname());
            ps.setString(3, registerRequest.getSecond_surname());
            ps.setDate(4, Date.valueOf(registerRequest.getBirthday()));
            ps.setString(5, registerRequest.getEmail());
            ps.setString(6, registerRequest.getRole());
            ps.executeUpdate();
            cn.close();
            registerResponse.setRegistered(true);
        }catch (SQLException throwables){
            throw new AlreadyExistsException("USER_ALREADY_EXISTS");
        }
        return registerResponse;
    }

    @Override
    public RegisterResponse registerUsuario(RegisterRequest registerRequest, Integer personCode) {
        RegisterResponse registerResponse = new RegisterResponse();
        String sql = "insert into memo_amautas.usuario(username,contrasenia,cod_persona) values (?,?,?)";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, registerRequest.getUsername());
            ps.setString(2,this.passwordEncoder.encode(registerRequest.getPassword()));
            ps.setInt(3, personCode);
            ps.executeUpdate();
            cn.close();
            registerResponse.setRegistered(true);
        }catch (SQLException throwables){
            throw new AlreadyExistsException("USER_ALREADY_EXISTS");
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
            sentencia.setString(1, loginRequest.getEmail());
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()){
                loginRequest1.setEmail(resultado.getString("username"));
                loginRequest1.setPassword(resultado.getString("contrasenia"));
            }
            cn.close();
            if(loginRequest1.getEmail() == null){
                throw new UserNotFoundException("");
            }
        }catch (SQLException throwables){
            throw new UserNotFoundException("USER_NOT_FOUND");
        }
        return loginRequest1;
    }

    @Override
    public UserDetailsImpl getUserInfo(String email) {

        String sql = "with t1 as (select * from memo_amautas.persona where email = ?) " +
                "select t1.*, usuario.* from memo_amautas.usuario inner join t1 on usuario.cod_persona= t1.id_persona";
        UserDetailsImpl userDetails = new UserDetailsImpl();
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, email);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                userDetails.setName(resultado.getString("nombre"));
                userDetails.setFirst_surname(resultado.getString("ape_pat"));
                userDetails.setSecond_surname(resultado.getString("ape_mat"));
                userDetails.setBirthday(resultado.getString("fecha_nac"));
                userDetails.setUsername(resultado.getString("username"));
                userDetails.setPassword(resultado.getString("contrasenia"));
                userDetails.setEmail(resultado.getString("email"));
                userDetails.setRole(resultado.getString("rol_persona"));
            }
            resultado.close();
            cn.close();
        }catch (SQLException throwables){
            throw new UserNotFoundException("USER_NOT_FOUND");
        }
        return userDetails;
    }

    @Override
    public Integer getPersonInfo(String email) {
        Integer personCode = 0;
        String sql = "select id_persona from memo_amautas.persona where email = ?";
        try{
            Connection cn = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement sentencia = cn.prepareStatement(sql);
            sentencia.setString(1, email);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()){
                personCode = resultado.getInt("id_persona");
            }
            resultado.close();
            cn.close();
        }catch (SQLException throwables){
            throw new UserNotFoundException("EMAIL_NOT_FOUND");
        }
        return personCode;
    }
}
