package com.portfolio.api.rest.hero.dao;

import com.portfolio.api.rest.hero.entity.Hero;

import java.util.List;

import com.portfolio.api.rest.hero.dto.HeroDTO;

public interface HeroDAO {
    List<Hero> findAll();

    Hero findById(int id);

    Hero save(HeroDTO heroDTO);

    Hero update(Hero hero, int id);

    void deleteById(int id);
}
