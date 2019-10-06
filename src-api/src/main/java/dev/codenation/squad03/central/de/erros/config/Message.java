package dev.codenation.squad03.central.de.erros.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Message {

  @Autowired
  private MessageSource messageSource;

  public String build(String message, List<Object> arguments) {
    return messageSource.getMessage(message, arguments.toArray(), LocaleContextHolder.getLocale());
  }
}