# 1er PARCIAL BACKEND

Proyecto correspondiente al trabajo del Primer parcial de la electiva Programacion Backend


## Requisitos previos

- apache-maven-3.9.1
- PostgresSQL 13
- Intellij
- JAVA 11
- Wildfly 18.0.1 final

## Instalación

- Clonar el repositorio.
- Modificar el settings.xml en la carpeta conf del maven. C:\apache-maven-3.9.1\conf
````xml
<mirrors>
<!--  mirror
     | Specifies a repository mirror site to use instead of a given repository. The repository that
     | this mirror serves has an ID that matches the mirrorOf element of this mirror. IDs are used
     | for inheritance and direct lookup purposes, and must be unique across the set of mirrors.
     |
    <mirror>
      <id>mirrorId</id>
      <mirrorOf>repositoryId</mirrorOf>
      <name>Human Readable Name for this Mirror.</name>
      <url>http://my.repository.com/repo/path</url>
    </mirror>
      -->
    <!-- se tiene que comentar lo unico que no esta comentado -->
    <mirror>
      <id>maven-default-http-blocker</id>
      <mirrorOf>external:http:*</mirrorOf>
      <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
      <url>http://0.0.0.0/</url>
      <blocked>true</blocked>
    </mirror> 
</mirrors>
````
- Instalar el Wilfly
- Instalar y configurar el POSTGRESQL
- Modificar el standalone.xml para que conecte con la base de datos C:\wildfly-18.0.1.Final\standalone\configuration
````xml
<datasources>
    <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
        <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
        <driver>h2</driver>
        <security>
            <user-name>sa</user-name>
            <password>sa</password>
        </security>
    </datasource>
    <datasource jndi-name="java:jboss/datasources/prueba" pool-name="LaboratorioPostgres" enabled="true" use-java-context="true">
        <connection-url>jdbc:postgresql://localhost:5432/bdpwb</connection-url>
        <driver>postgres</driver>
        <pool>
            <max-pool-size>20</max-pool-size>
        </pool>
        <security>
            <user-name>postgres</user-name>
            <password>root</password>
        </security>
    </datasource>
    <drivers>
        <driver name="h2" module="com.h2database.h2">
            <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
        </driver>
        <driver name="postgres" module="org.postgresql.driver">
            <driver-class>org.postgresql.Driver</driver-class>
            <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
        </driver>
    </drivers>
</datasources>
````
- Abrir el postgreSQL y crear los esquemas correspondientes a los modelos creados en el proyecto
- Configurar el archivo pg_hba.conf para que acepte las conecciones

````conf
    # Put your actual configuration here
# ----------------------------------
#
# If you want to allow non-local connections, you need to add more
# "host" records.  In that case you will also need to make PostgreSQL
# listen on a non-local interface via the listen_addresses
# configuration parameter, or via the -i or -h command line switches.



# TYPE  DATABASE        USER            ADDRESS                 METHOD

# "local" is for Unix domain socket connections only
local   all             all                                     trust
# IPv4 local connections:
host    all             all             127.0.0.1/32            trust
# IPv6 local connections:
host    all             all             ::1/128                 trust
# Allow replication connections from localhost, by a user with the
# replication privilege.
local   replication     all                                     trust
host    replication     all             127.0.0.1/32            trust
host    replication     all             ::1/128                 trust

````

- Abrir el proyecto en Intellij
- Configurar el Intellij para ejecutar servidor Wildfly
- Ejecutar el proyecto

## Contribución

Para hacer o agregar un cambio al proyecto tener en cuenta lo siguiente
- Todo nuevo feature se crea una rama a partir de develop con la etiqueta "feature/your-feauture"
- asegurarse que la rama esta actualizada antes de solicitar un PR
- Detallar en el PR los cambios realizados
- No aprobar uno mismo y mergear su propio PR
- Para actualizar la rama main, se crea a partir de la misma una rama con el siguiente formato "release/x.x.x"
- se procede a hacer merge de la rama develop en release/x.x.x
- actualizamos el changelog y la version en el pom.xml
- solicitamos PR para actualizar la rama main.

## Autores

* Mario Gueyraud. [Github](https://github.com/mgueyraud) - [LinkedIn](https://www.linkedin.com/in/mariogyd/)
* Javier Lopez. [Github](https://github.com/) -  [LinkedIn](https://www.linkedin.com/in/rafael-lopez-907040206/)
* Nicole Leiva. [Github](https://github.com/) -  [LinkedIn](https://www.linkedin.com/in/nicoleiva00/)
* Francisco Sanabria [Github](https://github.com/frandepy2) -  [LinkedIn](https://www.linkedin.com/in/francisco-sanabria-0833b01b2/)
