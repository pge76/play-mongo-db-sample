package models;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

@Entity(value = "DB.cars")
public class Car {

    @Id
    private ObjectId _id;

    public String name;
    public String color;
    public int topSpeed;

    public Car() {}

    public Car(String name, String color, int topSpeed) {
        this.name = name;
        this.color = color;
        this.topSpeed = topSpeed;
    }

}