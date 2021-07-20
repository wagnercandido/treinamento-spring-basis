package com.basis.cg.xtarefas.service.dto;

import com.basis.cg.xtarefas.service.enumeration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TarefaDTO implements Serializable {

    private Long id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataConclusao;

    private StatusEnum status;

    private Long responsavelId;

    private List<AnexoDTO> anexos;

}
