package structures;

public class Teacher {
    private String firstName;
    private String lastName;
    private char middleInitial;
    private int age;

    public Teacher(String firstName, String lastName, char middleInitial, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public char getMiddleInitial() {
        return this.middleInitial;
    }

    public String getFullName(){
        return this.firstName + " " + this.middleInitial + " " + this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return this.getFullName() + " " + this.age;
    }
}
