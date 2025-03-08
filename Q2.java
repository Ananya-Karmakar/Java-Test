abstract class bankaccount{
    String accunum;
    double balance;
    public bankaccount(String accnum,double balance){
        this.accunum =accnum;
        this.balance = balance;
    }
    void deposit(double amount){
        balance = balance +amount;
        System.out.println("New balance: " + balance);
    }
    abstract double withdraw(double amount);
} 

interface transaction {
public boolean transfer(bankaccount toaccount,double amount);
}


class savings extends bankaccount implements transaction{
    public savings(String accnum,double balance){
        super(accnum,balance);
    }
   
public boolean transfer(bankaccount toBankaccount,double amount){
    if(balance - amount < 500){
        System.out.println("Cannot transfer");
        return false;
    }
    else{
        balance = balance - amount;
        toBankaccount.balance = toBankaccount.balance + amount;
        System.out.println("Amount transferred successfully");
        System.out.println("Savings balance: " + balance);
        return true;
    }
}


public double withdraw(double amount){
    if(balance-amount < 500){
        System.out.println("Cannot be withdrawn");
        return 0;
    }else{
        balance = balance - amount;
        System.out.println("Current balance after withdrawn: "+ balance);
        return balance;
    }
}

}

class current extends bankaccount implements transaction{
    
    public current(String accnum,double balance){
        super(accnum,balance);
    }

    public double withdraw(double amount){
        if(balance-amount < -5000){
            System.out.println("Overdraft exceeded");
            return 0;
        }
            balance = balance - amount;
            System.out.println("Current balance after withdrawn: "+ balance);
            return balance;
        }
        public boolean transfer(bankaccount tBankaccount,double amount){
            if(balance -amount< 500){
                System.out.println("Cannot transfer");
                return false;
            }
            else{
                balance = balance - amount;
                tBankaccount.balance += amount;
                System.out.println("Amount transferred successfully");
                return true;
            }
        }

    }


public class Q2 {
    public static void main(String[] args) {
        savings s = new savings("SAV123",5000);
        current c = new current("CUR456",2000 );
        s.deposit(1000);
        c.withdraw(3000);
        System.out.println("savings balance: " +s.balance);
        System.out.println("current balance: " +c.balance);
        s.transfer(c, 1500);
        c.transfer(s, 6000);
    }
}
