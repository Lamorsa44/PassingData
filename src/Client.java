import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 420);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Write all you want to be displayed in the server");
            String message;

            while (true) {
                message = scanner.nextLine();
                out.println(message);
            }

        }
        catch (Exception e) {
            System.out.println("Oops something wend wrong");
        }
    }
}