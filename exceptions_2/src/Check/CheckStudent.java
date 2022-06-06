package src.Check;

import src.Exceptions.FailedSubject;
import src.Students.Students;
import src.universityStructure.Subjects;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

public class CheckStudent extends Average {
    public static List<Integer> getMarksSubject(Students student, Subjects academicSubject) {
        return student.getGrades().getSubjectGrades().get(academicSubject);
    }

    public static double getAverageMarksSubject(Students student, Subjects subject) {
        LinkedList<Students> studentList = new LinkedList<>();
        studentList.add(student);
        return getAverageMarks(studentList, subject);
    }

    public static EnumMap<Subjects, Double> getAverageMarks(Students student) throws FailedSubject {
        EnumMap<Subjects, Double> averageGrades = new EnumMap<>(Subjects.class);

        for (Subjects subject : student.getAcademicSubjects()) {
            averageGrades.put(subject, getAverageMarksSubject(student, subject));
        }
        return averageGrades;
    }
}

