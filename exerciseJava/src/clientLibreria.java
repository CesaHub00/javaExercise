import java.io.*;
import java.net.*;
import java.util.*;

public class clientLibreria {

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 2222;
    public static void main(String[] args){
        try(Socket clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT)){

            System.out.println("Connected to server address" + SERVER_ADDRESS + " and port " + SERVER_PORT);
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner inFromServer = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));

            String toSend = "1";

            outToServer.println(toSend);
            while (inFromServer.hasNext()) {
                System.out.println(inFromServer.nextLine());
                break;
            }
            outToServer.println("0");

            inFromServer.close();
            clientSocket.close();
        }catch (UnknownHostException e) {
            System.err.println("Error: Unknown host " + SERVER_ADDRESS);
        }catch (ConnectException e){
            System.err.println("Error: Connection refused. Is the server running on " + SERVER_ADDRESS + ":" + SERVER_PORT + "?");
        }catch (IOException e){
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }finally{
            System.out.println("Client connection closed.");
        }
    }
}
