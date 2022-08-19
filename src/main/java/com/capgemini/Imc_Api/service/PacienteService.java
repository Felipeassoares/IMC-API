package com.capgemini.Imc_Api.service;

import com.capgemini.Imc_Api.model.Paciente;
import com.capgemini.Imc_Api.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> findAll() {
        return repository.findAll();
    }

    public Paciente findById(Long id) {
        Optional<Paciente> obj = repository.findById(id);
        return obj.get();
    }

    public Paciente save(Paciente paciente) {

        return repository.save(paciente);
    }

    public Paciente update(Paciente paciente, Long id) {
        paciente.setId(id);
        return repository.save(paciente);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

    public Paciente update(String name, long id) {
        return null;
    }
}

