import java.io.*;
import java.util.*;

public class libreria{

    public static <U> void stampaAVideo(U toPrint){
        System.out.println(toPrint);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        final String NOMEFILE = "Libreria.txt";
        File file = new File(NOMEFILE);

        ArrayList<Libro> libreria = new ArrayList<Libro>();

        if(file.exists()){
            String line;
            String[] campiLibro;
            try{
                BufferedReader fileLibreria = new BufferedReader(new FileReader(file));
                Scanner inFile = new Scanner(fileLibreria);
                while(inFile.hasNextLine()){
                    line = inFile.nextLine().trim();
                    campiLibro = line.split(",");
                    libreria.add(new Libro(campiLibro[0], campiLibro[1], Integer.parseInt(campiLibro[2]), campiLibro[3].equals("in prestito")));
                }
                inFile.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }else{
            stampaAVideo("File non esistente!");
        }

        stampaAVideo("Benvenuto nella libreria!");
        while(true){
            stampaAVideo("-----------------------------------------------------");
            stampaAVideo("Azioni possibili:");
            stampaAVideo("1. Libri disponibili");
            stampaAVideo("2. Prendere in prestito un libro");
            stampaAVideo("3. Restituire un libro");
            stampaAVideo("4. Aggiungere un libro");
            stampaAVideo("5. Rimuovere un libro");
            stampaAVideo("6. Ordina la libreria per titolo");
            stampaAVideo("7. Ordina la libreria per autore");
            stampaAVideo("8. Ordina la libreria per numero di pagine");
            stampaAVideo("0. Salva ed esci");

            int scelta = 0;

            try{

                scelta = in.nextInt();
                in.nextLine();

            }catch(Exception ex){

                stampaAVideo("Inserisci uno numero!");
                in.nextLine();
                continue;
            }

            switch(scelta){
                case 1:
                    stampaAVideo(libreria.toString());
                    break;

                case 2:
                    prendereInPrestito(in, libreria);
                    break;

                case 3:
                    restituireLibro(in, libreria);
                    break;

                case 4:
                    aggiungereLibro(in, libreria);
                    break;

                case 5:
                    rimuovereLibro(in, libreria);
                    break;

                case 6:
                    libreria.sort((libro1, libro2) -> libro1.getNome().compareToIgnoreCase(libro2.getNome()));
                    stampaAVideo(libreria);
                    break;

                case 7:
                    libreria.sort((libro1, libro2) -> libro1.getAutore().compareToIgnoreCase(libro2.getAutore()));
                    stampaAVideo(libreria);
                    break;

                case 8:
                    libreria.sort((libro1, libro2) -> ((Integer) libro1.getPagine()).compareTo((Integer) libro2.getPagine()));
                    stampaAVideo(libreria);
                    break;

                case 0:
                    salvaLibreria(file, libreria);
                    clientLibreria.main(args);
                    stampaAVideo("Alla prossima!");
                    in.close();
                    System.exit(0);

                default:
                    stampaAVideo("Scelta non valida!");
            }
        }
    }

    public static void prendereInPrestito(Scanner in, ArrayList<Libro> libreria){
        stampaAVideo("Inserisci il titolo del libro che vuoi prendere in prestito");
        Iterator<Libro> it = libreria.iterator();
        int i = 0;
        while(it.hasNext()){
            Libro libro = it.next();
            if(!libro.getInPrestito()){
                i += 1;
                stampaAVideo(i + ". " + libro.getNome());
            }
        }

        String titoloLibroScelto = "";
        boolean trovato = false;
        do{
            try{
                titoloLibroScelto = in.nextLine();

                for(Libro libro: libreria){
                    if(libro.getNome().equalsIgnoreCase(titoloLibroScelto)){
                        trovato = true;
                        break;
                    }
                }

                if(!trovato){
                    throw new Exception();
                }

            }catch(Exception ex){

                stampaAVideo("Inserisci il titolo di uno dei libri!");
            }

        }while(!trovato);

        it = libreria.iterator();
        while(it.hasNext()){
            Libro libro = it.next();
            if(libro.getNome().equals(titoloLibroScelto)){
                libro.setInPrestito(true);
                break;
            }
        }

        stampaAVideo("Fatto!");
    }

    public static void restituireLibro(Scanner in, ArrayList<Libro> libreria){
        stampaAVideo("Inserisci il titolo del libro che vuoi restituire");
        Iterator<Libro> it = libreria.iterator();

        int i = 0;
        while(it.hasNext()){
            Libro libro = it.next();
            if(libro.getInPrestito()){
                i += 1;
                stampaAVideo(i + ". " + libro.getNome());
            }
        }

        String titoloLibroScelto = "";
        boolean trovato = false;
        do{
            try{
                titoloLibroScelto = in.nextLine();

                for(Libro libro: libreria){
                    if(libro.getNome().equalsIgnoreCase(titoloLibroScelto)){
                        trovato = true;
                        break;
                    }
                }

                if(!trovato){
                    throw new Exception();
                }

            }catch(Exception ex){

                stampaAVideo("Inserisci il titolo di uno dei libri!");
            }

        }while(!trovato);

        it = libreria.iterator();
        while(it.hasNext()){
            Libro libro = it.next();
            if(libro.getNome().equals(titoloLibroScelto)){
                libro.setInPrestito(false);
                break;
            }
        }

        stampaAVideo("Fatto!");
    }

    public static void aggiungereLibro(Scanner in, ArrayList<Libro> libreria){
        String nome = "", autore = "";
        int pagine = 0;

        stampaAVideo("Inserisci i dati ->");

        stampaAVideo("Titolo:");
        try{
            nome = in.nextLine();
        }catch(Exception ex){
            stampaAVideo("Inserisci il nome del libro!");
        }

        stampaAVideo("Autore:");
        try{
            autore = in.nextLine();
        }catch(Exception ex){
            stampaAVideo("Inserisci l'autore del libro!");
        }

        stampaAVideo("Numero di pagine:");
        try{
            pagine = in.nextInt();
            in.nextLine();
        }catch(Exception ex){
            stampaAVideo("Inserisci il numero di pagine del libro!");
        }


        if(!(nome.isBlank() || nome.isEmpty() || autore.isBlank() || autore.isEmpty() || pagine <= 0)){
            libreria.add(new Libro(nome, autore, pagine, false));

            stampaAVideo("Fatto!");
        } else {
            stampaAVideo("Qualcosa e andato storto!");
            aggiungereLibro(in, libreria);
        }

    }

    public static void rimuovereLibro(Scanner in, ArrayList<Libro> libreria){
        stampaAVideo("Quale libro vuoi rimuovere?");
        Iterator<Libro> it = libreria.iterator();
        int i = 0;
        while(it.hasNext()){
            i++;
            stampaAVideo(i + "." + it.next());
        }

        String titolo = "";
        try{
            titolo = in.nextLine();
        }catch(Exception ex){
            stampaAVideo("Inserisci il titolo del libro che vuoi rimuovere!");
        }

        it = libreria.iterator();
        if(!(titolo.isBlank() || titolo.isEmpty())){
            while(it.hasNext()){
                Libro libro = it.next();
                if(libro.getNome().equalsIgnoreCase(titolo)){
                    it.remove();
                    break;
                }
            }

            stampaAVideo("Fatto!");
        } else {
            stampaAVideo("Qualcosa e andato storto!");
            rimuovereLibro(in, libreria);
        }

    }

    public static void salvaLibreria(File file, ArrayList<Libro> libreria){

        BufferedWriter fileWriter;
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            fileWriter = new BufferedWriter(new FileWriter(file, false));
            for(Libro libro : libreria){
                fileWriter.write(libro.toString());
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Libro{
    private int pagine;
    private String nome;
    private String autore;
    private Boolean inPrestito;

    public Libro(String nome, String autore, int pagine, Boolean inPrestito){
        this.nome = nome;
        this.autore = autore;
        this.pagine = pagine;
        this.inPrestito = inPrestito;
    }

    @Override
    public String toString(){
        return this.nome + "," + this.autore + "," + this.pagine + (inPrestito ? ",in prestito" : ",disponibile") + "\n";
    }

    public int getPagine(){
        return this.pagine;
    }
    public void setPagine(int pagine){
        this.pagine = pagine;
    }

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getAutore(){
        return this.autore;
    }
    public void setAutore(String autore){
        this.autore = autore;
    }

    public Boolean getInPrestito(){
        return this.inPrestito;
    }
    public void setInPrestito(Boolean inPrestito){
        this.inPrestito = inPrestito;
    }
}
