import java.util.HashSet;

public class esHashSet {
    public static void main(String[] args){
        HashSet<Integer> hashset1 = new HashSet<>();
        HashSet<Integer> hashset2 = new HashSet<>();
        HashSet<Integer> hashset3 = new HashSet<>();

        hashset1.add(1);
        hashset1.add(2);
        hashset1.add(3);
        hashset1.add(4);
        hashset1.add(5);

        hashset2.add(6);
        hashset2.add(7);
        hashset2.add(8);
        hashset2.add(9);
        hashset2.add(10);

        hashset3.addAll(hashset1);
        hashset3.addAll(hashset2);

        for (Integer integer : hashset3) {
            System.out.println(integer);
        }
    }
}
