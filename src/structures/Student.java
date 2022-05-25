package structures;

import java.util.ArrayList;
import java.util.Random;

public class Student {
    private String id;
    private Teacher teacher;
    private String firstName;
    private String lastName;
    private char middleInitial;
    private int age;
    private int grade;
    private ArrayList<Class> classes;

    public Student(String id, Teacher teacher, String firstName, String lastName, char middleInitial, int age, int grade, ArrayList<Class> classes) {
        this.id = id;
        this.teacher = teacher;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.age = age;
        this.grade = grade;
        this.classes = classes;
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

    public int getAge() {
        return this.age;
    }

    public int getGrade() {
        return this.grade;
    }

    public String getFullName(){
        return this.firstName + " " + this.middleInitial + " " + this.lastName;
    }

    public ArrayList<Class> getClasses() {
        return this.classes;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setMiddleInitial(char middleInitial){
        this.middleInitial = middleInitial;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setClasses(ArrayList<Class> classes){
        this.classes = classes;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getNumberOfClasses() {
        return this.classes.size();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String generateId(int idLength) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit+1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(idLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
