package org.serratec.biblioteca_inclusiva.controller;

import org.serratec.biblioteca_inclusiva.dto.UsuarioRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.UsuarioResponseDTO;
import org.serratec.biblioteca_inclusiva.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody UsuarioRequestDTO dto) {

        return usuarioService.salvar(dto);
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {

        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {

        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id,
                                        @RequestBody UsuarioRequestDTO dto) {

        return usuarioService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {

        usuarioService.deletar(id);
    }}
