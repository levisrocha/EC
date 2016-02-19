

package escrita;

import java.io.*;

public class exemplo1 {
    public static void escreve(String arquivo, String texto){
        try{
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(texto);
            bw.newLine();
            
            System.out.println("texto inserido com sucesso!!!");
            
            bw.close();
            fw.close();
            
            
        }catch(IOException e){
            System.err.println(e);
        }catch(Exception e){
            System.err.println(e);
        }
        
        
    }
    
    
    public static void main(String [] args){
        escreve("arquivo escrita.txt", 
                "Hoja a aula está cheia! SQN");
    }

}
