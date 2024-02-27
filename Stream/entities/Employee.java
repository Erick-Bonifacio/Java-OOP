package entities;

public class Employee {
    
    private String name;
    private String email;
    private Double salary;

    public Employee(String name, String email, Double salary){
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public Double getSalary(){
        return salary;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public String toString(){
        return "Nome: " + name + " - Email: " + email + " - Salary: " + salary;
    }
}