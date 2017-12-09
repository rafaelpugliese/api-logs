# Como configurar

## IDE - Eclipse
Após baixar o projeto, realizar o importe no eclipse pela opção do maven.

## Banco de dados
O projeto está configurado (```application.properties```) para executar com o banco postgres. No caso de execução do projeto utilizando um banco postgres, basta criar a base ```api_logs``` e configurar (```application.properties```) o usuário (atualmente está configurado com usuário ```postgres``` e senha ```postgres``` ). Na utilização de outro banco, deve-se alterar as configuraçãoes em ```application.properties```.

# Como executar

## IDE - Eclipse
 Após o projeto aberto no eclipse, executar a classe ```br.audora.log.Application``` através do ```Java Application```.

# Execução
A API utiliza autenticação via token jwt. Para acessar os recursos, é necessáo realizar autenticação através do serviço POST de login (http://localhost:8080/login), basta seguir os passos descritos em ```Executando a autenticação``` em [Autenticação com JWT no Spring Boot](http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/). Nesta API, está configurado (```application.properties```) o usuário ```audora``` e a senha ```audora```.

Após realizada a autenticação, o token de retorno deve ser utilizado nas demais requisições conforme ```Executando a autenticação``` em [Autenticação com JWT no Spring Boot](http://andreybleme.com/2017-04-01/autenticacao-com-jwt-no-spring-boot/).

## Dados de exemplo para requisição de salvar um log

### Requisição

| Campo | valor |
| ------------- | ------------- |
| Link | http://localhost:8080/logs |
| Header | Content-Type: application/json <br> Authorization: token\** |
| Body* | { "produto":"OAB", "cliente":"Alagoas", "categoria":"permissão", "dataHora":"2017-12-16 08:40:10", "registros": { "usuario": {"nome": "José da silva", "idade": 55}, "descricao":"Descrição do usuário"}} |

\* Dados enviados pelo campo ```raw```. O formato do json recebido pelo ```registro``` é genérico, portanto, qualquer json pode ser enviado neste campo.

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
| Link*** | http://localhost:8080/log/search?produto=OBA&cliente=Alagoas&categoria=permissão&dataInicial=2017-12-16%2008:40:10&dataFinal=2017-12-16%2008:40:10|
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
