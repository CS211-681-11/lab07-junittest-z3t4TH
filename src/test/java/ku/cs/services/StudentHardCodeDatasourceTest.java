package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {

    @Test
    @DisplayName("ทดสอบการอ่านข้อมูลแบบ Hardcode ว่าได้ข้อมูลครบถ้วนถูกต้อง")
    void testReadData() {
        StudentHardCodeDatasource datasource = new StudentHardCodeDatasource();
        StudentList studentList = datasource.readData();
        assertNotNull(studentList);
        assertEquals(4,studentList.getStudents().size());
        Student firstStudent = studentList.findStudentById("6710400001");
        assertNotNull(firstStudent);
        assertEquals("First", firstStudent.getName());
        Student thirdStudent = studentList.findStudentById("6710400003");
        assertNotNull(thirdStudent);
        assertEquals("Third", thirdStudent.getName());
    }

}