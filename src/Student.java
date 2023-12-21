public class Student implements Comparable<Student>{
    private Integer iDNumber;
    private Double gpa;

    public Student(Integer IDNumber, double gpa) {
        this.iDNumber = IDNumber;
        this.gpa = gpa;
    }

    public Integer getiDNumber() {
        return iDNumber;
    }
    public Double getGpa() { return gpa; }

    @Override
    public int compareTo(Student o) {
        return iDNumber.compareTo(o.getiDNumber());
    }
}
