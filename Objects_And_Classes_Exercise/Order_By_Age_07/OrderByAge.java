package Order_By_Age_07;

public class OrderByAge {
    private String name;
    private String ID;
    private int age;

    public OrderByAge (String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    public int getAge() {
        return this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", name, ID, age); // Stefan with ID: 524244 is 10 years old.
    }
    
}
