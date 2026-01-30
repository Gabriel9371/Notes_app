# Notes API

### API REST pra gerenciamento de usuarios e suas anotações.
### O sistema permite criar usuarios, asociar notas a esses usuarios e consultar os dados por meio de endpoints Rest.
### Projeto com foco em organização de camadas, uso de DTOs e boas praticas com Spring Boot

# Tecnologias
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate 
- MySQL
- Maven


# Modelo de Dados

### User
- id
- name
- email
- notes (lista de notas)

### Notes
- id
- title
- content
- user (referência ao usuario)

## EndPoints

### Usuarios

GET/users <br>
Retorna a Lista de usuarios cadastrados.
---
GET /users/{id} <br>
Retorna um usuario pelo ID.
---
POST /users <br>
Cria um novo usuario.

---
Exemplo de request <br>
```json
{
  "name": "Gabriel",
  "email": "gabriel@gmail.com"
}

```

### Notas
GET/notes <br>
Retorna todas as notas.
---
GET /notes/{id} <br>
Retorna uma nota pelo ID.
---
POST /notes <br>
Cria uma nova Nota associada a um usuario.

Exemplo de request <br>
```json
{
  "title": "Nota x",
  "content": "Conteudo da nota",
  "userId": 1 
}
```

# Banco de Dados
no mysql crie uma `database` chamada notes_app
```text
    CREATE DATABASE notes_app;
```
# Configuração de variaveis
O projeto utiliza variaveis de ambiente parea conexão como o banco. 
`DB_USR`:seu usuario MySQL
`DB_PASS`:sua senha do MySQL



# Como rodar o projeto
1. Clone o repositório
2. Configure o banco de dados no application.properties
3. Execute o projeto com:
   mvn spring-boot:run
4. A API estará rodando em:
   http://localhost:8080
