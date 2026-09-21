
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to student manager system");
        String menu = """
                
                function menu:
                1. Add student
                2. Delete student
                3. Modify students
                4. Query students
                5. Show all students
                6. Exit
                Please enter your choice:""";


        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(menu);
            Scanner sc = new Scanner(System.in);
            Integer choice = sc.nextInt();
            switch (choice) {
                case Integer i when i == 1 -> addStudent();
                case Integer i when i == 2 -> deleteStudent();
                case Integer i when i == 3 -> modifyStudent();
                case Integer i when i == 4 -> queryStudent();
                case Integer i when i == 5 -> showAllStudents();
                case Integer i when i == 6 -> System.exit(0);
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }

    }

    static List<Student> students = new ArrayList<>();


    static void addStudent() {
        System.out.println("add student");
        Scanner sc = new Scanner(System.in);

        System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("email: ");
        String email = sc.nextLine();
        System.out.println("score: ");
        double score = Double.parseDouble(sc.nextLine());

        int id = students.size() + 1;

        Student stu = new Student(id, name, age, email, score);
        students.add(stu);
        showAllStudents();

    }

    static void deleteStudent() {
        System.out.println("delete Student");

    }

    static void modifyStudent() {
        System.out.println("modify student");
    }

    static void queryStudent() {
        System.out.println("query Student");
    }

    static void showAllStudents() {
        for (Student stu : students) {
            System.out.println(stu);
        }

    }

}
