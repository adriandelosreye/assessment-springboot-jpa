package com.bankmanagement.bankmanagement.service.strategy;

import org.springframework.stereotype.Component;

@Component("aTMWithdrawalStrategy")
public class ATMWithdrawalStrategy implements TransactionStrategy{
    @Override
    public double calculateFee() {
        return 1;
    }

    @Override
    public double calculateBalance(double balance, double amount) {
        double fee = calculateFee();
        double totalCost = amount + fee;
        if (balance < totalCost) {
            throw new RuntimeException("Insufficient balance for this transaction.");
        }
        return balance - totalCost;
    }
}