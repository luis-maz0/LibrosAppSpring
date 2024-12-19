package com.luismzo.ProyectoLibrosSpring.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luismzo.ProyectoLibrosSpring.model.DataLibros;
import com.luismzo.ProyectoLibrosSpring.service.ConsumoAPI;
import com.luismzo.ProyectoLibrosSpring.service.ConversorDataAPI;

import java.util.Scanner;

public class Principal {
    private String datoIngresado;
    private Scanner sc = new Scanner(System.in);
    private String json;
    private ConsumoAPI dataAPI = new ConsumoAPI();
    private ConversorDataAPI conversor = new ConversorDataAPI();

    public DataLibros mostrarLibros(){
        json = dataAPI.obtenerDataLibros("/");
        DataLibros libros = null;
        try {
            libros = conversor.obtenerDatos(json, DataLibros.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return libros;
    }
}
