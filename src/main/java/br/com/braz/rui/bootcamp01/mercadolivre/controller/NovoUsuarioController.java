package br.com.braz.rui.bootcamp01.mercadolivre.controller;

import br.com.braz.rui.bootcamp01.mercadolivre.domain.Usuario;
import br.com.braz.rui.bootcamp01.mercadolivre.request.NovoUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;



@RestController
@RequestMapping(value = "/novoUsuario")
public class NovoUsuarioController {

    @Autowired
    EntityManager entityManager;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity<?> novoUsuario(@Validated @RequestBody NovoUsuarioRequest novoUsuarioRequest){

        novoUsuarioRequest.setSenha(bCryptPasswordEncoder.encode(novoUsuarioRequest.getSenha()));
        novoUsuarioRequest.setLogin(novoUsuarioRequest.getLogin().toLowerCase());
        Usuario usuario = novoUsuarioRequest.toModel();
        entityManager.persist(usuario);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
