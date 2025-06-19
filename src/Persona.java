import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Persona<T>{
    private T name;
    private T surname;

    public Persona(T name, T surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }

    public T getName(){
        return name;
    }
    public void setName(T name){
        this.name = name;
    }

    public T getSurname(){
        return surname;
    }
    public void setSurname(T surname){
        this.surname = surname;
    }

    public void saluta(){
        System.out.println(this + " sta salutando!");
    }
    public void salta(){
        System.out.println(this + " salta 2 metri!");
    }

}

class Nano<T> extends Persona<T> {

    public Nano(T name, T surname){

        super(name, surname);
    }

    @Override
    public void salta(){
        super.salta();
        System.out.println("Salta 50cm!");
    }
}

class Elfo implements Comparable<Elfo>{
    private String name = "Luca";
    private String surname = "Mario";
    private int age = 1030;

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public int getAge(){
        return age;
    }

    @Override
    public int compareTo(Elfo obj){
        Elfo other = (Elfo) obj;

        return Integer.compare(age, other.getAge());
    }
}

// class sortElfo implements Comparator<Elfo>{

//     @Override
//     public int compare(Elfo o1, Elfo o2) {
//         Elfo primo = (Elfo) o1;
//         Elfo secondo = (Elfo) o2;

//         // if (primo.getAge() > secondo.getAge()) return -1;
//         // if (primo.getAge() < secondo.getAge()) return 1;
//         // return 0;

//         //return Integer.compare(primo.getAge(), secondo.getAge());
//         return ((Integer) primo.getAge()).compareTo((Integer) secondo.getAge());
//     }
// }

class sortNani implements Comparator<Nano<?>>{
    @Override
    public int compare(Nano<?> obj1, Nano<?> obj2){

        Nano<?> a = (Nano<?>) obj1;
        Nano<?> b = (Nano<?>) obj2;
        return ((String) a.getName()).compareTo((String) b.getName());
    }

}

class Main{

    public static <U> void printa(U toPrint){
        System.out.println(toPrint);
    }

    public static void main(String[] args){

        Persona<String> persona = new Persona<String>("x", "y");
        Nano<String> nano = new Nano<String>("Cesare", "Nava");
        Nano<String> nano1 = new Nano<String>("Pinco", "Pallino");

        printa(persona.getName());
        printa(persona.getSurname());
        persona.saluta();
        persona.salta();
        printa("=================");
        printa(nano.getName());
        printa(nano.getSurname());
        nano.saluta();
        nano.salta();
        printa("=================");
        printa(nano1.getName());
        printa(nano1.getSurname());
        nano1.saluta();
        nano1.salta();

        Elfo elfo = new Elfo();
        printa("=================");
        printa(elfo.getName());
        printa(elfo.getSurname());
        printa(elfo.getAge());

        Elfo elfo1 = new Elfo();
        ((Integer) elfo.getAge()).compareTo((Integer) elfo1.getAge());

        printa("=================");
        Persona<String> cesare = new Nano<>("Cesare", "nava");
        cesare.salta();
        cesare.saluta();

        Nano<String> cesare2 = (Nano<String>) cesare;
        cesare.salta();
        cesare.saluta();

        printa("=================");
        ArrayList<Nano<?>> lista = new ArrayList<Nano<?>>();
        for (int i = 0; i < 5; i++){
            lista.add(new Nano<String>("Nanico", Integer.toString(i)));
        }
        lista.add(nano);
        lista.add(nano1);
        lista.add(cesare2);
        printa(lista);

        printa("=================");
        Comparator<Nano<?>> sortNani = new sortNani();
        Collections.sort(lista, sortNani);
        printa(lista);

    }
}
