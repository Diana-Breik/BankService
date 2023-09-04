package org.example;

public class Main {
    public static void main(String[] args) {
        Account a = new Account();
        a.addingAnAmountToAccount("234");
        a.addingAnAmountToAccount("500");
        a.withdrawMoneyFromAccount("100");

        System.out.println("------------------");
        Client client1 = new Client("Diana","Breik","3333");
        BankService service = new BankService();
        // die Kontonummer ausgeben
        System.out.println( "Die neue Kontonummer ist: " + service.openABankAccount(client1));//33331
        System.out.println("Die neue Kontonummer für diesen Kunden ist: " + service.openABankAccount(new Client("Jan","Müller","4444")));//44441
        System.out.println(service);

        System.out.println("----------Überweisung----------");
        // Der Betrag auf dem Konto des Absenders soll sinken und der Betrag auf dem Konto des Empfängers soll steigen
        service.transferMoney("33331","44441","250");
        System.out.println(service);
    }
}