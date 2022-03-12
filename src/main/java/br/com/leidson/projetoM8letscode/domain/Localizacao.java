package br.com.leidson.projetoM8letscode.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Min(value = 0, message = "Latitude não deve ser menor que 0")
    @Max(value = 90, message = "Latitude não deve ser maior que 90")
    private int latitude;
    @Min(value = 0, message = "Latitude não deve ser menor que 0")
    @Max(value = 180, message = "Latitude não deve ser maior que 180")
    private int longitude;
    private String nome;

    @OneToOne
    @NotNull
    @JoinColumn(name = "rebelde_id")
    private Rebelde rebelde;

}
