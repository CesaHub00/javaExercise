import java.io.*;
import java.net.*;

public class serverLibreria {
    private static final int PORT = 2222;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){

            System.out.println("Server started on port " + PORT + ". Waiting for clients...");
            Socket clienSocket = serverSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            PrintWriter outToClient = new PrintWriter(clienSocket.getOutputStream(), true);

            String message;
            while((message = inFromClient.readLine()) != null){
                if (message.equals("1")) {
                    System.out.println("Libreria salvata!");
                    outToClient.println("Fatto!");
                }else{
                    break;
                }
            }

            serverSocket.close();
        } catch (BindException e) {
            System.err.println("Error: Port " + PORT + " already in use.");
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            System.out.println("Server shut down.");
        }
    }
}
