package program;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter yhe number od products: ");
        Integer n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Product #" + i + "data:");
            System.out.print("Common, used or imported (c/u/i): ");
            char tipo = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            if(tipo == 'c'){
                Product product = new Product(name, price);
                list.add(product);
            }
            if(tipo == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Product product = new UsedProduct(name, price, date);
                list.add(product);
            }
            if(tipo == 'i'){
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product product = new ImportedProduct(name, price, customsFee);
                list.add(product);
            }
        }

        System.out.println();
        System.out.println("Price tags:");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }
    }
}