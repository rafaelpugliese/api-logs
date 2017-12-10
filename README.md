# Descrição
API utilizada para registrar logs de uma aplicação web. Com esta API é possível salvar e consultar, além de outros recursos,  registros em um banco de dados.

## Tecnologias

- Spring boot;
- JPA Repository;
- Maven;
- PostgreSQL;
- Spring Security;
- JSON;
- JWT;
- JUnit;

## Informações Adicionais
- Existem mais de 20 testes implementados, para executar, basta executar a classe ```br.audora.log.SuiteApplicationTest``` existente no pacote de testes.

# Configuração de execução

## IDE - Eclipse
Após baixar o projeto, deve-se realizar o importe no Eclipse pela opção do maven. A pasta raiz do projeto para importação é ```api```.

## Banco de dados
O projeto está configurado (```application.properties```) para executar com o banco PostgreSQL. No caso de execução do projeto utilizando um banco PostgreSQL, basta criar a base ```api_logs``` e configurar (```application.properties```) o usuário (atualmente está configurado com login ```postgres``` e senha ```postgres``` ). Na utilização de outro banco, deve-se alterar as configuraçãoes em ```application.properties```.

# Como executar

## IDE - Eclipse
 Após o projeto aberto no Eclipse, executar a classe ```br.audora.log.Application``` através do ```Java Application```.

# Execução
A API utiliza autenticação via token JWT. Para acessar os recursos, é necessário gerar um token através do serviço de Login (http://localhost:8080/login) utilizando o método POST - ver  ```Executando a autenticação``` em [Autenticação com JWT no Spring Boot](http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/). Nesta API, está configurado (```application.properties```) o usuário ```audora``` e a senha ```audora```.

Após realizada a autenticação, o token de retorno deve ser utilizado nas demais requisições conforme ```Executando a autenticação``` em [Autenticação com JWT no Spring Boot](http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/).

## Dados de exemplo para requisição de salvar um log

### Requisição

| Campo | valor |
| ------------- | ------------- |
| Link | http://localhost:8080/logs |
| Método | POST |
| Header | Content-Type: application/json <br> Authorization: token\** |
| Body* | { "produto":"OAB", "cliente":"Alagoas", "categoria":"permissão", "dataHora":"2017-12-16 08:40:10", "registros": { "usuario": {"nome": "José da silva", "idade": 55}, "descricao":"Descrição do usuário"}} |

\* Dados enviados pelo campo ```raw```. O formato do JSON recebido por ```registro``` é genérico, portanto, qualquer JSON pode ser enviado neste campo, desde um único campo, até "objetos" em formato JSON.

\** Exemplo de valor para o token: ```Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhdWRvcmEiLCJleHAiOjE1MTM2Nzg5NjR9.UGmbKijIkpeRMU03q4gh9lB6pqSFbvDMbUuAEi3HZuNNojYGZz-Q0Hw83ndR_1tLtV8GNwpXvtTYo8rAO5zzDQ```

### Resposta

```json
{
    "produto": "OAB",
    "cliente": "Alagoas",
    "dataHora": "2017-12-16 08:40:10",
    "categoria": "permissão",
    "registros": {
        "usuario": {
            "nome": "José da silva",
            "idade": 55
        },
        "descricao": "Descrição do usuário"
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/logs/1"
        },
        "log": {
            "href": "http://localhost:8080/logs/1"
        }
    }
}
```

## Dados de exemplo para requisição de consulta

### Requisição

| Campo | valor |
|---------|---------|
| Link*** | http://localhost:8080/log/search?**produto**=OBA&**cliente**=Alagoas&**categoria**=permissão&**dataInicial**=2017-12-16%2005:20:10&**dataFinal**=2017-12-16%2009:30:10|
| Método | GET |
| Header | Content-Type: application/json <br> Authorization: token |

\*** Todos os parâmetros/filtros são opcionais

### Resposta

```json
[
    {
        "id": 1,
        "produto": "OAB",
        "cliente": "Alagoas",
        "dataHora": "2017-12-16 08:40:10",
        "categoria": "permissão",
        "registros": {
            "usuario": {
                "nome": "José da silva",
                "idade": 55
            },
            "descricao": "Descrição do usuário"
        }
    }
]
```

<!--
     ## Outros recursos

| Campo | valor |
| ------------- | ------------- |
| Link | http://localhost:8080/logs/{id} |
| Método | DELETE |
| Header | Content-Type: application/json <br> Authorization: token |
-->
