# Desafio Cliente-Contatos

Este projeto é uma API RESTful desenvolvida com Spring Boot como parte de um desafio técnico. O objetivo é gerenciar clientes e seus contatos.

## 🛠 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 (para testes) ou MySQL (produção)
- Maven
- Git

## 📁 Estrutura do Projeto

```
src/
 └── main/
     ├── java/
     │   └── spring.boot.desafio.Nubank/
     │       ├── controllers/
     │       ├── dto/
     │       ├── models/
     │       ├── repositories/
     │       └── services/
     └── resources/
         └── application.properties
```

## 🚀 Funcionalidades

- Cadastro de cliente
- Cadastro de contato associado a um cliente
- Listagem de todos os clientes
- Listagem de contatos por cliente
- Validações básicas de entrada

## 🔧 Como rodar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/SEU_USUARIO/Desafio-Cliente-Contatos.git
```

2. Acesse o diretório:
```bash
cd Desafio-Cliente-Contatos
```

3. Rode o projeto via sua IDE (STS, IntelliJ, Eclipse) ou via terminal:
```bash
./mvnw spring-boot:run
```

4. Acesse a aplicação:
```
http://localhost:8080
```

## 📫 Endpoints principais

| Método | Rota                     | Descrição                     |
|--------|--------------------------|-------------------------------|
| POST   | /clients                 | Cadastra um novo cliente      |
| POST   | /contacts                | Cadastra um contato           |
| GET    | /clients                 | Lista todos os clientes       |
| GET    | /clients/{id}/contacts  | Lista os contatos de um cliente |

## 📌 Observações

- Este projeto ainda está em desenvolvimento.
- Testes unitários e integração serão adicionados futuramente.

---

## ✒️ Autor

Feito com 💻 por Vagner Junior Ventura.
