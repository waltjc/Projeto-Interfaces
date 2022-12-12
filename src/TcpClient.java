
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class TcpClient {

	public static void main(String[] args) {
		 
		int port = 1451;
		
		try {
			
			Socket socket = new Socket("localhost", port);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String clientName = JOptionPane.showInputDialog("Digite seu nome: ");
			String fuelPrice = JOptionPane.showInputDialog("Digite o valor abastecido:");
			String fuelType = JOptionPane.showInputDialog("Digite o tipo de combustível:");
			String date = JOptionPane.showInputDialog("Digite a data:");
			
			out.println(clientName);
			clientName = in.readLine();
	
			out.println(fuelPrice);
			fuelPrice = in.readLine();
				
			out.println(fuelType);
			fuelType = in.readLine();
				
			out.println(date);
			date = in.readLine();
				
			out.close();
			in.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}