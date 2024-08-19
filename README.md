# Serviço de Autenticação

Este projeto é um serviço de autenticação baseado em Kotlin, construído com o framework Ktor. Ele fornece funcionalidade de autenticação de usuário e usa PostgreSQL para armazenamento de dados.

## Índice
- [Funcionalidades](#funcionalidades)
- [Stack Tecnológica](#stack-tecnológica)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração](#configuração)
- [Executando a Aplicação](#executando-a-aplicação)
- [Endpoints da API](#endpoints-da-api)
- [Autenticação](#autenticação)
- [Banco de Dados](#banco-de-dados)
- [Dependências](#dependências)

## Funcionalidades
- Autenticação de usuário
- Geração de token JWT
- Controle de acesso baseado em funções
- Limitação de taxa
- Configuração CORS

## Stack Tecnológica
- Kotlin
- Framework Ktor
- PostgreSQL
- Exposed (Framework SQL)
- Koin (Injeção de Dependência)
- Bcrypt (Hash de senha)
- Docker (para container PostgreSQL)

## Estrutura do Projeto
O projeto segue uma abordagem de arquitetura limpa:

- `application`: Contém serviços da aplicação
- `domain`: Define a lógica de negócio central e entidades
- `infrastructure`: Lida com detalhes técnicos e preocupações externas
- `presentation`: Gerencia rotas da API e manipulação de requisições/respostas

## Configuração
1. Certifique-se de ter o JDK 8 ou superior instalado
2. Instale o Docker e o Docker Compose
3. Clone o repositório
4. Configure as variáveis de ambiente:
    - `DB_URL` (padrão: "jdbc:postgresql://localhost:5432/auth_db")
    - `DB_USER` (padrão: "auth-user")
    - `DB_PASSWORD` (obrigatório, sem valor padrão)

## Executando a Aplicação
1. Inicie o banco de dados PostgreSQL:
   ```
   docker-compose up -d
   ```
2. Execute a aplicação:
   ```
   ./gradlew run
   ```

## Endpoints da API
- POST `/login`: Autentica um usuário e recebe um token JWT

## Autenticação
O serviço usa JWT (JSON Web Tokens) para autenticação. Após o login bem-sucedido, um token é fornecido e deve ser incluído no cabeçalho `Authorization` para requisições subsequentes.

## Banco de Dados
O projeto usa PostgreSQL como seu banco de dados. O schema é criado automaticamente na inicialização da aplicação usando a função `SchemaUtils.create()` do Exposed.

## Dependências
As principais dependências incluem:
- Ktor: Framework web
- Exposed: Framework SQL
- Koin: Injeção de dependência
- Bcrypt: Hash de senha
- PostgreSQL: Driver de banco de dados

Para uma lista completa de dependências, consulte o arquivo `build.gradle.kts`.

## Desenvolvimento
O projeto usa Gradle como sua ferramenta de build. Tarefas comuns:
- Build: `./gradlew build`
- Executar: `./gradlew run`
- Testar: `./gradlew test`

## Notas
- Certifique-se de proteger adequadamente suas credenciais de banco de dados e configuração JWT em um ambiente de produção.
- A configuração atual usa um container Docker para PostgreSQL, o que é adequado para desenvolvimento. Para produção, considere usar um serviço de banco de dados gerenciado.