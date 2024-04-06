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
//                case 4:
//                    System.out.println("Enter ID Student");
//                    int idEdit = scanner.nextInt();
//                    StudentManager.editStudent(idEdit, updateStudent);
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

//    public static Student creatNewStudent(Scanner scanner) {
//            System.out.println("Enter ID: ");
//            int id;
//            boolean idExists;
//            do{
//                System.out.println("Enter ID: ");
//                id = scanner.nextInt();
//                idExists = false;
//                for(Student student: listStudent)
//            }
//            System.out.println("Enter Name: ");
//            String name = scanner.nextLine();
//            System.out.println("Enter Date Of Birth: ");
//            int day = 0;
//            do{
//                System.out.println(" Enter day: ");
//                day = scanner.nextInt();
//            }while( day <= 0 || day >31);
//            int month = 0;
//            do{
//                System.out.println(" Enter month: ");
//                month = scanner.nextInt();
//            }while( month <= 0 || month >12);
//            System.out.println("Enter Year");
//            int year = scanner.nextInt();
//        LocalDate dateOfBirth = LocalDate.of(year,month,day);
//            System.out.println("Enter Phone Number: ");
//            String phoneNumber = scanner.nextLine();
//            System.out.println("Enter Address: ");
//            String address = scanner.nextLine();
//            System.out.println("Enter Gender: ");
//            String gender = scanner.nextLine();
//            System.out.println("Enter Email: ");
//            String email = scanner.nextLine();
//            System.out.println("Enter Score");
//            double score = scanner.nextDouble();
//        return new Student(id,name,dateOfBirth,phoneNumber,address,gender,email,score);
//    }

}