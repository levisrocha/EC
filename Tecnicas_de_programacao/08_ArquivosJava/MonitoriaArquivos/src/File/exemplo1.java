

package File;

import java.io.*;


public class exemplo1 {
    
    public static void arquivoTeste(String arquivo){
        File file = new File(arquivo);
        
        System.out.println("exists: "+file.exists());
        System.out.println("isDirectory: "+file.isDirectory());
        System.out.println("isFile: "+file.isFile());
        
    }
    public static void criaDiretorio(String diretorio){
        File file = new File(diretorio);
        file.mkdirs();
    }
    
    public static void main(String [] args){
        arquivoTeste("arquivo.txt");
        arquivoTeste("arquivo2.txt");
        criaDiretorio("c:\\teste2\\teste");
        
    }

}
