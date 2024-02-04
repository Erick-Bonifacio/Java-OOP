package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PayPalService;

public class Program {
     
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter contract data:");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();
        System.out.print("Date (DD/MM/YYYY): ");
        String dateString = sc.nextLine();
        //sc.nextLine();
        try{
            date = sdf.parse(dateString);
        }  
        catch(ParseException e){
            System.out.println("Invalid format for date!");
            sc.close();
            return;
        }
        System.out.print("Contract amount: ");
        double amount = sc.nextDouble();
        System.out.print("Installments number: ");
        Integer installments = sc.nextInt(); 

        Contract contract = new Contract(number, date, amount);
        ContractService cs = new ContractService(new PayPalService());
        cs.processContract(contract, installments);

        for(Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

        sc.close();
    }
}