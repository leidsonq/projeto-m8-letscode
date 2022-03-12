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
		ItemIventario itemIventario5 = new ItemIventario(null, item1, 5, null);
		ItemIventario itemIventario6 = new ItemIventario(null, item2, 6, null);
		ItemIventario itemIventario7 = new ItemIventario(null, item3, 8, null);
		ItemIventario itemIventario8 = new ItemIventario(null, item4, 3, null);

		Inventario inventario = new Inventario(null, new ArrayList<ItemIventario>());
		Inventario inventario2 = new Inventario(null, new ArrayList<ItemIventario>());
		inventario.getItensInventario().addAll(Arrays.asList(itemIventario1, itemIventario2, itemIventario3, itemIventario4));
		inventario2.getItensInventario().addAll(Arrays.asList(itemIventario5, itemIventario6, itemIventario7, itemIventario8));

		itemIventario1.setInventario(inventario);
		itemIventario2.setInventario(inventario);
		itemIventario3.setInventario(inventario);
		itemIventario4.setInventario(inventario);
		itemIventario5.setInventario(inventario2);
		itemIventario6.setInventario(inventario2);
		itemIventario7.setInventario(inventario2);
		itemIventario8.setInventario(inventario2);

		inventarioRepository.saveAll(Arrays.asList(inventario, inventario2));
		itemInventarioRepository.saveAll(Arrays.asList(
				itemIventario1, itemIventario2, itemIventario3, itemIventario4,
				itemIventario6, itemIventario7, itemIventario8));


		Rebelde rebelde = new Rebelde(null,"João",33, "Masculino", false, null, inventario);
		Rebelde rebelde2 = new Rebelde(null,"Maria",34, "Feminino", false, null, inventario2);
		Rebelde rebelde3 = new Rebelde(null,"José",38, "Masculino", false, null, inventario2);
		rebeldeRepository.saveAll(Arrays.asList(rebelde, rebelde2, rebelde3));

		Localizacao localizacao = new Localizacao(null, 1, 80, "lalala", rebelde);
		localizacaoRepository.saveAll(Arrays.asList(localizacao));
	}

}
