package Homework2;

public class Car {

    private String colour;
    private int fuel;
    private final int maxFuel;
    private final String model;
    private final Engine engine;
    private int mileage;

    public Car(String colour, int fuel, int maxFuel, String model, int consumption, int mileage) {
        this.colour = colour;
        this.fuel = fuel;
        this.maxFuel = maxFuel;
        this.model = model;
        this.engine = new Engine(consumption);
        this.mileage = mileage;
    }

    public void refueling() {
        fuel = maxFuel;
    }

    public void refueling(int volume) {
        fuel = Math.min(fuel + volume, maxFuel);
    }

    private void nofuling() {
        if (fuel <= 0) {
            fuel = 0;
            engine.off();
            System.out.println("Attention! Out of fuel, refueling required!");
            System.out.println("------");
        }
    }

    public void info() {
        System.out.println("fuel: " + fuel);
        System.out.println("mileage: " + mileage);
        System.out.println("Engine_on: " + engine.status);
        System.out.println("------");
    }

    public void info_all() {
        System.out.println("colour: " + colour);
        System.out.println("fuel: " + fuel);
        System.out.println("maxFuel: " + maxFuel);
        System.out.println("model: " + model);
        System.out.println("mileage: " + mileage);
        System.out.println("Engine_on: " + engine.status);
        System.out.println("------");
    }

    public void start() {
        engine.on();
    }

    public void stop() {
        engine.off();
    }

    public void move() {
        if (engine.status) {
            mileage += Math.min(100, 100 * fuel / engine.consumption);
            fuel -= engine.consumption * Math.min(100, 100 * fuel / engine.consumption) / 100;
            nofuling();
        }
    }

    public void move(int distance) {
        if (engine.status) {
            mileage += Math.min(distance, 100 * fuel / engine.consumption);
            fuel -= engine.consumption * Math.min(distance, 100 * fuel / engine.consumption) / 100;
            nofuling();
        }
    }

    public void getMileage() {
        System.out.println("mileage: " + mileage);
        System.out.println("------");
    }

    public class Engine {
        boolean status;
        final int consumption;

        public Engine(int consumption) {
            this.consumption = consumption;
            this.status = false;
        }

        public void on() {
            status = true;
        }

        public void off() {
            status = false;
        }

        public void on_off() {
            status = !status;
        }

    }
}
