package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StudentListTest {

    public StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนใหม่และตรวจสอบข้อมูล")
    void testAddNewStudent() {
        studentList.addNewStudent("6710405508", "Weerasak");
        assertEquals(1, studentList.getStudents().size());

        Student student = studentList.findStudentById("6710405508");
        assertNotNull(student);
        assertEquals("Weerasak", student.getName());
        assertEquals(0.0, student.getScore());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย ID ที่มีอยู่")
    void testFindStudentById() {
        studentList.addNewStudent("6710405508", "Weerasak");
        Student student = studentList.findStudentById("6710405508");
        assertNotNull(student);
        assertEquals("6710405508", student.getId());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย ID ที่ไม่มีอยู่จริง")
    void testFindNonExistentStudent() {
        studentList.addNewStudent("6710405508", "Weerasak");
        Student student = studentList.findStudentById("9999999999");
        assertNull(student);
    }

    @Test
    @DisplayName("ทดสอบการกรองรายชื่อด้วยชื่อ")
    void testFilterByName() {
        studentList.addNewStudent("6710405508", "Weerasak");
        studentList.addNewStudent("6710405240", "Thanom");
        studentList.addNewStudent("6710444608", "Thanomkai");

        StudentList filter = studentList.filterByName("Thanom");
        assertEquals(0, filter.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนนักเรียนที่มี ID อยู่ในระบบ")
    void testGiveScoreToId() {
        studentList.addNewStudent("6710405508", "Weerasak");
        studentList.giveScoreToId("6710405508", 80.0);
        Student student = studentList.findStudentById("6710405508");
        assertEquals(80.0, student.getScore());
    }
}