package ku.cs.models;

import java.util.ArrayList;

public class StudentList {
    private static ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public static void addNewStudent(String id, String name) {
        id = id.trim();
        name = name.trim();
        if (!id.equals("") && !name.equals("")) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id.trim(), name.trim()));
            }
        }
    }

    public void addNewStudent(String id, String name, double score) {
        id = id.trim();
        name = name.trim();
        if (!id.equals("") && !name.equals("")) {
            Student exist = findStudentById(id);
            if (exist == null) {
                students.add(new Student(id.trim(), name.trim(), score));
            }
        }
    }

    public static Student findStudentById(String id) {
        for (Student student : students) {
            if (student.isId(id)) {
                return student;
            }
        }
        return null;
    }

    public StudentList filterByName(String name) {
        StudentList filteredList = new StudentList();
        for (Student student : students) {
            if (student.isNameContains(name)) {
                filteredList.students.add(student);
            }
        }
        return filteredList;
    }

    public void giveScoreToId(String id, double score) {
        Student exist = findStudentById(id);
        if (exist != null) {
            exist.addScore(score);
        }
    }

    public String viewGradeOfId(String id) {
        Student exist = findStudentById(id);
        if (exist != null) {
            return exist.grade();
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
