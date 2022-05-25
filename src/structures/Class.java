package structures;

public class Class {
    private String className;
    private int period;
    private String grade;

    public Class(String className, int period, String grade) {
        this.className = className;
        this.period = period;
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return className + " " + grade + " " + period;
     }
}
