/*
Riassunto

Per la lettura/scrittura di file su disco:
-Testo (.txt, .csv): Usa FileReader/FileWriter (e avvolgili in BufferedReader/BufferedWriter).
-Binario (.jpg, .pdf): Usa FileInputStream/FileOutputStream (e avvolgili in BufferedInputStream/BufferedOutputStream).

Per la comunicazione di rete (Socket):
La comunicazione è a livello di byte stream, ma se scambi testo, devi usare InputStreamReader / OutputStreamWriter per convertire byte in caratteri e viceversa,
e poi avvolgerli con BufferedReader / PrintWriter per facilitare la lettura/scrittura di righe e gestire il flushing.
*/

import java.io.*;
import java.net.*;
import java.util.*;

// public class Server {
//     private static final int PORT = 2222;

//     public static void main(String[] args){
//         try (ServerSocket serverSocket = new ServerSocket(PORT)){
//             System.out.println("Server avviato!");
//             System.out.println("Server started on port " + PORT + ". Waiting for clients...");
//             Socket clientSocket = serverSocket.accept();
//             System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

//             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

//             String message;
//             while ((message = in.readLine().strip()) != null){
//                 System.out.println("Message recieved:" + message);
//                 out.println("Thank you!");
//                 out.println("~");
//                 //out.flush();

//                 if ("stop".equals(message)){
//                     break;
//                 }
//             }

//             serverSocket.close();
//         } catch (BindException e) {
//             System.err.println("Error: Port " + PORT + " already in use.");
//         } catch (IOException e) {
//             System.err.println("Server error: " + e.getMessage());
//             e.printStackTrace();
//         } finally {
//             System.out.println("Server shut down.");
//         }
//     }
// }
class Server{
    private static final int porta = 12345;

    public static void main(String[] args){
        try (ServerSocket serverSocket = new ServerSocket(porta)){
            Socket client = serverSocket.accept();

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(client.getInputStream())));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            while(in.hasNext()){
                System.out.println(in.next());

                if((in.nextLine().equals("0"))||(in.nextInt() == 0)){
                    out.print("addio");
                    break;
                }
            }

            in.close();
            serverSocket.close();
        } catch (Exception ex) {
            System.err.println("Errore: " + ex.getMessage());
        } finally{
            System.out.println("Server connection closed.");
        }
    }
}