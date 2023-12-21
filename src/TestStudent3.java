import java.util.Vector;

public class TestStudent3 {
    public static void mergeSort(Vector<Student> a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Vector<Student> l = new Vector<>();
        l.setSize(mid);
        Vector<Student> r = new Vector<>();
        r.setSize(n-mid);

        for (int i = 0; i < mid; i++) {
            l.set(i,a.get(i));
        }
        for (int i = mid; i < n; i++) {
            r.set(i-mid,a.get(i));
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r);
    }

    public static void merge(Vector<Student> a, Vector<Student> l, Vector<Student> r) {

        int left= l.size();
        int right = r.size();

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l.get(i).getiDNumber() <= r.get(j).getiDNumber()) {
                a.set(k,l.get(i));
                k++;
                i++;
            }
            else {
                a.set(k,r.get(j));
                k++;
                j++;
            }
        }
        while (i < left) {
            a.set(k,l.get(i));
            k++;
            i++;
        }
        while (j < right) {
            a.set(k,r.get(j));
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        StudentFactory big = new StudentFactory();
        Vector<Student> array1 = big.generateStudents(50);
        Vector<Student> array2 = big.generateStudents(100);

        mergeSort(array1, array1.size());

        System.out.println();
        System.out.println("after sort 1");
        for (Student student : array1) {
            System.out.print(student.getiDNumber() + " ");
        }


        mergeSort(array2, array2.size());
        System.out.println();
        System.out.println("after sort 2");
        for (Student student : array2) {
            System.out.print(student.getiDNumber() + " ");
        }

        Vector<Student> array3 = new Vector<>();
        array3.setSize(array1.size()+array2.size());
        merge(array3,array1,array2);
        System.out.println();
        System.out.println("after sort 3");


        for (Student student : array3) {
            System.out.print(student.getiDNumber() + " ");
        }


    }
}
