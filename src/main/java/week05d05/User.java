package week05d05;

public class User {

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        if (email.contains("@")
                && email.contains(".")
                && email.indexOf("@") < email.indexOf(".")
                && email.indexOf(".") > email.indexOf("@") + 1
                && email.indexOf(".") < email.length() - 1) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        } else {
            throw new IllegalArgumentException("Not valid email address format!");
        }
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public static void main(String[] args) {

        User user = new User("John", "Doe", "johndoe@johndocorporation.com");
        System.out.println(user.getFullName());
    }
}
