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
public class Decimal {
    //output Strings
    String outputStringDH = new String();
    String outputStringDB = new String();

    public String getOutputStringDH() {
        return outputStringDH;
    }

    public void setOutputStringDH(String outputStringDH) {
        this.outputStringDH = outputStringDH;
    }

    public String getOutputStringDB() {
        return outputStringDB;
    }

    public void setOutputStringDB(String outputStringDB) {
        this.outputStringDB = outputStringDB;
    }
    
     void decimalToHexadecimal(String decimalInt) {
     int remainder = 0;
     String hexString = new String(); 
 
     int decNum = Integer.parseInt(decimalInt);
     char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
 
     while(decNum>0)
     {
       remainder=decNum%16; 
       hexString=hex[remainder]+hexString; 
       decNum=decNum/16;
     }
     outputStringDH = hexString;
     
    
    
    }
      
    void decimalToBinary(String decimalInt) {
    int decNum = Integer.parseInt(decimalInt);
    StringBuilder sb = new StringBuilder();
    
    
     sb.setLength(0);
     int binary[] = new int[100];    
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
     
     outputStringDB = sb.toString();
     
     
    }
        
        
    
    
    
    
    
}
