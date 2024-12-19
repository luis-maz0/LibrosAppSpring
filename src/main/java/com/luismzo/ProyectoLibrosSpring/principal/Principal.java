package com.luismzo.ProyectoLibrosSpring.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luismzo.ProyectoLibrosSpring.model.DataLibro;
import com.luismzo.ProyectoLibrosSpring.model.DataLibros;
import com.luismzo.ProyectoLibrosSpring.service.ConsumoAPI;
import com.luismzo.ProyectoLibrosSpring.service.ConversorDataAPI;

import java.util.Comparator;
import java.util.List;
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
    public void mostrarCadaLibro(){
        List<DataLibro> libros = this.mostrarLibros().libros();
        libros.stream()
                .forEach(System.out::println);
    }
    public void mostrarTopLibrosMasVendidos(){
        List<DataLibro> libros = this.mostrarLibros().libros();
        System.out.println("TOP 10 LIBROS MAS DESCARGADOS");
        libros.stream()
                .sorted(Comparator.comparing(DataLibro::cantidad_descargas).reversed())
                .limit(10)
                .forEach(dataLibro -> {
                    System.out.println("Titulo:"+dataLibro.titulo() + " CantidadDescargas: "+dataLibro.cantidad_descargas());
                });
    }
}
