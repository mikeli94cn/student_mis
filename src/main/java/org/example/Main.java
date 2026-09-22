package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentService service = new StudentService();
        System.out.println("===Welcome to student manager system===");
        String menu = """
                
                Function Menu:
                1. Add student
                2. Show all students
                3. Query students
                4. Modify students
                5. Delete student
                6. Sort scores
                7. Average score
                8. Exit
                Please enter your choice:""";


        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println(menu);

            Integer choice = -1;
            while (true) {
                try {
                    choice = Integer.parseInt(new Scanner(System.in).nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number");
                }
            }

            switch (choice) {
                case Integer i when i == 1 -> service.addStudent();
                case Integer i when i == 2 -> service.showAllStudents();
                case Integer i when i == 3 -> service.queryStudent();
                case Integer i when i == 4 -> service.modifyStudent();
                case Integer i when i == 5 -> service.deleteStudent();
                case Integer i when i == 6 -> service.sortByScores();
                case Integer i when i == 7 -> service.averageScore();
                case Integer i when i == 8 -> System.exit(0);
                default -> System.out.println("Unexpected value: " + choice);
            }
        }

    }


}
