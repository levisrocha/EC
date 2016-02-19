package exemplo1;


public class DividePorZero extends Exception{
    
    public DividePorZero(){
        super("Erro.. divisão por zero!!");
    }
    
    public DividePorZero(String msg){
        super(msg);
    }
}
