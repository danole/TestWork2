package pojos;

public class Root {

    private long dt;

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return "Root{" +
                "dt=" + dt +
                '}';
    }
}
