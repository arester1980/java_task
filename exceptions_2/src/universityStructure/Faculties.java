package src.universityStructure;

import src.Exceptions.FailedGroup;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class Faculties {
    private String facultyName;
    private Set<Groups> groups;

    public Faculties(String facultyName) {
        this.facultyName = facultyName;
        groups = new TreeSet<>();
    }

    public String getFacultyName() {
        return facultyName;
    }

    public Set<Groups> getGroups() throws FailedGroup {
        if (groups.isEmpty()) {
            throw new FailedGroup("The faculty "
                    + getFacultyName() + " hasn't group(s)");
        }
        return groups;
    }

    public void setGroup(String groupName) {
        groups.add(new Groups(groupName));
    }

    public Groups getGroup(String groupName) throws FailedGroup {
        Optional<Groups> optionalGroup = getGroups().stream().
                filter(group -> group.getGroupName().equals(groupName)).findFirst();
        return optionalGroup.orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculties faculty = (Faculties) o;
        return facultyName.equals(faculty.facultyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facultyName);
    }

    @Override
    public String toString() {
        StringBuilder facultyInString = new StringBuilder("Faculty is " + facultyName + '\n');
        for (Groups group : groups) {
            facultyInString.append(group.toString());
        }
        return facultyInString.toString();
    }
}
