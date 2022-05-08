package Raw_Data_02;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;

    public Car(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires(){
        return new Tire[]{tire1, tire2, tire3, tire4};
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }
}
