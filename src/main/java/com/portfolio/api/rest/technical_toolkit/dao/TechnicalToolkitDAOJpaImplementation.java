package com.portfolio.api.rest.technical_toolkit.dao;

import com.portfolio.api.rest.technical_toolkit.dto.TechnicalToolkitDTO;
import com.portfolio.api.rest.technical_toolkit.entity.TechnicalToolkit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TechnicalToolkitDAOJpaImplementation implements TechnicalToolkitDAO {
    public EntityManager entityManager;

    @Autowired public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<TechnicalToolkit> findAll(){
        TypedQuery<TechnicalToolkit> theQuery = entityManager.createQuery("from TechnicalToolkit",
                TechnicalToolkit.class);
        List<TechnicalToolkit> toolkits = theQuery.getResultList();
        return toolkits;
    }

    @Override
    public TechnicalToolkit findById(int id){
        TechnicalToolkit toolkit = entityManager.find(TechnicalToolkit.class, id);
        return toolkit;
    }

    @Override
    public void deleteById(int id){
        TechnicalToolkit toolkit = findById(id);
        entityManager.remove(toolkit);
    }

    @Override
    public TechnicalToolkit save(List<TechnicalToolkitDTO> toolkitDTO){

        int batchSize = 50;
        for (int i = 0; i < toolkitDTO.size(); i++) {
            TechnicalToolkit toolkit = new TechnicalToolkit();
            toolkit.setCategory(toolkitDTO.get(i).getCategory());
            toolkit.setValue(toolkitDTO.get(i).getValue());
            entityManager.persist(toolkit);

            if (i % batchSize == 0 && i > 0) {
                entityManager.flush();  // Send batch to DB
                entityManager.clear();  // Clear first-level cache
            }
        }
        entityManager.flush();
        entityManager.clear();

        return null;
    }

    @Override
    public TechnicalToolkit update(TechnicalToolkitDTO toolkitDTO, int id){
        TechnicalToolkit existingToolkit = findById(id);
        existingToolkit.setCategory(toolkitDTO.getCategory());
        existingToolkit.setValue(toolkitDTO.getValue());
        entityManager.merge(existingToolkit);
        return existingToolkit;
    }


}
