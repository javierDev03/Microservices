# Microservices Demo - Spring Boot + API Gateway

Este proyecto es un **ejemplo básico de microservicios** utilizando **Spring Boot** con un **API Gateway**. Cada microservicio es independiente y expone su propia API REST. El objetivo es aprender la **arquitectura de microservicios**, **API Gateway**, escalabilidad y separación de responsabilidades por capas.



Cada microservicio tiene su propio **puerto** y puede tener su propia base de datos.  
El **API Gateway** enruta todas las solicitudes hacia el microservicio correspondiente, exponiendo un **único punto de entrada** para los clientes.

---

## 🔄 Flujo de solicitudes

```text
[ Cliente (Angular, Postman, etc.) ] 
              │
              ▼
         [ API Gateway (8080) ]
              │
   ┌──────────┼──────────┐
   ▼          ▼          ▼
[Users]     [Products]  [Orders]
(8081)      (8082)      (8083)
(DB propio) (DB propio) (DB propio)
