public class Account {

    private Long accountNumber;
    private long amount;

    public Account(Long accountNumber, long amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public void deposit(long money) {
        this.amount += money;
    }

    public boolean withdraw(long money) {
        if (this.amount - money >= 0) {
            this.amount -= money;
        } else {
            System.out.println("잔액이 부족합니다.");
            return false;
        }
        return true;
    }
}
