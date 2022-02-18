import javax.swing.text.html.HTMLEditorKit;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.logging.Logger;

public class ProcesamietoH {

    public static final Logger LOG = Logger.getLogger(HTMLpar.class.getName());

    public static void main(String[] args) {
        if(args.length == 0){
LOG.severe("falta incluir HTML documento");
System.exit(1);
        }
        FileReader fileReader = null;
        try{
            fileReader = new FileReader(args [0]);

        }catch (FileNotFoundException e){
            LOG.severe("no se puede abrir el HTML ");
            System.exit(2);
        }
        HTMLpar p = new HTMLpar();
        HTMLEditorKit.Parser proces = p.getParser();
        try{

        //proces.parse(fileReader, new Etiquetas(), true);
            proces.parse(fileReader, new Proparrafo(), true);


    }catch (IOException e){
        LOG.severe("no es legible");
        System.exit(3);
    }

        }

    }

