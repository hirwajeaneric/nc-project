package rw.wallet.e.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author hirwa
 */
@Entity
public class Account implements Serializable {
    @Id
    private String accountNumber;
    @ManyToOne
    private User User;
    private String accountName;
    private double amount;

    public Account() {
        amount= 1000.0;
    }

    public Account(String accountNumber, User User, double amount) {
        this.accountNumber = accountNumber;
        this.User = User;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
