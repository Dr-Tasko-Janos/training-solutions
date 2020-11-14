package statements;

public class Investment {
    private final int fund;
    private final int interestRate;
    private boolean active;

    public Investment(int fund, int interestRate) {
        this.active = true;
        this.fund = fund;
        this.interestRate = interestRate;
    }

    public int getFund() {
        return fund;
    }

    public double getYield(int days) {
        return ((fund * (interestRate / 100.0)) * days) / 365;
    }

    public double close(int days) {
        double sum = active ? (getYield(days) + fund) - ((getYield(days) + fund) * 0.003) : 0.0;
        active = false;
        if (sum == 0.0) {
            System.out.println("Your fund is not active anymore!");
        }
        return sum;
    }
}

