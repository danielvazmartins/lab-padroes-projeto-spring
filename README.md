# Desafio de Projeto com Spring Boot aplicando Padrões de Projeto
Projeto entregue como desafio de projeto do bootcamp da [DIO](https://web.dio.me/) `Code Update TQI - Backend com Kotlin e Java` no módulo `Explorando Padrões de Projetos na Prática com Java`

## Padrões de projeto explorados
* **Singleton** - O conceito do Singleton é utilizado para instanciar os services e os repositorys, criando apenas uma única instância sempre que é utilizado, isso é feito no SpringBoot através da annotation `@Autowired`.
* **Strategy** - Esse conceito está sendo utilizado no clientService, onde temos uma interface com os métodos que devem ser implementados, e os servicos de clientePF e clientPJ fazem sua implementação específica. A ideia aqui foi apenas de aplicar o conceito, nessas classes daria para implementar mais regras que diferenciam cada tipo de cliente.
* **Facade** - Esse padrão de projeto é utilizado para ocultar a complexidade de um serviço. Estamos utilizando esse conceito dentro do clientService no método de registrar o cliente, onde recebemos os dados do cliente e apenas o cep, mas o serviço faz a implementação buscando o restante do endereço de uma API externa (viaCep). Poderiamos implementar mais coisas aqui, por exemplo, fazer uma consulta do cliente na base do Cerasa ou outra base para verificar se o cliente possui alguma restição, essas regras poderiam ser diferentes, conforme a estrategia, o tipo do cliente.

## Depências
* Spring Web
* SpringBoot DevTools
* Lombok
* Spring Data JPA
* H2 Database
* Spring OpenFeign
* SpringDoc OpenApi

## URLs do projeto
* [Console H2](http://localhost:8080/h2-console) - A senha se encontra no arquivo `application.properties` (admin123)
* [Swagger](http://localhost:8080/swagger-ui/index.html) - É possível fazer todos os testes utilizando o Swagger