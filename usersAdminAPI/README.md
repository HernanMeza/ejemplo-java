# Hernán Meza Rivera
## Test para cliente BCI
------------------------------------
## Tecnología
- IDE Utilizado: STS 4.13.0.RELEASE
- Java 17
- Springboot 3.0.11-SNAPSHOT
- Gradle
- H2 DB
- Swagger
- JPA
- Hibernate

-------------------------------------

## Instalación
- Realizar clone del repositorio github o bien descargar zipeado de las cliente.
    ```sh
    - gh repo clone HernanMeza/ejemplo-java
    ```
- Importar las fuentes al IDE STS como proyecto Gradle existente
- Realizar Gradle Build.
- Verificar que el puerto 8080 esté disponible
- Ejecutar desde el boot dashboard

## Pruebas
### A. BASE DE DATOS
- Una vez arrancado el proyecto, en el browser a elección abrir el siguiente link para revisar la DB, 
http://localhost:8080/h2-console
- Verificar que el JDBC URL apunte a "jdbc:h2:mem:testdb" sin comillas, en caso contrario colocarlo manualmente
- clickear Connect
- La base de datos ya vendrá precargada con algunos usuarios; los inserts de estos usuarios pueden ser encontrados en el siguiente archivo:
    - /usersAdminAPI/src/main/resources/dataDePrueba.sql   

### B. DOCUMENTACION (SWAGGER)

- En una segunda pestaña acceder a http://localhost:8080/usersAdminAPI.html
- Se desplegara la documentación interna del api vía openAPI / Swagger

### C. API
Para testear el API desde postman realizar el import de los siguientes curl

#### TEST INGRESO DE NUEVO USUARIO CODIGO 201

En caso de Reejecutar dará codigo 200 correo ya registrado

```sh
curl --location 'http://localhost:8080/adminUsuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Hernan Meza Rivera",
    "email": "hernan.meza.ri@gmail.com",
    "password": "Mip@ssw0rd",
    "phones": [
      {
        "number": "966002658",
        "citycode": "1",
        "countrycode": "57"
      }
    ]
  }'
```
#### TEST INGRESO DATA ERRONEA CODIGO 400  

Falta el Email

```sh
curl --location 'http://localhost:8080/adminUsuarios' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Hernan Meza Rivera",
    "password": "Mip@ssw0rd",
    "phones": [
      {
        "number": "966002658",
        "citycode": "1",
        "countrycode": "57"
      }
    ]
  }'
```
  
 