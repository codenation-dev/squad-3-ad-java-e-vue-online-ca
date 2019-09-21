package dev.codenation.squad03.central.de.erros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe responsável por definir as configurações do Swagger.
 * 
 * @since 21.09.2019
 * @version 2.0
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apit() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("dev.codenation.squad03.central.de.erros.usuario.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API Central de Erros")
				.description("Documentação da API Central de Erros de acesso aos endpoints com Swagger.")
				.version("1.0")
				.build();
	}
}
