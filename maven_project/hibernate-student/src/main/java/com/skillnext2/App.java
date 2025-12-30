package com.skillnext2;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n---- STUDENT MENU ----");
            System.out.println("1. Insert Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Semester");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Semester: ");
                    int sem = sc.nextInt();
                    System.out.print("Department: ");
                    String dept = sc.next();

                    dao.insert(new Student(name, sem, dept));
                    System.out.println("Student inserted");
                    break;

                case 2:
                    List<Student> list = dao.getAll();
                    for (Student s : list) {
                        System.out.println(
                                s.getId() + " " +
                                s.getName() + " " +
                                s.getSem() + " " +
                                s.getDept()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    System.out.print("New Semester: ");
                    int newSem = sc.nextInt();

                    dao.update(uid, newSem);
                    System.out.println("Student updated");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int did = sc.nextInt();
                    dao.delete(did);
                    System.out.println("Student deleted");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
