package controllers;

import models.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import repositories.CarRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

import static play.libs.Scala.asScala;

@Singleton
public class CarController extends Controller {

    private final CarRepository carRepository;
    private final Form<CarData> form;
    private final MessagesApi messagesApi;
    private List<Car> cars;

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Inject
    public CarController(CarRepository carRepository, FormFactory formFactory, MessagesApi messagesApi) {
        this.carRepository = carRepository;
        this.form = formFactory.form(CarData.class);
        this.messagesApi = messagesApi;
    }

    public Result list(Http.Request request) {
        initlist();
        return ok(views.html.car.render(asScala(cars), form, request, messagesApi.preferred(request)));
    }

    public Result add(Http.Request request) {
        final Form<CarData> boundForm = form.bindFromRequest(request);

        initlist();

        if(boundForm.hasErrors()) {
            logger.error("errors = {}", boundForm.errors());
            return badRequest(views.html.car.render(asScala(cars), boundForm, request, messagesApi.preferred(request)));
        } else {
            CarData data = boundForm.get();
            Car car = new Car(data.name, data.color, data.topSpeed);

            carRepository.save(car);

            cars.add(car);
            return redirect(routes.CarController.list())
                    .flashing("Info", "Auto wurde hinzugefügt!");
        }
    }

    private void initlist() {
        try {
            cars = carRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Cars could not be fetched from Database due to error", e);
        }
        if(cars == null) {
            throw new RuntimeException("Cars could not be fetched from Database, result was null");
        }
    }
}
