/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package exemplo2;

/**
 *
 * @author BMC
 */
public class Excecao1 extends Exception{
    public Excecao1(){
        super("Exceção 1");
    }
    public Excecao1(String msg){
        super(msg);
    }
}
