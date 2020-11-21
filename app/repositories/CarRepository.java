package repositories;

import dev.morphia.query.FindOptions;
import it.unifi.cerm.playmorphia.PlayMorphia;
import models.Car;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.util.List;

public class CarRepository {

    private final PlayMorphia playMorphia;

    @Inject
    public CarRepository(PlayMorphia playMorphia) {
        this.playMorphia = playMorphia;
    }

    public Car findById(String id) {
        return playMorphia
                    .datastore()
                    .createQuery(Car.class)
                    .field("_id")
                    .equal(new ObjectId(id))
                    .first();
    }

    public List<Car> findAll() {
        return playMorphia
                .datastore()
                .createQuery(Car.class)
                .find(new FindOptions().limit(100))
                .toList();
    }

    public void save(Car c) {
        playMorphia.datastore().save(c);
    }
}
