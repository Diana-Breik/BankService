package org.example;

import java.math.BigDecimal;
import java.util.Objects;

//Erstellt eine Klasse 'Account' (kein Record, soll vorerst veränderlich sein) mit den Eigenschaften Kontonummer (String), Kontostand (BigDecimal) und dem zugehörigen Kunden.
public class Account {
    private  String bankAccountNumber;
    private BigDecimal accountBalance = new BigDecimal("0");
    private Client client;


    //Implementiert eine Methode, um Geld auf das Konto einzuzahlen.
    public void addingAnAmountToAccount(String amount){
        BigDecimal extraamount = new BigDecimal(amount);
        BigDecimal result =  accountBalance.add(extraamount);
        accountBalance =result;
    }

    //Implementiert eine Methode, um Geld vom Konto abzuheben.
    public void withdrawMoneyFromAccount(String amount){
        BigDecimal amountToBeWithdrawn = new BigDecimal(amount);
        BigDecimal result =  accountBalance.subtract(amountToBeWithdrawn);
        accountBalance =result;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "bankAccountNumber='" + bankAccountNumber + '\'' +
                ", currentAmount=" + accountBalance +
                ", client=" + client +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(bankAccountNumber, account.bankAccountNumber) && Objects.equals(accountBalance, account.accountBalance) && Objects.equals(client, account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNumber, accountBalance, client);
    }
}
