import java.util.Random;
import java.util.Vector;

public class StudentFactory {
    Vector<Integer> studID;
    public  StudentFactory() {
        studID = new Vector<>();
    }

    public Student createStudent(int ID, double gpa) {

        if(studID.isEmpty()) {
            studID.add(ID);
            return new Student(ID, gpa);
        }

        if (studID.contains(ID)) {
            System.out.println("already exists");
            return null;
        } else {
            studID.add(ID);
            return new Student(ID, gpa);
        }
    }

    public Vector<Student> generateStudents(int amt) {
        Vector<Student> temp = new Vector<>();
        Random ran = new Random();
        for(int i = 0; i <amt;i++) {
            temp.add(new Student(ran.nextInt(Integer.MAX_VALUE / 10000), ran.nextDouble(10)));
        }
        return temp;
    }

}
