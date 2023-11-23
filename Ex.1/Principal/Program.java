package Principal;

import entities.Rectangle;
import java.util.Scanner;
import java.util.Locale;

public class Program {
    
    public static void main(String[] args){
        
        Rectangle rectangle = new Rectangle();
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Digite a altura:");
        rectangle.altura = sc.nextDouble();
        System.out.println("Digite a largura ");
        rectangle.largura = sc.nextDouble();

        System.out.printf("\nArea: ");
        System.out.println(rectangle.area());
        System.out.printf("\nPerimetro: ");
        System.out.println(rectangle.perimetro());
        System.out.printf("\nDiagonal: ");
        System.out.println(rectangle.diagonal());

        sc.close();
    }
        
}
