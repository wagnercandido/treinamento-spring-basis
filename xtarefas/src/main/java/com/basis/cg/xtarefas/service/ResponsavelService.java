package com.basis.cg.xtarefas.service;

import com.basis.cg.xtarefas.domain.Responsavel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.cg.xtarefas.repository.ResponsavelRepository;
import com.basis.cg.xtarefas.service.dto.ResponsavelDTO;
import com.basis.cg.xtarefas.service.exception.ParametrizedException;
import com.basis.cg.xtarefas.service.mapper.ResponsavelMapper;
import com.basis.cg.xtarefas.service.util.ConstantsUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ResponsavelService {

    private final ResponsavelRepository repository;

    private final ResponsavelMapper mapper;

    public ResponsavelDTO salvar(ResponsavelDTO dto) {
        Responsavel obj = mapper.toEntity(dto);
        obj = repository.save(obj);
        return mapper.toDTO(obj);
    }

    public ResponsavelDTO buscarPorId(Long id) {
        Responsavel obj = repository.findById(id).orElseThrow(() -> new ParametrizedException(ConstantsUtil.OBJETO_NAO_ENCONTRADO));
        return mapper.toDTO(obj);
    }

    public void remover(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
    
    public List<ResponsavelDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

}
