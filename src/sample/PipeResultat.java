package sample;
import java.util.LinkedList;
import java.util.Queue;

public class PipeResultat extends Pipe {

    Queue<Integer> _inData = new LinkedList<Integer>();

    public synchronized void dataIN (Object in) {
        _inData.add((Integer) in );
        notify();
        System.out.println("on est ici dans piperesultat");


    }

    public synchronized Integer dataOUT (){

        if(_inData.isEmpty())
            try {
            wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return _inData.poll();

    }
}
