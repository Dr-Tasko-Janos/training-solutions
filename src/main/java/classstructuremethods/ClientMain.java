package classstructuremethods;

public class ClientMain {

    public static void main(String[] args) {

        Client client = new Client();

        //Calling the setters:

        client.setName("John Doe");
        client.setYear(1980);
        client.setAddress("1117 Budapest, Budafoki út 56.");

        //Calling the getters:

        System.out.println("Client name: " + client.getName());
        System.out.println("Client's year of birth: "+ client.getYear());
        System.out.println("Client address: " + client.getAddress());

        //Calling the additional method and give a feedback of the success:

        client.migrate("Centrum Praskie Koneser ul, Plac Konsera 10, 03-736 Warszawa, Lengyelország");
        System.out.println("\nYour address successfully modified!\nThe new address is:\t" +
                client.getAddress());

    }
}
