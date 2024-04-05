package model;

import java.io.Serializable;

public class Student extends School implements Ranking, Serializable {
    private double score;

    public Student() {
    }

//    public Student(int id, String name, String dateOfBirth, String phoneNumber, String address, String gender, String email, double score) {
//        super(id, name, dateOfBirth, phoneNumber, address, gender, email);
//        this.score = score;
//    }


    public Student(int id, String name, String dateOfBirth, String phoneNumber, String address, String gender, String email, double score) {
        super(id, name, dateOfBirth, phoneNumber, address, gender, email);
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String Rank() {
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", Address='" + getAddress() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", email='" + getEmail() + '\'' +
                "score=" + score +
                '}';
    }
}
