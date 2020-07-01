/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberconverter;

/**
 *
 * David V. Williamson
 */
public class Hexadecimal {
    //output Strings
    String outputStringHD = new String();
    String outputStringHB = new String();

    public String getOutputStringHD() {
        return outputStringHD;
    }

    public void setOutputStringHD(String outputStringHD) {
        this.outputStringHD = outputStringHD;
    }

    public String getOutputStringHB() {
        return outputStringHB;
    }

    public void setOutputStringHB(String outputStringHB) {
        this.outputStringHB = outputStringHB;
    }

    void hexadecimalToDecimal(String hexInput) {
     String digits = "0123456789ABCDEF";  
             hexInput = hexInput.toUpperCase();  
             int decVal = 0;  
             for (int i = 0; i < hexInput.length(); i++)  
             {  
                 char hexInputChar = hexInput.charAt(i);  
                 int digInd = digits.indexOf(hexInputChar);  
                 decVal = 16*decVal + digInd;  
             }  
             
             
             outputStringHD = String.valueOf(decVal);
             
              
}  
    
     void hexadecimalToBinary(String hexInput) {
             String digits = "0123456789ABCDEF";  
             hexInput = hexInput.toUpperCase();  
             int decVal = 0;  
             StringBuilder sb = new StringBuilder();
             
             for (int i = 0; i < hexInput.length(); i++)  
             {  
                 char hexInputChar = hexInput.charAt(i);  
                 int digInd = digits.indexOf(hexInputChar);  
                 decVal = 16*decVal + digInd;  
             }  
    
             int binary[] = new int[100];  
             int decNum = decVal;
             int index = 0;    
             while(decNum > 0){    
              binary[index++] = decNum%2;    
             decNum = decNum/2;    
             }
             int sbCounter = index;
             for (int i = 0; i < index; i++) {
     
             sb.append(binary[sbCounter-1]);
             sbCounter--;
             }
     
            outputStringHB = sb.toString();
            

   


}}
