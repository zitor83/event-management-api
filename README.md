# 🚀 Event Management API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.3-brightgreen?style=for-the-badge&logo=spring)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-green?style=for-the-badge&logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue?style=for-the-badge&logo=postgresql)

API RESTful profesional para la gestión integral de eventos. Construida aplicando **Clean Architecture** y principios **SOLID**, esta aplicación está diseñada para ser escalable, segura y fácilmente mantenible.

Destaca por su implementación de seguridad "Stateless" mediante **JSON Web Tokens (JWT)**, control de acceso basado en roles a nivel de método (RBAC) y un diseño modular por dominios.

## 🌟 Características y Decisiones de Arquitectura

* **Seguridad Robusta (Stateless):** Implementación de Spring Security con la sintaxis moderna de JJWT (v0.12+). Generación de tokens seguros con encriptación HS512 y filtro de intercepción personalizado (`OncePerRequestFilter`).
* **Autorización a Nivel de Método (RBAC):** Uso de `@PreAuthorize` para un control granular de los endpoints según los roles del usuario (`ROLE_ADMIN`, `ROLE_USER`).
* **Arquitectura Híbrida (Layer & Feature):** Separación inicial en capas lógicas (`Controller`, `Service`, etc.), evolucionando hacia una estructura modular. El núcleo de seguridad está completamente encapsulado en su propio paquete (`security`), garantizando alta cohesión y reutilización de código.
* **Mapeo Avanzado de DTOs:** Uso de **MapStruct** mediante clases abstractas inyectables (`@Autowired`) para resolver relaciones complejas (como la asignación de Roles desde la base de datos) directamente en la capa de transformación.
* **Manejo de Excepciones Global:** Interceptor centralizado (`@ControllerAdvice`) que estandariza las respuestas HTTP (400, 401, 404, etc.) aislando al cliente de las trazas del servidor.
* **Validación Declarativa:** Uso de `spring-boot-starter-validation` para garantizar la integridad de los datos (emails, tamaños, contraseñas) en la entrada de los controladores.

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
- [x] **Mapeo de Datos:** Implementación de MapStruct y DTOs.
- [x] **API:** Creación del Controlador base con endpoints GET y POST.

### Fase 2: Expansión del CRUD (Completada)
- [x] **Búsqueda Individual:** Endpoint GET por ID con manejo de error 404.
- [x] **Actualización:** Endpoint PUT con `@MappingTarget`.
- [x] **Eliminación:** Endpoint DELETE devolviendo 204 No Content.

### Fase 3: Seguridad y Autenticación (Completada) 🔒
- [x] **Modelo y Core:** Entidades `User`/`Role`, `UserDetailsServiceImpl` y `DataLoader`.
- [x] **Motor JWT:** Generación, validación y filtro de intercepción (`JwtAuthenticationFilter`).
- [x] **Auth Endpoints:** Controladores públicos para Login y Registro con validaciones completas.
- [x] **Mapeo de Usuarios:** Refactorización de `UserMapper` a clase abstracta para inyección de repositorios y asignación automática de roles.
- [x] **Configuración Global:** Conexión del filtro JWT a la `SecurityFilterChain` y gestión de errores (401).
- [x] **Autorización RBAC:** Habilitada la seguridad a nivel de método con `@PreAuthorize`.
- [x] **Refactor Modular:** Aislamiento de todo el ecosistema de autenticación en un paquete `security` dedicado.

### Fase 4: Optimización JPA y Relaciones Avanzadas (En Progreso) 🚀
- [ ] **Nuevas Entidades:** Modelado de relaciones complejas (Categorías, Oradores).
- [ ] **Manejo de Relaciones Bidireccionales:** Estrategias para evitar bucles infinitos en JSON.
- [ ] **Gestión de Excepciones de BD:** Manejo robusto de `DataIntegrityViolationException`.
- [ ] **Paginación y Filtrado:** Implementación de paginación eficiente para grandes volúmenes de datos.