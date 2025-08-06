# 📚 Literalura

**Literalura** é uma aplicação desenvolvida em Java utilizando o framework **Spring Boot**, que realiza a integração com a API pública do [Gutendex](https://gutendex.com/) para busca de livros de domínio público. A aplicação permite o armazenamento e a manipulação de informações sobre livros e autores em um banco de dados relacional.

Além da funcionalidade de busca, o sistema possibilita consultar, listar e aplicar filtros personalizados aos registros salvos localmente.

---

## 💡 Funcionalidades

-  Busca de livros por título através da API Gutendex.
-  Persistência de informações de livros e autores em banco de dados.
-  Listagem completa dos livros cadastrados.
-  Listagem dos autores armazenados.
-  Filtro de autores vivos em um determinado ano.
-  Filtro de livros por idioma.

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Spring Boot (versão 3.5.4)
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Jackson (processamento de JSON)
- API pública Gutendex (https://gutendex.com/)

---

## ✅ Pré-requisitos

Para executar a aplicação, certifique-se de ter os seguintes softwares instalados:

- **Java 21** ou superior
- **PostgreSQL** (instalado e em execução)

---

## ⚙️ Configuração do Banco de Dados

#### Antes de iniciar a aplicação, é necessário configurar corretamente o arquivo `application.properties`, localizado em:

```
src/main/resources/application.properties
```

```
spring.datasource.url=jdbc:postgresql://${DB_HOST}/literalura_db
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true
```

As propriedades DB_HOST, DB_USER e DB_PASSWORD correspondem a variáveis de ambiente que devem estar devidamente configuradas no ambiente de execução da aplicação.


###   Passos para configurar as variáveis de ambiente
1. **Defina as variáveis de ambiente
   No seu sistema operacional ou ambiente de execução, defina as variáveis:**

- **DB_HOST** — endereço do servidor PostgreSQL (ex: localhost:8080)
- **DB_USER** — usuário do banco de dados
- **DB_PASSWORD** — senha do banco de dados
  Exemplo para Linux/macOS (bash):

Exemplo para Linux/macOS (bash):
```
export DB_HOST=localhost:8080
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha
```
No Windows (PowerShell):
```
setx DB_HOST "localhost:8080"
setx DB_USER "seu_usuario"
setx DB_PASSWORD "sua_senha"
```
2. **Crie o banco de dados PostgreSQL
   Antes de iniciar a aplicação, certifique-se de que o banco de dados literalura_db existe no servidor PostgreSQL configurado.**

Você pode criar o banco com o seguinte comando SQL:

```sql
CREATE DATABASE literalura_db;
```
## 🚀 Como executar a aplicação

### Siga os passos abaixo para executar a aplicação localmente:

1. Clone o repositório do projeto:

```
git clone https://github.com/lucas-yago/literalura.git
```

2. Acesse o diretório do projeto:

```
cd literalura
```

3. Inicie a aplicação utilizando o Maven:

```
mvn spring-boot:run
```

4. Após a inicialização, um menu interativo será exibido no terminal. Siga as instruções apresentadas para utilizar as funcionalidades disponíveis.
