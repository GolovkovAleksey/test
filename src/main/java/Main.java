import comporator.StudentComparator;
import comporator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorUtil;
import util.StatisticUtl;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e);
        }
        logger.log(INFO, "Started, Logger configured");

        ReadExcel ReadExcel = null;
        
        List<University> universities =
                ReadExcel.readUniversities();
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);

        universities.sort(universityComparator);

        List<Student> students =
                ReadExcel.readStudents();
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);

        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticUtl.createStatistics(students, universities);
        WriterExcel.writeStatisticsExcel(statisticsList, "statistics.xlsx");
        logger.log(INFO, "Application finished");
    }
}
