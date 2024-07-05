package model;

public class Student extends Human {

    private final Integer studentId;

    public Student(Integer studentId, String lastName, String firstName, String middleName) {
        super(lastName, firstName, middleName);
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ":id=%s ФИО=%s %s %s", studentId, getLastName(), getFirstName(), getMiddleName());
    }

}
