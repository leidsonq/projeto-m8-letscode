package br.com.leidson.projetoM8letscode.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class ItemIventario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private int quantidade;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;
}
