package week03d05;

public class Operation {

    private int leftOperand;
    private int rightOperand;

    public Operation(String addition) {
        String[] additionInArray = addition.split("\\+");
        leftOperand = Integer.parseInt(additionInArray[0]);
        rightOperand = Integer.parseInt(additionInArray[1]);
    }

    public int getResult() {
        return this.leftOperand + this.rightOperand;
    }

    public static void main(String[] args) {

        Operation operation = new Operation("12+64");
        System.out.println(operation.getResult());
    }
}
