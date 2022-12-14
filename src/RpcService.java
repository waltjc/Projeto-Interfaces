import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class RpcService{
		
	public synchronized void setName() throws IOException {
		BufferedWriter putName = new BufferedWriter(new FileWriter("registros.txt", true));
		
		String clientName = JOptionPane.showInputDialog("Digite seu nome: ");
		
		putName.write("\n" + "Cliente: " + clientName + "\n");
		putName.close();
	}
	
	public void setFuelPrice() throws IOException {
		BufferedWriter putFuelPrice = new BufferedWriter(new FileWriter("registros.txt", true));
		
		String fuelPrice = JOptionPane.showInputDialog("Digite o valor: ");
		
		putFuelPrice.write("Valor: " + fuelPrice + "\n");
		putFuelPrice.close();
	}
	
	public synchronized void setFuelType() throws IOException {
		BufferedWriter putFuelType = new BufferedWriter(new FileWriter("registros.txt", true));
		
		String fuelType = JOptionPane.showInputDialog("Digite o tipo de combustivel: ");
		
		putFuelType.write("Combustivel: " + fuelType + "\n");
		putFuelType.close();
	}
	
	public synchronized void setDate() throws IOException {
		BufferedWriter putDate = new BufferedWriter(new FileWriter("registros.txt", true));
		
		String date = JOptionPane.showInputDialog("Digite a data atual: ");
		
		putDate.write("Data: " + date + "\n");
		putDate.close();
	}
	
	public synchronized void getClietName(String clientName) throws IOException {
			@SuppressWarnings("resource")
			String texto = new Scanner(new File("registros.txt"), "UTF-8").useDelimiter("\\A").next();
			
			try {
				if(texto.contains(clientName)){
					JOptionPane.showMessageDialog(null, "Dados do cliente: " + "\n" + texto.substring(5));
				} else {
					JOptionPane.showMessageDialog(null, "Nada encontrado");
				}
			} catch(Exception e){
				System.out.println("Erro");
			}
	}
}