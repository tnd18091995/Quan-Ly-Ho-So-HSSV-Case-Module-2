package models;

import java.time.LocalDate;

public class DateOfBirth {
    private LocalDate date;

    public DateOfBirth(String dateOfBirth) {
        if (DateOfBirthValidator.isValidDateOfBirth(dateOfBirth)) {
            this.date = LocalDate.parse(dateOfBirth);
        } else {
            throw new IllegalArgumentException("Invalid date of birth format. Use yyyy-MM-dd.");
        }
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(String dateOfBirth) {
        if (DateOfBirthValidator.isValidDateOfBirth(dateOfBirth)) {
            this.date = LocalDate.parse(dateOfBirth);
        } else {
            throw new IllegalArgumentException("Invalid date of birth format. Use yyyy-MM-dd.");
        }
    }
}