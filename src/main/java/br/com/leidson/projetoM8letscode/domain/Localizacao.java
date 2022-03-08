package br.com.leidson.projetoM8letscode.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter @Setter
public class Localizacao {
    private UUID id;
    private int latitude;
    private int longetude;
    private String nome;

}
