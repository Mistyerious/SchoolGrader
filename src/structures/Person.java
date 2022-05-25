package structures;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Person {
	private final LocalDate birthday;
	private Name name;

	public Person(LocalDate birthday, Name name) {
		this.birthday = birthday;
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public int getAge() {
		return (int) birthday.until(LocalDate.now(), ChronoUnit.YEARS);
	}

	public String getFirstName() {
		return name.first();
	}

	public String getMiddleName() {
		return name.middle() + ".";
	}

	public String getLastName() {
		return name.last();
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + " " + getAge();
	}
}
