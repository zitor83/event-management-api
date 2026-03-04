# 🚀 Event Management API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.3-brightgreen?style=for-the-badge&logo=spring)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-green?style=for-the-badge&logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue?style=for-the-badge&logo=postgresql)

API RESTful profesional para la gestión integral de eventos. Construida aplicando **Clean Architecture** y principios **SOLID**, esta aplicación está diseñada para ser escalable, segura y fácilmente mantenible.

Destaca por su implementación de seguridad "Stateless" mediante **JSON Web Tokens (JWT)** y control de acceso basado en roles (RBAC).

## 🌟 Características y Decisiones de Arquitectura

* **Seguridad Robusta (Stateless):** Implementación de Spring Security con la sintaxis moderna de JJWT (v0.12+). Generación de tokens seguros con encriptación HS512 y filtro de intercepción personalizado (`OncePerRequestFilter`).
* **Arquitectura Multicapa:** Separación estricta de responsabilidades (`Controller`, `Service`, `Repository`, `Domain`).
* **Data Transfer Objects (DTO):** Transferencia de datos segura aislando el modelo de dominio. Mapeo automatizado y eficiente con **MapStruct** (incluyendo actualizaciones in-place con `@MappingTarget`).
* **Manejo de Excepciones Global:** Interceptor centralizado (`@ControllerAdvice`) que estandariza las respuestas HTTP (400, 401, 404, etc.) proporcionando JSONs limpios al cliente.
* **Validación Declarativa:** Uso de `spring-boot-starter-validation` para garantizar la integridad de los datos en la entrada de los controladores.
* **Database Seeding:** Inicialización automatizada de datos (Roles y Usuarios por defecto) mediante `CommandLineRunner`.

## 🛠️ Stack Tecnológico
* **Core:** Java 21, Spring Boot 4.0.3
* **Seguridad:** Spring Security, Java JWT (JJWT), BCrypt
* **Base de Datos:** H2 (Desarrollo local) / PostgreSQL (Producción), Spring Data JPA
* **Herramientas Clave:** Lombok, MapStruct, Maven

## 🚀 Cómo ejecutar en local
1. Clona el repositorio en tu máquina local.
2. Asegúrate de tener Java 21 instalado.
3. Importa el proyecto en IntelliJ IDEA (o tu IDE favorito) como un proyecto Maven.
4. Ejecuta la clase principal `ApiApplication.java`.
5. La API estará escuchando peticiones en `http://localhost:8080/api/v1/events`.

---

## 🗺 Roadmap del Proyecto

### Fase 1: Configuración, Arquitectura y Creación (Completada)
- [x] **Project Setup:** Inicialización con Spring Boot y Dependencias Base.
- [x] **Modelo de Datos:** Creación de la entidad `Event` (Mapeo JPA).
- [x] **Configuración BD:** Estrategia DDL de Hibernate (`ddl-auto=update`).
- [x] **Persistencia y Lógica:** Creación de Repositorios y Servicios.
- [x] **Mapeo de Datos:** Implementación de MapStruct y DTOs (`Request` y `Response`).
- [x] **API:** Creación del Controlador base con endpoints GET y POST.
- [x] **Calidad:** Validación de datos (`@Valid`) y manejo global de excepciones.

### Fase 2: Expansión del CRUD (Completada)
- [x] **Búsqueda Individual:** Endpoint GET por ID con manejo de error 404.
- [x] **Actualización:** Endpoint PUT con `@MappingTarget`.
- [x] **Eliminación:** Endpoint DELETE devolviendo 204 No Content.

### Fase 3: Seguridad y Autenticación (En Progreso) 🔒
- [x] **Dependencias:** Integración de Spring Security y JJWT.
- [x] **Modelo de Seguridad:** Entidades `User` y `Role` (Relación ManyToMany).
- [x] **Core de Autenticación:** Implementación de `UserDetailsServiceImpl` y `DataLoader`.
- [x] **Motor JWT:** Utilidades para generar/validar tokens (`JwtGenerator`) y filtro de intercepción (`JwtAuthenticationFilter`).
- [x] **Auth Endpoints:** Controlador público para Login y emisión del Token Bearer.
- [ ] **Configuración Global:** Conectar el filtro JWT a la cadena de seguridad `SecurityFilterChain`.