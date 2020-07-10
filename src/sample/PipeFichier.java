package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PipeFichier {
    BufferedWriter bufferedWriter = null;
    FileWriter fileWriter = null;
    String filename ;

    public PipeFichier (String filename)
    {
       this.filename = filename;
        /*try {
            fileWriter = new FileWriter(filename);
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }*/
    }

    public String getFilename()
    {
        return this.filename;
    }

    public synchronized void dataIN (Object in) {
       try {
           fileWriter = new FileWriter(filename,true);
           bufferedWriter = new BufferedWriter(fileWriter);
           bufferedWriter.write((String) in);
           bufferedWriter.write("\r\n");
           System.out.println("on a écrit dans le fihier : "+in);
          bufferedWriter.close();
       } catch (IOException ex){
           ex.printStackTrace();
       }


    }

    public void Close ()
    {
        try{
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
