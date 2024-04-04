package models;

public class Email {
    private String emailAddress;

    public Email(String emailAddress) {
        if (EmailValidator.isValidEmailAddress(emailAddress)) {
            this.emailAddress = emailAddress;
        } else {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
    public String getEmailAddress() {
        return emailAddress;
    }
}
