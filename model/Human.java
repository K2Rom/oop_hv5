package model;

public abstract class Human {

    private String lastName;
    private String firstName;
    private String middleName;

    public Human(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setmiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return String.format(getClass().getSimpleName() + ": ФИО = %s %s %s", getLastName(), getFirstName(), getMiddleName());
    }

}
