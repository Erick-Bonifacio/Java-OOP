package entities;

import exceptions.SaldoError;

public class Account {

    protected Integer number;
    protected String holder;
    protected Double balance;
    protected Double withdrawLimit;

    public Account(){}

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double value){
        balance += value;
    }

    public void withdraw(Double value) throws SaldoError {
        if(value > getWithdrawLimit()){
            throw new SaldoError("Limite Insuficiente!");
        }
        if(value > getBalance()){
            throw new SaldoError("Saldo Insuficiente!");
        }
        balance -= value;
    }
}
