# 📘 Projeto Java - Sistema de Cadastro com CRUD, Validações e Banco de Dados

Este projeto foi desenvolvido como parte de um trabalho acadêmico da faculdade. Ele consiste em um sistema simples de cadastro de produtos, utilizando a linguagem Java com aplicação de CRUD, validações e integração com banco de dados MySQL.

## 🎯 Funcionalidades

- Cadastro de produtos
- Listagem dos produtos registrados
- Atualização de dados dos produtos
- Remoção de produtos do banco
- Validações de entrada de dados
- Conexão com banco de dados utilizando JDBC

## 🛠️ Tecnologias Utilizadas

- Java  
- JDBC  
- MySQL Xampp
- IDE: Eclipse

## 🗂️ Estrutura do Projeto

- `model/Produto.java`: Classe que representa o modelo de dados.
- `dao/ProdutoDAO.java`: Classe responsável pelas operações no banco de dados.
- `factory/ConnectionFactory.java`: Classe responsável por criar conexões com o MySQL.
- `aplicacao/Main.java`: Classe principal com a lógica de interação do usuário e chamadas ao DAO.
