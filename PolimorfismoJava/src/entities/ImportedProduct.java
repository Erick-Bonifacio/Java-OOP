package entities;

public class ImportedProduct extends Product{

    private double customsFee;

    public ImportedProduct() {}

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    public final String priceTag(){
        return name
                + " $ "
                + String.format("%.2f", totalPrice())
                + " (Customs fee: "
                + customsFee
                + " )";
    }

    public Double totalPrice(){
        return price + customsFee;
    }
}
