package src.universityStructure;

import src.Exceptions.FailedStudent;
import src.Students.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Groups implements Comparable<Groups> {
    private String groupName;
    private List<Students> students;

    public Groups(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public List<Students> getStudents() throws FailedStudent {
        if (students.isEmpty()) {
            throw new FailedStudent("The group " + getGroupName() + " hasn't student");
        }
        return students;
    }

    public void setStudent(Students student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groups group = (Groups) o;
        return groupName.equals(group.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }

    @Override
    public String toString() {
        StringBuilder groupInString = new StringBuilder("Group is " + groupName + '\n');
        for (Students student : students) {
            groupInString.append(student.toString());
        }
        return groupInString.toString();
    }

    @Override
    public int compareTo(Groups o) {
        return groupName.compareTo(o.groupName);
    }
}
