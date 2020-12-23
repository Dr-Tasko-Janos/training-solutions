package attributes.person;

public class Person {

    private String name;
    private String identificationCard;
    private Address address;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public void correctData(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public void moveToAddress(String country, String city, String streetAndNumber, String zipCode) {
        this.address = new Address(country, city, streetAndNumber, zipCode);
    }

    public String getAddress() {
        return address.addressToString();
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public String personToString() {
        return "name: " + name + " identitifactioncard number: " + identificationCard + ", address: " + address.addressToString();
    }
}
