package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Teacher extends School implements Ranking, Serializable {
    private int workDay;

    public Teacher() {
    }
    public Teacher(int id, String name, LocalDate dateOfBirth, String phoneNumber, String address, String gender, String email, int workDay) {
        super(id, name, dateOfBirth, phoneNumber, address, gender, email);
        this.workDay = workDay;
    }

    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                ", Address='" + getAddress() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", email='" + getEmail() + '\'' +
                "workDay=" + workDay+
                '}';
    }

    @Override
    public String Rank() {
        return null;
    }
}
