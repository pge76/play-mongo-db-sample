package controllers.mongoConfiguration;

import com.typesafe.config.Config;
import it.unifi.cerm.playmorphia.MongoClientFactory;

public class MyMongoClientConfiguration extends MongoClientFactory {

    private Config config;

    public MyMongoClientConfiguration(Config config) {
        super(config);
        this.config = config;
    }

}
