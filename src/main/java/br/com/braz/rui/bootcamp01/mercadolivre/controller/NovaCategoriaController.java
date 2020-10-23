package br.com.braz.rui.bootcamp01.mercadolivre.controller;

import br.com.braz.rui.bootcamp01.mercadolivre.domain.Categoria;
import br.com.braz.rui.bootcamp01.mercadolivre.request.NovaCategoriaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/novaCategoria")
public class NovaCategoriaController {

    @Autowired
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> novaCategoria(@Valid @RequestBody NovaCategoriaRequest novaCategoriaRequest){


        novaCategoriaRequest.setNome(novaCategoriaRequest.getNome().toLowerCase());
        Categoria categoria = novaCategoriaRequest.toModel();
        entityManager.persist(categoria);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
