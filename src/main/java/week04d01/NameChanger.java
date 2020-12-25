package week04d01;

public class NameChanger {

    private String fullName;

    public NameChanger(String fullName) {
        if (fullName.isEmpty() || fullName.isBlank() || fullName == null) {
            throw new IllegalArgumentException("Invalid name: " + "\"" + fullName + "\"");
        }
        this.fullName = fullName;
    }

    public String getFullName() {  //For testing reason
        return fullName;
    }

    public void changeFirstName(String firstName) {
        String[] nameArray = fullName.split(" ");
        nameArray[0] = firstName;
        fullName = String.join(" ", nameArray);
    }

    public static void main(String[] args) {

        NameChanger newName = new NameChanger("John Doe");
        System.out.println("Original name: " + newName.getFullName());

        newName.changeFirstName("Jack");
        System.out.println("New name: " + newName.getFullName());
    }
}
