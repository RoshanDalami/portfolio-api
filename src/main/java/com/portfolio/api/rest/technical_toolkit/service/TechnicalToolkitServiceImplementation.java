package com.portfolio.api.rest.technical_toolkit.service;

import com.portfolio.api.rest.technical_toolkit.dao.TechnicalToolkitDAO;
import com.portfolio.api.rest.technical_toolkit.dto.TechnicalToolkitDTO;
import com.portfolio.api.rest.technical_toolkit.entity.TechnicalToolkit;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalToolkitServiceImplementation implements TechnicalToolkitService{
    public TechnicalToolkitDAO technicalToolkitDAO;

    @Autowired
    public void setTechnicalToolkitDAO(TechnicalToolkitDAO technicalToolkitDAO){
        this.technicalToolkitDAO = technicalToolkitDAO;
    }

    @Override
    public List<TechnicalToolkit> findAll(){
        return technicalToolkitDAO.findAll();
    }

    @Override
    public TechnicalToolkit findById(int id){
        return technicalToolkitDAO.findById(id);
    }

    @Override
    @Transactional
    public TechnicalToolkit save(List<TechnicalToolkitDTO> toolkitDTO){
        TechnicalToolkit toolkit = technicalToolkitDAO.save(toolkitDTO);

        return toolkit;
    }

    @Override
    @Transactional
    public void deleteById(int id){
        technicalToolkitDAO.deleteById(id);
    }

    @Override
    @Transactional
    public TechnicalToolkit update(TechnicalToolkitDTO toolkitDTO, int id){
       TechnicalToolkit update = technicalToolkitDAO.update(toolkitDTO, id);
       return update;
    }


}
