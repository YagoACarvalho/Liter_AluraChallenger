📚 LiterAlura Challenge
LiterAlura é uma aplicação Java desenvolvida com Spring Boot que permite gerenciar um catálogo de livros e autores, consumindo dados de uma API externa e armazenando as informações em um banco de dados relacional.
🚀 Funcionalidades

✅ Buscar e cadastrar livros através de API externa
✅ Listar livros cadastrados no banco de dados
✅ Listar autores cadastrados
✅ Listar autores vivos em um determinado ano
✅ Buscar livros por idioma
✅ Interface de linha de comando interativa
✅ Persistência de dados com JPA/Hibernate

🛠️ Tecnologias Utilizadas
Backend

Java 17+ - Linguagem de programação principal
Spring Boot 3.5.3 - Framework principal para desenvolvimento
Spring Data JPA - Abstração para persistência de dados
Hibernate 6.6.18 - ORM (Object-Relational Mapping)

Banco de Dados

PostgreSQL - Banco de dados relacional (produção)
H2 Database - Banco em memória (desenvolvimento/testes)
HikariCP - Pool de conexões de alta performance

Consumo de API

HTTP Client - Cliente HTTP nativo do Java (Java 11+)
Jackson - Serialização/deserialização JSON
API Externa - Gutendex API para dados de livros

Ferramentas de Build

Maven - Gerenciamento de dependências e build
Maven Wrapper - Execução do Maven sem instalação local

📋 Pré-requisitos

Java 17 ou superior
Maven 3.6+ (ou usar o Maven Wrapper incluído)
PostgreSQL 12+ (opcional - pode usar H2 em memória)
