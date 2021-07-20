package com.basis.cg.xtarefas.service;

import com.basis.cg.xtarefas.domain.Tarefa;
import com.basis.cg.xtarefas.service.enumeration.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.cg.xtarefas.repository.TarefaRepository;
import com.basis.cg.xtarefas.service.dto.TarefaDTO;
import com.basis.cg.xtarefas.service.dto.listagem.TarefaListagemDTO;
import com.basis.cg.xtarefas.service.exception.ParametrizedException;
import com.basis.cg.xtarefas.service.mapper.TarefaMapper;
import com.basis.cg.xtarefas.service.util.ConstantsUtil;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TarefaService {

    private final TarefaRepository repository;

    private final TarefaMapper mapper;

    public TarefaDTO salvar(TarefaDTO dto) {
        processoSalvar(dto);
        Tarefa obj = mapper.toEntity(dto);
        obj = repository.save(obj);
        return mapper.toDTO(obj);
    }

    public TarefaDTO buscarPorId(Long id) {
        Tarefa obj = repository.findById(id).orElseThrow(() -> new ParametrizedException(ConstantsUtil.OBJETO_NAO_ENCONTRADO));
        return mapper.toDTO(obj);
    }

    public void remover(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    public List<TarefaListagemDTO> listar(String status) {
        status = StringUtils.isEmpty(status) ? null : status;
        return repository.listar(status).stream().map(mapper::toListagemDTO).collect(Collectors.toList());
    }

    private void processoSalvar(TarefaDTO dto) {
        if(Objects.nonNull(dto.getId())) {
            dto.setDataInicio(LocalDate.now());
            dto.setStatus(StatusEnum.EM_ADAMENTO);
            return;
        }
        buscarPorId(dto.getId());
    }

}
