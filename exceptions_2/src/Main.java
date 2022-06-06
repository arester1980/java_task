package src;

import src.Check.CheckStudent;
import src.Check.CheckUniversity;
import src.Exceptions.*;
import src.Start.Init;
import src.Start.Person;
import src.Students.Students;
import src.universityStructure.Faculties;
import src.universityStructure.Subjects;
import src.universityStructure.University;

import java.util.EnumSet;
import java.util.Scanner;

public class Main {
    private final static Subjects SUBJECT = Subjects.CRIMINAL;
    private final static int STUDENT_NUMBER_FOR_TEST = 7;

    private static void getAverageGradesOfStudent(University university) throws FailedSubject, FailedFaculty,
            FailedStudent, FailedGroup {
        Students student = CheckUniversity.getStudentsUniversity(university).get(STUDENT_NUMBER_FOR_TEST);
        System.out.println("Average marks of " + student.getName() + " " + student.getSurname());
        System.out.println(CheckStudent.getAverageMarks(student));
    }

    private static void getAverageGradesOfFaculties(University university) throws FailedFaculty, FailedGroup,
            FailedStudent {
        System.out.println("Average marks of subject " + SUBJECT);
        System.out.println("Law=" +
                CheckUniversity.getAverageMarksFaculty(university, "Law", SUBJECT));
        System.out.println("Management=" +
                CheckUniversity.getAverageMarksFaculty(university, "Management", SUBJECT));
        System.out.println("Engineering=" +
                CheckUniversity.getAverageMarksFaculty(university, "Engineering", SUBJECT));
    }

    private static void getAverageMarksGroup(University university) throws FailedFaculty, FailedGroup,
            FailedStudent {
        System.out.println("Average marks of groups by subject " + SUBJECT);
        System.out.println("Law-01=" +
                CheckUniversity.getAverageMarksGroup(university, "Law-01", SUBJECT));
        System.out.println("Law-02=" +
                CheckUniversity.getAverageMarksGroup(university, "Law-02", SUBJECT));
        System.out.println("Man-01=" +
                CheckUniversity.getAverageMarksGroup(university, "Man-01", SUBJECT));
        System.out.println("Man-02=" +
                CheckUniversity.getAverageMarksGroup(university, "Man-02", SUBJECT));
        System.out.println("Eng-01=" +
                CheckUniversity.getAverageMarksGroup(university, "Eng-01", SUBJECT));
    }

    private static void getAverageMarksUniversity(University university) throws FailedFaculty, FailedGroup,
            FailedStudent {
        System.out.println("Average marks of subject by university " + SUBJECT);
        System.out.println(CheckUniversity.getAverageMarksUniversity(university, SUBJECT));
    }

    private static void getExceptions(University university) throws FailedGroup, FailedMark, FailedStudent,
            FailedFaculty, FailedSubject {
        System.out.println("Select exception (1-5): ");
        Scanner scanner = new Scanner(System.in);
        int programNumber = scanner.nextInt();
        switch (programNumber) {
            case 1:
                int incorrectGrade = 19;
                System.out.println("Marks below 0 or greater than 10");
                Students studentWithGradeOutOfRange = CheckUniversity.getStudentsUniversity(university).get(STUDENT_NUMBER_FOR_TEST);
                studentWithGradeOutOfRange.setGrade(Subjects.CRIMINAL, incorrectGrade);
                System.out.println(studentWithGradeOutOfRange);
                break;
            case 2:
                System.out.println("The student hasn't any subject");
                Students studentWithoutSubjects = new Students("Nick", "Luck", EnumSet.noneOf(Subjects.class));
                university.getFaculties().get(1).getGroup("Law-02").setStudent(studentWithoutSubjects);
                System.out.println(CheckStudent.getAverageMarks(studentWithoutSubjects));
                break;
            case 3:
                System.out.println("There aren't students in group");
                String groupWithoutStudents = "Man-02";
                university.getFaculties().get(0).setGroup(groupWithoutStudents);
                System.out.println(CheckUniversity.getAverageMarksGroup(university, groupWithoutStudents,
                        Subjects.SOURCE));
                break;
            case 4:
                System.out.println("There aren't groups on faculty");
                String facultyWithoutGroups = "Sport";
                university.setFaculty(new Faculties(facultyWithoutGroups));
                System.out.println(CheckUniversity.getAverageMarksFaculty(university, facultyWithoutGroups,
                        Subjects.DELIVERY));
                break;
            case 5:
                System.out.println("There aren't faculties in university");
                University universityWithoutFaculties = new University();
                System.out.println(CheckUniversity.getStudentsUniversity(universityWithoutFaculties));
                break;
            default:
                System.out.println("Wrong number");
                break;
        }
    }

    public static void main(String[] args) {
        Init initializer = new Person();
        try {
            University university = initializer.setUniversity();

            System.out.println("University structure: ");
            System.out.println(university);

            getAverageGradesOfStudent(university);
            getAverageGradesOfFaculties(university);
            getAverageMarksGroup(university);
            getAverageMarksUniversity(university);

            getExceptions(university);
        } catch (FailedMark | FailedSubject | FailedStudent |
                 FailedFaculty | FailedGroup | FailedUniversity e) {
            e.printStackTrace();
        }
    }
}
