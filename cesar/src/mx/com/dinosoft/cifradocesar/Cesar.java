package mx.com.dinosoft.cifradocesar;

import android.annotation.SuppressLint;

public class Cesar {
	
	String texto;
	
	public Cesar(){}
	
	@SuppressLint("UseValueOf")
	public String cifrar(String texto, int n){ 
        int aux = 0; 
        String salida=""; 
         
        for(int i=0; i<texto.length(); i++){
	        if(texto.charAt(i) < 91)
	            aux = 90;
	        if(texto.charAt(i) > 96)
	            aux = 122;
	        
	        if( (65 <= texto.codePointAt(i) && texto.codePointAt(i) <= 90)	|| 	
	        	(97 <= texto.codePointAt(i) && texto.codePointAt(i) <= 122))
	            if(n+texto.charAt(i) > aux)
	            	salida = salida + new Character((char) (texto.codePointAt(i) +n-26)).toString();
	            else
	                salida = salida + new Character((char) (texto.codePointAt(i) + n)).toString();
	        else
	            salida = salida + new Character((char) (texto.codePointAt(i))).toString();
	    } 
         
        return salida;
    }

}
