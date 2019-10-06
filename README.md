# squad-3-java

## Central de Erros
## Objetivo
Em projetos modernos é cada vez mais comum o uso de arquiteturas baseadas em serviços ou microsserviços. Nestes ambientes complexos, erros podem surgir em diferentes camadas da aplicação (backend, frontend, mobile, desktop) e mesmo em serviços distintos. Desta forma, é muito importante que os desenvolvedores possam centralizar todos os registros de erros em um local, de onde podem monitorar e tomar decisões mais acertadas. Neste projeto vamos implementar um sistema para centralizar registros de erros de aplicações.

### A arquitetura do projeto é formada por:

#### Backend - API
criar endpoints para serem usados pelo frontend da aplicação
criar um endpoint que será usado para gravar os logs de erro em um banco de dados relacional
a API deve ser segura, permitindo acesso apenas com um token de autenticação válido

#### Frontend
deve implementar as funcionalidades apresentadas nos wireframes
deve ser acessada adequadamente tanto por navegadores desktop quanto mobile
deve consumir a API do produto
desenvolvida na forma de uma Single Page Application

#### A API tem como principais dependências:

- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Web Starter](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html)
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html)
- [Lombok](https://projectlombok.org/)
- [PostgresSQL Driver](https://www.postgresql.org/)
- [Swagger](https://swagger.io/)
- [oauth2] (https://oauth.net/2/)

## Banco de dados
- H2
- PostgresSQL

## Modelo de dados
- Usuario
- Log

## Organização de código automatizado
- GoogleStyle (http://google.github.io/styleguide/)