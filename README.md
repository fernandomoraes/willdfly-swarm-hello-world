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
