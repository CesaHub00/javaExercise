import java.util.*;
import java.util.stream.*;


public class esStream {
    public static void main(String[] args){
        System.out.println("Inserici dei numeri:");
        System.out.println("Inserisci una lettera per confermare!");

        ArrayList<Integer> array = new ArrayList<Integer>();
        int x = 0;
        boolean y = true;

        Scanner scanner = new Scanner(System.in);

        do{

            try{

                x = scanner.nextInt();

                System.out.println("Hai inserito un numero!");
                array.add(x);

            }catch(Exception error){

                System.out.println("Hai inserito una lettera!");
                y = false;
            }

        }while(y);

        scanner.close();

        List<Integer> list = array.stream()
                                    .filter(n -> n % 2 == 0)
                                    .collect(Collectors.toList());

        System.out.println(list);
    }
}
