package com.example.cinedeloitte.mapper;

import com.example.cinedeloitte.model.dto.SalaRequestDTO;
import com.example.cinedeloitte.model.dto.SalaResponseDTO;
import com.example.cinedeloitte.model.entity.Sala;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SalaMapper {

    SalaResponseDTO toResponse(Sala sala);

    Sala toEntity(SalaRequestDTO dto);

    void updateEntityFromDTO(SalaRequestDTO dto, @MappingTarget Sala sala);
}
