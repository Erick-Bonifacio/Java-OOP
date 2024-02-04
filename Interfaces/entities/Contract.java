package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
    
    private Integer serialNumber;
    private Date date;
    private double value;

    private List<Installment> installments = new ArrayList<>();

    public Contract(Integer serialNumber, Date date, double value){
        this.serialNumber = serialNumber;
        this.date = date;
        this.value = value;
    }

    public Integer getSerialNumber(){
        return serialNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public List<Installment> getInstallments() {
		return installments;
	}
}