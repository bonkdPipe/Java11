import java.util.Vector;

public class TestStudent2 {
    static SortStudentsByGPA ob = new SortStudentsByGPA();
    private static int partition(Vector<Student> arr, int low, int high)
    {
        Student pivot = arr.get(high);
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (ob.compare(arr.get(j),pivot) < 0)
            {
                i++;

                // swap arr[i] and arr[j]
                Student temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Student temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private static void sort(Vector<Student> arr, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int indexPartition = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, indexPartition-1);
            sort(arr, indexPartition+1, high);
        }
    }

    public static void main(String[] args) {
        StudentFactory big = new StudentFactory();
        Vector<Student> array = big.generateStudents(50);
        sort(array,0,49);
        for (Student student : array) {
            System.out.print(student.getGpa() + " ");
        }
    }
}
