package com.luismzo.ProyectoLibrosSpring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDataAPI {
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T obtenerDatos( String json, Class<T> clase) throws JsonProcessingException {
        return objectMapper.readValue(json, clase);
    }
}
