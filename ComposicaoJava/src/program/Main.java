package program;

import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(sc.next());

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String status = sc.next();

        Order order = new Order(new Date(), OrderStatus.valueOf(status));

        System.out.print("How many items to this order? ");
        int items = sc.nextInt();

        for(int i = 0; i < items; i++){
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            order.addItem(new OrderItem(productQuantity, productPrice, new Product(productName, productPrice)));
        }

        sc.close();
    }
}