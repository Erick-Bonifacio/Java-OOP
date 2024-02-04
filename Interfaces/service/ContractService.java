package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {
    
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months){
        double amount = contract.getValue() / months;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(contract.getDate());
        for(int i = 1; i <= months; i++){
            double interest = onlinePaymentService.interest(amount, i);
            double totalValue = amount + interest + onlinePaymentService.paymentFee(amount + interest);
            calendar.add(Calendar.MONTH, 1);
            Date newDate = calendar.getTime();
            contract.getInstallments().add(new Installment(newDate, totalValue));
        }
         
    }
}