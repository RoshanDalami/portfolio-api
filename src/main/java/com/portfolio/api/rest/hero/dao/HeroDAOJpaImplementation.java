package com.portfolio.api.rest.hero.dao;

import com.portfolio.api.rest.hero.dto.HeroDTO;
import com.portfolio.api.rest.hero.entity.Hero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HeroDAOJpaImplementation implements HeroDAO {
    private EntityManager entityManager;

    @Autowired
    public HeroDAOJpaImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Hero> findAll() {
        TypedQuery<Hero> theQuery = entityManager.createQuery("from Hero", Hero.class);
        List<Hero> heroes = theQuery.getResultList();
        return heroes;
    }

    @Override
    public Hero findById(int id) {
        Hero hero = entityManager.find(Hero.class, id);
        return hero;
    }

    @Override
    public Hero save(HeroDTO heroDTO) {
        Hero hero = new Hero();
        hero.setFirstText(heroDTO.getFirstText());
        hero.setSubtext(heroDTO.getSubtext());
        hero.setFollowingText(heroDTO.getFollowingText());
        hero.setEndingText(heroDTO.getEndingText());
        hero.setDescription(heroDTO.getDescription());
        hero.setLocation(heroDTO.getLocation());
        hero.setEmail(heroDTO.getEmail());
        entityManager.persist(hero);
        return hero;
    }

    @Override
    public void deleteById(int id) {
        Hero hero = entityManager.find(Hero.class, id);
        entityManager.remove(hero);
    }

    @Override
    public Hero update(Hero hero, int id) {
        Hero existingHero = findById(id);
        existingHero.setFirstText(hero.getFirstText());
        existingHero.setSubtext(hero.getSubtext());
        existingHero.setFollowingText(hero.getFollowingText());
        existingHero.setEndingText(hero.getEndingText());
        existingHero.setDescription(hero.getDescription());
        existingHero.setLocation(hero.getLocation());
        existingHero.setEmail(hero.getEmail());
        return entityManager.merge(existingHero);
    }

}
