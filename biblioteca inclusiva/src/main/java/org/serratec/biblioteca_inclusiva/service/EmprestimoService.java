package org.serratec.biblioteca_inclusiva.service;

import org.serratec.biblioteca_inclusiva.dto.EmprestimoRequestDTO;
import org.serratec.biblioteca_inclusiva.dto.EmprestimoResponseDTO;
import org.serratec.biblioteca_inclusiva.entity.Emprestimo;
import org.serratec.biblioteca_inclusiva.entity.Livro;
import org.serratec.biblioteca_inclusiva.entity.Usuario;
import org.serratec.biblioteca_inclusiva.repository.EmprestimoRepository;
import org.serratec.biblioteca_inclusiva.repository.LivroRepository;
import org.serratec.biblioteca_inclusiva.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    public EmprestimoResponseDTO salvar(EmprestimoRequestDTO dto) {

        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(dto.getUsuarioId());

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Optional<Livro> livroOptional =
                livroRepository.findById(dto.getLivroId());

        if (livroOptional.isEmpty()) {
            throw new RuntimeException("Livro não encontrado");
        }

        Usuario usuario = usuarioOptional.get();
        Livro livro = livroOptional.get();

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);

        emprestimo = emprestimoRepository.save(emprestimo);

        return toResponseDTO(emprestimo);
    }

    private EmprestimoResponseDTO toResponseDTO(Emprestimo emprestimo) {

        EmprestimoResponseDTO dto = new EmprestimoResponseDTO();

        dto.setId(emprestimo.getId());
        dto.setDataEmprestimo(emprestimo.getDataEmprestimo());
        dto.setDataDevolucao(emprestimo.getDataDevolucao());

        dto.setUsuario(emprestimo.getUsuario().getNome());
        dto.setLivro(emprestimo.getLivro().getTitulo());

        return dto;
    }

    public List<EmprestimoResponseDTO> listar() {

        List<Emprestimo> emprestimos = emprestimoRepository.findAll();

        return emprestimos.stream().map(emprestimo -> {

            return toResponseDTO(emprestimo);

        }).collect(Collectors.toList());
    }

    public EmprestimoResponseDTO buscarPorId(Long id) {

        Optional<Emprestimo> emprestimoOptional =
                emprestimoRepository.findById(id);

        if (emprestimoOptional.isEmpty()) {
            throw new RuntimeException("Empréstimo não encontrado");
        }

        Emprestimo emprestimo = emprestimoOptional.get();

        EmprestimoResponseDTO response = new EmprestimoResponseDTO();

        response.setId(emprestimo.getId());
        response.setDataEmprestimo(emprestimo.getDataEmprestimo());
        response.setDataDevolucao(emprestimo.getDataDevolucao());
        response.setUsuario(emprestimo.getUsuario().getNome());
        response.setLivro(emprestimo.getLivro().getTitulo());

        return response;
    }

    public void deletar(Long id) {

        Optional<Emprestimo> emprestimoOptional =
                emprestimoRepository.findById(id);

        if (emprestimoOptional.isEmpty()) {
            throw new RuntimeException("Empréstimo não encontrado");
        }

        emprestimoRepository.deleteById(id);
    }
}