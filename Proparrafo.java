import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class Proparrafo extends HTMLEditorKit.ParserCallback {

    private int contador;
    private boolean enParrafo;



    public Proparrafo(){
        contador =0;
        enParrafo= false;
    }

    @Override
    public void handleText(char[] data, int pos) {
        if ((enParrafo)){
            String texto = new String(data);
            System.out.println(texto);
            System.out.println(texto.length());

        }
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if (t== HTML.Tag.P){
            enParrafo =true;

        }

    }


    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if (t== HTML.Tag.P){
            enParrafo =false;
            contador++;

        }
        if (t== HTML.Tag.BODY){
            System.out.printf("parrafos en el documento: %d%n", contador);

        }



    }

}
