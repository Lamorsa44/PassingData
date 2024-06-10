import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(420)) {
            while (true) {
                System.out.println("Waiting for client");
                try(Socket socket = serverSocket.accept();
                    PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    System.out.println("Client accepted");

                    while (!socket.isClosed()) {
                        String message = bufferedReader.readLine();
                        System.out.println(STR. "Client: \{message}");
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}