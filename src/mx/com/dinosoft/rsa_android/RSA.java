package mx.com.dinosoft.rsa_android;

import java.math.BigInteger;
import java.util.Random;
  
public class RSA { 
  
    int tamPrimo; 
    BigInteger n, q, p, e, d; 
    BigInteger z; 
  
     
    public RSA(int size){ this.tamPrimo = size;} 
      
    public void generaClaves(){
    	
    	// p != q    primos de muchas cifras
    	p = new BigInteger(tamPrimo,10,new Random());
    	do 
    		q = new BigInteger(tamPrimo,10,new Random()); 
        while(q.compareTo(p) == 0); 
    	
    	// n = p * q 
        n = p.multiply(q); 
        
        // z = (p-1)(q-1)
        z = p.subtract(BigInteger.valueOf(1)); 
        z = z.multiply(q.subtract(BigInteger.valueOf(1))); 
        
        // e < z     e primo relativo de z
        do 
        	e = new BigInteger(2 * tamPrimo, new Random());
        while(  (e.compareTo(z) != -1)   ||  (e.gcd(z).compareTo(BigInteger.valueOf(1)) != 0)     ); 
        
        // (e*d)%z == 1
        d = e.modInverse(z); 
        
    } 
      
      
    public BigInteger[] encripta(String mensaje){ 
    	
        int i; 
        byte[] temp = new byte[1]; 
        byte[] digitos = mensaje.getBytes(); 
        BigInteger[] bigdigitos = new BigInteger[digitos.length]; 
          
        for(i=0; i<bigdigitos.length;i++){ 
            temp[0] = digitos[i]; 
            bigdigitos[i] = new BigInteger(temp); 
        } 
          
        BigInteger[] encriptado = new BigInteger[bigdigitos.length]; 
          
        for(i=0; i<bigdigitos.length; i++) 
            encriptado[i] = bigdigitos[i].modPow(e,n); 
          
        return(encriptado);
        
    } 
      
      
    public String desencripta(BigInteger[] encriptado){ 
    	
        BigInteger[] desencriptado = new BigInteger[encriptado.length]; 
          
        for(int i=0; i<desencriptado.length; i++) 
            desencriptado[i] = encriptado[i].modPow(d,n); 
          
        char[] charArray = new char[desencriptado.length]; 
          
        for(int i=0; i<charArray.length; i++) 
            charArray[i] = (char) (desencriptado[i].intValue()); 
          
        return(new String(charArray)); 
        
    } 
      
    public BigInteger getP() {return(p);} 
    public BigInteger getQ() {return(q);} 
    public BigInteger getN() {return(n);} 
    public BigInteger getD() {return(d);} 
    public BigInteger getE() {return(e);} 
    public BigInteger getZ() {return(z);} 
    
}
