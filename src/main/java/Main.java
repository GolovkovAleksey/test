public class Main {
    public static void main(String[] args) {
        StudyProfile studyProfile = StudyProfile.ENGINEER;
        System.out.println(studyProfile);
        University university = new University();
        university.fullName = "Test";
        university.mainProfile = "ENGINEER";
        university.id = "1";
        university.shortName = "we";
        university.yearOfFoundation = 2002;
        System.out.println(university);

        Student student = new Student();
        student.avgExamScore = 3;
        student.currentCourseNumber = 1;
        student.fullName ="eee";
        student.universityId = "";
        System.out.println(student);
    }

}
