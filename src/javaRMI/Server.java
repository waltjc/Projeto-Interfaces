package javaRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

    private static final int PORT = 1099;

    public static void main(String[] args) throws Exception {
        DataCall dataCall = new DataCallImpl();

        // Cria o registro e vincula à porta (PORT)
        Registry registry = null;
        try {
            registry = LocateRegistry.createRegistry(PORT);
            registry.rebind("cliente", dataCall);
        } catch (Exception e) {
            System.out.println("Servidor: não foi possível iniciar o servidor!");
            System.exit(0);
        }

        // Obtendo o endereço do servidor
        String address = null;
        try {
            address = System.getProperty("java.rmi.server.hostname");
            // O endereço é nulo? em caso sim, é 127.0.0.1 (localhost), caso contrário, ainda é o endereço
            address = address == null ? "127.0.0.1" : address;
        } catch (Exception e) {
            System.out.println("Não é possível obter o endereço inet.");
            System.exit(0);
        }

        String myID = new String(address + ":" + "cliente");
        System.out.println(myID);
    }
}
