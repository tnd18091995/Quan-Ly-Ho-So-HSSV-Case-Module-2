package controller;
import model.Teacher;
import storage.IReadWriteFile;
import storage.ReadWriteFileTeacher;
import java.util.List;

public class TeacherManager {
    private static IReadWriteFile readWriteFile = new ReadWriteFileTeacher();
    private static List<Teacher> teachersList = readWriteFile.readFile();
    public static void addNewTeacher(Teacher teachers) {
        teachersList.add(teachers);
        readWriteFile.writeFile(teachersList);
    }
    public static void showTeacherList() {
        if (teachersList.isEmpty()) {
            System.out.println("Không có hồ sơ giảng viên nào!");
        }
        for (Teacher teacher : teachersList) {
            System.out.println(teacher);
        }
    }
    public static void findTeacher(int id) {
        for (Teacher teacher : teachersList) {
            if (teacher.getId() == id) {
                System.out.println("Hồ sơ giảng viên được tìm thấy là: " + teacher);
                return;
            }
        }
        System.out.println("Khong tim thay ho so giang vien");
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
            System.out.println("Khong tim thay giang vien");
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
