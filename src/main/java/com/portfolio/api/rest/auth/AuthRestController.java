package com.portfolio.api.rest.auth;

import com.portfolio.api.rest.auth.dto.LoginDTO;
import com.portfolio.api.rest.auth.dto.TokenDTO;
import com.portfolio.api.rest.auth.dto.UserDTO;
import com.portfolio.api.rest.auth.service.AuthService;
import com.portfolio.api.utils.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Auth", description = "Endpoints for Authentication")
@RequestMapping("/api/v1/auth")
public class AuthRestController {
    private AuthService authService;

    public AuthRestController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Object>> register(@RequestBody UserDTO userDTO){
        authService.register(userDTO);
        return ResponseEntity.created(null).body(new ApiResponse<>(HttpStatus.CREATED.value(), "User created " +
                "successfully", null));
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<TokenDTO>> login(@RequestBody LoginDTO loginDTO){
      TokenDTO token =   authService.login(loginDTO);
        return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "User logged in successfully", token));
    }
}
