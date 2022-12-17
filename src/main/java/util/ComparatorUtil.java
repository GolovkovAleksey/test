package util;

import comporator.*;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;

public class ComparatorUtil {
        private ComparatorUtil() {
        }

        public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {

            switch (studentComparatorType) {
                case UNIVERSITY_ID:
                    return new StudentUniversityIdComparator();
                case COURSE:
                    return new StudentCourseComparator();
                case AVG_EXAM_SCORE:
                    return new StudentAvgExamScoreComparator();
                case FULL_NAME:
                    return new StudentFullNameComparator();
                default:
                    return new StudentFullNameComparator();
            }
        }

        public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType) {

            switch (universityComparatorType) {
                case FULL_NAME:
                    return new UniversityFullNameComparator();
                case ID:
                    return new UniversityIdComparator();
                case SHORT_NAME:
                    return new UniversityShortNameComparator();
                case YEAR:
                    return new UniversityYearComparator();
                case PROFILE:
                    return new UniversityProfileComparator();
                default:
                    return new UniversityFullNameComparator();
            }
        }
}
