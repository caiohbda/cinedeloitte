package com.example.cinedeloitte.mapper;

import com.example.cinedeloitte.model.dto.ReservaRequestDTO;
import com.example.cinedeloitte.model.dto.ReservaResponseDTO;
import com.example.cinedeloitte.model.entity.Reserva;
import com.example.cinedeloitte.model.entity.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SalaMapper.class)
public interface ReservaMapper {

    @Mapping(source = "sala", target = "sala")
    ReservaResponseDTO toResponse(Reserva reserva);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "sala", target = "sala")
    Reserva toEntity(ReservaRequestDTO dto, Sala sala);
}
