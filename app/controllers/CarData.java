package controllers;

import static play.data.validation.Constraints.*;

public class CarData {

    @Required
    public String name;

    @Required
    public String color;

    @Min(0)
    @Max(400)
    public int topSpeed;
}
