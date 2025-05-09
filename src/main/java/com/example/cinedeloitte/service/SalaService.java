package com.example.cinedeloitte.service;

import com.example.cinedeloitte.model.dto.SalaRequestDTO;
import com.example.cinedeloitte.model.dto.SalaResponseDTO;

import java.util.List;

public interface SalaService {
    SalaResponseDTO create(SalaRequestDTO dto);
    List<SalaResponseDTO> findAll();
    SalaResponseDTO findById(Long id);
    SalaResponseDTO update(Long id, SalaRequestDTO dto);
    void delete(Long id);
}
