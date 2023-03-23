package fer.oop.zzv05.person;

import java.util.Arrays;

public class Student extends Person {
    private short academicYear;
    private int[] ocjene;

    public Student(int id, String name, short academicYear, int[] ocjene) {
        super(id, name);
        this.ocjene = ocjene;
        this.academicYear = academicYear;
    }

    public int[] getOcjene() {
        return ocjene;
    }

    public void setOcjene(int[] ocjene) {
        this.ocjene = ocjene;
    }

    public short getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(short academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public double getGrade() {
        return (double) Arrays.stream(ocjene).sum() / ocjene.length;
    }

    @Override
    public String toString() {
        return super.toString() + ", academicYear=" + academicYear + ", grades=" + Arrays.toString(ocjene);
    }
}
