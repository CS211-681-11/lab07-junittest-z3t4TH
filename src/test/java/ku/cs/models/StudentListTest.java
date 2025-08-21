package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentListTest {

    public StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void testAddNewStudent(){
        studentList.addNewStudent("6710405508","Weerasak");
        assertEquals(1, studentList.getStudents().size());

        Student student = studentList.findStudentById("6710405508");
        assertEquals("Weerasak",student.getName());
    }

    @Test
    void testFindStudentById(){
        studentList.addNewStudent("6710405508","Weerasak");
        Student student = studentList.findStudentById("6710405508");
        assertEquals("6710405508",student.getId());
    }

    @Test
    void testFilterByName() {
        studentList.addNewStudent("6710405508", "Weerasak");
        studentList.addNewStudent("6710405240", "Thanom");
        studentList.addNewStudent("6710444608", "Thanomkai");

        StudentList filter = studentList.filterByName("Thanom");
        assertEquals(2, filter.getStudents().size());

    }

    @Test
    void testGiveScoreToId(){
        studentList.addNewStudent("6710405508", "Weerasak");
        studentList.giveScoreToId("6710405240", 80);

        Student student = studentList.findStudentById("6710405508");
        assertEquals("80",student.getScore());

    }

}