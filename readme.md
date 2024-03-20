# Prueba Técnica para Expreso Brasilia

Este proyecto fue desarrollado con Springboot haciendo uso de una base de datos construida con la base de datos H2. hay que tener en cuenta que el proyecto de desarrolló con la versión 21 del JDK

## Requerimientos
1. Tener instalado el JDK con la versión 21 y con todas las variables de entorno configurada en el sistema operativo.
2. Tener instalado un editor de código o un IDE de desarrollo como Intellij o eclipse
3. Este proyecto corre con Maven

## Configuración de la bases de datos
1. Abrir el sistema gestor de base de datos de su preferencia
2. Crear un esquema de base de datos con el nombre de su preferencia.
3. luego de crear el esquema, uste debe ir al directorio del proyecto y buscar el archivo application.properties donde usted configurar todas las credenciales de su base de datos como la url, usuario, contraseña, puerto etc.
```bash
spring.application.name=api-restfull
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:h2:mem:expreso_brasilia_db
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
server.port=8081
```

## Correr el proyecto
1. Una vez que usted haya hecho todas las configuraciones de base de datos e instalado todas las dependencias que el proyecto requiere, vamos a abrir el proyecto en nuestro editor de preferencia.
2. Este proyecto lo desarrolle con el IDE de Intellij de JetBrains y correr o compilar el proyecto es muy sencillo. en este IDE tenemos varios accesos para correr el proyecto, en la parte superior tenemos un menu y podemos ir a la pestaña Run y ver las opciones que tenemos para ejecutar nuestro proyecto.
3. debemos estar pendiente a la terminal para ver el estado del servidor y ver finalmente si todo compiló perfectamente

## Herramientas de apoyo y recomendaciones
1. Usar Postman para probar la Api Restfull
2. Crear una rama basada en main o en dev si quiere desarrollo un nuevo feature o hacer algún ajuste

