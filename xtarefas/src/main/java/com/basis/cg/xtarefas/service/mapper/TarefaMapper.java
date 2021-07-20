package com.basis.cg.xtarefas.service.mapper;

import com.basis.cg.xtarefas.domain.Tarefa;
import com.basis.cg.xtarefas.service.dto.TarefaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.basis.cg.xtarefas.service.dto.listagem.TarefaListagemDTO;

@Mapper(componentModel = "spring", uses = { AnexoMapper.class, ResponsavelMapper.class })
public interface TarefaMapper {

    @Mapping(source = "responsavelId", target = "responsavel.id")
    Tarefa toEntity(TarefaDTO dto);

    @Mapping(source = "responsavel.id", target = "responsavelId")
    TarefaDTO toDTO(Tarefa obj);

    TarefaListagemDTO toListagemDTO(Tarefa obj);
}
