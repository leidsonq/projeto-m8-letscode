package br.com.leidson.projetoM8letscode.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int latitude;
    private int longetude;
    private String nome;

    @OneToOne
    @JoinColumn(name = "rebelde_id")
    private Rebelde rebelde;

}
