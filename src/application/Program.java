package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

import java.lang.reflect.AccessFlag;

public class Program {

    public static void main(String[] args) {

        Account acc = new Account(1001, "João", 0.0);

        BusinessAccount bacc = new BusinessAccount(1002, "Jayne", 0.0, 500.0);

        //UPCASTING é pegarmos um objeto do tipo da subclasse e atribuí-lo a uma variável do tipo da superclasse
        //conseguimos converter tranquilamente, pois, toda subclasse é uma superclasse indiretamente

        Account acc1 = bacc;

        Account acc2 = new BusinessAccount(1003, "Jean", 100.0, 800.0);

        Account acc3 = new SavingsAccount(1004, "Yasmin", 150.0, 0.05);

        //DOWNCASTING é pegarmos um objeto do tipo da superclassse e atribuí-lo a uma variavel do tipo da subclasse
        //aqui já não é tão simples converter, pois o sistema não sabe se essa conversão é segura, pois o tipo da variavel a qual está sendo usada como atribuição é do tipo da superclasse
        //lembrando que, mesmo que a acc2 é uma intancia da subclasse, ela é do tipo da superclasse
        //pra fazer a conversão é necessario faze-la manual

        // -> exemplo do erro -> BusinessAccount acc4 = acc2;

        BusinessAccount acc4 = (BusinessAccount)acc2;

        //aqui temos um problema, apesar da ide nao mostrar erro nesse codigo, ele ainda é incorreto
        //pois, apesar da variavel acc3 ser do tipo Account, ela é instanciada como SavingsAccount, o que contradiz o downcasting do codigo
        //o erro será mostrado em tempo de execução, ou seja, quando compilar o codigo

        // -> exemplo do erro -> BusinessAccount acc5 = (BusinessAccount)acc3;

        //para evitar esse tipo de erro é necessario fazer um teste comparados os tipos dos downcastings

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount acc5 = (BusinessAccount)acc3;
            acc5.loan(200.0);
            System.out.println("Empréstimo!");
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount acc5 = (SavingsAccount)acc3;
            acc5.updateBalance();
            System.out.println("Atualizar");
        }
    }
}
