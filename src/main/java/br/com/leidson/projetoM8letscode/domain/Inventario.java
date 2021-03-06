package br.com.leidson.projetoM8letscode.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Inventario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @NotNull
    @JoinColumn(name = "rebelde_id")
    private Rebelde rebelde;

    @JsonIgnore
    @OneToMany(mappedBy = "inventario")
    private List<ItemIventario> itensInventario = new ArrayList<>();
}
