import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Card {
    public String getName() {
        String valueName;
        switch (value) {
            case 1:
                valueName = "Ace";
                break;
            case 11:
                valueName = "Jack";
                break;
            case 12:
                valueName = "Queen";
                break;
            case 13:
                valueName = "King";
                break;
            default:
                valueName = String.valueOf(value);
                break;
        }

        String suitName;
        switch (suit) {
            case 1:
                suitName = "Diamonds";
                break;
            case 2:
                suitName = "Clubs";
                break;
            case 3:
                suitName = "Hearts";
                break;
            case 4:
                suitName = "Spades";
                break;
            default:
                suitName = "Invalid suit";
                break;
        }

        return valueName + " of " + suitName;
    }
}


public class Server {
    public static void main(String[] args) throws Exception {
        int port = 8080; // specify the port number here
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for a client to connect...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // read the card values from the client
            int value = Integer.parseInt(in.readLine());
            int suit = Integer.parseInt(in.readLine());

            // create the card object
            Card card = new Card(value, suit);

            // print the name of the card
            card.printName();

            // send the name of the card back to the client
            out.println(card.getName());

            clientSocket.close();
        }
    }
}
