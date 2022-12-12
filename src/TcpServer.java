
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	private static Object mensagem;

	public static void main(String[] args) {
		System.out.println("-----------------------");
		System.out.println(":: SERVIDOR INICIADO ::");
		System.out.println("-----------------------");
			
		int port = 1451;
		
		
		try {
			
			ServerSocket socketServer = new ServerSocket(port);
			System.out.println("Ouvindo a porta "+port+"...");
			
			Socket socketClient = socketServer.accept();			
						
			PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			
			//Definindo as variáveis dos dados do cliente
			String clientName;
			String fuelPrice;
			String fuelType;
			String dateFill;
			mensagem = "";
			
			String dir = System.getProperty("user.dir"); //Pegando o diretório do projeto
			File arquivo = new File(dir + "\\src\\registros.txt"); // Criando o arquivo 'registros.text' no caminho especificado
			
			FileWriter fw = new FileWriter(arquivo, true); // Instanciando a classe para escrever no arquivo de texto, parâmetro 'true' sinaliza que o arquivo pode ser re-escrito
			BufferedWriter bw = new BufferedWriter( fw ); // onstrutor recebe como argumento o objeto do tipo FileWriter
			
			do {
				try {
					clientName = in.readLine();
					out.println(clientName);
					bw.newLine();
					bw.write("Nome do cliente: " + clientName.toUpperCase());
					bw.newLine();
					
					fuelPrice = in.readLine();
					out.println(fuelPrice);
					bw.write("Total abastecido: " + "R$" +fuelPrice);
					bw.newLine();
					
					fuelType = in.readLine();
					out.println(fuelType);
					bw.write("Tipo de combustível: " + fuelType.toUpperCase());
					bw.newLine();
					
					dateFill = in.readLine();
					out.println(dateFill);
					bw.write("Data: " + dateFill);
					bw.newLine();
					
				} catch (IOException iOException) {
                    System.err.println(iOException.toString());
                }
            } while (!mensagem.equals(""));
				
			out.close();
			bw.close();
			fw.close();
			in.close();
			socketClient.close();
			socketServer.close();
			
			System.out.println("\n-----------------------");
			System.out.println("\n:: Dados registrados!");
			System.out.println(":: Servidor finalizado.");
			
			
		} catch (IOException e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
}
