# Microservices Demo - Spring Boot + API Gateway

Este proyecto es un **ejemplo básico de microservicios** utilizando **Spring Boot** con un **API Gateway**. Cada microservicio es independiente y expone su propia API REST. El objetivo es aprender la **arquitectura de microservicios**, **API Gateway**, escalabilidad y separación de responsabilidades por capas.

---

## Estructura del proyecto

El proyecto contiene cuatro proyectos independientes:

- **UsersService**: microservicio para gestión de usuarios.  
- **ProductsService**: microservicio para gestión de productos.  
- **OrdersService**: microservicio para gestión de pedidos.  
- **API Gateway**: centraliza todas las peticiones hacia los microservicios.

Cada microservicio tiene su propio puerto y puede tener su propia base de datos. El API Gateway actúa como **único punto de entrada** para los clientes.

---

## Flujo de solicitudes

El flujo de solicitudes es el siguiente:

- El cliente (Angular, Postman, etc.) realiza solicitudes HTTP al API Gateway.  
- El API Gateway redirige cada solicitud al microservicio correspondiente según la ruta:  
  - `/users/**` → Users Service  
  - `/products/**` → Products Service  
  - `/orders/**` → Orders Service  
- Cada microservicio procesa la solicitud y devuelve la respuesta al Gateway, que la envía al cliente.

---

## Microservicios y Endpoints

### Users Service
- Puerto: 8081  
- Endpoints:  
  - `GET /users` → Lista todos los usuarios  
  - `GET /users/{id}` → Obtiene un usuario por ID  
- Arquitectura interna:  
  - **Controller** → maneja solicitudes HTTP  
  - **Service** → lógica de negocio  
  - **Repository** → acceso a datos (opcional)

### Products Service
- Puerto: 8082  
- Endpoints:  
  - `GET /products` → Lista todos los productos  
- Arquitectura interna similar a Users Service

### Orders Service
- Puerto: 8083  
- Endpoints:  
  - `GET /orders` → Lista todos los pedidos  
- Arquitectura interna similar a Users Service

### API Gateway
- Puerto: 8080  
- Rutas configuradas:  
  - `/users/**` → Users Service  
  - `/products/**` → Products Service  
  - `/orders/**` → Orders Service

---

## Tecnologías utilizadas

- Java 17+  
- Spring Boot  
- Spring Web  
- Spring Cloud Gateway  
- Maven  
- H2 Database (opcional, para pruebas)  
- Docker (opcional)  
- Git

---

## Cómo ejecutar

Abrir una terminal por cada microservicio y ejecutar:

```bash
# Users Service
cd UsersService
./mvnw spring-boot:run

# Products Service
cd ProductsService
./mvnw spring-boot:run

# Orders Service
cd OrdersService
./mvnw spring-boot:run

# API Gateway
cd api-gateway
./mvnw spring-boot:run
