package com.example.cinedeloitte.service.impl;
import com.example.cinedeloitte.exception.NotFoundException;
import com.example.cinedeloitte.mapper.SalaMapper;
import com.example.cinedeloitte.model.entity.Sala;

import com.example.cinedeloitte.model.dto.SalaRequestDTO;
import com.example.cinedeloitte.model.dto.SalaResponseDTO;
import com.example.cinedeloitte.repository.SalaRepository;
import com.example.cinedeloitte.service.SalaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SalaServiceImpl implements SalaService {
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private SalaMapper mapper;

    @Override
    public SalaResponseDTO create(SalaRequestDTO dto) {
        if (salaRepository.existsByNome(dto.getNome())) {
            throw new IllegalArgumentException("Nome da sala já está em uso.");
        }
        Sala sala = mapper.toEntity(dto);
        return mapper.toResponse(salaRepository.save(sala));
    }

    @Override
    public List<SalaResponseDTO> findAll() {
        return salaRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public SalaResponseDTO findById(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("sala não encontrada"));
        return mapper.toResponse(sala);
    }

    @Override
    public SalaResponseDTO update(Long id, SalaRequestDTO dto) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sala não encontrada"));

        if (!sala.getNome().equals(dto.getNome()) && salaRepository.existsByNome(dto.getNome())) {
            throw new IllegalArgumentException("Nome da sala já está em uso.");
        }

        mapper.updateEntityFromDTO(dto, sala);
        return mapper.toResponse(salaRepository.save(sala));
    }

    @Override
    public void delete(Long id) {
        if (!salaRepository.existsById(id)) {
            throw new NotFoundException("Sala não encontrada");
        }
        salaRepository.deleteById(id);
    }
}
