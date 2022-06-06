package src.Check;

import src.Students.Students;
import src.universityStructure.Subjects;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Average {
    public static Double getAverageMarks(List<Students> students, Subjects subject) {
        List<Integer> subjectMarks = students.stream().filter(student -> student.isStudySubject(subject)).
                map(student -> CheckStudent.getMarksSubject(student, subject)).
                flatMap(Collection::stream).collect(Collectors.toList());

        Integer sumMarks = subjectMarks.stream().reduce(Integer::sum).orElse(0);
        return !subjectMarks.isEmpty() ? (sumMarks / (double) subjectMarks.size()) : sumMarks;
    }
}
