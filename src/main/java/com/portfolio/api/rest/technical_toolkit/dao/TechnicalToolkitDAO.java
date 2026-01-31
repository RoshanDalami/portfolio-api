package com.portfolio.api.rest.technical_toolkit.dao;

import com.portfolio.api.rest.technical_toolkit.dto.TechnicalToolkitDTO;
import com.portfolio.api.rest.technical_toolkit.entity.TechnicalToolkit;

import java.util.List;

public interface TechnicalToolkitDAO {
    List<TechnicalToolkit> findAll();
    TechnicalToolkit findById(int id);
    TechnicalToolkit save(List<TechnicalToolkitDTO> technicalToolkitDTO);
    void deleteById(int id);
    TechnicalToolkit update(TechnicalToolkitDTO technicalToolkit, int id);
}
