# Cash-Online

1) Clonar el repositorio a una carpeta local.
2) Abrir Eclipse para compilar el programa.
3) Revisar si está la librería "lombok" instalada, está dentro del proyecto en "Library".
4) Crear base MySQL en localhost puerto 3306 de nombre "cash" usuario "root" y contraseña "Password".
5) Usar XAMPP y darle start al MySQL.
6) Ejecutar "ApiApplication".
7) Utilizar aplicación ejecutar los métodos GET y POST. Yo para este caso utilicé Postman.

a) Para dar el alta de usuario:

Escribir en el body en "raw" formato JSON:

{
  "user": {
    "email": "test@app.com.ar",
    "firstName": "Fatiga",
    "lastName": "Argento"
  }
}

POST http://localhost:9090/users 

b) Para dar de baja:

DELETE http://localhost:9090/users/1

c) Para listar los usuarios y sus respectivos préstamos:

GET http://localhost:9090/users

d) Para listar un usuario particular:

GET http://localhost:9090/users/1

e) Para listar todos los préstamos:

GET http://localhost:9090/loans?page=1&size=50

f) Para listar un préstamo:

http://localhost:9090/loans?page=0&size=50&user_id=1
