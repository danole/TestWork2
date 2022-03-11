package steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import pojos.Main;
import pojos.Root;
import pojos.Weather;
import pojos.Wind;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private Main main;
    private Wind wind;
    private List<Weather> weather;
    private Root root;

    public Root getRoot() {
        return root;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    @Когда("^отправили запрос на ресурс api.openweathermap.org и получили данные$")
    public void sendRequest() {
        main = given().
                when().get("http://api.openweathermap.org/data/2.5/weather?" +
                        "lat=59.915173&lon=30.472012&appid=b6f7f9ad246523e09d301e3266e28053&units=metric&lang=ru").
                then().extract().body().jsonPath().getObject("main", Main.class);

        wind = given().
                when().get("http://api.openweathermap.org/data/2.5/weather?" +
                        "lat=59.915173&lon=30.472012&appid=b6f7f9ad246523e09d301e3266e28053&units=metric&lang=ru").
                then().extract().body().jsonPath().getObject("wind", Wind.class);

        weather = given().
                when().get("http://api.openweathermap.org/data/2.5/weather?" +
                        "lat=59.915173&lon=30.472012&appid=b6f7f9ad246523e09d301e3266e28053&units=metric&lang=ru").
                then().extract().body().jsonPath().getList("weather", Weather.class);

        root = given().
                when().get("http://api.openweathermap.org/data/2.5/weather?" +
                        "lat=59.915173&lon=30.472012&appid=b6f7f9ad246523e09d301e3266e28053&units=metric&lang=ru").
                then().extract().body().jsonPath().getObject(".", Root.class);
    }

    @И("^вывели на экран$")
    public void output() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM HH:mm yyyy", new Locale("ru"));
        String parseDate = dateFormat.format(new Date(root.getDt() * 1000));
        System.out.println(getMain());
        System.out.println(getWind());
        System.out.println(getWeather().get(0));
        System.out.println("Дата и время : " + parseDate);
    }

}
