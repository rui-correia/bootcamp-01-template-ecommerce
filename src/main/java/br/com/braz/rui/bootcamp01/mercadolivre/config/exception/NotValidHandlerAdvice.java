package br.com.braz.rui.bootcamp01.mercadolivre.config.exception;

import br.com.braz.rui.bootcamp01.mercadolivre.config.error.ErroPadronizado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class NotValidHandlerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroPadronizado> handle(MethodArgumentNotValidException methodArgumentNotValidException){
        Collection<String> mensagens = new ArrayList<>();
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
        fieldErrorList.forEach(fieldError -> {
            String mensagem = String.format("Falha: '%s': %s", fieldError.getField().toUpperCase(), fieldError.getDefaultMessage());
            mensagens.add(mensagem);
        });
        ErroPadronizado erroPadronizado = new ErroPadronizado(mensagens);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroPadronizado);
    }
}
