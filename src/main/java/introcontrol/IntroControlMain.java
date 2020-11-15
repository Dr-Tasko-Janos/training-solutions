package introcontrol;

public class IntroControlMain {
    public static void main(String[] args) {
        IntroControl introcontrol = new IntroControl();

        System.out.println("\n\nTest of \"subtractTenIfGreaterThanTen\" method:");
        System.out.println("\tIn case 12: " + introcontrol.subtractTenIfGreaterThanTen(12));
        System.out.println("\tIn case 10: " + introcontrol.subtractTenIfGreaterThanTen(10));
        System.out.println("\tIn case 8: " + introcontrol.subtractTenIfGreaterThanTen(8));
        System.out.println("\tIn case 0: " + introcontrol.subtractTenIfGreaterThanTen(0));
        System.out.println("\tIn case -2: " + introcontrol.subtractTenIfGreaterThanTen(-2));

        /*
        System.out.println("\n\nTest of \"subtractTenIfGreaterThanTenx\" method, which is an alternative solution with a ternary operator of the method above: ");
        System.out.println("\tIn case 12x: " + introcontrol.subtractTenIfGreaterThanTenx(12));
        System.out.println("\tIn case 10x: " + introcontrol.subtractTenIfGreaterThanTenx(10));
        System.out.println("\tIn case 8x: " + introcontrol.subtractTenIfGreaterThanTenx(8));
        System.out.println("\tIn case 0x: " + introcontrol.subtractTenIfGreaterThanTenx(0));
        System.out.println("\tIn case -2x: " + introcontrol.subtractTenIfGreaterThanTenx(-2));
        */


        System.out.println("\n\nTest of \"describeNumber\" method:");
        System.out.println("\tIn case 0: " + introcontrol.describeNumber(0));
        System.out.println("\tIn case 2: " + introcontrol.describeNumber(2));
        System.out.println("\tIn case -2: " + introcontrol.describeNumber(-2));


        System.out.println("\n\nTest of \"greetingToJoe\" method:");
        System.out.println("\tIn case of \"Joe\": " + introcontrol.greetingToJoe("Joe"));
        System.out.println("\tIn case of \"John\": " + introcontrol.greetingToJoe("John"));


        System.out.println("\n\nTest of the \"calculateBonus\" method:");
        System.out.println("\tIn case 1_000_001: " + introcontrol.calculateBonus(1000001));
        System.out.println("\tIn case 1_000_000: " + introcontrol.calculateBonus(1000000));
        System.out.println("\tIn case 999_999: " + introcontrol.calculateBonus(999999));

        /*
        System.out.println("\n\nTest of the \"calculateBonus\" method with an alternative solution of the method above with a return value of type double:");
        System.out.println("\tIn case 1_000_001: " + introcontrol.calculateBonus(1000001));
        System.out.println("\tIn case 1_000_000: " + introcontrol.calculateBonus(1000000));
        System.out.println("\tIn case 999_999: " + introcontrol.calculateBonus(999999));
        System.out.println("And here is the difference between the two method: ");
        System.out.println("\tin case of 1_000_009 with an integer return type: " + introcontrol.calculateBonus(1_000_009));
        System.out.println("\tin case of 1_000_009 with a double return type: " + introcontrol.calculateBonusx(1_000_009));
        */


        System.out.println("\n\nTest of the \"calculateConsumption\" method:");
        System.out.println("\tIn case prev value: 100, next value: 200: " + introcontrol.calculateConsumption(100, 200));
        System.out.println("\tIn case prev value: 100, next value: 100: " + introcontrol.calculateConsumption(100, 100) +
                " or it can be: 9999 in the case of a \"full circle\", because the measure limit is 9999(!).");
        System.out.println("\tIn case prev value: 200, next value: 100: " + introcontrol.calculateConsumption(200, 100));


        System.out.println("\n\nTest of the \"printNumbers\" method:");
        System.out.print("\tIn case of 50: ");
        introcontrol.printNumbers(50);
        System.out.print("\tIn case of 0: ");
        introcontrol.printNumbers(0);
        System.out.print("\tIn case of -50: ");
        introcontrol.printNumbers(-50);


        System.out.println("\n\nTest of the \"printNumbersBetweenAnyDirection\" method:");
        System.out.print("\tIn case of a = 0 and b = 50: ");
        introcontrol.printNumbersBetweenAnyDirection(0, 50);
        System.out.print("\tIn case of a = -1 and b = 50: ");
        introcontrol.printNumbersBetweenAnyDirection(-1, 50);
        System.out.print("\tIn case of a = 1 and b = 50: ");
        introcontrol.printNumbersBetweenAnyDirection(1, 50);
        System.out.print("\tIn case of a = 50 and b = 0: ");
        introcontrol.printNumbersBetweenAnyDirection(50, 0);
        System.out.print("\tIn case of a = 50 and b = -1: ");
        introcontrol.printNumbersBetweenAnyDirection(50, -1);
        System.out.print("\tIn case of a = 50 and b = 1: ");
        introcontrol.printNumbersBetweenAnyDirection(50, 1);
        System.out.print("\tIn case of a = 0 and b = 0: ");
        introcontrol.printNumbersBetweenAnyDirection(0, 0);
        System.out.print("\tIn case of a = -1 and b = -50: ");
        introcontrol.printNumbersBetweenAnyDirection(-1, -50);
        System.out.print("\tIn case of a = -50 and b = -1: ");
        introcontrol.printNumbersBetweenAnyDirection(-50, -1);
        System.out.print("\tIn case of a = -1 and b = -1: ");
        introcontrol.printNumbersBetweenAnyDirection(-1, -1);


        System.out.println("\n\nTest of the \"printOddNumbers\" method:");
        System.out.print("\tIn case of 50: ");
        introcontrol.printOddNumbers(50);
        System.out.print("\tIn case of 51: ");
        introcontrol.printOddNumbers(51);
        System.out.print("\tIn case of 0: ");
        introcontrol.printOddNumbers(0);
        System.out.print("\tIn case of -50: ");
        introcontrol.printOddNumbers(-50);
        System.out.print("\tIn case of -51: ");
        introcontrol.printOddNumbers(-51);

        /*
        System.out.println("\n\nTest of the \"printOddNumbersx\" method which is an  alternative method of the solution above with two nested ternary operator:");
        System.out.print("\tIn case of 50: ");
        introcontrol.printOddNumbersx(50);
        System.out.print("\tIn case of 51: ");
        introcontrol.printOddNumbersx(51);
        System.out.print("\tIn case of 0: ");
        introcontrol.printOddNumbersx(0);
        System.out.print("\tIn case of -50: ");
        introcontrol.printOddNumbersx(-50);
        System.out.print("\tIn case of -51: ");
        introcontrol.printOddNumbersx(-51);
        */
    }
}
