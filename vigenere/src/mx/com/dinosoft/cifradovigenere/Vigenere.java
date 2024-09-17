package mx.com.dinosoft.cifradovigenere;

import android.annotation.SuppressLint;

public class Vigenere {
	
	String texto;
	
	public Vigenere(){}
	
	@SuppressLint("UseValueOf")
	public String cifrar(String texto, String clave){ 
		
		int i, j=0, n, longitudClave;
		String salida=""; 
		longitudClave=clave.length();
	    
	    for(i=0; i<texto.length(); i++){
	        
	    	if(	(65 <= texto.codePointAt(i) && texto.codePointAt(i) <= 90) || 
	        	(97 <= texto.codePointAt(i) && texto.codePointAt(i) <= 122)){
	            if(j == longitudClave)
	                j=0;
	            n = clave.codePointAt(j)-65;
	            j++;
	            if(n+texto.codePointAt(i) > 90)
	            	salida = salida + new Character((char) (texto.codePointAt(i) +n-26)).toString();
	            else
	                salida = salida + new Character((char) (texto.codePointAt(i) + n)).toString();
	        }else
	            salida = salida + new Character((char) (texto.codePointAt(i))).toString();
	    }
		System.out.printf("\n");
         
        return salida;
    }

}