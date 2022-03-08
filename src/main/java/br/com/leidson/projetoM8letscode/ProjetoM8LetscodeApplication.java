package br.com.leidson.projetoM8letscode;

import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.repositories.RebeldeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjetoM8LetscodeApplication implements CommandLineRunner {

	@Autowired
	RebeldeRepository rebeldeRepository;

	public static void main(String[] args) {

		SpringApplication.run(ProjetoM8LetscodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Rebelde rebelde = new Rebelde(null,"Leidson",33, "Masculino");
		rebeldeRepository.saveAll(Arrays.asList(rebelde));
	}
}
