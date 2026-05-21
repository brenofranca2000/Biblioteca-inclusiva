package org.serratec.biblioteca_inclusiva.controller;

import org.serratec.biblioteca_inclusiva.dto.EmprestimoRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.EmprestimoResponseDTO;
import org.serratec.biblioteca_inclusiva.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoResponseDTO salvar(@RequestBody EmprestimoRequestDTO dto) {

        return emprestimoService.salvar(dto);
    }

    @GetMapping
    public List<EmprestimoResponseDTO> listar() {

        return emprestimoService.listar();
    }

    @GetMapping("/{id}")
    public EmprestimoResponseDTO buscarPorId(@PathVariable Long id) {

        return emprestimoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        emprestimoService.deletar(id);
    }
}