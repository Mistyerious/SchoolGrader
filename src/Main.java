import structures.Class;
import structures.Name;
import structures.Student;
import structures.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Teacher teacher = new Teacher(LocalDate.of(1967, 3, 17), new Name("James", 'G', "Wallis"));
		List<Class> classes = new ArrayList<>();
		String[] periods = {"Science", "Math", "History", "Civics", "Culinary", "English"};

		for (int period = 0; period < periods.length; period++) {
			classes.add(new Class(periods[period], period + 1, "No Standard"));
		}

		List<Student> students = new ArrayList<>() {{
			add(new Student(
					LocalDate.of(2011, 7, 30),
					new Name("Jackson", 'C', "Balls"),
					teacher, 16, classes)
			);
			add(new Student(
					LocalDate.of(2011, 2, 5),
					new Name("Billy", 'C', "Balls"),
					teacher, 17, classes)
			);
			add(new Student(
					LocalDate.of(2010, 8, 12),
					new Name("Martha", 'C', "Balls"),
					teacher, 18, classes)
			);
			add(new Student(
					LocalDate.of(2012, 8, 6),
					new Name("Clark", 'C', "Balls"),
					teacher, 14, classes)
			);
			add(new Student(
					LocalDate.of(2013, 1, 3),
					new Name("Johnson", 'C', "Balls"),
					teacher, 13, classes)
			);
		}};


		Scanner scanner = new Scanner(System.in);
		print("Type in your arg: ");
		String input = "";

		do try {
			input = scanner.nextLine().trim();
			String[] arguments = input.split("\\s+");
			String commandName = arguments[0];

			switch (commandName) {
				case "students" -> {
					if (arguments.length > 1 && arguments[1].equals("info")) {
						if (arguments.length < 3) {
							throw new Exception("You must supply an ID, e.g students slEIIq");
						}

						Student student = students.stream()
								.filter(s -> s.getId().equals(arguments[2]))
								.findFirst().orElseThrow();

						println("""
										| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |
										-------------------------------------------------------------------------------------------------------------------------------------------
										| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s |
										""",
								"First Name", "Middle Initial", "Last Name", "Age", "Grade", "Classes",
								student.getFirstName(), student.getMiddleName(), student.getLastName(), student.getAge(), student.getGrade(), student.getClasses().size()
						);
					} else {
						println("""
								| %-20s | %-20s | %-20s |
								----------------------------------------------------------------------
								""", "Student", "Teacher", "Classes"
						);

						for (Student student : students) {
							println("""
											| %-20s | %-20s | %-20s |
											| %-20s | %-20s | %-20s |
											| %-20s | %-20s | %-20s |
											| %-20s | %-20s | %-20s |
											----------------------------------------------------------------------
											""",
									"ID: " + student.getId(), "", "",
									student.getName(), student.getTeacher().getName(), student.getClasses().size(),
									student.getAge(), student.getTeacher().getAge(), "",
									student.getStringGrade(), "", ""
							);
						}
					}
				}
				case "teachers" -> println("""
								| %-20s | %-20s | %-20s | %-20s |
								----------------------------------------------------------------------
								| %-20s | %-20s | %-20s | %-20s |
								""",
						"First Name", "Middle Initial", "Last Name", "Age",
						teacher.getFirstName(), teacher.getMiddleName(), teacher.getLastName(), teacher.getAge()
				);
				case "grades" -> {
					if (arguments.length < 2) {
						throw new Exception("You must supply an operation, e.g grades check slEIIq");
					} else if (arguments.length < 3) {
						throw new Exception("You must supply an ID, e.g grades check slEIIq");
					}

					Student student = students.stream()
							.filter(s -> s.getId().equals(arguments[2]))
							.findFirst().orElseThrow();

					switch (arguments[1]) {
						case "check" -> {
							println("""
									| %-20s | %-20s | %-20s |
									----------------------------------------------------------------------
									""", "Student", "Teacher", "Class"
							);

							for (Class currentClass : student.getClasses()) {
								println("""
												| %-20s | %-20s | %-20s |
												----------------------------------------------------------------------
												| %-20s | %-20s | %-20s |
												| %-20s | %-20s | %-20s |
												----------------------------------------------------------------------
												""",
										student.getName(), student.getTeacher().getName(), "Period: " + currentClass.getPeriod(),
										"", "", currentClass.getClassName(),
										"", "", currentClass.getGrade()
								);
							}
						}
						case "modify" -> {
							if (arguments.length < 5 || !arguments[3].matches("[-+]?\\d+(\\.\\d+)?")) {
								throw new Exception("Period must be numeric, e.g grades slEIIq 1 A");
							}

							student.getClasses()
									.get(Integer.parseInt(arguments[3]) - 1)
									.setGrade(arguments[4]);

							println("""
									| %-20s | %-20s | %-20s |
									----------------------------------------------------------------------
									""", "Student", "Teacher", "Class"
							);

							for (Class currentClass : student.getClasses()) {
								println("""
												| %-20s | %-20s | %-20s |
												----------------------------------------------------------------------
												| %-20s | %-20s | %-20s |
												| %-20s | %-20s | %-20s |
												----------------------------------------------------------------------
												""",
										student.getName(), student.getTeacher().getName(), "Period: " + currentClass.getPeriod(),
										"", "", currentClass.getClassName(),
										"", "", currentClass.getGrade()
								);
							}
						}
						default -> println("Operations are:\ncheck, modify");
					}
				}
				default -> println("Commands are:\nstudents, teachers, grades, help");
			}
		} catch (Exception e) {
			println("Error: " + e.getMessage());
		} while (!input.equals("exit"));
	}

	private static void print(String str, Object... args) {
		if (args.length == 0) System.out.print(str);
		else System.out.printf(str, args);
	}

	private static void println(String str, Object... args) {
		if (args.length == 0) System.out.println(str);
		else System.out.printf(str, args);
	}
}
