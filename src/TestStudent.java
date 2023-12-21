import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class TestStudent {
    public static void main(String[] args) {
        StudentFactory big = new StudentFactory();

        Student[] array = new Student[50];
        Random ran = new Random();

        for(int i = 0; i < array.length; i++) {
            Student temp = big.createStudent(ran.nextInt(Integer.MAX_VALUE),ran.nextDouble(10));
            while (temp == null) {
                temp = big.createStudent(ran.nextInt(Integer.MAX_VALUE),ran.nextDouble(10));
            }
            array[i] = temp;
        }
        System.out.println("before sort");
        for (Student student : array) {
            System.out.print(student.getiDNumber() + " ");
        }

        for (int i = 1; i < array.length; ++i) {
            Student key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].getiDNumber() > key.getiDNumber()) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        System.out.println();
        System.out.println("after sort");
        for (Student student : array) {
            System.out.print(student.getiDNumber() + " ");
        }
    }
}
