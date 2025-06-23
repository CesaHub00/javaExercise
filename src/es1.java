import java.util.*;
import java.io.*;
import java.net.*;

public class es1 {

    public static <T> void printa(T toPrint){
        System.out.print(toPrint);
    }

    private static HashMap<Integer, elfo> map = new HashMap<Integer, elfo>();
    private static Scanner scan = new Scanner(System.in);

    private static String name, surname;
    private static Integer age;

    private static int i = 0;
    public static void main(String[] args){

        while(scan.hasNextLine() && !(scan.nextLine().equals("stop"))){
            i++;
            printa("Name:");
            name = scan.nextLine();
            scan.nextLine();

            printa("Surname:");
            surname = scan.nextLine();
            scan.nextLine();

            printa("Age:");
            age = scan.nextInt();
            scan.nextLine();

            map.put(i, new elfo(name, surname, age));
        }

        printa(map.toString());
        scan.close();
    }
}

abstract class essereVivente{

    abstract void respira(String qualcosa);
}

class umano extends essereVivente{

    private String name;
    private String surname;
    private Integer age;

    public umano(String name, String surname, Integer age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public String getSurname(){
        return surname;
    }

    public void setAge(Integer age){
        this.age = age;
    }
    public Integer getAge(){
        return age;
    }

    public void salta() {
        System.out.print("Salta 1 metro");
    }

    public <T> void scrive(T scrive) {
        System.out.print("Scrive: " + scrive);
    }
    public <T, T2> void scrive(T scrive, T2 scrive2) {
        System.out.print("Scrive: " + scrive + " e " + scrive2);
    }

    public <T> void legge(T legge){
        System.out.print("Legge: " + legge);
    }
    public <T, T2> void legge(T legge, T2 legge2) {
        System.out.print("Legge: " + legge + " e " + legge2);
    }

    public <T> void dice(T dice){
        System.out.print("Dice: " + dice);
    }
    public <T, T2> void dice(T dice, T2 dice2) {
        System.out.print("Dice: " + dice + " e " + dice2);
    }

    @Override
    void respira(String qualcosa) {
        System.out.print("Respira " + qualcosa + "!");
    }
}

class nano extends umano{
    public nano(String name, String surname, Integer age){
        super(name, surname, age);
    }

    @Override
    public void salta() {
        System.out.print("Salta 50 centimetri");
    }
}

class elfo extends umano {

    public elfo(String name, String surname, Integer age){
        super(name, surname, age);
    }

    @Override
    public void salta() {
        System.out.print("Salta 2 metri");
    }
}

class client{
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

class server{
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
