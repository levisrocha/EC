

package exemplo2;


public class main {
    public static void geraExcecao() throws Excecao2{
        throw new Excecao2();
    }
    
    public static void main(String [] args){
        try{
            geraExcecao();
            
        }catch(Excecao1 e){
            System.err.println(e);
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
