

package leitura;

import java.io.*;

public class exemplo1 {
    

    public static void le(String arquivo){
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linha = null;
            while((linha = br.readLine()) != null){
                System.out.println(linha);
            }
            
            
            br.close();
            fr.close();
        }catch(Exception e){
            System.err.println(e);
        }   
    }
    
    
    public static void main(String [] args){
        le("arquivo leitura.txt");
    }
}
