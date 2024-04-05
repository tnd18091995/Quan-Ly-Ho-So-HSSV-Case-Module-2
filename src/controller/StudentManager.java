package controller;
import models.Student;
import storage.IReadWriteFile;
import storage.ReadWriteFileStudent;
import java.util.List;

public class StudentManager {
    private static IReadWriteFile readWriteFile = new ReadWriteFileStudent();
    private static List<Student> studentsList = readWriteFile.readFile();
    public static void addNewStudent(Student students) {
        studentsList.add(students);
        readWriteFile.writeFile(studentsList);
    }
    public static void showStudentList() {
        if (studentsList.isEmpty()) {
            System.out.println("Không có hồ sơ sinh viên nào!");
        }
        for (Student student : studentsList) {
            System.out.println(student);
        }
    }
    public static void findStudent(int id) {
        for (Student student : studentsList) {
            if (student.getId() == id) {
                System.out.println("Ho so hoc sinh duoc tim thay la: " + student);
                return;
            }
        }
        System.out.println("Khong tim thay ho so hoc sinh");
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
            System.out.println("Khong tim thay hoc sinh");
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
