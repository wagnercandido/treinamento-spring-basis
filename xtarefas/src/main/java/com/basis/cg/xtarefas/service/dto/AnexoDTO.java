package com.basis.cg.xtarefas.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AnexoDTO implements Serializable {

    private Long id;

    private String file;

    private String fileName;

}
