package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionario não encontrado"));
    }

    public Funcionario createFuncionario(String nome, String cargo, BigDecimal salario, LocalDate dataContratacao) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(dataContratacao);
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario updateFuncionario(Long id, String nome, String cargo, BigDecimal salario, LocalDate dataContratacao) {
        Funcionario existingFuncionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Funcionario não encontrado"));

        existingFuncionario.setNome(nome);
        existingFuncionario.setCargo(cargo);
        existingFuncionario.setSalario(salario);
        existingFuncionario.setDataContratacao(dataContratacao);

        return funcionarioRepository.save(existingFuncionario);
    }

    public void deleteFuncionario(Long id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new NotFoundException("Funcionario não encontrado");
        }
        funcionarioRepository.deleteById(id);
    }
}
