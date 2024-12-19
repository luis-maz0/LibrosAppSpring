package com.luismzo.ProyectoLibrosSpring;

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
		//USO DE API:
		//https://gutendex.com/?ref=public_apis&utm_medium=website
		//Menu
		/*1. DATOS LIBROS.
		* 2. TOP 10 LIBROS MAS DESCARGADOS (DIGITALES)
		* 3. LIBRO A BUSCAR
		* 4. ESTADISTICAS LIBRO
		* */
	}
}