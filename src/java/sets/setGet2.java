/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;
import java.io.Serializable;
/**
 *
 * @author user
 */
public class setGet2 implements Serializable{
    double resultado = 0;
    public setGet2(){
        
    }
    public double suma( int num1, int num2){
        this.resultado = num1 + num2;
        
        return resultado;
    }
    
}
