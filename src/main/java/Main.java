import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        ReadExcel ReadExcel = null;
        List<University> universities =
                ReadExcel.readUniversities();
        for(University university : universities) {
            System.out.println(university);
        }

        List<Student> students =
                ReadExcel.readStudents();
        for(Student student : students) {
            System.out.println(student);
        }
    }

}
