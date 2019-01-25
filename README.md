PROYECTO DISEÑO DE SOFTWARE - POLIVENTAS
======================

1 - Descripción
---------------


2 - Prototipo no funcional
---------------
Para observar el flujo correcto del sistema, se debe ingresar con un perfil de usuario distinto.

* Iniciar sesion como Comprador:
```
Usuario: comprador
Password:

```
* Iniciar sesion como Vendedor:

```
Usuario: vendedor
Password:
```

* Iniciar sesion como Administrador:

```
Usuario: admin
Password:
```
3 - Prototipo funcional
---------------
Se desarrolló la implementación del proyecto en JavaFX con la ayuda de SceneBuilder. La base de datos fue elaborada en MySQL y estuvo alojada remotamente.

* Librerias utilizadas:

```
Controlsfx-8.40.14: Proporciona controles que no estan incluidos en javaFx
Mysql-connector-java-8.0.14 : Para establecer conexion entre la aplicacion y la base de datos.
```

```
NOTA: Solo ingresando con alguno de los nombres de usuario ya mencionados se podrá iniciar una sesión.
```
4 - Consulta de Usuarios
-----------------
````````````````
Para consultar información sobre un usuario el administrador deberá acceder a la opción de administrar usuarios, en esta ventana hay dos tipos de consulta, la primera consiste en buscar un usuario específico ingresando en el apartado de cédula el número de cédula del usario que se desea y presionando la tecla enter, la segunda consiste en consultar todos los usuarios que pertenecen a un rol especifico seleccionando un rol en el comboBox que posee el rol en la parte inferior izquierda
````````````````
