package br.com.leidson.projetoM8letscode.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Traicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer idDenunciante;
    private Integer idDenunciado;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Traicao traicao = (Traicao) o;

        if (idDenunciante != null ? !idDenunciante.equals(traicao.idDenunciante) : traicao.idDenunciante != null)
            return false;
        return idDenunciado != null ? idDenunciado.equals(traicao.idDenunciado) : traicao.idDenunciado == null;
    }

    @Override
    public int hashCode() {
        int result = idDenunciante != null ? idDenunciante.hashCode() : 0;
        result = 31 * result + (idDenunciado != null ? idDenunciado.hashCode() : 0);
        return result;
    }
}
