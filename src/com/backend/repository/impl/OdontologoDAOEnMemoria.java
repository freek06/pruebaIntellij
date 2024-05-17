package com.backend.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.backend.entity.Odontologo;
import com.backend.repository.IDao;
import org.apache.log4j.Logger;

public class OdontologoDAOEnMemoria implements IDao<Odontologo> {
    private static final Logger LOGGER = Logger.getLogger(OdontologoDAOEnMemoria.class);
    private List<Odontologo> odontologos = new ArrayList<>();
    private long idCounter = 1;

    public OdontologoDAOEnMemoria() {
        // Inicializamos la lista con los datos de prueba.
        odontologos.add(new Odontologo(idCounter++, "12345", "Fulanito", "Cosme"));
        odontologos.add(new Odontologo(idCounter++, "67890", "Nemo", "Payaso"));
        odontologos.add(new Odontologo(idCounter++, "56473", "Elmer", "Grunnion"));
        odontologos.add(new Odontologo(idCounter++, "69960", "Nombre4", "Apellido4"));
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologo.setId(idCounter++);
        odontologos.add(odontologo);
        LOGGER.info("Odontólogo guardado en memoria: " + odontologo);
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Lista de odontólogos en memoria: " + odontologos);
        return new ArrayList<>(odontologos);
    }
}
