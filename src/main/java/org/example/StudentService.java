package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    List<Student> students = new ArrayList<>();

    void addStudent() {
        System.out.println("add student");
        Scanner sc = new Scanner(System.in);

        System.out.println("name: ");
        String name = sc.nextLine();
        System.out.println("age: ");

        int age = 0;
        while (true) {
            try {
                age = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }

        System.out.println("email: ");
        String email = sc.nextLine();
        System.out.println("score: ");
        double score;
        while (true) {
            try {
                score = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a score number");
            }
        }

        int id = this.students.size() + 1;

        Student stu = new Student(id, name, age, email, score);
        this.students.add(stu);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("student added");


    }

    void deleteStudent() {
        System.out.println("delete Student");
        this.showAllStudents();
        System.out.println("Enter student ID");
        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());


    }

    void modifyStudent() {
        System.out.println("modify student");
        this.showAllStudents();

    }

    void queryStudent() {
        System.out.println("query Student");
        Integer choice;
        while (true) {
            System.out.println("""
                    press 1 : query by id; 
                    press 2 : query by name; 
                    press 3 : query by email;""");
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        switch (choice) {
            case Integer i when i == 1 -> this.queryStudentById();
            case Integer i when i == 2 -> this.queryStudentByName();
            case Integer i when i == 3 -> this.queryStudentByEmail();
            default -> System.out.println("Invalid choice");
        }
    }

    void queryStudentById() {
        System.out.println("id:");
        int id = Integer.MIN_VALUE;
        while (true) {
            try {
                id = Integer.parseInt(new Scanner(System.in).nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        boolean isExist = false;
        for (Student student : this.students) {
            if (student.getId() == id) {
                isExist = true;
                System.out.println(student);
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }

    void queryStudentByName() {
        System.out.println("name: ");
        String name = new Scanner(System.in).nextLine();
        boolean isExist = false;
        for (Student stu : this.students) {
            if (stu.getName().equals(name)) {
                isExist = true;
                System.out.println(stu.toString());
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }

    void queryStudentByEmail() {
        System.out.println("email: ");
        String email = new Scanner(System.in).nextLine();
        boolean isExist = false;
        for (Student stu : this.students) {
            if (stu.getEmail().equals(email)) {
                isExist = true;
                System.out.println(stu.toString());
            }
        }
        if (!isExist) {
            System.out.println("Student not found");
        }
    }

    void showAllStudents() {
        for (Student stu : students) {
            System.out.println(stu);
        }
    }

    void sortByScores() {

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //return Double.compare(o1.getScore(), o2.getScore());
                return Double.compare(o2.getScore(), o1.getScore());
            }
        });

        showAllStudents();

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
    }

    void averageScore() {

    }
}
