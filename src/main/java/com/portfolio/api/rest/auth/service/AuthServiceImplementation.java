package com.portfolio.api.rest.auth.service;

import com.portfolio.api.rest.auth.dao.AuthDAO;
import com.portfolio.api.rest.auth.dto.LoginDTO;
import com.portfolio.api.rest.auth.dto.TokenDTO;
import com.portfolio.api.rest.auth.dto.UserDTO;
import com.portfolio.api.rest.auth.entity.Auth;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImplementation implements AuthService {
    private AuthDAO authDAO;

    public AuthServiceImplementation(AuthDAO authDAO) {
        this.authDAO = authDAO;
    }

    @Transactional
    @Override
    public void register(UserDTO userDTO) {
        Auth user = authDAO.register(userDTO);
    }


    @Override
    public TokenDTO login(LoginDTO loginDTO){
        TokenDTO token = authDAO.login(loginDTO);
        return token;
    }

}
