import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
    @Id
    private Integer id;
    private int accountNum;
    private double balance;
    private String name;

    public Account(Integer id, int accountNum, double balance, String name) {
        this.id = id;
        this.accountNum = accountNum;
        this. balance = balance;
        this.name = name;
    }

    public Account() {
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accountNum=" + accountNum +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
