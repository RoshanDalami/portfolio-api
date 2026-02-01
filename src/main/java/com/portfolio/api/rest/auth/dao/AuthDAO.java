package com.portfolio.api.rest.auth.dao;

import com.portfolio.api.rest.auth.dto.LoginDTO;
import com.portfolio.api.rest.auth.dto.TokenDTO;
import com.portfolio.api.rest.auth.dto.UserDTO;
import com.portfolio.api.rest.auth.entity.Auth;

import java.util.List;

public interface AuthDAO {
    List<Auth> findAll();
    Auth findByEmail(String email);
    String hashPassword(String password);
    Auth register(UserDTO user);
    TokenDTO login(LoginDTO loginDTO);

}
