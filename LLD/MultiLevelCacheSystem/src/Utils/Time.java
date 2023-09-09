package Utils;

public class Time {
    private int time;

    public Time() {
        this.time = 0;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void incrementTime(int time) {
        this.time += time;
    }

    @Override
    public String toString() {
        return String.valueOf(this.time);
    }
}
