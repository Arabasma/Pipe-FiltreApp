 package sample;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static sample.Main.th1;


 public class Controller {
    @FXML
    private TextField nombreun ;
    @FXML
    private TextField nombredeux ;
    @FXML
    private Label resultat ;
 String premierNombre;
 String deuxiemeNombre;
 String resultatAfficher;
 public static sample.Operation oper;
    public  synchronized void CalculeSomme()
    {
        premierNombre=nombreun.getText();
        deuxiemeNombre=nombredeux.getText();

        oper = new Operation(Integer.parseInt(premierNombre),Integer.parseInt(deuxiemeNombre),'s');

        Main.ops.dataIN(oper);
        Integer resul = (Integer) Main.results.dataOUT();
        resultatAfficher = resul.toString() ;
        resultat.setText(resultatAfficher);
        System.out.println(" VOILA"+resul);





    }
    public  synchronized void CalculeProduit()
    {
        premierNombre=nombreun.getText();
        deuxiemeNombre=nombredeux.getText();
        resultat.setText(resultatAfficher);
        oper = new Operation(Integer.parseInt(premierNombre),Integer.parseInt(deuxiemeNombre),'p');

        Main.ops.dataIN(oper);
        Integer resul = (Integer) Main.results.dataOUT();
        resultatAfficher = resul.toString() ;
        resultat.setText(resultatAfficher);
        System.out.println(" VOILA"+resul);
    }
    public synchronized void CalculeFacto()
    {
        premierNombre=nombreun.getText();
        deuxiemeNombre=nombredeux.getText();
        resultat.setText(resultatAfficher);
        oper = new Operation(Integer.parseInt(premierNombre),0,'f');

        Main.ops.dataIN(oper);
        Integer resul = (Integer) Main.results.dataOUT();
        resultatAfficher = resul.toString() ;
        resultat.setText(resultatAfficher);
        System.out.println(" VOILA"+resul);
    }

    public void Quitter()
    {
     Main.supprimerFichier();

    }

    public void Tracer ()
    {
      Main.afficherFichier();
    }
}
