package com.redempleo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.redempleo.repository.UsuarioRepository;
import com.redempleo.model.Usuario;

@SpringBootApplication
public class RedempleoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedempleoApplication.class, args);
	}
	@Bean
	CommandLineRunner initDatabase(UsuarioRepository usuarioRepository) {
		return args -> {
			usuarioRepository.save(new Usuario("Fernanda", "fernanda@email.com"));
		};
	}
}