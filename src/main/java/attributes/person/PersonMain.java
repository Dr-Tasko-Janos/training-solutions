package attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Person newPerson = new Person("John Doe", "ABC123456789");
        System.out.println(newPerson.getName());
        System.out.println(newPerson.getIdentificationCard());
        newPerson.moveToAddress("Hungary", "Debrecen", "Piac utca 1.", "4032");
        System.out.println(newPerson.getAddress());

        newPerson.correctData("Jack Doe", "DEF000000000");
        System.out.println(newPerson.personToString());

        Address newAddress = new Address("Hungary", "Debrecen", "Vásár utca 1.", "4032");
        System.out.println(newAddress.getCountry());
        System.out.println(newAddress.getCity());
        System.out.println(newAddress.getStreetAndNumber());
        System.out.println(newAddress.getZipCode());
        System.out.println(newAddress.addressToString());
        newAddress.correctData("England", "London", "Church street 1.", "00174861");
        System.out.println(newAddress.addressToString());
    }
}
