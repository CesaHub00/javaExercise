import java.time.*;
import java.time.format.DateTimeFormatter;

public class esDate {
    public static void main(String[] args){
        LocalDateTime local = LocalDateTime.now();
        System.out.println(local);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
        String datetime = local.format(format);
        System.out.println(datetime);
    }
}
