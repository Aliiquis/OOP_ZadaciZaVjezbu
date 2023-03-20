package fer.oop.zzv04;

public class CompetitionEntry {
    private Teacher teacher;
    private Dessert dessert;
    private Student[] students;
    private int[] grades;
    private int n;

    public CompetitionEntry(Teacher teacher, Dessert dessert) {
        this.teacher = teacher;
        this.dessert = dessert;
        this.students = new Student[3];
        this.grades = new int[3];
        this.n = 0;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public boolean addRating(Student student, int grade) {
        if (n >= 3) {
            return false;
        }
        for (Student s : students) {
            if (student.equals(s)) {
                return false;
            }
        }
        students[n] = student;
        grades[n] = grade;
        n++;
        return true;
    }

    public double getRating() {
        if (n == 0) {
            return 0.;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return 1. * sum / n;
    }
}
