package view;

import controller.StudentManager;
import controller.TeacherManager;
import model.Student;
import model.Teacher;

import java.time.LocalDate;
import java.util.Scanner;

import static controller.StudentManager.addNewStudent;

public class MenuStudent {
    public static void showMenuStudent() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----StudentManager-----");
            System.out.println("1. Add Student");
            System.out.println("2. Show ListStudents");
            System.out.println("3. Find Student");
            System.out.println("4. Edit Student");
            System.out.println("5. Remove Student");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    StudentManager.addNewStudent(scanner);
                    break;
                case 2:
                    StudentManager.showStudentList();
                    break;
                case 3:
                    System.out.println("Enter Student ID");
                    int id = scanner.nextInt();
                    StudentManager.findStudent(id);
                    break;
                case 4:
                    System.out.println("Enter ID Student");
                    int idEdit = scanner.nextInt();
                    StudentManager.removeStudent(idEdit);
                    StudentManager.addNewStudent(scanner);
                case 5:
                    System.out.println("Enter ID Student");
                    int idRemove = scanner.nextInt();
                    StudentManager.removeStudent(idRemove);
                case 0:
                    System.out.println("Exit Program");
                    break;
                default:
                    System.out.println("Try Enter Again!");
                    break;
            }
        } while (choice != 0);
    }
}