package br.com.leidson.projetoM8letscode.repositories;

import br.com.leidson.projetoM8letscode.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
