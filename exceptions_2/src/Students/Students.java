package src.Students;

import src.Exceptions.FailedMark;
import src.Exceptions.FailedSubject;
import src.universityStructure.Subjects;

import java.util.EnumSet;

public class Students {
    private static long studentsCount = 0;

    private String name;
    private String surname;
    private long studentIDNumber;
    private EnumSet<Subjects> academicSubjects;
    private Marks grades;

    public Students(String name, String surname, EnumSet<Subjects> academicSubjects) {
        this.name = name;
        this.surname = surname;
        this.academicSubjects = academicSubjects;
        grades = new Marks(this.academicSubjects);
        studentIDNumber = studentsCount;
        studentsCount++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public EnumSet<Subjects> getAcademicSubjects()
            throws FailedSubject {
        if (academicSubjects.isEmpty()) {
            throw new FailedSubject("Student " +
                    getName() + " " + getSurname() + " hasn't subject(s)");
        }
        return academicSubjects;
    }

    public boolean isStudySubject(Subjects academicSubject) {
        return academicSubjects.contains(academicSubject);
    }

    public void setAcademicSubject(Subjects subject) {
        academicSubjects.add(subject);
        grades.addSubject(subject);
    }

    public Marks getGrades() {
        return grades;
    }

    public void setGrade(Subjects subject, int grade)
            throws FailedMark, FailedSubject {
        if (!getAcademicSubjects().contains(subject)) {
            setAcademicSubject(subject);
        }
        grades.setGrade(subject, grade);
    }

    @Override
    public String toString() {
        return "Student " + name + ' ' +
                surname + ' ' + grades + '\n';
    }
}

