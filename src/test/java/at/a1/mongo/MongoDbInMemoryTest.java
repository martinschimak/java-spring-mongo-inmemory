package at.a1.mongo;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
// Spring 2.7 @DataMongoTest(properties = "spring.mongodb.embedded.version=4.4.0") // Spring 2.7
@DataMongoTest(properties = "de.flapdoodle.mongodb.embedded.version=4.4.0") // Spring 3.3
public class MongoDbInMemoryTest {

    @Test
    public void test(@Autowired MongoTemplate mongoTemplate) {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start().add("key", "value").get();
        // when
        mongoTemplate.save(objectToSave, "collection");
        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key").containsOnly("value");
    }

}