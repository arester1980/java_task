package src.Students;

import src.Exceptions.FailedMark;
import src.universityStructure.Subjects;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

public class Marks {
    private EnumMap<Subjects, List<Integer>> subjectGrades = new EnumMap<>(Subjects.class);

    public Marks(EnumSet<Subjects> academicSubjects) {
        for (Subjects academicSubject : academicSubjects) {
            subjectGrades.put(academicSubject, new ArrayList<>());
        }
    }

    public EnumMap<Subjects, List<Integer>> getSubjectGrades() {
        return subjectGrades;
    }

    public void addSubject(Subjects academicSubject) {
        if (!subjectGrades.containsKey(academicSubject)) {
            subjectGrades.put(academicSubject, new ArrayList<>());
        }
    }

    public void setGrade(Subjects academicSubject, int grade)
            throws FailedMark {
        if ((grade >= 0) && (grade <= 10)) {
            List<Integer> grades = subjectGrades.get(academicSubject);
            grades.add(grade);
            subjectGrades.put(academicSubject, grades);
        } else {
            throw new FailedMark("Marks " + grade + " not available");
        }
    }

    @Override
    public String toString() {
        return subjectGrades.toString();
    }

}

