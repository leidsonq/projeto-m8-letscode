package br.com.leidson.projetoM8letscode;

import br.com.leidson.projetoM8letscode.domain.*;
import br.com.leidson.projetoM8letscode.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ProjetoM8LetscodeApplication implements CommandLineRunner {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemInventarioRepository itemInventarioRepository;

	@Autowired
	InventarioRepository inventarioRepository;

	@Autowired
	LocalizacaoRepository localizacaoRepository;

	@Autowired
	RebeldeRepository rebeldeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoM8LetscodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Item item1 = new Item(null, "Arma", 4);
		Item item2 = new Item(null, "Munição", 3);
		Item item3 = new Item(null, "Água", 2);
		Item item4 = new Item(null, "Comida", 1);

		itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));

		ItemIventario itemIventario1 = new ItemIventario(null, item1, 5, null);
		ItemIventario itemIventario2 = new ItemIventario(null, item2, 6, null);
		ItemIventario itemIventario3 = new ItemIventario(null, item3, 8, null);
		ItemIventario itemIventario4 = new ItemIventario(null, item4, 3, null);

		Inventario inventario = new Inventario(null, new ArrayList<ItemIventario>());
		inventario.getItensInventario().addAll(Arrays.asList(itemIventario1, itemIventario2, itemIventario3, itemIventario4));

		itemIventario1.setInventario(inventario);
		itemIventario2.setInventario(inventario);
		itemIventario3.setInventario(inventario);
		itemIventario4.setInventario(inventario);

		inventarioRepository.saveAll(Arrays.asList(inventario));
		itemInventarioRepository.saveAll(Arrays.asList(itemIventario1, itemIventario2, itemIventario3, itemIventario4));


		Localizacao localizacao = new Localizacao(null, 100, 80, "Mexico");
		localizacaoRepository.saveAll(Arrays.asList(localizacao));


		Rebelde rebelde = new Rebelde(null,"Leidson",33, "Masculino", false, 0, localizacao, inventario);
		rebeldeRepository.saveAll(Arrays.asList(rebelde));
	}

}
