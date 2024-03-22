package org.example.classes;

public class Transaction {
    private int from;
    private int to;
    private double amount;
    String date;

    public Transaction(int from, int to, double amount,String date ){
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.date = date;
    }

    public String getTransaction(){
        return "Transaction [from" + from + ", to=" + to + ", amount=" + amount + ",date=" + date + "]";
    }
    public int getFrom(){
        return from;
    }
    public int getTo(){
        return to;
    }
}
