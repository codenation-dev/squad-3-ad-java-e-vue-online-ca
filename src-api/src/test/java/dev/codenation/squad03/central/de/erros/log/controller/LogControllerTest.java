package dev.codenation.squad03.central.de.erros.log.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import dev.codenation.squad03.central.de.erros.exception.ResourceNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LogControllerTest {

  @Autowired
  private LogController logController;

  @Test
  public void dependencyInjectionTest() {
    assertThat(this.logController).isNotNull();
  }

  @Test(expected = ResourceNotFoundException.class)
  public void throwResourceNotFoudExcetion() {
    this.logController.findById(Long.MAX_VALUE);
  }

  @Test()
  public void shouldThrowExceptionWithRightMessage() {
    try {
      this.logController.findById(Long.MAX_VALUE);
      fail();
    } catch (ResourceNotFoundException e) {
      Long id = Long.MAX_VALUE;
      String message = e.getMessage().replace(".", "");
      assertThat(message).isEqualTo(String.format(LocaleContextHolder.getLocale(),
          "Informação não encontrada para o identificador: %d", id));
    }
  }
}