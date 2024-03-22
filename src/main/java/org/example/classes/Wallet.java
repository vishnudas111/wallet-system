package org.example.classes;


public class Wallet {
    private int accountNumber;
    private float balance;
    private String name;

    public Wallet(int accountNumber, String name, float balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.name = name;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public float getBalance(){
        return balance;
    }
    public String getName(){
        return name;
    }
    public void setBalance(float balance){
        this.balance = balance;
    }

    public void deposit(float amount){
        if(amount<0.0001){
            System.out.println("Invalid amount");
            return;
        }
        balance+=amount;
    }
    public boolean withdraw(float amount){
        if(balance>=amount){
            balance-=amount;
        }else{
            System.out.println("Invalid amount");
            return false;
        }
        return true;
    }

}
