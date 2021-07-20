package com.basis.cg.xtarefas.repository;

import com.basis.cg.xtarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    @Query("SELECT t from Tarefa t WHERE" +
            ":status IS NULL OR t.status LIKE :status")
    List<Tarefa> listar(@Param("status") String status);
}
