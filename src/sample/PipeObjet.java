package sample;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PipeObjet extends Pipe {

    Queue<Operation> _inData = new LinkedList<Operation>();




     public synchronized void dataIN (Object in) {
         _inData.add((Operation)in );
         System.out.println("Element ajouté au pipe objet"+((Operation) in).operationTostring());
         notify();
         System.out.println("système notifié");

     }

     public synchronized Operation dataOUT (){

         if(_inData.isEmpty())
             try {
             wait();
                 System.out.println("système en attente");
             } catch (InterruptedException e) {

                 e.printStackTrace();
             }
             Operation opr = _inData.poll();
         System.out.println("système sortie de attente"+opr.operationTostring()+this.getClass());
         return opr;

     }
}
