package br.com.leidson.projetoM8letscode.repositories;

import br.com.leidson.projetoM8letscode.domain.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvetarioRepository extends JpaRepository<Inventario, Integer> {

}
