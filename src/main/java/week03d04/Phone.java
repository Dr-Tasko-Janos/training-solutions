package week03d04;

import static week03d04.PhoneParser.parse;

public class Phone {

    private String prefix;
    private String number;

    public Phone(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public static void main(String[] args) {

        Phone newNumber = parse();
        System.out.println("newNumber has the following properties:\n\tprefix: " + newNumber.prefix + "\n\tnumber: " + newNumber.number);

    }
}
