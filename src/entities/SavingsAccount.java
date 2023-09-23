package entities;

public class SavingsAccount extends Account {

    private Double interestRate;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(Integer number, String holder, Double balance, Double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }

    //o override serve para subescrever metodos herdados para terem comportamentos diferentes na classe que estpa usando o override
    //por exemplo, por padrao o metodo withdraw desconta 5 reais da conta, mas em contas poupança nao deve descontar nada, como quero que esse metodo herdado tenha um comportamento diferenciado eu uso o override logo acima do metodo
    @Override
    public void withdraw(double amount){
        balance -= amount;
    }
}
