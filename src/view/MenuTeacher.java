package view;
import controller.TeacherManager;
import model.Teacher;

import java.time.LocalDate;
import java.util.Scanner;
public class MenuTeacher {
    public static void showMenuTeacher() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----TeacherManager-----");
            System.out.println("1. Add Teacher");
            System.out.println("2. Show ListTeachers");
            System.out.println("3. Find Teacher");
            System.out.println("4. Edit Teacher");
            System.out.println("5. Remove Teacher");
            System.out.println("0. Exit ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    TeacherManager.addNewTeacher(scanner);

                    break;
                case 2:
                    TeacherManager.showTeacherList();
                    break;
                case 3:
                    System.out.println("Enter ID Teacher");
                    int id = scanner.nextInt();
                    TeacherManager.findTeacher(id);
                    break;
                case 4:
                    System.out.println("Enter ID Teacher");
                    int idEdit = scanner.nextInt();
                    Teacher updateTeacher = creatNewTeacher(scanner);
                    TeacherManager.editTeacher(idEdit, updateTeacher);
                case 5:
                    System.out.println("Enter ID Teacher");
                    int idRemove = scanner.nextInt();
                    TeacherManager.removeTeachers(idRemove);
                case 0:
                    System.out.println("Exit Program");
                    break;
                default:
                    System.out.println("Enter Again");
                    break;
            }
        } while (choice != 0);
    }
    public static Teacher creatNewTeacher(Scanner scanner) {
        System.out.println("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Date Of Birth: ");
        int day = 0;
        do{
            System.out.println(" Enter day: ");
            day = scanner.nextInt();
        }while( day <= 0 || day >31);
        int month = 0;
        do{
            System.out.println(" Enter month: ");
            month = scanner.nextInt();
        }while( month <= 0 || month >12);
        System.out.println("Enter Year");
        int year = scanner.nextInt();
        LocalDate dateOfBirth = LocalDate.of(year,month,day);
        System.out.println("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Gender: ");
        String gender = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Work Day");
        int workDay = scanner.nextInt();
        return new Teacher(id,name,dateOfBirth,phoneNumber,address,gender,email,workDay);
    }
}