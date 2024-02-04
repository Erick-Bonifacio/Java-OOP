package service;

public class PayPalService implements OnlinePaymentService {

    private static double FEE_PERCENTAGE = 0.02;
    private static double MONTHLY_INTEREST = 0.01;

    @Override
    public double paymentFee(double amount) {
        return amount * FEE_PERCENTAGE;
    }

    @Override
    public double interest(double amount, Integer months) {
        return amount * MONTHLY_INTEREST * months;
    }
    
}