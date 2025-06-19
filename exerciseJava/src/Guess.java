import java.util.Scanner;

public class Guess {
    public static void main(String[] args){
        System.out.println("Indovina il numero!");

        int y = (int)(Math.random()*101);
        System.out.println("Inserisci un numero: ");

        Scanner scan = new Scanner(System.in);
        int x;
        do{
            x = scan.nextInt();
            x = guess(y,x);
        }while (y != x);

        scan.close();
    }

    public static int guess(int y, int x){
        if (y < x){
            System.out.println("Valore alto!");

        }else if (y > x){
            System.out.println("Valore basso!");

        } else {
            System.out.println("Corretto!");
        }

        return x;
    }
}
