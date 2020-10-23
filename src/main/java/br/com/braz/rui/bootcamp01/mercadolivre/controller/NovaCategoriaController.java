package br.com.braz.rui.bootcamp01.mercadolivre.controller;

import br.com.braz.rui.bootcamp01.mercadolivre.request.NovaCategoriaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/novaCategoria")
public class NovaCategoriaController {

    @PostMapping
    public ResponseEntity<?> novaCategoria(@RequestBody NovaCategoriaRequest novaCategoriaRequest){
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
