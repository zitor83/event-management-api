# 🚀 Event Management API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.3-brightgreen?style=for-the-badge&logo=spring)
![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-green?style=for-the-badge&logo=springsecurity)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Ready-blue?style=for-the-badge&logo=postgresql)

API RESTful profesional para la gestión integral de eventos. Construida aplicando **Clean Architecture** y principios **SOLID**, esta aplicación está diseñada para ser escalable, segura y fácilmente mantenible.

Destaca por su implementación de seguridad "Stateless" mediante **JSON Web Tokens (JWT)**, control de acceso basado en roles a nivel de método (RBAC), optimización avanzada de consultas y una sólida cobertura de tests.

## 🌟 Características y Decisiones de Arquitectura

* **Seguridad Robusta (Stateless):** Implementación de Spring Security con la sintaxis moderna de JJWT. Generación de tokens seguros con encriptación HS512 y filtro de intercepción personalizado (`OncePerRequestFilter`).
* **Autorización a Nivel de Método (RBAC):** Uso de `@PreAuthorize` para un control granular de los endpoints según los roles del usuario (`ROLE_ADMIN`, `ROLE_USER`).
* **Rendimiento y Optimización de BD:** Resolución del temido problema "N+1" en relaciones Many-To-Many mediante anotaciones `@EntityGraph` y consultas JPQL optimizadas (`JOIN FETCH`).
* **Integración Frontend (CORS):** Políticas de intercambio de recursos de origen cruzado configuradas globalmente a nivel de Spring Security para habilitar conexiones con SPAs (Angular/React).
* **Prevención de Ciclos JSON:** Uso estratégico de `@JsonIgnore` y exclusión de métodos de Lombok (`@ToString.Exclude`, `@EqualsAndHashCode.Exclude`) para evitar colapsos de memoria (`StackOverflowError`) en relaciones bidireccionales.
* **Mapeo Avanzado de DTOs:** Uso de **MapStruct** mediante clases abstractas inyectables (`@Autowired`) para resolver relaciones complejas directamente en la capa de transformación.
* **Manejo de Excepciones Global:** Interceptor centralizado (`@ControllerAdvice`) que estandariza las respuestas HTTP (400, 401, 404, 409) aislando al cliente de las trazas del servidor.

## 🛠️ Stack Tecnológico
* **Core:** Java 21, Spring Boot 4.0.3
* **Seguridad:** Spring Security, Java JWT (JJWT), BCrypt
* **Base de Datos:** H2 (Desarrollo/Testing) / PostgreSQL (Producción), Spring Data JPA
* **Testing:** JUnit 5, Mockito, MockMvc
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
- [x] **Configuración Global:** Conexión del filtro JWT a la `SecurityFilterChain`.
- [x] **Autorización RBAC:** Habilitada la seguridad a nivel de método con `@PreAuthorize`.

### Fase 4: Optimización JPA y Relaciones Avanzadas (Completada) 🚀
- [x] **Manejo de Relaciones Bidireccionales:** Helper Methods en JPA y prevención de recursividad JSON.
- [x] **Lógica de Negocio Compleja:** Enlazado dinámico de relaciones en `EventService` y manejo seguro de colecciones concurrentes.
- [x] **Paginación y Filtrado:** Implementación eficiente usando `Pageable`.
- [x] **CORS:** Configuración de conectividad segura para clientes web.
- [x] **Optimización de Consultas (N+1):** Mitigación del problema N+1 usando `@EntityGraph` y `JOIN FETCH`.

### Fase 5: Testing y Calidad de Código (En Progreso) 🧪
- [x] **Entorno de Pruebas:** Configuración de perfil aisaldo con base de datos H2 en memoria (`create-drop`).
- [x] **Tests Unitarios (Lógica de Negocio):** Cobertura exhaustiva de `EventService` aplicando el patrón AAA usando Mockito (`@Mock`, `@InjectMocks`).
- [ ] **Tests de Integración (Capa Web):** Simulación de peticiones HTTP con MockMvc y `@WebMvcTest`.
- [ ] **Tests de Repositorios:** Verificación de consultas customizadas y paginación con `@DataJpaTest`.