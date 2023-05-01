# Payment REST API
Bem-vindo(a) à API de pagamento de débitos para pessoas físicas e jurídicas!

Esta API permite que você receba pagamentos de débitos e os armazene no banco de dados com status Pendente de Processamento. Após o processamento por uma aplicação terceira, o status do pagamento poderá ser alterado de Pendente para Processado através de uma chamada para nossa API.

Além disso, esta API oferece a funcionalidade de listar todos os pagamentos recebidos e a possibilidade de filtrá-los por código do débito, CPF/CNPJ do pagador ou status do pagamento.

Para utilizar nossa API, basta clonar o repositório https://github.com/mauricioPReis/payment-rest-api e executá-la em sua máquina. Utilizamos o padrão REST com payloads e respostas em formato JSON e o banco de dados H2 embutido no Spring Boot.

Se tiver alguma dúvida, consulte a documentação em nosso repositório ou entre em contato com nossa equipe de suporte.

## Tecnologias Utilizadas

- Java 20
- Spring Boot
- H2 Database
- Maven
## Como executar o projeto
1. Clone o repositório em sua máquina local
2. Abra o terminal e navegue até a pasta do projeto
3. Execute o comando `mvn spring-boot:run`
4. Acesse `http://localhost:8080` para utilizar a API

## Endpoints da API
### Receber um pagamento

<details>
  <summary>Requisição</summary>

`POST /payments`
```json
{
  "debitCode": 123,
  "payerType": "12345678910",
  "paymentMethod": "cartao_credito",
  "cardNumber": "1234567890",
  "value": 100.00
}

```
Resposta
```json
{
  "id": 1,
  "debitCode": 123,
  "payerType": "12345678910",
  "paymentMethod": "cartao_credito",
  "cardNumber": "1234567890",
  "value": 100.00,
  "paymentStatus": "pendente_processamento"
}
```
</details>
  
### Atualizar status de um pagamento
<details>
  <summary>Requisição</summary>

`PUT /payments/{id}`
```json
{
  "paymentStatus": "processado_sucesso"
}
```
Resposta
```json
{
  "id": 1,
  "debitCode": 123,
  "payerType": "12345678910",
  "paymentMethod": "cartao_credito",
  "cardNumber": "1234567890",
  "value": 100.00,
  "paymentStatus": "processado_sucesso"
}
```  
</details>

### Listar todos os pagamentos
<details>
  <summary>Requisição</summary>
  
`GET /payments`

Resposta
```json
{
  "id": 1,
  "debitCode": 123,
  "payerType": "12345678910",
  "paymentMethod": "cartao_credito",
  "cardNumber": "1234567890",
  "value": 100.00,
  "paymentStatus": "processado_sucesso"
}
```
</details>

### Filtrar pagamentos
<details>
  <summary>Requisição</summary>
  
  A requisição pode ser feito fazendo filtro, de status do pagamento, CPF/CNPJ e código do débito
Exemplo:
  `GET /payments?debitCode=123&payerType=12345678910&paymentStatus=pendente_processamento`
  

```json
[
  {
    "id": 2,
    "debitCode": 123,
    "payerType": "12345678910",
    "paymentMethod": "cartao_credito",
    "cardNumber": "1234567890",
    "value": 100.00,
    "paymentStatus": "pendente_processamento"
  }
]
```
</details>

### Deletar um pagamento
<details>
  <summary>Requisição</summary>

Requisição
  Ire deletar o pagamento com o ID informado, desde que este ainda esteja com status Pendente de Processamento`pendente_processamento`
  
`DELETE /payments/{id}`

Resposta
Caso o pagamento tenha status "pendente_processamento":

  ```json
  204 No Content
  ```
  
  Caso contrário:
  ```json
  {
   "errorMessage": "Pagamento não encontrado"
  }
 
  ```
</details>
