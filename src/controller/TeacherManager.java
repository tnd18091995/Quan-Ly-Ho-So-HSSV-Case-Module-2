package controller;
import model.Student;
import model.Teacher;
import storage.IReadWriteFile;
import storage.ReadWriteFileTeacher;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

import static regex.Regex.MAIL_PATTERN;
import static regex.Regex.PHONE_PATTERN;

public class TeacherManager {
    private static IReadWriteFile readWriteFile = new ReadWriteFileTeacher();
    private static List<Teacher> teachersList = readWriteFile.readFile();
    public static void addNewTeacher(Scanner scanner) {
        System.out.println("Enter ID: ");
        int id;
        boolean idExists;
        do{
            System.out.println("Enter ID: ");
            id = scanner.nextInt();
            idExists = false;
            for(Teacher teacher: teachersList){
                if(teacher.getId() == id){
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
        System.out.println("Enter Work Day: ");
        int workDay = scanner.nextInt();
        Teacher teachers = new Teacher(id,name,dateOfBirth,phoneNumber,address,gender1,email,workDay);
        teachersList.add(teachers);
        readWriteFile.writeFile(teachersList);
    }
    public static void showTeacherList() {
        if (teachersList.isEmpty()) {
            System.out.println("Empty!");
        }
        for (Teacher teacher : teachersList) {
            System.out.println(teacher);
        }
    }
    public static void findTeacher(int id) {
        for (Teacher teacher : teachersList) {
            if (teacher.getId() == id) {
                System.out.println(teacher);
                return;
            }
        }
        System.out.println("Not Teacher Found!");
    }

    public static void removeTeachers(int id) {
        Teacher removeTeachers = null;
        for (Teacher teacher : teachersList) {
            if (teacher.getId() == id) {
                removeTeachers = teacher;
                break;
            }
        }
        if (removeTeachers != null) {
            teachersList.remove(removeTeachers);
            readWriteFile.writeFile(teachersList);
        } else {
            System.out.println("Not Teacher Found!");
        }
    }
    public static void editTeacher(int id, Teacher updateTeacher) {
        int editTeacher = -1;
        for (int i = 0; i < teachersList.size(); i++) {
            if (teachersList.get(i).getId() == id) {
                editTeacher = i;
                break;
            }
        }
        if (editTeacher != -1) {
            teachersList.set(editTeacher, updateTeacher);
            readWriteFile.writeFile(teachersList);
        }
    }
}
