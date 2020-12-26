package week06d05;

public class Biscuit {

    private BiscuitType type;
    private int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public String getType() {
        return type.name();
    }

    public int getGramAmount() {
        return gramAmount;
    }

    public static Biscuit of(BiscuitType type, int gramAmount) {
        Biscuit favourite = new Biscuit(type, gramAmount);
        return favourite;
    }

    @Override
    public String toString() {
        return "My favourite biscuit type: " + getType() + " --- gramAmount: " + getGramAmount();
    }

    public static void main(String[] args) {

        Biscuit biscuit = new Biscuit(BiscuitType.OREO, 120);
        System.out.println(biscuit);
    }
}

enum BiscuitType {

    OREO, VIENNESE_WHIRLS, KIT_KAT
}
