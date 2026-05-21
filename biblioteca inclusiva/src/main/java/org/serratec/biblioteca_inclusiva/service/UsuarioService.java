package org.serratec.biblioteca_inclusiva.service;

import org.serratec.biblioteca_inclusiva.dto.UsuarioRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.UsuarioResponseDTO;
import org.serratec.biblioteca_inclusiva.entity.Usuario;
import org.serratec.biblioteca_inclusiva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<UsuarioResponseDTO> listar() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(usuario -> {
            UsuarioResponseDTO response = new UsuarioResponseDTO();
            response.setId(usuario.getId());
            response.setNome(usuario.getNome());
            response.setEmail(usuario.getEmail());
            return response;
        }).collect(Collectors.toList());
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOptional.get();

        UsuarioResponseDTO response = new UsuarioResponseDTO();

        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());

        return response;
    }

public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {

    Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

    if (usuarioOptional.isEmpty()) {
        throw new RuntimeException("Usuário não encontrado");

    }

    Usuario usuario = usuarioOptional.get();

    usuario.setNome(dto.getNome());
    usuario.setEmail(dto.getEmail());

    usuario = usuarioRepository.save(usuario);

    UsuarioResponseDTO response = new UsuarioResponseDTO();

    response.setId(usuario.getId());
    response.setNome(usuario.getNome());
    response.setEmail(usuario.getEmail());

    return response;
}

public void deletar(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        usuarioRepository.deleteById(id);
    }}