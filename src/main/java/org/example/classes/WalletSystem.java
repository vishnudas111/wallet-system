package org.example.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletSystem {

    HashMap<Integer, Wallet> wallets;
    ArrayList<Transaction> transactions;
    public WalletSystem(){
        this.wallets = new HashMap<>();
        this.transactions = new ArrayList<>();
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }
    public HashMap<Integer,Wallet> getWallets(){
        return wallets;
    }

    public void createWallet(int accountNumber, String name, float amount){

        Wallet wallet = new Wallet(accountNumber,name,amount);
        wallets.put(accountNumber,wallet);
    }

    public void transfer(int from, int to,float amount){

        Wallet sender  = wallets.get(from);
        Wallet receiver  = wallets.get(to);
        if(amount<0.0001){
            System.out.println("Invalid amount");
            return;
        }
        if(sender!=null && receiver!=null){
            if(sender.withdraw(amount)){
                receiver.deposit(amount);
                System.out.println("Transaction Succesful");
            }else{
                System.out.println("Insufficient balance for transaction");
            }
        }else{
            System.out.println("Invalid Account Number");
        }
    }

    public boolean withdraw(int acc, float amount){
        Wallet wallet = wallets.get(acc);
        wallet.withdraw(amount);
        return true;
    }
    public void accountStatement(int accountNumber){
        System.out.println("YOU SELECTED ACCOUNT STATEMENT");
        Wallet wallet = wallets.get(accountNumber);
        if(wallet!=null){
            System.out.println("Summary for account number: " + accountNumber);
            System.out.println("Current balance:" + wallet.getBalance());
            System.out.println("Your Transaction History");
            for(Transaction transaction : transactions){
                if(transaction.getFrom()==accountNumber){
                    System.out.println(transaction.getTransaction());
                }
            }
        }
    }

    public void overView(){
        for(HashMap.Entry<Integer,Wallet> entry : wallets.entrySet()){
            System.out.println("Balance for the account number" + " " + entry.getValue().getAccountNumber() + " : " + entry.getValue().getBalance());
        }
    }
}
