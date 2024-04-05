package view;

import java.util.Scanner;

import controller.StudentManager;
import models.Student;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do{
                System.out.println("-----Menu-----");
                System.out.println("1. Add Student");
                System.out.println("2. Show ListStudents");
                System.out.println("3. Find Student");
                System.out.println("4. Find Student");
                System.out.println("0. Exit ");
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 1:
                        Student newStudent = creatNewStudent(scanner);
                        StudentManager.addNewStudent(newStudent);
                        break;
                    case 2:
                        StudentManager.showStudentList();
                        break;
                    case 3:
                        System.out.println("Nhập mã sinh viên cần tìm");
                        int id = scanner.nextInt();
                        StudentManager.findStudent(id);
                        break;
                    case 0:
                        System.out.println("Chuong trinh ket thuc");
                        break;
                    default:
                        System.out.println("Nhap sai roi nhap lai di!");
                        break;
                }
            } while(choice != 0);
        }

        public static Student creatNewStudent(Scanner scanner) {
            System.out.println("Nhap ID Hoc Sinh Sinh Vien ID= ");
            int id = scanner.nextInt();
            System.out.println("Nhap ten Hoc Sinh Sinh Vien  NAME= ");
            String name = scanner.nextLine();
//            return new Student(id,name,);
        }
    }

}
