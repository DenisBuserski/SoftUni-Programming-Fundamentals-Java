package Students_20_06;

public class Students {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    public Students(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }
    
    public  String getHomeTown() {
        return this.homeTown;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
    
}
