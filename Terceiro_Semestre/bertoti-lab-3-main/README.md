# Workout Manager (Treinos A/B/C)

Aplicação web fullstack para gerenciamento e acompanhamento de rotinas de treino (divisão clássica A, B e C), desenvolvida com backend RESTful em Spring Boot, persistência relacional no MySQL e interface moderna responsiva com JavaScript puro.

---

## Tecnologias Utilizadas

* **Java 11**
* **Spring Boot 2.4.1**
  * Spring Data JPA
  * Hibernate ORM
  * Spring Web (REST)
* **MySQL 8.x**
* **HikariCP**
* **Frontend:** HTML5, CSS3 moderno e Vanilla JavaScript (Fetch API)
* **Apache Maven**

---

## Funcionalidades

* **Listagem Dinâmica:** Visualização em cards dos treinos A, B e C com os respectivos grupos musculares e exercícios.
* **Cadastro:** Adição de novos exercícios informando nome, séries e repetições.
* **Edição em Linha:** Alteração em tempo real de nome, séries e repetições diretamente no card.
* **Exclusão:** Remoção de exercícios com atualização imediata no banco e na interface.
* **Carga Inicial Automática:** Povoamento padrão no banco na primeira inicialização (`CommandLineRunner`).

---

## Estrutura do Projeto

```text
bertoti-lab-3-main/
├── src/
│   ├── main/
│   │   ├── java/com/thehecklers/sburrestdemo/
│   │   │   ├── Exercicio.java               # Entidade JPA (Exercício)
│   │   │   ├── ExercicioRepository.java     # Repositório JPA para Exercício
│   │   │   ├── Treino.java                  # Entidade JPA (Treino A/B/C)
│   │   │   ├── TreinoRepository.java        # Repositório JPA para Treino
│   │   │   ├── TreinoController.java        # Endpoints REST (CRUD)
│   │   │   └── SburRestDemoApplication.java # Configurações, DataSource e Main
│   │   └── resources/
│   │       ├── application.properties       # Configurações do Spring e JPA
│   │       └── static/                      # Interface Web da aplicação
│   │           ├── index.html
│   │           ├── style.css
│   │           └── index.js
├── pom.xml
└── mvnw.cmd
