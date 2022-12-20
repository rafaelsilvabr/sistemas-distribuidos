import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost"; // specify the server's hostname or IP address here
        int port = 8080; // specify the server's port number here

        Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // prompt the user for the card values
            System.out.print("Enter the value of the card (1-13): ");
            int value = scanner.nextInt();
            System.out.print("Enter the suit of the card (1-4): ");
            int suit = scanner.nextInt();

            // send the card values to the server
            out.println(value);
            out.println(suit);

            // read the name of the card from the server
            String name = in.readLine();
            System.out.println("Card name: " + name);
        }
    }
}
