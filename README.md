# Foro-hub ![Static Badge](https://img.shields.io/badge/Version-1.1-green)

Foro-hub es una aplicación de foros desarrollada en Java utilizando el framework Spring Boot. Permite a los usuarios crear, gestionar y participar en discusiones sobre diversos temas.

## Características

- Registro e inicio de sesión de usuarios.
- Creación, edición y eliminación de temas de discusión.
- Responder a temas y comentar en discusiones.
- Búsqueda de temas y discusiones.
- Perfil de usuario con historial de actividades.

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Base de Datos**: MySQL
- **Migraciones**: Flyway

### Dependencias Principales

- Lombok
- Spring Web
- Spring Boot DevTools
- Spring Data JPA
- Flyway Migration
- MySQL Driver
- Validation
- Spring Security

## Requisitos Previos

- JDK 17 
- Maven
- MySQL

## Instalación

Para ejecutar el proyecto localmente, sigue estos pasos:

1. Clona el repositorio:
    ```bash
    git clone https://github.com/alexower/Foro-hub.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd Foro-hub
    ```

3. Configura la conexión a la base de datos MySQL en `src/main/resources/application.properties`.

4. Compila y empaqueta la aplicación usando Maven:
    ```bash
    mvn clean install
    ```

5. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

El servidor debería estar ejecutándose en `http://localhost:8080`.

## Uso

- Visita `http://localhost:8080` 
- Pruebas Postman

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Sube tu rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.


## Autor
Alex Milak
