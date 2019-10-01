package Øving9.base;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("Jens",4, 4);
        System.out.println(student.getNavn());
        System.out.println(student.getAntOppg());
        System.out.println(student.toString());
        student.økAntOppg(2);
        System.out.println(student.toString());
    }
}
