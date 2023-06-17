# order-service
This is stores the details of all the orders that system have. It also expose the apis to perform crud on Order domain.

## API Spec for order-service

| Endpoint | HTTP Method | Request Body | Status | Response Body | Description                                            |
|----------|-------------|--------------|--------|---------------|--------------------------------------------------------|
| /orders  | POST        | OrderRequest | 200    | Order         | Submits a new order for given book in a given quantity |
| /orders  | GET         |              | 200    | Order[]       | Retrieve all Orders                                    |

```mermaid
---
title: "Order-Service C4 Model: Container Level Diagram" 
---

flowchart LR

    User["User
    [Person]

A user of the Book Shop Application"]

subgraph BS [Book Shop]

CS["Catalog-Service
[Container: Spring Boot]

Provides functionality for managing the books in the catalog"]

OS["Order-Service
[Container: Spring Boot]

Provides functionality for purchasing the books"]

CnS["Config-Service
[Container: Spring Boot]

Provides centralized Configuration"] 

CnRepo[("Config Repo
[Container: Git

Stores Configuration Data]
")]

OD[("Order Database
[Container: PostgreSQL]

Stores order data")]

CD[("Catalog Database
[Container: PostgreSQL]

Stores book data")]
end

User-- "Uses\n[REST/HTTP]" -->OS
OS-- "Reads from and writes to\n[R2DBC]" -->OD
OS-- "Retrieves books detail\n[REST/HTTP]" -->CS
CS-- "Reads from and writes to\n[JDBC]" -->CD
OS -- "Gets configuration from\n[REST/HTTP]" --> CnS
CS -- "Gets configuration from\n[REST/HTTP]" --> CnS
CnS-- "Reads config data from\n[REST/HTTP]" -->CnRepo

classDef focusSystem fill:#1168bd,stroke:#0b4884,color:#ffffff
classDef person fill:#08427b,stroke:#052e56,color:#ffffff
class User person
class OS,OD focusSystem


```