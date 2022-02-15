
import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.nio.file.DirectoryStream;
        import java.nio.file.Files;
        import java.nio.file.Path;
        import java.nio.file.Paths;
        import java.util.Scanner;
import java.util.logging.*;

public class Contadores {
    static final Logger LOGGER = Logger.getLogger(Contadores.class.getName());

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
        LOGGER.setUseParentHandlers(false);
        System.out.println("Loger name " + LOGGER.getName());

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

            Handler consoleHandler  = new ConsoleHandler();


            consoleHandler.setFormatter(new CvsFormatter());
            consoleHandler.setLevel(Level.FINE);
            LOGGER.addHandler(consoleHandler);
            LOGGER.setLevel(Level.FINE);

            LOGGER.addHandler(new MyHandler());
            try{
                Handler fileHandler = new FileHandler("custom-logger.log", 2000, 5);
                fileHandler.setFilter(new MyFilter());
                LOGGER.addHandler(fileHandler);

                for(int i=0; i<10; i++){
                    LOGGER.log(Level.INFO, "abajo las chivas" + i);

                }LOGGER.log(Level.CONFIG, "configurando")

                }catch (SecurityException e) { LOGGER.severe((e.getMessage()));

            }catch (IOException e){
                LOGGER.severe(e.getMessage());
            }

            //Modifica el programa anterior para agregar manejo de logs en la eliminación de palabras vacías.
            //El programa debe generar un archivo log (bitacora) en el cual se deben mostrar un resumen para cada archivo que se procese.
            //Para cada archivo que se procese se debe registrar en el log (separar con una coma cada valor):
            //Nombre del archivo
            //Número de palabras en el archivo
            //Número de palabras diferentes que no sean palabras vacías
            //La lista de palabras diferentes
        }
    }
}
