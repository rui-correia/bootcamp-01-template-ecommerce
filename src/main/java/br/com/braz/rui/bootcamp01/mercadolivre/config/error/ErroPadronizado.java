package br.com.braz.rui.bootcamp01.mercadolivre.config.error;

import java.util.Collection;

public class ErroPadronizado {

    Collection<String> mensagens;

    public ErroPadronizado(Collection<String> mensagens){
        this.mensagens = mensagens;
    }

    public Collection<String> getMensagens(){
        return mensagens;
    }

    public void setMensagens(Collection<String> mensagens){
        this
                .mensagens = mensagens;
    }

}
