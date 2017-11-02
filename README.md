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
JPA, CDI and JTA support with postgres database

You can use Docker to run the postgres database instance:
```.sh
docker run --name some-postgres -p 5432:5432 -e POSTGRES_PASSWORD=12345 -d postgres
```

