package com.portfolio.api.rest.auth.service;

import com.portfolio.api.rest.auth.dto.LoginDTO;
import com.portfolio.api.rest.auth.dto.TokenDTO;
import com.portfolio.api.rest.auth.dto.UserDTO;

public interface AuthService {

    void register(UserDTO user);
    TokenDTO login(LoginDTO loginDTO);
}
