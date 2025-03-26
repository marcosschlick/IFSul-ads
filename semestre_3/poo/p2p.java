import java.io.*;
import java.net.*;

public class p2p {
    private static final int PORT = 12345; // Porta para conexão

    public static void main(String[] args) {
        try {
            // Pergunta se o usuário quer ser o host ou se conectar a um host
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Você quer ser o host (1) ou se conectar a um host (2)?");
            String choice = userInput.readLine();

            Socket socket;
            if (choice.equals("1")) {
                // Host
                ServerSocket serverSocket = new ServerSocket(PORT);
                System.out.println("Aguardando conexão...");
                socket = serverSocket.accept();
                System.out.println("Conectado!");
                serverSocket.close();
            } else {
                // Cliente
                System.out.println("Digite o IP do host:");
                String host = userInput.readLine();
                socket = new Socket(host, PORT);
                System.out.println("Conectado!");
            }

            // Thread para receber mensagens
            new Thread(() -> {
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Amigo: " + message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Enviar mensagens
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String message;
            while (true) {
                message = userInput.readLine();
                out.println(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}