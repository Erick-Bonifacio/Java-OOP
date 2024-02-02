package aplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Produto;

public class Program{
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String path = "C:\\Users\\erick\\OneDrive\\Área de Trabalho\\JavaUdemy\\Projetos\\Java-OOP\\Arquivos\\in.csv";
        File sourceFile = new File(path);
        List<Produto> list = new ArrayList<>();

		String sourceFolderStr = sourceFile.getParent(); // pega o caminho, sem o nome do arquivo
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir(); //cria uma subpasta out
        if(success == false) System.out.println("Erro");
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

        //try with resources block
        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Produto(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Produto item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.getTotalValue()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}