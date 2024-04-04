package models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateOfBirthValidator {
    public static boolean isValidDateOfBirth(String dateOfBirth) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateOfBirth);
        return matcher.matches();
    }
}
