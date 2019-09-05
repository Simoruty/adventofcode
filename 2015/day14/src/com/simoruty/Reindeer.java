package com.simoruty;

public class Reindeer {
    private String name;
    private int speed;
    private int timeToSpeed;
    private int timeToRest;

    Reindeer(String name, int speed, int timeToSpeed, int timeToRest) {
        this.name = name;
        this.speed = speed;
        this.timeToSpeed = timeToSpeed;
        this.timeToRest = timeToRest;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getSpeed() {
        return speed;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    int getTimeToSpeed() {
        return timeToSpeed;
    }

    void setTimeToSpeed(int timeToSpeed) {
        this.timeToSpeed = timeToSpeed;
    }

    int getTimeToRest() {
        return timeToRest;
    }

    void setTimeToRest(int timeToRest) {
        this.timeToRest = timeToRest;
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", timeToSpeed=" + timeToSpeed +
                ", timeRest=" + timeToRest +
                '}';
    }

    int distanceTraveledAfterTime(int time) {
        int distance = 0;
        int timeMod = timeToSpeed + timeToRest;
        int count = time / timeMod;
        time = time % timeMod;

        if (time < timeToSpeed)
            distance += time * speed + (count * speed * timeToSpeed);
        else
            distance += timeToSpeed * speed + (count * speed * timeToSpeed);

        return distance;
    }
}
