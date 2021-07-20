package com.basis.cg.xtarefas.service.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageByLocaleService {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String id) {
        Locale locale = new Locale("pt", "BR");
        return messageSource.getMessage(id, null, locale);
    }

}
