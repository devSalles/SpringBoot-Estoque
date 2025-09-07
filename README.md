📦 SpringBoot-Estoque

Sistema de gestão de estoque desenvolvido em Spring Boot com integração ao MySQL.
O projeto implementa um CRUD completo (criar, listar, atualizar e remover produtos), seguindo boas práticas de APIs RESTful e persistência de dados.

✨ Funcionalidades

📌 Cadastro de produtos

📋 Listagem de todos os produtos

🔍 Consulta de produto por ID

✏️ Atualização de informações de um produto

🗑️ Remoção de produtos individuais ou em lote

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot (Web, Data JPA)

MySQL

Maven

Hibernate (ORM)

📂 Estrutura de Endpoints

Método	Endpoint	Descrição

GET	/produto/showAll	- Lista todos os produtos

GET	/produto/show/{id}	- Busca um produto por ID

POST	/produto/add	- Cria um novo produto

PUT	/produto/edit/{id}	- Atualiza informações de um produto

DELETE	/produto/delete/{id}	- Remove um produto por ID

DELETE	/produto/deleteAll	- Remove todos os produtos
