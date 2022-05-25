import structures.Class;
import structures.Student;
import structures.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new Teacher("James", "Wallis", 'G', 55);
        ArrayList<Class> classes = new ArrayList<>();
        String[] periods = {"Science", "Math", "History", "Civics", "Culinary", "English"};

        for (int period = 0; period < periods.length; period++) {
            classes.add(new Class(periods[period], period + 1, "No Standard"));
        }

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(Student.generateId(6), teacher, "Jackson", "Balls", 'C', 16, 11, classes));
        students.add(new Student(Student.generateId(6), teacher, "Billy", "Balls", 'C', 17, 11, classes));
        students.add(new Student(Student.generateId(6), teacher, "Martha", "Balls", 'C', 18, 12, classes));
        students.add(new Student(Student.generateId(6), teacher, "Clark", "Balls", 'C', 14, 10, classes));
        students.add(new Student(Student.generateId(6), teacher, "Johnson", "Balls", 'C', 13, 9, classes));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type in your arg: ");
        String input = "";

        do {
            input = scanner.nextLine();
            String commandName = input.split(" ")[0].toLowerCase();
            String[] arguments = input.substring(commandName.length()).trim().split(" ");

            switch (commandName) {
                case "students" -> {
                    if ("info".equals(arguments[0])) {
                        Student student = students.stream().filter(s -> s.getId().equals(arguments[1])).toList().get(0);
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "First Name", "Middle Initial", "Last Name", "Age", "Grade", "Classes");
                        System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", student.getFirstName(), student.getMiddleInitial(), student.getLastName(), student.getAge(), student.getGrade(), student.getNumberOfClasses());
                    } else {
                        System.out.printf("| %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "Student", "Teacher", "Classes");
                        for (Student student : students) {
                            System.out.printf("| ID: %-16s | %-20s | %-20s |\n| %-20s | %-20s | %-20s |\n", student.getId(), "", "", student.getFullName(), student.getTeacher().getFullName(), student.getNumberOfClasses());
                            System.out.printf("| %-20s | %-20s | %-20s |\n", student.getAge(), student.getTeacher().getAge(), "");
                            System.out.printf("| %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", student.getGrade() + "th", "", "");
                        }
                    }
                }
                case "teachers" -> {
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "First Name", "Middle Initial", "Last Name", "Age");
                    System.out.printf("| %-20s | %-20s | %-20s | %-20s |\n", teacher.getFirstName(), teacher.getMiddleInitial(), teacher.getLastName(), teacher.getAge());
                }
                case "grades" -> {
                    if (arguments[0].isEmpty()) throw new Exception("Arguments must be provided ");
                    switch (arguments[0]) {
                        case "check" -> {
                            Student student = students.stream().filter(s -> s.getId().equals(arguments[1])).toList().get(0);
                            System.out.printf("| %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "Student", "Teacher", "Class");
                            for (Class currentClass : student.getClasses()) {
                                System.out.printf("| %-20s | %-20s | %-20s |\n", student.getFullName(), student.getTeacher().getFullName(), "Period: " + currentClass.getPeriod());
                                System.out.printf("| %-20s | %-20s | %-20s |\n", "", "", currentClass.getClassName());
                                System.out.printf("| %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "", "", currentClass.getGrade());
                            }
                        }
                        case "modify" -> {
                            Student student = students.stream().filter(s -> s.getId().equals(arguments[1])).toList().get(0);
                            if (!arguments[2].matches("[-+]?\\d+(\\.\\d+)?"))
                                throw new Exception("Period must be numeric, e.g grades slEIIq 1 A");
                            Class classToModify = student.getClasses().get(Integer.parseInt(arguments[2]) - 1);
                            classToModify.setGrade(arguments[3]);
                            System.out.printf("| %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "Student", "Teacher", "Class");
                            for (Class currentClass : student.getClasses()) {
                                System.out.printf("| %-20s | %-20s | %-20s |\n", student.getFullName(), student.getTeacher().getFullName(), "Period: " + currentClass.getPeriod());
                                System.out.printf("| %-20s | %-20s | %-20s |\n", "", "", currentClass.getClassName());
                                System.out.printf("| %-20s | %-20s | %-20s |\n----------------------------------------------------------------------\n", "", "", currentClass.getGrade());
                            }
                        }
                        default -> {
                            System.out.println("Commands are:\ncheck, modify");
                        }
                    }
                }
                case "help" -> {
                    System.out.println("Commands are:\nstudents, teachers, grades, help");
                }
            }
        } while (!input.equals("exit"));
    }
}
