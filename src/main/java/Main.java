import Comporator.StudentComparator;
import Comporator.UniversityComparator;
import Enums.StudentComparatorType;
import Enums.UniversityComparatorType;
import Model.Student;
import Model.University;
import Util.ComparatorUtil;
import Util.JsonUtil;
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

        universities.sort(universityComparator);
        String universitiesJson = JsonUtil.universityListToJson(universities);

        System.out.println(universitiesJson);

        List<University> universitiesFromJson = JsonUtil.jsonToUniversityList(universitiesJson);
        // проверка, воссзоздания коллекции
        System.out.println(universities.size() == universitiesFromJson.size());
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            // проверка, json
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            // проверка, воссоздания элемента
            System.out.println(universityFromJson);
        });

        List<Student> students =
                ReadExcel.readStudents();
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);

        students.sort(studentComparator);
        String studentsJson = JsonUtil.studentListToJson(students);
        // проверяем, что json создан успешно
        System.out.println(studentsJson);
        List<Student> studentsFromJson = JsonUtil.jsonToStudentList(studentsJson);
        // проверка, воссзоздания коллекции
        System.out.println(students.size() == studentsFromJson.size());
        students.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            // проверка, json
            System.out.println(studentJson);
            Student studentFromJson = JsonUtil.jsonToStudent(studentJson);
            // проверка, воссоздания элемента
            System.out.println(studentFromJson);
        });

    }
}
