## Sistema de Gestão de Condicionamento Fisico com IA

Projeto desenvolvido para a FATEC São José dos Campos - Prof. Jessen Vidal, no curso de Banco de Dados.

O sistema simula um gerenciamento de condicionamento fisico integrado com Inteligência Artificial usando LangChain4J + Ollama, permitindo consultas inteligentes diretamente no banco de dados.

---

## Sobre o Projeto

A ideia do projeto é unir:

- gerenciamento de condicionamento fisico;
- banco de dados relacional;
- inteligência artificial local;
- integração entre IA e SQL.

A IA consegue interagir com o sistema utilizando ferramentas (Tools / Function Calling), realizando consultas e análises através do banco de dados.

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL 8
- LangChain4J
- Ollama
- Lombok
- Maven

---

## Estrutura da Documentação

A documentação foi separada na pasta docs/ para facilitar a organização:

| Arquivo | Descrição |
|----------|------------|
| docs/database.md | Explica a estrutura do banco de dados |
| docs/ia-integration.md | Explica como funciona a integração da IA |

---

## Como Executar o Projeto

## Configurar o Banco de Dados

Execute o script SQL:

bash
mysql -u seu_usuario -p < aviao.sql


Depois configure o arquivo:

properties
src/main/resources/application.properties


Exemplo:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/aurafitengine
spring.datasource.username=root
spring.datasource.password=123456


---

## Rodar o Ollama

Com o Ollama instalado:

bash
ollama run qwen2.5:1.5b


---

## Executar a Aplicação

### Linux/macOS

bash
./mvnw clean spring-boot:run


### Windows

bash
mvnw.cmd clean spring-boot:run


---

## Funcionalidades

- Cadastro de dados de treinos fisicos
- Integração com banco MySQL
- IA local funcionando via Ollama
- Consultas inteligentes usando LangChain4J
- Uso de Tools para interação com SQL

---

## Integrantes

| Nome | GitHub |
|------|--------|
| Breno Andrade | [@brenobsa]
(https://github.com/brenobsa) |
| Maria Clara Prado Farkas | [@mariaclarafarkas75-byte](https://github.com/mariaclarafarkas75-byte) |

---

## Informações Acadêmicas

- Curso: Banco de Dados
- Matéria: Engenharia de Software
- Professor: Prof. Bertoti