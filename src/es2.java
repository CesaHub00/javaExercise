import java.util.*;

public class es2 {
    private static HashMap<Integer, elfo> map = new HashMap<Integer, elfo>();
    private static Scanner scan = new Scanner(System.in);

    private static String name, surname;
    private static Integer age;

    private static int i = 0;
    public static void main(String[] args){

        printa.printae("Add a new element in hashmap:\n");

        while(true){
            printa.printae("Name:");
            String nameInput = scan.nextLine();
            if (nameInput.equalsIgnoreCase("stop")) {
                break;
            }
            name = nameInput;

            printa.printae("Surname:");
            surname = scan.nextLine();

            printa.printae("Age:");
            age = scan.nextInt();
            scan.nextLine();

            i++;
            map.put(i, new elfo(name, surname, age));
        }

        printa.printae(map.toString());
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

class elfo extends umano {

    public elfo(String name, String surname, Integer age){
        super(name, surname, age);
    }

    @Override
    public void salta() {
        printa.printae("Salta 2 metri");
    }
}

class printa{

    public static <T> void printae(T toPrint){
        System.out.println(toPrint);
    }
}
