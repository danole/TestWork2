package pojos;

public class Wind {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Скорость ветра = " + speed + " м/с";
    }
}
