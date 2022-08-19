package com.capgemini.Imc_Api.controller;

import com.capgemini.Imc_Api.model.Paciente;
import com.capgemini.Imc_Api.repositories.PacienteRepository;
import com.capgemini.Imc_Api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {


    @Autowired
    private PacienteService service;
    @Autowired
    private final PacienteRepository pacienteRepository;

    public PacienteController(PacienteRepository pacienteRepository) {

        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        List<Paciente> result = service.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findbyId(@PathVariable Long id) {
        Paciente list = service.findById(id);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
        paciente = service.save(paciente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.PUT)
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente, @PathVariable Long id) {
        paciente = service.update(paciente, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "buscarPorNome")
    public ResponseEntity<List<Paciente>> buscarPorNome(@RequestParam(name = "name") String name) {

        List<Paciente> paciente = pacienteRepository.getPacientesByName(name);

        return new ResponseEntity<List<Paciente>>(paciente, HttpStatus.OK);
    }

    @GetMapping("/buscarImc")
    public ResponseEntity<List<Paciente>> buscarImc(@RequestParam(name = "imc") Double name) {

        List<Paciente> paciente = pacienteRepository.getPacientesByImc(name);

        return new ResponseEntity<List<Paciente>>(paciente, HttpStatus.OK);

    }
}



