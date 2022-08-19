package com.capgemini.Imc_Api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_pacientes")
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String idade;
    private Double peso;
    private Double altura;
    private Double imc;

    public Paciente(Long id, String name, String idade, Double peso, Double altura, Double imc) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }

    public Paciente() {

    }

    public Paciente(long id, String name, String idade, double peso, double altura, double imc) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;}
    }

