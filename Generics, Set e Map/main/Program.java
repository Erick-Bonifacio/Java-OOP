package main;

import java.util.HashSet;
import java.util.Scanner;

import entities.Student;

public class Program {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        HashSet<Student> hs = new HashSet<>();
        
        System.out.print("How many students for couse A? ");
        int students = sc.nextInt();
        for(int i = 0; i < students; i++){
            int number = sc.nextInt();
            hs.add(new Student(number));
        }

        System.out.print("How many students for couse B? ");
        students = sc.nextInt();
        for(int i = 0; i < students; i++){
            int number = sc.nextInt();
            hs.add(new Student(number));
        }

        System.out.print("How many students for couse C? ");
        students = sc.nextInt();
        for(int i = 0; i < students; i++){
            int number = sc.nextInt();
            hs.add(new Student(number));
        }

        System.out.println("Total students: " + hs.size());
        
        sc.close(); 
    }
}