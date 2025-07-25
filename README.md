# 🛡️ Spring Boot 3 + Spring Security 6 + JWT (Proyecto Base)

Proyecto desarrollado principalmente como ejercicio práctico para entender y aplicar Spring Boot 3, Spring Security 6 y JWT.
A pesar de ser una versión inicial, es completamente funcional y permite autenticación con JWT y control de accesos por roles.
Con el tiempo, planeo mejorarlo gradualmente incorporando validaciones, manejo global de errores, refresh tokens y más buenas prácticas.

---

## 🚀 Tecnologías usadas

- Java 17
- Spring Boot 3.x
- Spring Security 6
- JWT
- Maven
- MySQL (puedes adaptarlo fácilmente)
- Lombok
- Postman (para pruebas)

---

## 🧠 Funcionalidades

- Registro de usuarios
- Login y generación de JWT
- Validación de tokens en cada request
- Roles y permisos (ejemplo básico con ROLE_USER / ROLE_ADMIN)
- Filtrado de rutas públicas y protegidas

---

## 🔐 Endpoints de autenticación

| Método | Endpoint        | Acceso     | Descripción               |
|--------|------------------|------------|---------------------------|
| POST   | `/auth/register` | Público    | Registro de usuario       |
| POST   | `/auth/login`    | Público    | Login y obtención de JWT  |

