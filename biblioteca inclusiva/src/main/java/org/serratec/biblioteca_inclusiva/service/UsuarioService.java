package org.serratec.biblioteca_inclusiva.service;

import org.serratec.biblioteca_inclusiva.dto.UsuarioRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.UsuarioResponseDTO;
import org.serratec.biblioteca_inclusiva.entity.Usuario;
import org.serratec.biblioteca_inclusiva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());

        usuario = usuarioRepository.save(usuario);

        UsuarioResponseDTO response = new UsuarioResponseDTO();

        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());

        return response;
    }
}