package br.com.leidson.projetoM8letscode.services;

import br.com.leidson.projetoM8letscode.domain.Inventario;
import br.com.leidson.projetoM8letscode.domain.ItemIventario;
import br.com.leidson.projetoM8letscode.domain.Localizacao;
import br.com.leidson.projetoM8letscode.domain.Rebelde;
import br.com.leidson.projetoM8letscode.repositories.ItemInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemIventarioService {
    @Autowired
    private ItemInventarioRepository repo;

    @Autowired
    InventarioService inventarioService;

    public ItemIventario inserir(ItemIventario obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Optional<ItemIventario> buscar(Integer id) {
        Optional<ItemIventario> obj = repo.findById(id);
        return obj;
    }

    public void atualizarInventario (Integer idIventario, Integer idItemIventario) {
        Optional<Inventario> inventario = inventarioService.buscar(idIventario);
        Inventario novoIventario = new Inventario();
        if(inventario.isPresent()){
            novoIventario = inventario.get();
        }
        Optional<ItemIventario> itemIventario = buscar(idItemIventario);
        ItemIventario novoItemInventario = new ItemIventario();
        if (itemIventario.isPresent()) {
            novoItemInventario = itemIventario.get();
        }
        novoIventario.getItensInventario().add(novoItemInventario);
        inventarioService.atualizar(novoIventario);
    }
}
