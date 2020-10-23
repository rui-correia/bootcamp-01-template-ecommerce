package br.com.braz.rui.bootcamp01.mercadolivre.config.validator;

import br.com.braz.rui.bootcamp01.mercadolivre.annotation.NomeUnico;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NomeUnicoValidator implements ConstraintValidator<NomeUnico, String> {

    private String campo;
    private Class<?> classe;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(NomeUnico constraintAnnotation) {
        campo = constraintAnnotation.fieldName();
        classe = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {
        if (valor == null) return true;

        String valorLower = valor.toLowerCase();

        Query customQuery = entityManager.createQuery("select 3 from " + classe.getName() + " where " + campo + " = :valor");
        customQuery.setParameter("valor", valorLower);
        List<?> resultadoConsulta = customQuery.getResultList();
        Assert.state(resultadoConsulta.size() <= 1, "Conteúdo: " + valorLower + " já cadastrado no banco.");

        return resultadoConsulta.isEmpty();
    }
}
