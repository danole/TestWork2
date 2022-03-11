package pojos;

public class Main {

    private float temp;
    private float feels_like;
    private int humidity;
    private int pressure;

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Температура = " + temp + " °C" +
                ", Температура комфорт = " + feels_like + " °C" +
                ", Влажность = " + humidity + " %" +
                ", Атмосферное давление = " + pressure + " мм.рт.ст.";
    }
}
