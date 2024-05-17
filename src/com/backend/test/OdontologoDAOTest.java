package com.backend.test;

import com.backend.entity.Odontologo;
import com.backend.repository.impl.OdontologoDAOEnMemoria;
import com.backend.repository.impl.OdontologoDaoH2;
import com.backend.service.impl.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OdontologoDAOTest {

    private OdontologoService odontologoServiceH2;
    private OdontologoService odontologoServiceMemoria;

    @BeforeEach
    void setup() {
        odontologoServiceH2 = new OdontologoService(new OdontologoDaoH2() {
            @Override
            public List<Odontologo> listar() {
                return null;
            }
        });
        odontologoServiceMemoria = new OdontologoService(new OdontologoDAOEnMemoria());
    }

    @Test
    void deberiaRegistrarseUnOdontologoEnH2() {
        Odontologo odontologo = new Odontologo("12345", "Nombre1", "Apellido1");
        Odontologo odontologoRegistrado = odontologoServiceH2.registraOdontologo(odontologo);
        assertNotNull(odontologoRegistrado.getId());
    }

    @Test
    void deberiaRetornarseUnaListaNoVaciaDeOdontologosEnH2() {
        assertFalse(odontologoServiceH2.listarOdontologos().isEmpty());
    }

    @Test
    void deberiaRegistrarseUnOdontologoEnMemoria() {
        Odontologo odontologo = new Odontologo("67890", "Nombre2", "Apellido2");
        Odontologo odontologoRegistrado = odontologoServiceMemoria.registraOdontologo(odontologo);
        assertNotNull(odontologoRegistrado.getId());
    }

    @Test
    void deberiaRetornarseUnaListaNoVaciaDeOdontologosEnMemoria() {
        odontologoServiceMemoria.registraOdontologo(new Odontologo("67890", "Nombre2", "Apellido2"));
        assertFalse(odontologoServiceMemoria.listarOdontologos().isEmpty());
    }
}
