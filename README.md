# 📦 Sistema de Gestão de Estoque

API REST desenvolvida com **Java e Spring Boot** para gerenciamento de produtos e controle de estoque.

O sistema implementa operações de **CRUD**, controle de entrada e saída de produtos e regras de negócio para garantir a integridade do estoque, respeitando um limite máximo global de **5.000 unidades**.

---

## 🎯 Objetivo do Projeto

- Desenvolver uma API REST para gerenciamento de produtos;
- Aplicar regras de negócio relacionadas ao controle de estoque;
- Garantir a consistência e integridade das operações;
- Praticar o desenvolvimento de aplicações utilizando Spring Boot e JPA.

---

## 🧱 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?style=flat-square&logo=springboot&logoColor=white)
![Spring Web](https://img.shields.io/badge/Spring%20Web-3.5.0-brightgreen?style=flat-square&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.5.0-brightgreen?style=flat-square&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=flat-square&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql&logoColor=white)
![Jakarta Validation](https://img.shields.io/badge/Jakarta%20Validation-3.5.0-orange?style=flat-square)
![Lombok](https://img.shields.io/badge/Lombok-1.18.x-red?style=flat-square)
![Swagger](https://img.shields.io/badge/Swagger%2FOpenAPI-2.8.6-85EA2D?style=flat-square&logo=swagger&logoColor=black)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=flat-square&logo=apachemaven&logoColor=white)

---

## ✨ Funcionalidades

### 📦 Produto

- Cadastro de produtos;
- Listagem de todos os produtos;
- Consulta de produto por ID;
- Atualização das informações de um produto;
- Remoção de um produto;
- Remoção de todos os produtos.

### 📊 Controle de Estoque

- Consulta do estoque total;
- Entrada de produtos no estoque;
- Saída de produtos do estoque;
- Validação do limite máximo global de estoque;
- Validação da quantidade disponível para retirada.

---

## ⚙️ Regras de Negócio

- O estoque total não pode ultrapassar **5.000 unidades**;
- Não é permitido adicionar quantidade nula ou negativa;
- Não é permitido retirar quantidade nula ou negativa;
- Não é permitido retirar uma quantidade superior ao estoque disponível;
- Produtos inexistentes não podem ser consultados ou alterados;
- As violações das regras de negócio geram exceções específicas.

---

## 📄 Documentação da API

A API pode ser explorada e testada através da documentação interativa do **Swagger / OpenAPI**.

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```
---
## 📡 Rotas da API

### 📦 Produto

| Método | Rota | Descrição |
|:------:|:--------------------------|:--------------------------------|
| **GET** | `/produto/showAll` | Lista todos os produtos |
| **GET** | `/produto/show/{id}` | Busca um produto pelo ID |
| **POST** | `/produto/add` | Cadastra um novo produto |
| **PUT** | `/produto/edit/{id}` | Atualiza um produto existente |
| **DELETE** | `/produto/delete/{id}` | Remove um produto pelo ID |
| **DELETE** | `/produto/deleteAll` | Remove todos os produtos |

---

## 📁 Estrutura do Projeto

```text
src/
└── main/
    └── java/
        └── Estoque_CRUD/
            ├── controller/
            │
            ├── core/
            │   ├── exception/
            │   └── infra/
            │
            ├── dto/
            │
            ├── model/
            │
            ├── repository/
            │
            ├── service/
            │
            └── EstoqueCrudApplication.java
