import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
public class AdditionClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            AdditionService service = (AdditionService) registry.lookup("AdditionService");
            int result = service.add(num1, num2);
            System.out.println("Result of addition: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
