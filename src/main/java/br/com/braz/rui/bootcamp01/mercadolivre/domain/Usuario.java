package br.com.braz.rui.bootcamp01.mercadolivre.domain;

import br.com.braz.rui.bootcamp01.mercadolivre.annotation.NomeUnico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo email não pode ficar em branco.")
    @Email(message = "Email com formato inválido.")
    private String login;
    @NotBlank(message = "Campo senha não pode ficar em branco.")
    @Size(min = 6, message = "Tamanho mínimo da senha: 6 caracteres.")
    private String senha;
    @NotNull
    private LocalDateTime dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario(String login, String senha, LocalDateTime dataCadastro) {
        this.login = login;
        this.senha = senha;
        this.dataCadastro = LocalDateTime.now();
    }
}
