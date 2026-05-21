package org.serratec.biblioteca_inclusiva.controller;

import org.serratec.biblioteca_inclusiva.dto.CategoriaRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.CategoriaResponseDTO;
import org.serratec.biblioteca_inclusiva.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public CategoriaResponseDTO salvar(@RequestBody CategoriaRequestDTO dto) {

        return categoriaService.salvar(dto);
    }

    @GetMapping
    public List<CategoriaResponseDTO> listar() {

        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDTO buscarPorId(@PathVariable Long id) {

        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDTO atualizar(@PathVariable Long id,
                                          @RequestBody CategoriaRequestDTO dto) {

        return categoriaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        categoriaService.deletar(id);
    }
}