package org.serratec.biblioteca_inclusiva.dto;

import java.time.LocalDate;

public class EmprestimoRequestDTO {

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}