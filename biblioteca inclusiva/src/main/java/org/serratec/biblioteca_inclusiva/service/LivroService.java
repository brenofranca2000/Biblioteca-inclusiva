package org.serratec.biblioteca_inclusiva.service;

import org.serratec.biblioteca_inclusiva.dto.LivroRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.LivroResponseDTO;
import org.serratec.biblioteca_inclusiva.entity.Categoria;
import org.serratec.biblioteca_inclusiva.entity.Livro;
import org.serratec.biblioteca_inclusiva.repository.CategoriaRepository;
import org.serratec.biblioteca_inclusiva.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public LivroResponseDTO salvar(LivroRequestDTO dto) {

        Optional<Categoria> categoriaOptional =
                categoriaRepository.findById(dto.getCategoriaId());

        if (categoriaOptional.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        Categoria categoria = categoriaOptional.get();

        Livro livro = new Livro();

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setIsbn(dto.getIsbn());
        livro.setQuantidade(dto.getQuantidade());
        livro.setCategoria(categoria);

        livro = livroRepository.save(livro);

        LivroResponseDTO response = new LivroResponseDTO();

        response.setId(livro.getId());
        response.setTitulo(livro.getTitulo());
        response.setAutor(livro.getAutor());
        response.setIsbn(livro.getIsbn());
        response.setQuantidade(livro.getQuantidade());
        response.setCategoria(livro.getCategoria().getNome());

        return response;
    }

    public List<LivroResponseDTO> listar() {

        List<Livro> livros = livroRepository.findAll();

        return livros.stream().map(livro -> {

            LivroResponseDTO response = new LivroResponseDTO();

            response.setId(livro.getId());
            response.setTitulo(livro.getTitulo());
            response.setAutor(livro.getAutor());
            response.setIsbn(livro.getIsbn());
            response.setQuantidade(livro.getQuantidade());
            response.setCategoria(livro.getCategoria().getNome());

            return response;

        }).collect(Collectors.toList());
    }

    public LivroResponseDTO buscarPorId(Long id) {

        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isEmpty()) {
            throw new RuntimeException("Livro não encontrado");
        }

        Livro livro = livroOptional.get();

        LivroResponseDTO response = new LivroResponseDTO();

        response.setId(livro.getId());
        response.setTitulo(livro.getTitulo());
        response.setAutor(livro.getAutor());
        response.setIsbn(livro.getIsbn());
        response.setQuantidade(livro.getQuantidade());
        response.setCategoria(livro.getCategoria().getNome());

        return response;
    }

    public LivroResponseDTO atualizar(Long id, LivroRequestDTO dto) {

        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isEmpty()) {
            throw new RuntimeException("Livro não encontrado");
        }

        Optional<Categoria> categoriaOptional =
                categoriaRepository.findById(dto.getCategoriaId());

        if (categoriaOptional.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        Categoria categoria = categoriaOptional.get();

        Livro livro = livroOptional.get();

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setIsbn(dto.getIsbn());
        livro.setQuantidade(dto.getQuantidade());
        livro.setCategoria(categoria);

        livro = livroRepository.save(livro);

        LivroResponseDTO response = new LivroResponseDTO();

        response.setId(livro.getId());
        response.setTitulo(livro.getTitulo());
        response.setAutor(livro.getAutor());
        response.setIsbn(livro.getIsbn());
        response.setQuantidade(livro.getQuantidade());
        response.setCategoria(livro.getCategoria().getNome());

        return response;
    }

    public void deletar(Long id) {

        Optional<Livro> livroOptional = livroRepository.findById(id);

        if (livroOptional.isEmpty()) {
            throw new RuntimeException("Livro não encontrado");
        }

        livroRepository.deleteById(id);
    }
}