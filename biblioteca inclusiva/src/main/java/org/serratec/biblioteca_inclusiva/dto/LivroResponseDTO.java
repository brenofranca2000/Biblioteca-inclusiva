package org.serratec.biblioteca_inclusiva.dto;

public class LivroResponseDTO {

    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer quantidade;
    private String categoria;

    public Long getId() {
        return id;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}