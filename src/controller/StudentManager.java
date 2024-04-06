package controller;
import model.Student;
import models.Gender;
import storage.IReadWriteFile;
import storage.ReadWriteFileStudent;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static regex.Regex.MAIL_PATTERN;
import static regex.Regex.PHONE_PATTERN;

public class StudentManager {
    private static IReadWriteFile readWriteFile = new ReadWriteFileStudent();
    private static List<Student> studentsList = readWriteFile.readFile();
    public static void addNewStudent(Scanner scanner) {
        System.out.println("Enter ID: ");
        int id;
        boolean idExists;
        do{
            System.out.println("Enter ID: ");
            id = scanner.nextInt();
            idExists = false;
            for(Student student: studentsList){
                if(student.getId() == id){
                    System.err.println("ID already exists! Please entry again!");
                    idExists = true;
                    break;
                }
            }
        }while (idExists);
        System.out.println();
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
        String phoneNumber1 = scanner.nextLine();
        while (!PHONE_PATTERN.matcher(phoneNumber1).matches()){
            System.out.println("Invalid phone number");
            phoneNumber1 = scanner.nextLine();
        }
        String phoneNumber = phoneNumber1;
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Choice Gender: ");
        System.out.println("1. Male \n2. Female");
        int choice = scanner.nextInt();
        String gender1 = null;
        switch (choice){
            case 1:
                gender1 = "Male";
                break;
            case 2:
                gender1 = "Female";
                break;
            default:
                System.out.println("Invalid selection");
        }
        System.out.println("Enter Email: ");
        String email1 = scanner.nextLine();
        while (!MAIL_PATTERN.matcher(email1).matches()){
            System.out.println("Invalid email!");
            email1 = scanner.nextLine();
        }
        String email = email1;
        System.out.println("Enter Score");
        double score = scanner.nextDouble();
        Student student = new Student(id,name,dateOfBirth,phoneNumber,address,gender1,email,score);
        studentsList.add(student);
        readWriteFile.writeFile(studentsList);
    }
    public static void showStudentList() {
        if (studentsList.isEmpty()) {
            System.out.println("Not Student Found!");
        }
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }
    public static void findStudent(int id) {
        for (Student student : studentsList) {
            if (student.getId() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Not Student Found!");
    }

    public static void removeStudent(int id) {
        Student removeStudents = null;
        for (Student student : studentsList) {
            if (student.getId() == id) {
                removeStudents = student;
                break;
            }
        }
        if (removeStudents != null) {
            studentsList.remove(removeStudents);
            readWriteFile.writeFile(studentsList);
        } else {
            System.out.println("Not Student Found!");
        }
    }
    public static void editStudent(int id, Student updateStudent) {
       int editStudent = -1;
        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getId() == id) {
                editStudent = i;
                break;
            }
        }
        if (editStudent != -1) {
            studentsList.set(editStudent, updateStudent);
            readWriteFile.writeFile(studentsList);
        }
    }
}
