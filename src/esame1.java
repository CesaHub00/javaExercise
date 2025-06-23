//Java gestisce la memora con la jvm.
// è divisa in heap che contiene tutti gli oggetti allocati dinamicamente, ed è dove lavora principalmente il garbage collector; 
//lo stack viene creato per ogni thread e contiene le variabili locali, le chiamate ai metodi, la memoria viene liberata in automatico al fine del metodo.
// In generale il garbage collector individua e libera la memoria occupata da oggetti non più raggiungibili.
// Alcuni tipo sono
// - garbage first
// - serial gb usato per sistemi con poche risorse
// - paraller gb che lavora con thread multipli
// - zgc che è un gb a bassa latenza per applicazioni con molti dati e requisiti real time.

import java.util.*;
public class esame1{
  public static void main(String[] args){
    System.out.println("Scegliere un numero:");
    Scanner input = new Scanner(System.in);
    int n = 0;
    try{
      n = input.nextInt();
      input.nextLine();
    }catch(Exception ex){
      System.out.println("Errore: " + ex.getMessage() + ".  Inserisci un numero.");
    }

    System.out.println("Seglie in quale modo risolvere il problema:");
    System.out.println("1.Risoluzione per ricorsione.");
    System.out.println("2.Risoluzione per iterazione.");

    int scelta = 0;
    try{
      scelta = input.nextInt();
      input.nextLine();
    }catch(Exception ex){
      System.out.println("Inserisci il numero del modo corrispondente.");
    }

    int totale;
    switch (scelta){
      case 1:
        totale = ricorsione(n);
        System.out.println(" Il risultato totale è: "+ totale);
        break;
      case 2:
        totale = iterazione(n);
        System.out.println("Il risultato totale è: " + totale);
        break;
      default:
        System.out.println("Seleziona una fra le proposte");
    }
    input.close();

  }

  private static int ricorsione(int numero){
    if(numero > 1) {
      return numero * ricorsione(numero - 1);
    } else {
      return 1;
    }
  }

  private static int iterazione(int numero){
    int risultato = numero;
    while((numero-1) > 0){
      numero = 1;
      risultato *= numero;
    }
    return risultato;
  }
}



