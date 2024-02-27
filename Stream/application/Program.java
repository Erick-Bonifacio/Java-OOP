package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {
    
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.print("Enter full path: ");
        String path = sc.nextLine();
        System.out.print("Enter salary: ");
        Double baseSalary = sc.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line != null){

                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));

                line = br.readLine();
            }

            List<String> selectEmployees = list.stream().filter(x -> x.getSalary() > baseSalary).map(x -> x.getEmail()).sorted().collect(Collectors.toList());
            selectEmployees.forEach(System.out::println);

            Double sum = list.stream().filter(emp -> emp.getName().charAt(0) == 'M').map(emp -> emp.getSalary()).reduce(0.0, (x,y) -> x + y);
            System.out.println("Sum of salary of people whose name starts whit 'M': " + sum);

        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}