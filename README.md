# REST API CRUD com Spring Boot e MySQL

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)

> Status do Projeto: ✔️ Concluido ✔️

### Este repositório contém um projeto de exemplo de uma API RESTful com operações CRUD (Create, Read, Update, Delete) implementadas em Spring Boot, utilizando um banco de dados MySQL para armazenar informações de tarefas.

## 🛠️ Funcionalidades do projeto 🛠️

- [x] Criar uma nova tarefa
- [x] Listar todas as tarefas
- [x] Listar uma tarefa por ID
- [x] Listar tarefas de forma paginada
- [x] Listar tarefas por parte do nome
- [x] Atualizar uma tarefa existente por ID
- [x] Excluir uma tarefa por ID

## ⚠️ Pré-requisitos ⚠️

### Certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

- `Java JDK (versão 8 ou superior)`: https://www.oracle.com/br/java/technologies/downloads/
- `MySQL`: https://www.mysql.com/downloads/

## 🛠️ Configuração 🛠️

### Clone o repositório para sua máquina local:

1. git clone https://github.com/caiquessantos/Rest_API-CRUD-SpringBoot3-MySQL.git

### Crie o banco de dados

1. Crie uma nova conexão com o nome de sua escolha e coloque 'Hostname': localhost.
2. Crie um banco de dados MySQL com o nome 'tarefas'.
3. Atualize as configurações de conexão no arquivo src/main/resources/application.properties de acordo com as suas configurações da conexão criada(username, password).

### Execute a aplicação Spring Boot:

- ./mvnw spring-boot:run
- A aplicação estará disponível em http://localhost:8080/api/tarefas.

## 💻 Uso 💻

### A API pode ser testada utilizando ferramentas como Postman ou curl. Aqui estão alguns exemplos de solicitações:

1. Criar uma tarefa:

- `POST /api/tarefas/criar
{
"titulo": "Minha Tarefa",
"descricao": "Descrição da minha tarefa"
}`

2. Listar todas as tarefas:

- `GET /api/tarefas`

3. Listar uma tarefa por ID:

- `GET /api/tarefas/buscaporid/{id}`

4. Listar tarefas de forma paginada:

- `GET /api/tarefas/pagina/{numeroDaPagina}`

5. Listar tarefas por parte do nome:

- `GET /api/tarefas/buscapornome/{parteDoNome}`

6. Atualizar uma tarefa por ID:

- `PUT /api/tarefas/editar/{id}
{
"titulo": "Novo Título",
"descricao": "Nova Descrição"
}`

7. Excluir uma tarefa por ID:

- `DELETE /api/tarefas/excluir/{id}`

## 💡 Técnicas e Tecnologias usadas 💡

- [Java](https://www.oracle.com/java/technologies/)
- [SpringBoot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [Postman](https://www.postman.com/)
- [Hibernate](https://hibernate.org/)
- [Eclipse IDE](https://eclipseide.org/)
- JPA
- POO
- REST
