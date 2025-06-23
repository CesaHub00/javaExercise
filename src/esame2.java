import java.util.*;

public class esame2{
  public static void main(String[] args){
    ArrayList<giornalista> listaGiornalisti = new ArrayList<giornalista>();
    Scanner input = new Scanner(System.in);

    System.out.println("Scelta azione:");
    System.out.println("1.Inserisci nuovo giornalista");
    System.out.println("2.Visualizza");
    int sceltaAzione;
    sceltaAzione = input.nextInt();
    input.nextLine();

    if(sceltaAzione == 1){
      inserimento(input, listaGiornalisti);
    }else if (sceltaAzione == 2){
      visualizza(input, listaGiornalisti);
    }else{
      System.out.println("Inserisci il numero di una delle due scelte");
    }
    input.close();
  }


  public static void visualizza(Scanner input, ArrayList<giornalista> listaGiornalisti){
    System.out.println("Inserisci il numeor della scelta per cui vuoi visualizzare i giornalisti");
    System.out.println("1.Anni di esperienza decrescente");
    System.out.println("2.Numero più alto di articoli pubblicati");
    System.out.println("3.Cognome in ordine alfabetico");

    int scelta = 0;
    try{
      scelta = input.nextInt();
      input.nextLine();
    }catch(Exception ex){
      System.err.println("errore "+ ex.getMessage());
    }

    switch (scelta){
      case 1:
        listaGiornalisti.sort((giornalista1, giornalista2) -> ((Integer) giornalista1.getAnniExp()).compareTo((Integer) giornalista2.getAnniExp())); // sort per gli anni di esperienza
        System.out.println(listaGiornalisti);
        break;
      case 2:
        listaGiornalisti.sort((giornalista1, giornalista2) -> (((Integer) giornalista1.getArtPubb()).compareTo((Integer) giornalista2.getArtPubb()))); // sort per articoli pubblicati
        System.out.println(listaGiornalisti.get(0).getArtPubb());
        break;
      default:
        listaGiornalisti.sort((giornalista1, giornalista2) -> (giornalista1.getCognome()).compareTo(giornalista2.getCognome())); // sort per cognome
        System.out.println(listaGiornalisti);
    }
  }


  public static void inserimento(Scanner input, ArrayList<giornalista> listaGiornalisti){
    String nomeIns;
    String cognomeIns, continua;
    int anniExpIns, artPubbIns;
    System.out.println("Inserisci informazioni del giornalista:");
    while(true){
      try{
        System.out.println(" Inserisci nome:");
        nomeIns = input.nextLine();
        System.out.println("Inserisci cognome");
        cognomeIns = input.nextLine();
        System.out.print("Inserisci anni di esperienza:");
        anniExpIns = input.nextInt();
        input.nextLine();
        System.out.println("Inserisci articoli pubblicati:");
        artPubbIns= input.nextInt();
        input.nextLine();

        listaGiornalisti.add(new giornalista(nomeIns, cognomeIns, anniExpIns, artPubbIns));
        System.out.println("Aggiungere un altro gioralista? (Rispondere con: Si/No)");
        continua = input.nextLine();
      if (continua.equalsIgnoreCase("no")){
        break;
      }
      }catch(Exception ex){
        System.err.println("Errore: " + ex.getMessage() + ". Riprovare.");
      }
    }
  }
}

class giornalista{
  private String nome;
  private String cognome;
  private int anniExp;
  private int artPubb;

  public giornalista(String nome, String cognome, int anniExp, int artPubb){
  this.nome = nome;
  this.cognome = cognome;
  this.anniExp = anniExp;
  this.artPubb = artPubb;
  }

  public int getAnniExp(){
  return this.anniExp;
  }

  public int getArtPubb(){
  return this.artPubb;
  }

  public String getCognome(){
  return this.cognome;
  }

  public String getNome(){
  return this.nome;
  }
}