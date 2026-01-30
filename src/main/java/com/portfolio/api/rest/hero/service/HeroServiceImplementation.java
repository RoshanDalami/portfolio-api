package com.portfolio.api.rest.hero.service;

import com.portfolio.api.rest.hero.dao.HeroDAO;
import com.portfolio.api.rest.hero.dto.HeroDTO;
import com.portfolio.api.rest.hero.entity.Hero;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImplementation implements HeroService {
    public HeroDAO heroDAO;

    @Autowired
    public void setHeroDAO(HeroDAO heroDAO) {
        this.heroDAO = heroDAO;
    }

    @Override
    public List<Hero> findAll() {
        return heroDAO.findAll();
    }

    @Override
    public Hero findById(int id){
        return heroDAO.findById(id);
    }

    @Transactional
    @Override
    public Hero save(HeroDTO heroDTO){
        Hero hero = heroDAO.save(heroDTO);
        return hero;
    }

    @Transactional
    @Override
    public void deleteById(int id){
        heroDAO.deleteById(id);
    }

    @Transactional
    @Override
    public Hero update(Hero hero, int id){
        Hero updated =  heroDAO.update(hero, id);
        return updated;
    }



}
