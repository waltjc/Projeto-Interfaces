package javaRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Client {

    private static final int PORT = 1099;

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1"; // host padrão

        try {
            Registry registry = LocateRegistry.getRegistry(host, PORT);
            DataCall dataCall = (DataCall) registry.lookup("cliente");
            
            String getName = JOptionPane.showInputDialog("Digite o nome do cliente: ");
            String getFuelPrice = JOptionPane.showInputDialog("Digite o valor: ");
            String getFuelType = JOptionPane.showInputDialog("Digite o tipo do combustível: ");
            String getDate = JOptionPane.showInputDialog("Digite a data: ");
            
            Data newClient = new Data(getName, getFuelPrice, getFuelType, getDate);
            System.out.println("Registrando os dados");
            dataCall.addClient(newClient);
            
            String getClientName = JOptionPane.showInputDialog("Digite o nome do cliente: ");
            System.out.println("Recuperando os dados...");
            System.out.println(dataCall.getClient(getClientName));
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
