# Práctica de Git y GitHub — API de Tareas (Java + Spring Boot)

Proyecto de práctica para el curso **Programación II**. Su propósito principal
**no** es el código en sí, sino servir como repositorio base para los
ejercicios de control de versiones (fork, commits, ramas, Pull Requests,
merge, squash and merge, rebase and merge y `git log`) descritos en la hoja
de trabajo del curso.

Es una API REST sencilla para administrar una lista de tareas (*to-do list*).

## Tecnologías

- Java 17
- Spring Boot 3.2.5 (Web, Data JPA, Validation)
- Base de datos H2 en memoria
- Maven
- JUnit 5 + Mockito

## Cómo ejecutar el proyecto

```bash
mvn spring-boot:run
```

La aplicación inicia en `http://localhost:8080`. La consola de la base de
datos H2 está disponible en `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:practicadb`, usuario: `sa`, contraseña: vacía).

Para ejecutar las pruebas:

```bash
mvn test
```

## Endpoints disponibles

| Método | Ruta                        | Descripción                          |
|--------|-----------------------------|---------------------------------------|
| GET    | `/api/tareas`                | Lista todas las tareas                |
| GET    | `/api/tareas/{id}`           | Obtiene una tarea por id              |
| POST   | `/api/tareas`                | Crea una nueva tarea                  |
| PUT    | `/api/tareas/{id}`           | Actualiza una tarea existente         |
| PATCH  | `/api/tareas/{id}/completar` | Marca una tarea como completada       |
| DELETE | `/api/tareas/{id}`           | Elimina una tarea                     |

Ejemplo de cuerpo para crear una tarea (`POST /api/tareas`):

```json
{
  "titulo": "Practicar rebase",
  "descripcion": "Completar la sección 4.7 de la hoja de trabajo",
  "completada": false
}
```

## Uso de este repositorio para la práctica de Git/GitHub

1. Haga **fork** de este repositorio hacia su propia cuenta de GitHub.
2. Clone su fork y configure el remoto `upstream` apuntando a este
   repositorio original.
3. Siga las secciones de la hoja de trabajo del curso, creando ramas como
   `feature/funcionalidad-a`, `feature/funcionalidad-b` y
   `feature/funcionalidad-c` para practicar, respectivamente, un merge
   estándar, un *squash and merge* y un *rebase and merge* mediante Pull
   Requests dentro de su propio fork.
4. Ideas de cambios pequeños para practicar en cada rama:
   - Agregar un nuevo endpoint (por ejemplo, `GET /api/tareas/pendientes`
     que devuelva solo las tareas no completadas).
   - Agregar un nuevo campo a `Tarea` (por ejemplo, una fecha límite).
   - Agregar una prueba unitaria adicional en `TareaServiceTest`.
   - Mejorar este mismo README con ejemplos adicionales.

## Estructura del proyecto

```
src/main/java/com/plusti/practicagit/
├── PracticaGitApplication.java   # Clase principal
├── controller/                   # Controladores REST y manejo de errores
├── model/                        # Entidades JPA
├── repository/                   # Interfaces Spring Data JPA
└── service/                      # Lógica de negocio
```
