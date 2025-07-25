package com.example.cinedeloitte.service.impl;

import com.example.cinedeloitte.exception.InvalidReservationPeriodException;
import com.example.cinedeloitte.exception.NotFoundException;
import com.example.cinedeloitte.exception.RoomAlreadyReservedException;
import com.example.cinedeloitte.mapper.ReservaMapper;
import com.example.cinedeloitte.model.dto.ReservaRequestDTO;
import com.example.cinedeloitte.model.dto.ReservaResponseDTO;
import com.example.cinedeloitte.model.entity.Reserva;
import com.example.cinedeloitte.model.entity.Sala;
import com.example.cinedeloitte.repository.ReservaRepository;
import com.example.cinedeloitte.repository.SalaRepository;
import com.example.cinedeloitte.service.ReservaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ReservaServiceImpl implements ReservaService {

    private ReservaRepository reservaRepository;
    private SalaRepository salaRepository;
    private ReservaMapper mapper;

    @Transactional
    @Override
    public ReservaResponseDTO create(ReservaRequestDTO dto) {
        if (dto.getStartIn().isAfter(dto.getEndIn())) {
            throw new InvalidReservationPeriodException("Data/hora de início deve ser antes da de término.");
        }

        if (dto.getStartIn().isBefore(OffsetDateTime.now())) {
            throw new InvalidReservationPeriodException("Não é possível reservar uma sala para o passado.");
        }

        Sala sala = salaRepository.findById(dto.getSalaId())
                .orElseThrow(() -> new NotFoundException("Sala com ID " + dto.getSalaId() + " não encontrada."));

        if(reservaRepository.existsBySalaIdAndPeriodOverlap(dto.getSalaId(),dto.getStartIn(),dto.getEndIn())) {
            throw new RoomAlreadyReservedException("Ja tem uma sala reservada nesse periodo de tempo");
        }

        Reserva reserva = mapper.toEntity(dto, sala);
        reserva.setSala(sala);
        reserva = reservaRepository.save(reserva);

        return mapper.toResponse(reserva);
    }

    @Override
    public List<ReservaResponseDTO> findAll(){
        return reservaRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ReservaResponseDTO> findReservasFuturas() {
        return reservaRepository.findByStartInAfter(OffsetDateTime.now())
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public List<ReservaResponseDTO> findBySala(Long salaId) {
        return reservaRepository.findBySalaId(salaId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void cancel(Long id) {
        if (!reservaRepository.existsById(id)) {
            throw new NotFoundException("Reserva não encontrada");
        }
        reservaRepository.deleteById(id);
    }
}
