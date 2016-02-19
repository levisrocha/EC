/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lerPacote;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ialis
 */
public class exemplo1 {

    public static void leitura(String arquivo){
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);

//            String linha = null;
//            while((linha = br.readLine()) != null){
//                System.out.println(linha);
//            }

            //ArrayList tabela = new ArrayList();
            String linha, palavra;
            String[][] tabela = new String[6][5];
            int numLinha = 0; int numColuna = 0;
            while ((linha = br.readLine()) != null){
                palavra = "";
                numColuna =0;
                for(int i = 0; i < linha.length(); i++){
                    if(linha.charAt(i) != '\t'){
                        palavra = palavra.concat(String.valueOf(linha.charAt(i)));
                    }else{
                        //tabela.add(palavra);
                        tabela[numLinha][numColuna] = palavra;
                        System.out.print(palavra+"\t");
                        palavra = "";
                        numColuna++;
                    }
                }
                //tabela.add(palavra);
                System.out.println(palavra);
                tabela[numLinha][numColuna] = palavra;
                numLinha++;
            }

            br.close();
            fr.close();
        }catch(IOException e){
            System.err.println(e);
        }
    }


    public static void main(String [] args){
        leitura("conf.dat");
    }
}
