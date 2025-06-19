import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class esArray {
    public static void main(String[] args) {
        // cercare un numero in un array
        //es1();

        // cercare i dulplicati in un array e metterli a 0
        //es2();

        // invertire l'ordine degli elementi in un array
        //es3();

        // calcolare la somma di due array elemento per elemento
        es4();

    } // end main

    ///////////////////////////////////////////////////////////////////////////////////////////
    public static void es1(){
        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10};

        System.out.println("Numero da cercare:");
        Scanner input = new Scanner(System.in);

        int x;
        if (input.hasNextInt()){
            x = input.nextInt();
            for (int i : arr1){
                if (x == arr1[i]){
                    System.out.println("Trovato il numero " + x + " nella posizione " + i);
                    printArray(arr1);
                    input.close();
                    return;
                }
            }

            System.out.println("Numero non trovato!");
            printArray(arr1);
        } else {
            System.out.println("Rifai!");
        }

        input.close();
    }// end es1

    public static void printArray(int[] arrInt){
        System.out.print("[");
        for (int i = 0; i < arrInt.length; i++){
            System.out.print(arrInt[i]);

            if (i < arrInt.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    } // end printArray
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void es2(){
        int[] arr = new int[] {1, 5, 9, 1, 5, 8, 4, 8, 4, 3};
        System.out.println("Array iniziale: " + Arrays.toString(arr));

        Arrays.sort(arr);
        System.out.println("Array sort: " + Arrays.toString(arr));

        rimuoviDuplicati(arr);
        System.out.println("Array senza duplicati: " + Arrays.toString(arr));

        ArrayList<Integer> arrReversed = new ArrayList<Integer>();
        for (int index = 0; index < arr.length; index++) {
            arrReversed.add(index, arr[index]);
        }
        Collections.sort(arrReversed, Collections.reverseOrder());
        System.out.println("Array sort reversed: " + arrReversed);
    } // end es2

    public static void rimuoviDuplicati(int[] arrayConDuplicati){
        for (int i : arrayConDuplicati) {
            int count = 0;

            for (int j = 0; j < arrayConDuplicati.length; j++) {
                if (i == arrayConDuplicati[j] && count == 0) {
                    count = 1;
                    continue;

                } else if (i == arrayConDuplicati[j] && count != 0){
                    arrayConDuplicati[j] = 0;
                }
            }
        }
    } // end rimuoviDuplicati
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void es3(){
        String[] arrayInit = new String[] {"1.ciao", "2.sono", "3.cesare", "4.e", "5.questo", "6.sarebbe", "7.un", "8.test"};
        System.out.println("Array iniziale: " + Arrays.toString(arrayInit));

        String[] newArray = new String[arrayInit.length];
        int y = 0;
        for(int i = arrayInit.length - 1; i >= 0; i--){
            newArray[y] = arrayInit[i];
            y++;
        }
        System.out.println("Array reversed: " + Arrays.toString(newArray));
    }// end es3
    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void es4(){
        int[] array1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arrayExpected = new int[] {2, 4, 6, 8, 10, 12, 14, 16, 18};
        //int[] arrayFinal = new int[array1.length];
        ArrayList<Integer> arrayFinal = new ArrayList<Integer>();

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (i == j) {
                    //arrayFinal[i] = array1[i] + array2[j];
                    arrayFinal.add(array1[i] + array2[j]);
                }
            }
        }

        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(arrayExpected));
        //System.out.println(Arrays.toString(arrayFinal));
        System.out.println(arrayFinal);

        System.out.println("-------------------------------------------");
        Iterator<Integer> iterated = arrayFinal.iterator();
        System.out.println(iterated.hasNext() ? iterated.next() : "");

        System.out.println("-------------------------------------------");
        if (iterated.hasNext()) System.out.println(iterated.next());

        System.out.println("-------------------------------------------");
        while (iterated.hasNext()) {
            System.out.println(iterated.next());
        }
    }

} // end class esArray
