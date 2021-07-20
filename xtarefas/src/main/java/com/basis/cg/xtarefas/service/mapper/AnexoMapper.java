package com.basis.cg.xtarefas.service.mapper;

import com.basis.cg.xtarefas.domain.Anexo;
import com.basis.cg.xtarefas.service.dto.AnexoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnexoMapper {

    Anexo toEntity(AnexoDTO dto);

    AnexoDTO toDTO(Anexo obj);
}
