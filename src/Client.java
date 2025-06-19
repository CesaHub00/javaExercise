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

// public class Client {
//         private static final String SERVER_ADDRESS = "127.0.0.1";
//         private static final int SERVER_PORT = 2222;

//     public static void main(String[] args){

//         try (Socket clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT)){
//             System.out.println("Connected to server " + SERVER_ADDRESS + ": " + SERVER_PORT);

//             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//             Scanner in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));

//             Scanner scan = new Scanner(System.in);
//             String toSend;
//             String message;
//             while (scan.hasNextLine()) {
//                 toSend = scan.nextLine();

//                 out.println(toSend);

//                 while (in.hasNextLine()) {
//                     message = in.nextLine();
//                     if(message.equals("~")){
//                         break;
//                     }
//                     System.out.println(message);
//                 }

//                 if (toSend.equals("stop")){
//                     break;
//                 }
//             }
//             in.close();
//             scan.close();

//             clientSocket.close();
//         } catch (UnknownHostException e) {
//             System.err.println("Error: Unknown host " + SERVER_ADDRESS);
//         } catch (ConnectException e) {
//             System.err.println("Error: Connection refused. Is the server running on " + SERVER_ADDRESS + ":" + SERVER_PORT + "?");
//         } catch (IOException e) {
//             System.err.println("Client error: " + e.getMessage());
//             e.printStackTrace();
//         } finally {
//             System.out.println("Client connection closed.");
//         }
//     }
// }
class Client{
    private static final int porta = 12345;
    private static final String SERVER_ADDRESS = "127.0.0.1";

    public static void main(String[] args) {

        try(Socket clientSocket = new Socket(SERVER_ADDRESS, porta)){

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(clientSocket.getInputStream())));
            Scanner in2 = new Scanner(System.in);

            while(in2.hasNext()){
                out.print(in2.next());

                while(in.hasNext()){
                    System.out.println(in.next());
                }

                if ((in2.nextInt() == 0) || (in2.nextLine().equals("0"))) {
                    break;
                }
            }

            in.close();
            in2.close();
            clientSocket.close();
        }catch(Exception ex){
            System.err.println("Errore: " + ex.getMessage());
        }finally{
            System.out.println("Client connection closed.");
        }
    }
}