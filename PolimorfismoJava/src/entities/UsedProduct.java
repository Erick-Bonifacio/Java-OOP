package entities;

import java.time.LocalDate;
import java.util.Date;

public class UsedProduct extends Product{

    private LocalDate manufactureDate;

    public UsedProduct(){}

    public UsedProduct(String name, double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getDate (){
        return manufactureDate;
    }

    public void setDate(LocalDate date){
        manufactureDate = date;
    }

    @Override
    public final String priceTag(){
        return name
                + " (used) "
                + " $ "
                + String.format("%.2f", price)
                + " (manufactureDate: "
                + manufactureDate
                + " )";
    }
}
