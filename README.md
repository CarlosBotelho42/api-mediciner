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
- Criada uma classe que trata Exceptions globais de forma mais facil sem por os try cat com o RestControllerAdvice