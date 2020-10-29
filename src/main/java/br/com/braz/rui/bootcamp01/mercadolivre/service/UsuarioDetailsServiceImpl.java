package br.com.braz.rui.bootcamp01.mercadolivre.service;

import br.com.braz.rui.bootcamp01.mercadolivre.config.security.UsuarioUD;
import br.com.braz.rui.bootcamp01.mercadolivre.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UsuarioDetailsServiceImpl implements UserDetailsService {

    @Autowired
    EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioUD usuarioUD = entityManager.createQuery("select u from " + Usuario.class + " where email = :email", UsuarioUD.class);
        customQuery.setParameter("email", email);


        Assert.isTrue(resultado == null, "Usuário não encontrado: " + email);

        return new UsuarioUD();
    }
}
