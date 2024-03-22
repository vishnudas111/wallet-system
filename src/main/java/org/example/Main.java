package org.example;

import org.example.classes.WalletSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WalletSystem walletSystem = new WalletSystem();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("OPTIONS");
            System.out.println("1. Create wallet");
            System.out.println("2. Transfer Amount");
            System.out.println("3. Account Statement");
            System.out.println("4. Overview");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("YOU SELECTED CREATE WALLET");

                    System.out.println("Enter name");
                    String name = scanner.next();
                    System.out.println("Enter amount");
                    float amount = scanner.nextFloat();
                    if (amount<0.0001){
                        System.out.println("Invalid amount");
                    }
                    int acc = walletSystem.getWallets().size()+1;
                    walletSystem.createWallet(acc,name,amount);
                    System.out.println("Account created for user 1" + name + " with account number " + acc);
                    break;
                case 2:
                    System.out.println("YOU SELECTED TRANSFER");
                    System.out.println("ENTER SENDER ACCOUNT NUMBER");
                    int sender = scanner.nextInt();
                    System.out.println("ENTER SENDER ACCOUNT NUMBER");
                    int receiver = scanner.nextInt();
                    System.out.println("ENTER AMOUNT");
                    float amount1 = scanner.nextInt();
                    walletSystem.transfer(sender,receiver,amount1);
                    break;
                case 3:
                    System.out.println("YOU SELECTED ACCOUNT STATEMENT");
                    System.out.println("ENTER ACCOUNT NUMBER");
                    int acc1 = scanner.nextInt();
                    walletSystem.accountStatement(acc1);
                    break;
                case 4:
                    System.out.println("YOU SELECTED OVERVIEW");
                    walletSystem.overView();
                    break;

                case 5:
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
            if (option == 5) {
                break;
            }


        }



    }
}