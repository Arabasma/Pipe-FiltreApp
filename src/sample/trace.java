package sample;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class trace extends  Filter{
    PipeObjet _dataINPipe;
    PipeFichier _dataOUTPipe;

    public trace(PipeObjet _dataINPipe, PipeFichier _dataOUTPipe) {
        super();
        this._dataINPipe = _dataINPipe;
        this._dataOUTPipe = _dataOUTPipe;
    }

    public Operation getData()

    {
        return _dataINPipe.dataOUT();
    }
    public void sendData( String resultat)
    {
        _dataOUTPipe.dataIN(resultat);

    }

    @Override
    public void run() {

            execute();
    }
    @Override
    synchronized void execute()
    {


        while (true) {

                Operation op = this.getData();
                String trc = op.operationTostring();
                System.out.println("voila ce qu'on écrit dans le fichier ;"+trc);
                this.sendData(trc);



        }

    }
}
