package Car_Salesman_03;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;
    
    public String getColor() {
        return this.color;
    }

    public String getWeight() {
        return this.weight;
    }

    public Engine1 getEngine() {
        return this.engine;
    }

    public String getModel() {
        return this.model;
    }

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return this.model + ":" +"\n" + String.format("%s%n" +
                "  Weight: %s%n" +
                "  Color: %s",this.engine,this.weight,this.color);
    }
    
}
