package src.Start;

import src.Exceptions.*;
import src.universityStructure.University;

public abstract class Init {
    protected University university;

    public Init() {
        university = new University();
    }

    protected abstract void setFaculties();

    protected abstract void setGroups() throws FailedUniversity, FailedFaculty;

    protected abstract void setStudents() throws FailedFaculty, FailedGroup;

    protected abstract void setGrades() throws FailedMark, FailedSubject, FailedGroup,
            FailedFaculty, FailedUniversity, FailedStudent;

    public University setUniversity() throws FailedMark, FailedSubject, FailedGroup, FailedUniversity,
            FailedFaculty, FailedStudent {
        setFaculties();
        setGroups();
        setStudents();
        setGrades();
        return university;
    }
}

