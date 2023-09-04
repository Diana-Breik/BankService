package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Erstellt eine Klasse 'BankService', die eine Menge von Konten verwaltet
public class BankService {
  private  List <Account> ourAccounts = new ArrayList<>();

  //Implementiert eine Methode im BankService, um ein Konto zu eröffnen. Man soll dafür nur einen Kunden als Argument übergeben müssen. Es soll die neue Kontonummer zurückgeben
  public String openABankAccount(Client client){
    Account newaccount = new Account();
    ourAccounts.add(newaccount);
    newaccount.setClient(client);
    newaccount.setBankAccountNumber(client.customerNumber() + "1");
    newaccount.setAccountBalance(new BigDecimal("1500"));
    return newaccount.getBankAccountNumber();
  }

  //Implementiert eine Methode im BankService, von einer Kontonummer (als String) einen bestimmten Betrag (als BigDecimal) auf eine andere Kontonummer (als String) zu überweisen.
  public void transferMoney(String sendingAccount, String receivingAccount, String amount){
    boolean x = false, y = false;
    for (Account a : ourAccounts){
      if(sendingAccount.equals(a.getBankAccountNumber())){
        a.withdrawMoneyFromAccount(amount);
        x= true;
      }
      if(a.getBankAccountNumber().equals(receivingAccount)){
        a.addingAnAmountToAccount(amount);
        y= true;
      }
      if(x == true && y == true){
        break;
      }
    }
  }

  @Override
  public String toString() {
    return "BankService{" +
            "ourAccounts=" + ourAccounts +
            '}';
  }
  /*public String generateRandomString() {
    String uuid = UUID.randomUUID().toString();
    // Entfernen Sie die Bindestriche aus der generierten UUID
    return uuid.replaceAll("-", "");
  }*/


}
