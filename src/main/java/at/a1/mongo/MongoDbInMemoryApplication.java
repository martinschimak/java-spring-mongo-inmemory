package at.a1.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongoDbInMemoryApplication {

    public static void main(final String... args) {
        SpringApplication.run(MongoDbInMemoryApplication.class, args);
    }

}
