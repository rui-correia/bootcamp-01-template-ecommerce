package br.com.braz.rui.bootcamp01.mercadolivre.request;

import br.com.braz.rui.bootcamp01.mercadolivre.annotation.ExisteCadastrado;
import br.com.braz.rui.bootcamp01.mercadolivre.annotation.NomeUnico;
import br.com.braz.rui.bootcamp01.mercadolivre.domain.Categoria;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCategoriaRequest {

    @NotBlank(message = "Nome não deve estar em branco.")
    @NomeUnico(domainClass = Categoria.class, fieldName = "nome")
    private String nome;
    @ExisteCadastrado(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoriaMae;

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

    public Long getIdCategoriaMae() {
        return idCategoriaMae;
    }

    public void setIdCategoriaMae(Long idCategoriaMae) {
        this.idCategoriaMae = idCategoriaMae;
    }

    public Categoria toModel(EntityManager entityManager) {
        Categoria categoriaMae = null;
        if (idCategoriaMae != null) {
            categoriaMae = entityManager.find(Categoria.class, idCategoriaMae);
        }
        return new Categoria(this.nome, categoriaMae);
    }
}
