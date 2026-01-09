# DSCommerce – API REST com Spring Boot
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/gabrielcarvalhotp/dscommerce/blob/main/LICENSE)

## Sobre o projeto
API REST desenvolvida em Java com Spring Boot para um sistema de e-commerce, contemplando autenticação, autorização, gerenciamento de usuários, produtos, categorias e pedidos, seguindo boas práticas de arquitetura em camadas.

## Objetivo do Projeto
* Consolidar conhecimentos em Spring Boot
* Praticar segurança com OAuth2
* Trabalhar com modelagem de domínio
* Criar uma API REST organizada e escalável
* Servir como projeto de portfólio backend Java

## Arquitetura do Projeto
```text
src/main/java
 └── com.agvsistemas.dscommerce
     ├── controllers   → Camada de entrada (REST)
     ├── services      → Regras de negócio
     ├── repositories  → Persistência de dados
     ├── entities      → Modelo de domínio
     ├── dto           → Objetos de transferência de dados
     ├── config        → Configurações (segurança, autenticação, etc)
     ├── exceptions    → Tratamento de erros
     └── projections   → Consultas otimizadas
```
## Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* OAuth2 / JWT
* Maven
* JPA / Hibernate
* Banco de dados H2

## Como Executar o Projeto
### Pré-requisitos

* Java 21 (conforme configurado no projeto)
* Maven

### Passos
```bash
# Clonar o repositório
git clone https://github.com/gabrielcarvalhotp/dscommerce.git

# Entrar no diretório
cd dscommerce

# Executar a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em:
```text
http://localhost:8080
```

## Documentação de Requisitos

Este projeto foi baseado no documento de requisitos do sistema DSCommerce, utilizado nos cursos da DevSuperior, contendo:

* Casos de uso
* Modelo conceitual
* Regras de negócio
* Fluxos funcionais

## Autor
Gabriel Oliveira
