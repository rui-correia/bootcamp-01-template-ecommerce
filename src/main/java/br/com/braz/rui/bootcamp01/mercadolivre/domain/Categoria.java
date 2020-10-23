package br.com.braz.rui.bootcamp01.mercadolivre.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "t_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @Deprecated
    public Categoria(){}

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }
}
