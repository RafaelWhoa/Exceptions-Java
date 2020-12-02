package app;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

/**
  * 
  * Fazer um programa para ler os dados de uma conta bancária e depois realizar um
  * saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
  * ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
  * saque da conta.
  * 
  **/
public class App 
{
    public static void main( String[] args )
    {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account acc = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
        }
        catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }

        sc.close();
    }
}
