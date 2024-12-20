package com.luismzo.ProyectoLibrosSpring.principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luismzo.ProyectoLibrosSpring.model.DataLibro;
import com.luismzo.ProyectoLibrosSpring.model.DataLibros;
import com.luismzo.ProyectoLibrosSpring.service.ConsumoAPI;
import com.luismzo.ProyectoLibrosSpring.service.ConversorDataAPI;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        libros.forEach(System.out::println);
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
    public void buscarLibro(){
        System.out.println("Ingrese el nombre del libro: ");
        datoIngresado = sc.next();
        json = dataAPI.obtenerDataLibros("/?search="+datoIngresado.replace(" ","+"));
        DataLibros resultado = null;
        try {
            resultado = conversor.obtenerDatos(json, DataLibros.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if( !resultado.libros().isEmpty() ){
            resultado.libros().forEach(dataLibro -> {
                System.out.println("Titulo: " + dataLibro.titulo());
                System.out.println("Autor/es: " + dataLibro.autores());
                System.out.println("Traducciones: " + dataLibro.lenguajes());
            });
        }else{
            System.out.println("Lo siento! Libro no encontrado");
        }

    }
    public void mostrarEstadisticas(){
        List<DataLibro> libros = this.mostrarLibros().libros();
        DoubleSummaryStatistics estadisticas = libros.stream()
                .filter(d -> d.cantidad_descargas()>0)
                .collect(Collectors.summarizingDouble(DataLibro::cantidad_descargas));
        System.out.println("Cantidad maxima de descargas: " + estadisticas.getMax() );
        System.out.println("Cantidad minima de descargas: " + estadisticas.getMin() );
        System.out.println("Cantidad promedio de descargas: " + estadisticas.getAverage() );
        System.out.println("Libros analizados: " + estadisticas.getCount() );
    }
}
