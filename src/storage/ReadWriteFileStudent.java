package storage;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileStudent implements IReadWriteFileStudent {
    public static final String PATHNAME_STUDENT = "studentList.txt";

    public void writeFile(List<Student> students){
        File fileStudent = new File(PATHNAME_STUDENT);
        try {
            OutputStream opsStudent = new FileOutputStream(fileStudent);
            ObjectOutputStream oosStudent =  new ObjectOutputStream(opsStudent);
            oosStudent.writeObject(students);
            oosStudent.close();
            opsStudent.close();
            oosStudent.writeObject(students);
        } catch (IOException e) {
            System.out.println("loi ghi file" + e.getMessage());
        }
    }

    public List<Student> readFile(){
        File file = new File(PATHNAME_STUDENT);
        if (!file.exists()) {
            return getStudent();
        }
        try {
            InputStream isStudent = new FileInputStream(file);
            ObjectInputStream oisStudent = new ObjectInputStream(isStudent);
            Object object = oisStudent.readObject();
            return (List<Student>) object;
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file" + e.getMessage());
            return getStudent();
        } catch (IOException e) {
            System.out.println("Loi doc file" + e.getMessage());
            return getStudent();
        } catch (ClassNotFoundException e) {
            System.out.println("Loi doc file" + e.getMessage());
            return getStudent();
        }
    }
    public List<Student> getStudent(){
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(new Student());
        writeFile(listStudent);
        return listStudent;
    }
}