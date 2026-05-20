package org.serratec.biblioteca_inclusiva.repository;

import org.serratec.biblioteca_inclusiva.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}