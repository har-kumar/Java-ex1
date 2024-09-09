import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
public class AdditionServiceImpl extends UnicastRemoteObject implements AdditionService {
    protected AdditionServiceImpl() throws RemoteException {
        super();
    }
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    public static void main(String[] args) {
        try {
            AdditionService service = new AdditionServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("AdditionService", service);
            System.out.println("AdditionService is running and bound to RMI registry.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
