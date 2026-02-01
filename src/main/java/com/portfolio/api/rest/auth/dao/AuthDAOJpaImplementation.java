package com.portfolio.api.rest.auth.dao;

import com.portfolio.api.config.JWTConfig;
import com.portfolio.api.rest.auth.dto.LoginDTO;
import com.portfolio.api.rest.auth.dto.TokenDTO;
import com.portfolio.api.rest.auth.dto.UserDTO;
import com.portfolio.api.rest.auth.entity.Auth;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthDAOJpaImplementation implements AuthDAO{
    private EntityManager entityManager;
    private JWTConfig jwtConfig;
    public AuthDAOJpaImplementation(EntityManager entityManager, JWTConfig jwtConfig){
        this.entityManager = entityManager;
        this.jwtConfig = jwtConfig;

    }

    @Override
    public List<Auth> findAll(){
        TypedQuery<Auth> theQuery = entityManager.createQuery("from Auth", Auth.class);
        List<Auth> auths = theQuery.getResultList();
        return auths;
    }

    @Override
    public Auth findByEmail(String email){
        TypedQuery<Auth> theQuery = entityManager.createQuery("from Auth where email = :email", Auth.class);
        theQuery.setParameter("email", email);
        Auth auth = theQuery.getSingleResult();
        return auth;
    }

    @Override
    public String hashPassword(String password){
        String hashedPassword =  BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    @Override
    public Auth register(UserDTO user){
        Auth auth = new Auth();
        String hashedPassword = hashPassword(user.getPassword());
        auth.setEmail(user.getEmail());
        auth.setPassword(hashedPassword);
        auth.setRole("USER");
        auth.setUsername(user.getUsername());
        entityManager.persist(auth);
        return auth;
    }

    @Override
    public TokenDTO login(LoginDTO loginDTO){
        Auth auth = findByEmail(loginDTO.getEmail());
        String accessToken = jwtConfig.generateToken(auth.getEmail(), auth.getRole());
        TokenDTO token = new TokenDTO();
        token.setToken(accessToken);
        token.setUsername(auth.getUsername());
        token.setRole(auth.getRole());
        token.setEmail(auth.getEmail());
        return BCrypt.checkpw(loginDTO.getPassword(), auth.getPassword()) ? token : null;
    }




}
