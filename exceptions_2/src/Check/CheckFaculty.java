package src.Check;

import src.Exceptions.FailedGroup;
import src.Exceptions.FailedStudent;
import src.Students.Students;
import src.universityStructure.Faculties;
import src.universityStructure.Groups;
import src.universityStructure.Subjects;

import java.util.ArrayList;
import java.util.List;

public class CheckFaculty extends Average {

    public static boolean getGroup(Faculties faculty, String groupName) throws FailedGroup {
        return faculty.getGroups().stream().anyMatch(group -> group.getGroupName().equals(groupName));
    }

    public static List<Students> getStudentsFaculty(Faculties faculty) throws FailedGroup, FailedStudent {
        ArrayList<Students> students = new ArrayList<>();
        for (Groups group : faculty.getGroups()) {
            students.addAll(group.getStudents());
        }
        return students;
    }

    public static Double getAverageMarksSubject(Faculties faculty, Subjects subject) throws FailedStudent,
            FailedGroup {
        return getAverageMarks(getStudentsFaculty(faculty), subject);
    }
}

