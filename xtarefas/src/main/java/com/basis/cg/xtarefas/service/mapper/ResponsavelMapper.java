package com.basis.cg.xtarefas.service.mapper;

import com.basis.cg.xtarefas.domain.Responsavel;
import com.basis.cg.xtarefas.service.dto.ResponsavelDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper {

    Responsavel toEntity(ResponsavelDTO dto);

    ResponsavelDTO toDTO(Responsavel obj);
}
