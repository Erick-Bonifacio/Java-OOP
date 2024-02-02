package entities;

public class Rectangle {

    public double altura;
    public double largura;

    public Rectangle(){}

    public double area(){
        return altura * largura;
    }

    public double perimetro(){
        return altura + altura + largura + largura;
    }

    public double diagonal(){
        return Math.sqrt((Math.pow(altura, 2) + Math.pow(largura, 2)));
    }
}
