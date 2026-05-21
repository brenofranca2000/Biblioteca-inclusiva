package org.serratec.biblioteca_inclusiva.controller;

import org.serratec.biblioteca_inclusiva.dto.LivroRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.LivroResponseDTO;
import org.serratec.biblioteca_inclusiva.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public LivroResponseDTO salvar(@RequestBody LivroRequestDTO dto) {

        return livroService.salvar(dto);
    }

    @GetMapping
    public List<LivroResponseDTO> listar() {

        return livroService.listar();
    }

    @GetMapping("/{id}")
    public LivroResponseDTO buscarPorId(@PathVariable Long id) {

        return livroService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public LivroResponseDTO atualizar(@PathVariable Long id,
                                      @RequestBody LivroRequestDTO dto) {

        return livroService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        livroService.deletar(id);
    }
}