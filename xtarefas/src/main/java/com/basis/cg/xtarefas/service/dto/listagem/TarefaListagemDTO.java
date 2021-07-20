package com.basis.cg.xtarefas.service.dto.listagem;

import com.basis.cg.xtarefas.service.enumeration.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class TarefaListagemDTO implements Serializable {

    private Long id;

    private String nome;

    private StatusEnum status;

    private LocalDate dataInicio;

    private LocalDate dataConclusao;

}
