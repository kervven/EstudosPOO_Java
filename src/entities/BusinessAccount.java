package entities;

public class BusinessAccount extends Account {

    private Double loanLimit;

    public BusinessAccount() {
        super();
    }

    public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    //o Override é usado também quando ja queremos aproveitar a regra da superclasse e incluir mais regras de negocio por cima
    //nesse exemplo, alem do desconto de 5 reais do saque, em contas do tipo desta classe aqui é ainda descontado por cima 2 reais
    //mas para aproveitarmos a regra de negocio original e por cima adiocionar outra regra é necessario usar a palavra super + o nome do metodo e em seguida a sua regra nova

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance -= 2.0;
    }
}
