# Event Management API 🚀

API REST profesional para la gestión de eventos. Implementa Clean Architecture, Spring Data JPA, MapStruct y el patrón DTO. Diseñada bajo principios SOLID para garantizar escalabilidad y un mantenimiento óptimo.

## 🛠️ Stack Tecnológico
* **Lenguaje:** Java 21
* **Framework:** Spring Boot 4.0.3
* **Base de Datos:** H2 (Entorno local) / PostgreSQL (Producción)
* **Herramientas Clave:** Lombok, MapStruct, Spring Boot Validation

## 📐 Arquitectura y Patrones
* **Clean Architecture:** Separación estricta en capas lógicas (`domain`, `repository`, `service`, `controller`).
* **Patrón DTO:** Transferencia de datos segura entre el cliente y el servidor aislando la base de datos.
* **Manejo de Excepciones:** Interceptor global (`@ControllerAdvice`) para respuestas HTTP estandarizadas y amigables.

## 🚀 Cómo ejecutar en local
1. Clona el repositorio en tu máquina local.
2. Asegúrate de tener Java 21 instalado.
3. Importa el proyecto en IntelliJ IDEA (o tu IDE favorito) como un proyecto Maven.
4. Ejecuta la clase principal `ApiApplication.java`.
5. La API estará escuchando peticiones en `http://localhost:8080/api/v1/events`.

---

## 🗺 Roadmap del Proyecto

## 🗺 Roadmap del Proyecto

### Fase 1: Configuración, Arquitectura y Creación (Completada)
- [x] **Project Setup:** Inicialización con Spring Boot y Dependencias Base.
- [x] **Modelo de Datos:** Creación de la entidad `Event` (Mapeo JPA).
- [x] **Configuración BD:** Estrategia DDL de Hibernate (`ddl-auto=update`) configurada.
- [x] **Persistencia:** Creación del Repositorio (`EventRepository`).
- [x] **Capa Lógica:** Creación de `IEventService` y `EventService`.
- [x] **Mapeo de Datos:** Implementación de MapStruct y DTOs (`Request` y `Response`).
- [x] **API:** Creación del Controlador (`EventController`) con endpoints GET (listar) y POST (crear).
- [x] **Calidad y Seguridad:** Validación de datos de entrada (`@Valid`) y manejo global de excepciones.

### Fase 2: Expansión del CRUD (Completada)
- [x] **Búsqueda Individual:** Endpoint GET para buscar un evento por su ID con manejo de error 404.
- [x] **Actualización:** Endpoint PUT con `@MappingTarget` para modificar eventos existentes.
- [x] **Eliminación:** Endpoint DELETE devolviendo código de estado 204 No Content.