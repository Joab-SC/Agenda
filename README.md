# agenda

Sistema de agenda de contactos que permita gestionar contactos, grupos de contactos y reuniones; el cual debe permitir la creación, modificación y eliminación de estos.
# Autores

- Autor 1: Sergio Posada
- Autor 2: Michael Álvarez
- Autor 3: Joab Suárez

# Herramientas

- [java 17](https://adoptium.net/es)
- [junit 5.10.0](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.10.0)
- [maven](https://maven.apache.org)


# Construcción y pruebas

Para compilar el proyecto puede usar el comando:

```shell
mvn clean compile
```

Para ejecutar las pruebas puede usar el comando: 

```shell
 mvn clean test
```

Para generar el jar puede usar el comando: 

```shell
 mvn clean package
```

y para ejecutar el jar

```shell
 java -jar target/agenda-1.0.jar
```
