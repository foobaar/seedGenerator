# Seed Generator

This is an experiment in learning kafka 1.0.0

This app is a producer that posts random numbers to a the `seed` topic on a configurable interval.
Along with the random number, it posts a random UUID as the key which is propagated down all the way by
every app.

### Prerequisites

What things you need to install the software and how to install them

```
1. You would need an instance of kafka(1.1.0 and higher) running.
   Update bootstrap.servers in application.yml to point towards your kafka instance.
2. You would need java8 installed
```

### Installing


```
1. ./gradlew bootRun would start your app.

2. You can also run the app through java -jar /build/libs/seedGenerator-0.0.1-SNAPSHOT.jar
```

The app runs indefinitely.
 
## Built With

* [Spring Docs](https://docs.spring.io/spring-kafka/docs/2.1.5.RELEASE/reference/html/)
* [Kafka Docs](https://docs.confluent.io/current/streams/index.html)
