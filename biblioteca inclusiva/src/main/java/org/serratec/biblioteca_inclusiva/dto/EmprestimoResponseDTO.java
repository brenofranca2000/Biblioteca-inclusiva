package org.serratec.biblioteca_inclusiva.dto;

import java.time.LocalDate;

public class EmprestimoResponseDTO {

    private Long id;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    public Long getId() {
        return id;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}