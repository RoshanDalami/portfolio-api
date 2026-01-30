package com.portfolio.api.rest.hero.service;

import com.portfolio.api.rest.hero.dto.HeroDTO;
import com.portfolio.api.rest.hero.entity.Hero;

import java.util.List;

public interface HeroService {
    List<Hero> findAll();

    Hero findById(int id);

    Hero save(HeroDTO heroDTO);

    Hero update(Hero hero, int id);

    void deleteById(int id);
}
