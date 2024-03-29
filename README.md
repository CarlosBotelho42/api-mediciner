## Sobre o projeto

- API-MEdiciner é um projeto para fins de aprendizado, para mnelhorar minhas habilidades com spring e suas tecnologias.

## Funcionalidades

- [x] 

---


## Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Flyway](https://documentation.red-gate.com/flyway)**
- **[Lombok](https://projectlombok.org/setup/maven)**

---

## Alterações

- Utilizar o Flyway como ferramenta de Migrations do projeto.
- Realizar validações com Bean Validation utilizando algumas de suas anotações, como a @NotBlank.
- Paginação com o Pageable do Spring(localhost:8080/medicos?size=1&page=o) Podemos utilizar no lugar do List de listar todos os medicos.
- Utilizando a interface Pageable do Spring para realizar consultas com paginação.
- Controle da paginação e a ordenação dos dados devolvidos pela API com os parâmetros page, size e sort.
- Criação do metodo PUT para fazer a atualização cadastral do medido, no entendo atualizamos apenas alguns dadodos passados nas regras de negocio(Para isso usei o DTO)
- Implementada a lógica de exclusão com o uso de um atributo booleano.
- Usando o server.error.include-stacktrace=never para travar o trace da resposta de requisicao quando acorre algum erro(importante pois no trace vem infos importantes sobre a API)
- Criada uma classe para isolar o tratamento de exceptions da API, com a utilização da anotação @RestControllerAdvice.
- Tratando erros do tipo 400 (Bad Request), para erros de validação do Bean Validation, na classe de tratamento de erros.
---

- Entendido o Funciona o processo de autenticação e autorização em uma API Rest;
- Adicionado o Spring Security ao projeto;
- Entendido  o comportamento padrão do Spring Security em uma aplicação;
- Implementado o processo de autenticação na API, de maneira Stateless, utilizando as classes e configurações do Spring Security.
- Adicionada a biblioteca Auth0 java-jwt como dependência do projeto;
- Utilizando essa biblioteca para realizar a geração de um token na API;
- Injetando uma propriedade do arquivo application.properties em uma classe gerenciada pelo Spring, utilizando a anotação @Value;
- Devolvendo um token gerado na API quando um usuário se autenticar nela.

---

- Entendendo o funcionamento dos Filters em uma requisição;
- Utilizada a biblioteca Auth0 java-jwt para realizar a validação dos tokens recebidos na API;
- Realizado o processo de autenticação da requisição, utilizando a classe SecurityContextHolder, do Spring;
- Liberar e restringir requisições, de acordo com a URL e o verbo do protocolo HTTP.

---

- Isolados os códigos de validações de regras de negócio em classes separadas, utilizando nelas a anotação @Component do Spring;
- Finalizada a implementação do algoritmo de agendamento de consultas;
- Utilizado os princípios SOLID para deixar o código da funcionalidade de agendamento de consultas mais fácil de entender, evoluir e testar.