package org.serratec.biblioteca_inclusiva.dto;

public class LivroRequestDTO {

    private String titulo;

    private String autor;

    private String isbn;

    private Integer quantidade;

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}