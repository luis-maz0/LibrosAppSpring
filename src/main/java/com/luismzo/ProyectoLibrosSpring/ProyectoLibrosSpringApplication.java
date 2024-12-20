package com.luismzo.ProyectoLibrosSpring;

import com.luismzo.ProyectoLibrosSpring.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoLibrosSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoLibrosSpringApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//TODO: funciona todo ok! Fataria agregar un menú interactivo.
		Principal principal = new Principal();
		principal.mostrarLibros();
		principal.mostrarTopLibrosMasVendidos();
		principal.buscarLibro();
		principal.mostrarEstadisticas();
	}
}
