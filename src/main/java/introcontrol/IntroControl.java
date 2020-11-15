package introcontrol;

public class IntroControl {
    public int subtractTenIfGreaterThanTen(int number) {
        if (number <= 10) {
            return number;
        } else {
            return number - 10;
        }
    }

    /*
    public int  subtractTenIfGreaterThanTenx(int number){
        return (number <= 10)? number : number - 10;
    }
    */

    public String describeNumber(int number) {
        if (number == 0) {
            return "zero";
        } else {
            return "non zero";
        }
    }

    public String greetingToJoe(String name) {
        if ("Joe".equals(name)) {
            return "Hello Joe";
        } else {
            return "";
        }
    }

    public int calculateBonus(int sale) {
        if (sale >= 1_000_000) {
            return (int) (sale * 0.1);
        }
        return 0;
    }

    /*
    public double calculateBonusx(int sale){
        if(sale >= 1_000_000.0){
            return sale * 0.1;
        }
        return 0.0;
    }
    */

    public int calculateConsumption(int prev, int next) {
        int measureLimit = 9999;
        if (prev > next) {
            return measureLimit - prev + next;
        } else {
            return next - prev;
        }
    }

    public void printNumbers(int max) {
        String iteration = "";
        if (max >= 0) {
            for (int i = 0; i <= max; i++) {
                iteration += ((i < max) ? (i + ", ") : i);
            }
        } else {
            iteration += "Error! The max value must be greater than or equal to 0(zero)!";
        }
        System.out.print(iteration + "\n");
    }

    public void printNumbersBetweenAnyDirection(int a, int b) {
        String iteration = "";
        if (a < 0 || b < 0) {
            System.out.print("ERROR! Both arguments value must belong to the array of positive whole numbers.");
        } else {
            if (a < b) {
                for (int i = a; i <= b; i++) {
                    iteration += ((i < b) ? (i + ", ") : i);
                }
            } else if (a > b) {
                for (int i = a; i >= b; i--) {
                    iteration += ((i > b) ? (i + ", ") : i);
                }
            } else if (a == b) {
                iteration += a;
            }
        }
        System.out.print(iteration + "\n");
    }

    public void printOddNumbers(int max) {
        String iteration = "";
        if (max >= 0) {
            for (int i = 1; i <= max; i += 2) {
                iteration += ((i < max) ? (i + ", ") : i);
            }
        } else {
            iteration += "Error! The max value must be greater than or equal to 0(zero)!";
        }
        System.out.print(iteration + "\n");
    }

    /*
    public void printOddNumbersx(int max) {
        String iteration = "";
        if (max >= 0) {
           for (int i = 0; i <= max; i++) {
                    iteration +=    (i%2 !=0) ? ((i < max) ? (i + ", ") : i) : "";
           }
        } else {
            iteration += "Error! The max value must be greater than or equal to 0(zero)!";
        }
        System.out.print(iteration + "\n");
    }
    */
}


