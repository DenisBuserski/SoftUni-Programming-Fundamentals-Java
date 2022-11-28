package Opinion_Poll_03;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age = age;
    }
    
    @Override
    public String toString() {
        return name + " - " + age;
    }
    
}
