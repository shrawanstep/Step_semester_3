public class MessCardWallet {
    private double balance;
    MessCardWallet(double balance){this.balance=balance;}
    void topUp(double amount){if(amount>0)balance+=amount;}
    void deduct(double amount){if(amount<=balance)balance-=amount;else System.out.println("Deduct rejected: insufficient balance");}
    double getBalance(){return balance;}
    public static void main(String[] args){MessCardWallet w=new MessCardWallet(500);w.topUp(200);System.out.println("Balance after top-up: "+w.getBalance());w.deduct(1000);System.out.println("Final balance: "+w.getBalance());}
}
