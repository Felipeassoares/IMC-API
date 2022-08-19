package com.capgemini.Imc_Api.PacienteController;

import com.capgemini.Imc_Api.controller.PacienteController;
import com.capgemini.Imc_Api.model.Paciente;
import com.capgemini.Imc_Api.repositories.PacienteRepository;
import com.capgemini.Imc_Api.service.PacienteService;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles(value = "test", inheritProfiles = false)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacienteControllerTest {

    @Autowired
    private PacienteController pacienteController;

    @MockBean
    private PacienteService pacienteService;

    @MockBean
    private PacienteRepository pacienteRepository;
    private Object paciente;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.pacienteController);
    }

    @Test
    public void findById() {

        when(this.pacienteService.findById(1L))
                .thenReturn(new Paciente(1L, "Felipe", "36", 86, 1.71, 29.7));

        given()
                .accept(ContentType.JSON)
                .when()
                .get("/api/pacientes/{id}", 1L)
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deletarPorId() throws Exception {
        pacienteService.delete(11L);

        Optional<Paciente> optionalPaciente = pacienteRepository
                .findById((11L));

        assertFalse(optionalPaciente.isPresent());
    }

    @Test
    public void update() throws Exception {
        pacienteService.update("Fernando", 1L);

        Optional<Paciente> optionalPaciente = Optional.ofNullable(pacienteService.update("Felipe", 1L));
    }

    @Test
    public void findAll() throws Exception {
        pacienteService.findAll();

        List<Paciente> optionalPaciente = pacienteService.findAll();

        assertTrue(List.of().isEmpty());
    }
}