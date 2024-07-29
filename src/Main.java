import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int n;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao so luong sv:");
        n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            input();
        }
        System.out.println("IN DANH SACH SV:");
        output();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao ma sv can xoa:");
        String codeToRemove = sc.nextLine();
        removeByCode(codeToRemove);
        System.out.println("Danh sach sv sau khi xoa:");
        output();

        sortByGradeDesc();
        System.out.println("Danh sach sv sau khi sap xep giam dan theo diem:");
        output();

        System.out.println("Nhap vao ma sv hoac ten sv can tim:");
        String keyword = sc.nextLine();
        Student foundStudent = findByCodeOrName(keyword);
        if (foundStudent != null) {
            System.out.println("Tim thay sinh vien: " + foundStudent);
        } else {
            System.out.println("Khong tim thay sinh vien.");
        }

        System.out.println("Nhap vao diem can tim kiem (>= x):");
        float x = sc.nextFloat();
        List<Student> filteredStudents = filterByGrade(x);
        System.out.println("Danh sach sinh vien co diem >= " + x + ":");
        for (Student student : filteredStudents) {
            System.out.println(student);
        }
    }

    // Nhap moi 1 sinh vien
    public static void input() {
        System.out.println("Nhap vao thong tin sinh vien:");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ma sv:");
        String code = scanner.nextLine();
        System.out.println("Nhap ten sv:");
        String name = scanner.nextLine();
        System.out.println("Nhap diem:");
        float grade = scanner.nextFloat();
        Student student = new Student(code, name, grade);
        studentList.add(student);
    }

    // In danh sach sinh vien
    public static void output() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }

    // Xoa sinh vien theo ma
    public static void removeByCode(String code) {
        studentList.removeIf(student -> student.getCode().equals(code));
    }

    // Sap xep sinh vien theo diem giam dan
    public static void sortByGradeDesc() {
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade()));
    }

    // Tim kiem sinh vien theo ma hoac ten
    public static Student findByCodeOrName(String keyword) {
        for (Student student : studentList) {
            if (student.getCode().equals(keyword) || student.getName().equalsIgnoreCase(keyword)) {
                return student;
            }
        }
        return null;
    }

    // Tim kiem sinh vien co diem >= x
    public static List<Student> filterByGrade(float x) {
        List<Student> filteredStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGrade() >= x) {
                filteredStudents.add(student);
            }
        }
        return filteredStudents;
    }
}