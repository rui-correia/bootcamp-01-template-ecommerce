package br.com.braz.rui.bootcamp01.mercadolivre.request;

import br.com.braz.rui.bootcamp01.mercadolivre.annotation.NomeUnico;
import br.com.braz.rui.bootcamp01.mercadolivre.domain.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @NomeUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public NovaCategoriaRequest(){}


    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
