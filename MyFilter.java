import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class MyFilter extends Formatter {
    public String[] readFile(File file){
        String lines= "";
        try{
            Scanner sc=new Scanner(file);
            while(sc.hasNextLine()){
                lines +=sc.nextLine();
            }
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        return lines.split(" ");
    }

    public static void main(String[] args) throws IOException {

        final String Directorio="C:\\Users\\wicho\\IdeaProjects\\Contadores";
        /* C:\Users\wicho\IdeaProjects\Contadores*/
        try(DirectoryStream<Path> ds= Files.newDirectoryStream(Paths.get(Directorio))){
            for(Path ruta: ds){
                System.out.println(ruta.getFileName());
                Contadores lectura= new Contadores();
                File file= new File(String.valueOf(ruta.getFileName()));
                String[] lines= lectura.readFile(file);
                int words= lines.length;
                System.out.println("El archivo tiene "+words+" palabras, de las cuales son "+" palabras diferentes.");
            }
        } catch (IOException e) {
            System.err.println("Error: "+e.getMessage());

            FileHandler logFile = new FileHandler("logging.txt");
            SimpleFormatter plainText = new SimpleFormatter();
            logFile.setFormatter(plainText);

        }
    }

    @Override
    public String format(LogRecord record) {
        return null;
    }
}
