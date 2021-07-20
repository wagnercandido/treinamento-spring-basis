package com.basis.cg.xtarefas.service;

import com.basis.cg.xtarefas.domain.Anexo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.basis.cg.xtarefas.repository.AnexoRepository;
import com.basis.cg.xtarefas.service.dto.AnexoDTO;
import com.basis.cg.xtarefas.service.exception.ParametrizedException;
import com.basis.cg.xtarefas.service.mapper.AnexoMapper;
import com.basis.cg.xtarefas.service.util.ConstantsUtil;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AnexoService {

    private final AnexoRepository repository;

    private final AnexoMapper mapper;

    public AnexoDTO salvar(AnexoDTO dto) {
        Anexo obj = mapper.toEntity(dto);
        obj = repository.save(obj);
        return mapper.toDTO(obj);
    }

    public AnexoDTO buscarPorId(Long id) {
        Anexo obj = repository.findById(id).orElseThrow(() -> new ParametrizedException(ConstantsUtil.OBJETO_NAO_ENCONTRADO));
        return mapper.toDTO(obj);
    }

    public void remover(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
    
    public List<AnexoDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

}
