package javaRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
public class DataCallImpl extends UnicastRemoteObject implements DataCall {

    private HashMap<String, Data> clients = new HashMap<>();

    public DataCallImpl() throws RemoteException {
    }

    @Override
    public Data getClient(String name) throws RemoteException {
        return clients.get(name);
    }

    @Override
    public List<Data> catalog() throws RemoteException {
        return new ArrayList<>(clients.values());
    }

    @Override
    public void addClient(Data client) throws RemoteException {
    	clients.put(client.getClientName(), client);
    }
}
