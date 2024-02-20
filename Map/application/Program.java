package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file full path: ");
        String path = sc.nextLine();
        HashMap<String, Integer> hs = new HashMap<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){

            String line = bf.readLine();
            while(line != null){
                String[] fields = line.split(",");
                String nome = fields[0];
                int votes = Integer.parseInt(fields[1]);
                int lastVotes = 0;
                if(hs.containsKey(nome)) lastVotes = hs.get(nome);
                hs.put(nome, votes + lastVotes);

                line = bf.readLine();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        for(String key : hs.keySet()){
            System.out.println("Total votes for " + key + ": " + hs.get(key));
        }

        sc.close();
    }
}