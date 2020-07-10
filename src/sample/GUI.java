package sample;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Filter  {
    PipeObjet ops;
    PipeResultat res;
    String namefile;
    Stage primaryStage;



    public GUI (Stage primaryStage,PipeObjet ops,PipeResultat res,String namefile)
    {
        this.primaryStage = primaryStage;
        this.ops = ops;
        this.res = res;
        this.namefile = namefile;
    }
    @Override
    public void run() {

        execute();
    }
    @Override
    synchronized void execute()
    {
     // ops = new PipeObjet();
      //res = new PipeResultat();
      //namefile = "log.txt";
       /* Integer resu = (Integer) 0;

        ops.dataIN(new Operation(2,3,'s'));
        Filter c = new calcul((PipeObjet) ops,(PipeResultat) res);
        Filter t = new trace((PipeObjet) ops,namefile);
        Filter a = new trace(null, namefile);

        Thread th1 = new Thread( c );
        Thread th2 = new Thread( t );
        Thread th3 = new Thread( a );
        th1.start();*/
       /* try {
            Parent root = FXMLLoader.load(getClass().getResource("fenetre.fxml"));

            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 300, 275));
            primaryStage.show();
        }
        catch ( Exception e)
        {

        }


       /* while (th1.isAlive()) {}
        resu= (Integer) res.dataOUT();
        System.out.println("resultat"+resu);
        th2.start();
        th3.start();*/
    }
}
