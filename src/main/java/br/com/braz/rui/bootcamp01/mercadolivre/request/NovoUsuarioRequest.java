package br.com.braz.rui.bootcamp01.mercadolivre.request;


import br.com.braz.rui.bootcamp01.mercadolivre.annotation.NomeUnico;
import br.com.braz.rui.bootcamp01.mercadolivre.domain.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class NovoUsuarioRequest {

    @NotBlank(message = "Campo email não pode ficar em branco.")
    @Email(message = "Email com formato inválido.")
    @NomeUnico(domainClass = Usuario.class, fieldName = "login")
    private String login;
    @NotBlank(message = "Campo senha não pode ficar em branco.")
    @Size(min = 6, message = "Tamanho mínimo da senha: 6 caracteres.")
    private String senha;
    private LocalDateTime dataCadastro;

    @Deprecated
    public NovoUsuarioRequest(){}

    public NovoUsuarioRequest(@NotBlank(message = "Campo email não pode ficar em branco.") @Email(message = "Email com formato inválido.") String login, @NotBlank(message = "Campo senha não pode ficar em branco.") @Size(min = 6, message = "Tamanho mínimo da senha: 6 caracteres.") String senha, LocalDateTime dataCadastro) {
        this.login = login;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario toModel() {
        return new Usuario(
                this.login,
                this.senha,
                this.dataCadastro);
    }
}
