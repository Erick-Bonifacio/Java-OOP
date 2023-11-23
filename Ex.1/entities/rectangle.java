package entities;

public class Rectangle {

    public double altura;
    public double largura;

    public double area(){
        return altura * largura;
    }

    public double perimetro(){
        return altura + altura + largura + largura;
    }

    public double diagonal(){
        return math.sqrt(math.pow(altura) + math.pow(largura));
    }
}
