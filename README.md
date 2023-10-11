# 🚀 API de Gerenciamento de Rebeldes

Bem-vindo à API de Gerenciamento de Rebeldes! Esta API foi desenvolvida para ajudar os rebeldes na sua luta contra o Império, permitindo o compartilhamento de recursos e informações vitais.

## ✨ Recursos

Aqui estão alguns dos recursos disponíveis nesta API:

- **Adicionar Rebeldes**: Registre novos rebeldes com informações pessoais e seu inventário de recursos.

- **Atualizar Localização do Rebelde**: Permite que um rebelde atualize sua última localização, indicando o nome da nova base.

- **Reportar Rebelde Traidor**: Se você suspeitar de traição, pode relatar um rebelde como traidor. Um rebelde é marcado como traidor quando, pelo menos, três outros rebeldes relatam a traição. Traidores se tornam inativos e não podem mais fazer compras na base.

- **Relatórios de Porcentagem**: Obtenha a porcentagem de traidores e rebeldes ativos em relação ao total de rebeldes.

- **Base de Compras**: Rebeldes podem comprar itens essenciais na base, incluindo armas, munição, água e comida.

## 🛠️ Tecnologias Utilizadas

Esta API foi desenvolvida com as seguintes tecnologias:

- **Linguagem de Programação**: Java
- **Framework Web**: Spring Boot
- **Banco de Dados**: PostgreSQL (gerenciado com Dbeaver)
- **Controle de Versão**: Git/GitHub
- **Ferramenta de Documentação**: Swagger

## ⚙️ Como Usar a API

Para utilizar a API, siga as instruções abaixo:

### Adicionar Rebelde

```http
POST /rebeldes
```

Envie uma solicitação JSON com as informações do rebelde e seu inventário de recursos. Veja um exemplo no README.

### Atualizar Localização do Rebelde

```http
PUT /rebeldes/{id}/localizacao
```

Atualize a localização de um rebelde pelo ID. Veja um exemplo no README.

### Reportar Rebelde Traidor

```http
POST /rebeldes/{id}/traidor
```

Relate um rebelde como traidor pelo ID.

### Obter Porcentagem de Traidores

```http
GET /relatorios/porcentagem/traidores
```

Retorna a porcentagem de traidores.

### Obter Porcentagem de Rebeldes

```http
GET /relatorios/porcentagem/rebeldes
```

Retorna a porcentagem de rebeldes ativos.

### Compras na Base

```http
POST /compras
```
Permite que rebeldes comprem itens na base. Veja um exemplo no README.

### Inserir item:
```
INSERT INTO ITEM ("ID", "NOME", "VALOR") VALUES (1, 'carro', 50.0)
```

---

## H2

* url: http://localhost:8080/h2
* JDBC URL: jdbc:h2:mem:teste

--

## Docker
* 1 acessar via console e entrar na pasta "docker" onde esta o arquivo "docker-compose.yml"
* 2 rodar o comando docker compose up
* verificar se docker está ligado> docker -v


---



## ⚙️ Configurando o Pipeline

Para configurar o pipeline de integração contínua com o Jenkins:

1. Crie um job no Jenkins.
2. Configure o job para executar testes automatizados, análise estática de código e implantação.
3. Use um arquivo Jenkinsfile para definir os estágios do pipeline.

## 🤖 Contribuição

Contribuições são bem-vindas! Se você deseja melhorar ou adicionar recursos a esta API, abra um pull request e nós adoraríamos revisar.


