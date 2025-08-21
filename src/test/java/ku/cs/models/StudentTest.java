package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s = new Student("6710405508", "StudentTest");
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());

    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6710405508", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    void testIsId(){
        Student s = new Student("6710405508", "StudentTest");
        assertTrue(s.isId("6710405508"));
        assertFalse(s.isId("6710405507"));
    }

    @Test
    void testChangeName() {
        Student s = new Student("6710405508", "StudentTest");
        s.changeName("Weerasak");
        assertEquals("Weerasak", s.getName());
    }

    @Test
    void testIsNameContains() {
        Student s = new Student("6710405508", "Weerasak Thanomkai");
        assertTrue(s.isNameContains("Weerasak"));
        assertFalse(s.isNameContains("Thanomakai"));
    }
}