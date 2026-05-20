package org.serratec.biblioteca_inclusiva.repository;

import org.serratec.biblioteca_inclusiva.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}