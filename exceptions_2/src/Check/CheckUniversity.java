package src.Check;

import src.Exceptions.FailedFaculty;
import src.Exceptions.FailedGroup;
import src.Exceptions.FailedStudent;
import src.Students.Students;
import src.universityStructure.Faculties;
import src.universityStructure.Groups;
import src.universityStructure.Subjects;
import src.universityStructure.University;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckUniversity extends Average {
    public static Double getAverageMarksFaculty(University university, String facultyName, Subjects subject)
            throws FailedFaculty, FailedStudent, FailedGroup {
        Faculties facultyByName;
        Optional<Faculties> optionalFaculty = university.getFaculties().stream().
                filter(faculty -> faculty.getFacultyName().equals(facultyName)).findFirst();
        if (optionalFaculty.isPresent()) {
            facultyByName = optionalFaculty.get();
        } else {
            throw new FailedFaculty("There isn't faculty " + facultyName);
        }
        return CheckFaculty.getAverageMarksSubject(facultyByName, subject);
    }

    private static Groups searchGroup(University university, String groupName) throws FailedGroup, FailedFaculty {
        for (Faculties faculty : university.getFaculties()) {
            if (CheckFaculty.getGroup(faculty, groupName)) {
                return faculty.getGroup(groupName);
            }
        }
        return null;
    }

    public static Double getAverageMarksGroup(University university, String groupName, Subjects subject)
            throws FailedStudent, FailedGroup, FailedFaculty {
        Groups group;
        Double averageGrade = 0.0;

        if ((group = searchGroup(university, groupName)) != null) {
            averageGrade = CheckGroup.getAverageMarksSubject(group, subject);
        }
        return averageGrade;
    }

    public static List<Students> getStudentsUniversity(University university) throws FailedGroup, FailedStudent,
            FailedFaculty {
        ArrayList<Students> students = new ArrayList<>();
        for (Faculties faculty : university.getFaculties()) {
            students.addAll(CheckFaculty.getStudentsFaculty(faculty));
        }
        return students;
    }

    public static Double getAverageMarksUniversity(University university, Subjects subject)
            throws FailedStudent, FailedGroup, FailedFaculty {
        return getAverageMarks(getStudentsUniversity(university), subject);
    }
}
