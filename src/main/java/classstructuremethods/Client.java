package classstructuremethods;

public class Client {

    private String name, address;
    private int year;

    //Setters:
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Getters:
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getYear() {
        return year;
    }

    //An additional setter:
    public void migrate(String address){
        this.address = address;
    }
}
