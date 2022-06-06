package src.Check;

import src.Exceptions.FailedStudent;
import src.universityStructure.Groups;
import src.universityStructure.Subjects;

public class CheckGroup extends Average {
    public static Double getAverageMarksSubject(Groups group, Subjects subject)
            throws FailedStudent {
        return getAverageMarks(group.getStudents(), subject);
    }
}
