package com.example.cinedeloitte.service;

import com.example.cinedeloitte.model.dto.ReservaResponseDTO;
import com.example.cinedeloitte.model.dto.ReservaRequestDTO;

import java.util.List;

public interface ReservaService {
    ReservaResponseDTO create(ReservaRequestDTO dto);
    List<ReservaResponseDTO> findAll();
    List<ReservaResponseDTO> findReservasFuturas();
    List<ReservaResponseDTO> findBySala(Long salaId);
    void cancel(Long id);
}
