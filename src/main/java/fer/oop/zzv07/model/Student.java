package fer.oop.zzv07.model;

public class Student extends Person {

    private int grade;

    public Student(String name, String surname, int grade) {
        super(name, surname);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }
}