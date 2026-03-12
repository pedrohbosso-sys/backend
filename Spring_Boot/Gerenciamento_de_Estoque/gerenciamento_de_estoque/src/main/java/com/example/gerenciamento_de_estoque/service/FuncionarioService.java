package com.example.gerenciamento_de_estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gerenciamento_de_estoque.model.Funcionario;
import com.example.gerenciamento_de_estoque.repository.FuncionarioAutenticadoRepository;
import com.example.gerenciamento_de_estoque.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioAutenticadoRepository funcionarioAutenticadoRepository;

    public boolean cadastrar(String nome, String nif, String senha) {
        // Verifica se NIF e nome estão autorizados
        boolean autorizado = funcionarioAutenticadoRepository
                .existsByNifAndNomeAndAtivoTrue(nif, nome);

        if (!autorizado) {
            return false;
        }

        // Verifica se NIF já está cadastrado
        if (funcionarioRepository.existsByNif(nif)) {
            return false;
        }

        // Salva o funcionário
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setNif(nif);
        funcionario.setSenha(senha);
        funcionario.setAtivo(true);
        funcionarioRepository.save(funcionario);

        return true;
    }

    public Funcionario login(String nif, String senha) {
        return funcionarioRepository.findByNif(nif)
                .filter(f -> f.getSenha().equals(senha))
                .filter(f -> f.isAtivo())
                .orElse(null);
    }
}