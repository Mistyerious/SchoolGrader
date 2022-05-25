package structures;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Student extends Person {
	private final static Random RNG = new Random();

	private final String id = generateId(6);
	private Teacher teacher;
	private int grade;
	private final List<Class> classes = new ArrayList<>();

	public Student(LocalDate birthday, Name name, Teacher teacher, int grade, List<Class> classes) {
		super(birthday, name);
		this.teacher = teacher;
		this.grade = grade;
		this.classes.addAll(classes);
	}

	public String getId() {
		return id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getGrade() {
		return grade;
	}

	public String getStringGrade() {
		return grade + switch (grade) {
			case 1 -> "st";
			case 2 -> "nd";
			case 3 -> "rd";
			default -> "th";
		};
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Class> getClasses() {
		return classes;
	}

	private static String generateId(int idLength) {
		int leftLimit = 48;
		int rightLimit = 122;

		return RNG.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(idLength)
				.mapToObj(Character::toString)
				.collect(Collectors.joining());
	}
}
