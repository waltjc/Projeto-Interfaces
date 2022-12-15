package javaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface DataCall extends Remote {
    public Data getClient(String name) throws RemoteException;
    public List<Data> catalog() throws RemoteException;
    public void addClient(Data client) throws RemoteException;

}
