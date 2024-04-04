package controller;

import models.Student;
import storage.IReadWriteFile;
import storage.ReadWriteFile;
import java.util.List;

public class StudentManager {
        private static IReadWriteFile readWriteFile = new ReadWriteFile();
        private static List<Student> studentsList = readWriteFile.readFile();

        public static void addNewStudent(Student students) {
            studentsList.add(students);
            readWriteFile.writeFile(studentsList);
        }
        public static void showStudentList(){
            if(studentsList.isEmpty()){
                System.out.println("Không có hồ sơ sinh viên nào!");
            }
            for(Student student: studentsList){
                System.out.println(student);
            }
        }
        public static void findStudent(int id){
            for(Student student: studentsList){
                if(student.equals(id)){
                    System.out.println(student);
                }
            }
        }
    }
