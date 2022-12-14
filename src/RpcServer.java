import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class RpcServer {
	public static void main(String[] args) throws XmlRpcException, IOException {
		int port = 4500;
		
		WebServer webServer = new WebServer(port);
		XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
		
		PropertyHandlerMapping phm = new PropertyHandlerMapping();
		phm.addHandler("XmlRpcService", RpcService.class);
		
		xmlRpcServer.setHandlerMapping(phm);
		XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
		
		serverConfig.setEnabledForExceptions(true);
		serverConfig.setContentLengthOptional(false);
		webServer.start();
		
		System.out.println("-------------------------------");
		System.out.println("Servidor iniciado no endereço 127.0.0.1:" + port);
		System.out.println("Para encerrar, pressione CTRL+C...");
		
		RpcService service = new RpcService();
		
		int entrada = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção: \n1. Cadastrar dados \t2.Consultar dados"));
		switch(entrada) {
			case 1:
					
				service.setName();
				service.setFuelPrice();
				service.setFuelType();
				service.setDate();
				break;
				
			case 2:
				String getName = JOptionPane.showInputDialog("Digite o nome do cliente: ");
				service.getClietName(getName);
		}
	}
}