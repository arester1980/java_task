package src.universityStructure;

import src.Exceptions.FailedFaculty;

import java.util.ArrayList;

public class University {
    private ArrayList<Faculties> faculties = new ArrayList<>();

    public University() {
    }

    public ArrayList<Faculties> getFaculties() throws FailedFaculty {
        if (faculties.isEmpty()) {
            throw new FailedFaculty("There aren't any groups");
        }
        return faculties;
    }

    public void setFaculty(Faculties faculty) {
        faculties.add(faculty);
    }

    @Override
    public String toString() {
        StringBuilder facultiesInString = new StringBuilder();
        for (Faculties faculty : faculties) {
            facultiesInString.append('\n');
            facultiesInString.append(faculty);
        }
        return facultiesInString.toString();
    }
}

