package org.serratec.biblioteca_inclusiva.controller;

import org.serratec.biblioteca_inclusiva.dto.UsuarioRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.UsuarioResponseDTO;
import org.serratec.biblioteca_inclusiva.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponseDTO salvar(@RequestBody UsuarioRequestDTO dto) {

        return usuarioService.salvar(dto);
    }
}