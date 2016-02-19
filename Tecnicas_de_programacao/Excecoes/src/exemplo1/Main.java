package exemplo1;

import java.io.*;

public class Main {
    
    public static float divide(float numerador, float denominador) throws DividePorZero{
		if(denominador == 0){
                    throw new DividePorZero();
                }
		return numerador / denominador;
    }

    
    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try{
            
            System.out.println("Digite um numerador: ");
            float numerador = Float.parseFloat(entrada.readLine());
            System.out.println("Digite um denominador: ");
            float denominador = Float.parseFloat(entrada.readLine());    
            float resultado = divide(numerador, denominador);
            System.out.println("O resultado é: "+resultado);
            
        }catch(DividePorZero e){
            System.err.println(e);
        
        }catch(Exception e){
            System.out.println(e);
        }
            
    }
    
}

