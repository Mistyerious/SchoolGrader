package structures;

public record Name(String first, char middle, String last) {
	@Override
	public String toString() {
		return "%s %s. %s".formatted(first, middle, last);
	}
}
