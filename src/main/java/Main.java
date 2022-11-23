import Comporator.StudentComparator;
import Comporator.UniversityComparator;
import Enums.StudentComparatorType;
import Enums.UniversityComparatorType;
import Model.Student;
import Model.University;
import Util.ComparatorUtil;
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
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                ReadExcel.readStudents();
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }

}
