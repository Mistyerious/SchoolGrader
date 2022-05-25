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
        return this.className;
    }

    public int getPeriod() {
        return this.period;
    }

    public String getGrade() {
        return this.grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String toString() {
        return this.className + " " + this.grade + " " + this.period;
     }
}
