package br.com.braz.rui.bootcamp01.mercadolivre.config.validator;

import br.com.braz.rui.bootcamp01.mercadolivre.annotation.ExisteCadastrado;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExisteCadastradoValidator implements ConstraintValidator<ExisteCadastrado, Long> {

    private String campo;
    private Class<?> classe;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(ExisteCadastrado existeCadastrado) {
        campo = existeCadastrado.fieldName();
        classe = existeCadastrado.domainClass();
    }

    @Override
    public boolean isValid(Long idAtributo, ConstraintValidatorContext constraintValidatorContext) {
        if (idAtributo == null) return true;

        Query customQuery = entityManager.createQuery("select 1 from " + classe.getName() + " where " + campo + " = :idAtributo");
        customQuery.setParameter("idAtributo", idAtributo);

        List<?> resultado = customQuery.getResultList();
        Assert.isTrue(resultado.size() <= 1, "Nenhum registro encontrado com id: " + campo + " na tabela: " + classe.getName().toUpperCase());
        return !resultado.isEmpty();

    }
}
