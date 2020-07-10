package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.PipeObjet;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

public class Main extends Application {
    public  static  PipeObjet ops ; //contient les objets : opérandes+ opération que l'utilisateur a entré
    public  static  PipeObjet res;
    public  static  PipeResultat results;
    public static PipeFichier fich;
    public  static  String namefile = "log.txt";
    public  static Thread th1;
    public  static Thread th2;
      static Stage st;

    public static void supprimerFichier()
    {
        File file = new File(namefile);
        file.delete();
        st.close();

    }

    public static void afficherFichier()
    {
          try{
                File file = new File(namefile);
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }

    }
    @Override
    public synchronized void start(Stage primaryStage) throws Exception{
        ops = new PipeObjet();
        res = new PipeObjet();
        results = new PipeResultat();
        fich = new PipeFichier(namefile);
        Filter calculer = new calcul(ops,res,results);
        Filter  sauvegarder = new trace(res,fich);
        th1 = new Thread(calculer);
        th2 = new Thread(sauvegarder);
        Parent root = FXMLLoader.load(getClass().getResource("fenetre.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        st = primaryStage;


            th1.start();

            System.out.println("On a lancé premier thread");
           th2.start();
            System.out.println("On a lancé le deuxième thread");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
