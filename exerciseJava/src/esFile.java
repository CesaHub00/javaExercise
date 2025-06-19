import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class esFile {

    public static void main (String[] args){
        final String FILENAME = "textFile.txt";
        File file = new File(FILENAME);
        try{
            //BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, false));
            BufferedWriter fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            //Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILENAME)));
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(FILENAME), StandardCharsets.UTF_8)));

            if(file.exists()){
                if (file.canRead() && file.canWrite()){
                    fileWriter.write("I wrote something!");
                    fileWriter.newLine();
                    fileWriter.write(file.getAbsolutePath());
                    fileWriter.newLine();
                    fileWriter.write(file.getCanonicalPath());
                    fileWriter.newLine();
                    fileWriter.write(file.getPath());
                    fileWriter.newLine();
                    fileWriter.write(file.getName());
                    fileWriter.newLine();
                } else {
                    file.canRead();
                    file.canWrite();
                }
            } else {
                file.createNewFile();
                fileWriter.write(file.getAbsolutePath());
                fileWriter.write(file.getCanonicalPath());
                fileWriter.write(file.getPath());
            }
            fileWriter.close();

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e){

            System.out.println("Something went wrong:" + e);
        }// end first try

        final String DIRECTORYNAME = "C:\\Users\\cesar\\Desktop\\Other_files\\TestJava\\src\\testDirectory";
        try{
            File dir = new File(DIRECTORYNAME);
            File dir2 = new File(dir, FILENAME);

            if (dir.exists() && dir.isDirectory()) {
                File[] dirs = dir.listFiles();

                if (dirs != null && dirs.length > 0) {

                    for (File f : dirs) {
                        System.out.println(f.getName());
                        if (f.getName().equals(file.getName())) {
                            System.out.println("Trovato!");
                        } else {
                            dir2.createNewFile();
                        }
                    }
                } else {
                    dir2.createNewFile();
                }

            } else {
                dir.mkdir();
                System.out.println("Directory creata");
            }// end first try

        } catch (Exception e){

            System.out.println("Something went wrong:" + e);
        }
    }
}// end esFile
