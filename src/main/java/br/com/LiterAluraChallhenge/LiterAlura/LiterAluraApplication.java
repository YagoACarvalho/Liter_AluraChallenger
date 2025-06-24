package br.com.LiterAluraChallhenge.LiterAlura;

import br.com.LiterAluraChallhenge.LiterAlura.controller.MenuController;
import br.com.LiterAluraChallhenge.LiterAlura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private MenuController menuController;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		menuController.exibirMenu();
	}
}
