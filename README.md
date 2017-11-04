# willdfly-swarm-hello-world

## Changelog (tags)

### 1.0.0
Simple http servlet support. 

to run:

````.sh
mvn clean install && java -jar target/helloworld-swarm.jar 
````

or:
````.sh
mvn wildfly-swarm:run
````

test:
````.sh
curl http://localhost:8080/status
````

should respond:
```.json
{"status":"ok"}
```

### 1.1.0
JPA, CDI and JTA support with postgres database.

You can use Docker to run the postgres database instance:
```.sh
docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=12345 -d postgres
```

### 1.2.0
JAX-RS and Jackson support.

<b>Note</b>: when the application is started through ```mvn wildfly-swarm:run```, the following warning is displayed:

```.sh
WARN  [org.jboss.as.weld] (ServerService Thread Pool -- 2) WFLYWELD0052: Using deployment classloader to load 
proxy classes for module com.fasterxml.jackson.jaxrs.jackson-jaxrs-json-provider:main. Package-private 
access will not work. To fix this the module should declare dependencies on [org.jboss.weld.core, 
org.jboss.weld.spi]
```
about the warning, the following issue exists: https://issues.jboss.org/browse/SWARM-1280

<b>Note 2</b>: to debug the application, the following ways can be used:

```.sh
java -jar -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 \
  target/helloworld-swarm.jar
```

or, when running through maven plugin:
```.sh
# the swarm process will suspend on start and open a debugger on this port.
mvn wildfly-swarm:run -Dswarm.debug.port=5005
```
or, add to swarm maven plugin:
```.xml
<configuration>
  <debug>5005</debug>
</configuration>
```

debug options: http://www.adam-bien.com/roller/abien/entry/what_are_the_options_of

swarm properties: https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/configuration_properties.html


### 1.3.0
Liquibase initial support.

To bootstrap database configuration, the init.sql was created. If you use Docker, you can run the following:
```.sh
docker run --name some-postgres -e POSTGRES_PASSWORD=123456 -p 5432:5432 \
-v $PWD/init.sql:/docker-entrypoint-initdb.d/init.sql -d postgres
```
