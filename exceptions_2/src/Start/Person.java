package src.Start;

import src.Exceptions.*;
import src.Students.Students;
import src.universityStructure.Faculties;
import src.universityStructure.Groups;
import src.universityStructure.Subjects;

import java.util.EnumSet;

public class Person extends Init {

    @Override
    protected void setFaculties() {
        university.setFaculty(new Faculties("Law"));
        university.setFaculty(new Faculties("Management"));
        university.setFaculty(new Faculties("Engineering"));
    }

    @Override
    protected void setGroups() throws FailedFaculty {
        university.getFaculties().get(0).setGroup("Law-01");
        university.getFaculties().get(1).setGroup("Man-01");
        university.getFaculties().get(1).setGroup("Man-02");
        university.getFaculties().get(2).setGroup("Eng-01");
        university.getFaculties().get(2).setGroup("Eng-02");
    }

    @Override
    protected void setStudents() throws FailedFaculty, FailedGroup {
        university.getFaculties().get(0).getGroup("Law-01").setStudent(new Students("John", "Dow",
                EnumSet.of(Subjects.CIVIL, Subjects.CRIMINAL)));
        university.getFaculties().get(0).getGroup("Law-01").setStudent(new Students("Mark", "Smith",
                EnumSet.of(Subjects.CIVIL, Subjects.CRIMINAL)));
        university.getFaculties().get(0).getGroup("Law-01").setStudent(new Students("Helga", "Grun",
                EnumSet.of(Subjects.CIVIL, Subjects.CRIMINAL)));

        university.getFaculties().get(1).getGroup("Man-01").setStudent(new Students("Jack", "Sparrow",
                EnumSet.of(Subjects.PRODUCTION, Subjects.SOURCE)));
        university.getFaculties().get(1).getGroup("Man-01").setStudent(new Students("Mary", "Scottish",
                EnumSet.of(Subjects.PRODUCTION, Subjects.SOURCE)));
        university.getFaculties().get(1).getGroup("Man-01").setStudent(new Students("Henry", "Tudor",
                EnumSet.of(Subjects.PRODUCTION, Subjects.SOURCE)));
        university.getFaculties().get(1).getGroup("Man-02").setStudent(new Students("Elis", "Presli",
                EnumSet.of(Subjects.PRODUCTION, Subjects.SOURCE)));
        university.getFaculties().get(1).getGroup("Man-02").setStudent(new Students("John", "Dow",
                EnumSet.of(Subjects.PRODUCTION, Subjects.SOURCE)));

        university.getFaculties().get(2).getGroup("Eng-01").setStudent(new Students("Eugen", "Grin",
                EnumSet.of(Subjects.SOFTWARE, Subjects.DELIVERY)));
        university.getFaculties().get(2).getGroup("Eng-02").setStudent(new Students("Anastasiya", "Romanoff",
                EnumSet.of(Subjects.SOFTWARE, Subjects.DELIVERY)));
        university.getFaculties().get(2).getGroup("Eng-02").setStudent(new Students("Hann", "Solov",
                EnumSet.of(Subjects.SOFTWARE, Subjects.DELIVERY)));
    }

    @Override
    protected void setGrades() throws FailedMark, FailedSubject,
            FailedGroup, FailedFaculty, FailedStudent {
        for (Faculties faculty : university.getFaculties()) {
            for (Groups group : faculty.getGroups()) {
                for (Students student : group.getStudents()) {
                    for (Subjects studentSubject : student.getAcademicSubjects()) {
                        int gradesCount = (int) (Math.random() * 4);
                        for (int i = 0; i < gradesCount; i++) {
                            student.setGrade(studentSubject, (int) ((Math.random() * 10) + 1));
                        }
                    }
                }
            }
        }
    }
}
