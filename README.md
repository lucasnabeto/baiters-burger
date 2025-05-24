# BaitersBurger 

## Português

Este projeto é uma aplicação Java com Spring Boot, MongoDB e Mongo Express, orquestrados via Docker Compose.

### Pré-requisitos

-   Docker
-   Docker Compose

### Como rodar a aplicação

1. Clone este repositório:

    ```bash
    git clone https://github.com/lucasnabeto/BaitersBurger.git
    cd BaitersBurger
    ```


2. Construa e suba os containers:

    ```bash
    docker-compose up --build
    ```

    Isso irá:

    - Subir o MongoDB na porta 27017
    - Subir o Mongo Express na porta 8081
    - Subir a aplicação na porta 8080


3. Acesse a aplicação:
    - API: [http://localhost:8080](http://localhost:8080)
    - Mongo Express: [http://localhost:8081](http://localhost:8081)

### Parar os containers

Para parar e remover os containers, execute:

```bash
docker-compose down
```

### Observações

-   O usuário e senha do MongoDB estão definidos como `root` e `baitersburger`.
-   O Mongo Express está sem autenticação básica para facilitar o acesso em desenvolvimento.

---

## English

This project is a Java application using Spring Boot, MongoDB, and Mongo Express, orchestrated via Docker Compose.

### Prerequisites

-   Docker
-   Docker Compose

### How to run the application

1. Clone this repository:

    ```bash
    git clone https://github.com/lucasnabeto/BaitersBurger.git
    cd BaitersBurger
    ```


2. Build and start the containers:

    ```bash
    docker-compose up --build
    ```

    This will:

    - Start MongoDB on port 27017
    - Start Mongo Express on port 8081
    - Start the application on port 8080


3. Access the application:
    - API: [http://localhost:8080](http://localhost:8080)
    - Mongo Express: [http://localhost:8081](http://localhost:8081)

### Stop the containers

To stop and remove the containers, run:

```bash
docker-compose down
```

### Notes

-   MongoDB username and password are set to `root` and `baitersburger`.
-   Mongo Express is running without basic authentication for easier development access.
