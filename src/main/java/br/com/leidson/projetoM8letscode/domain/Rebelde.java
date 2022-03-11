package br.com.leidson.projetoM8letscode.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Rebelde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private int idade;
    private String genero;
    private boolean traidor = false;
    private int traicao = 0;

    @OneToOne
    @JoinColumn (name = "localizacao_id")
    private Localizacao localizacao;
    @OneToOne
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;


}
