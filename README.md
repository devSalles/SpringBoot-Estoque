📦 SpringBoot-Estoque

Sistema de gestão de estoque desenvolvido em Spring Boot com integração ao MySQL.
O projeto implementa um CRUD completo (criar, listar, atualizar e remover produtos) e um controle inteligente de estoque, respeitando um limite máximo global de 5000 unidades.

✨ Funcionalidades:

📌 Cadastro de produtos

📋 Listagem de todos os produtos

🔍 Consulta de produto por ID

✏️ Atualização de informações de um produto

🗑️ Remoção de produtos individuais ou em lote

📊 Consulta do estoque total

📥 Entrada de produtos no estoque com validação de limite máximo

📤 Saída de produtos no estoque com validação de quantidade disponível

🚀 Tecnologias Utilizadas:

Java 17+

Spring Boot (Web, Data JPA)

MySQL

Maven

Hibernate (ORM)

Swagger para testes

📂 Estrutura de Endpoints:

GET	/produto/showAll	- Lista todos os produtos

GET	/produto/show/{id}	- Busca um produto por ID

POST	/produto/add	- Cria um novo produto

PUT	/produto/edit/{id}	- Atualiza informações de um produto

DELETE	/produto/delete/{id}	- Remove um produto por ID

DELETE	/produto/deleteAll	- Remove todos os produtos

⚙️ Regras de Negócio:

🔒 O estoque total não pode ultrapassar 5000 unidades

❌ Não é permitido adicionar ou retirar quantidades nulas ou negativas

⚠️ Não é permitido retirar mais do que a quantidade disponível do produto

🛑 Caso uma regra seja violada, são lançadas exceções específicas:

IdNotFoundException → Produto não encontrado

StockOverFlowException → Quantidade excede o limite de 5000 unidades

InsufficientStockException → Estoque insuficiente para retirada
