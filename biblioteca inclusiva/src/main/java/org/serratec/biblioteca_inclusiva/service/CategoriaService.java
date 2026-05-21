package org.serratec.biblioteca_inclusiva.service;

import org.serratec.biblioteca_inclusiva.dto.CategoriaRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.CategoriaResponseDTO;
import org.serratec.biblioteca_inclusiva.entity.Categoria;
import org.serratec.biblioteca_inclusiva.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaResponseDTO salvar(CategoriaRequestDTO dto) {

        Categoria categoria = new Categoria();

        categoria.setNome(dto.getNome());

        categoria = categoriaRepository.save(categoria);

        CategoriaResponseDTO response = new CategoriaResponseDTO();

        response.setId(categoria.getId());
        response.setNome(categoria.getNome());

        return response;
    }

    public List<CategoriaResponseDTO> listar() {

        List<Categoria> categorias = categoriaRepository.findAll();

        return categorias.stream().map(categoria -> {

            CategoriaResponseDTO response = new CategoriaResponseDTO();

            response.setId(categoria.getId());
            response.setNome(categoria.getNome());

            return response;

        }).collect(Collectors.toList());
    }

    public CategoriaResponseDTO buscarPorId(Long id) {

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        Categoria categoria = categoriaOptional.get();

        CategoriaResponseDTO response = new CategoriaResponseDTO();

        response.setId(categoria.getId());
        response.setNome(categoria.getNome());

        return response;
    }

    public CategoriaResponseDTO atualizar(Long id, CategoriaRequestDTO dto) {

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        Categoria categoria = categoriaOptional.get();

        categoria.setNome(dto.getNome());

        categoria = categoriaRepository.save(categoria);

        CategoriaResponseDTO response = new CategoriaResponseDTO();

        response.setId(categoria.getId());
        response.setNome(categoria.getNome());

        return response;
    }

    public void deletar(Long id) {

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada");
        }

        categoriaRepository.deleteById(id);
    }
}