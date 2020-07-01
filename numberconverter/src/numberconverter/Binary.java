/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberconverter;

/**
 *
 * @author willi
 */
public class Binary {
    //output Strings
    String outputStringBH = new String();
    String outputStringBD = new String();

    public String getOutputStringBD() {
        return outputStringBD;
    }

    public void setOutputStringBD(String outputStringBD) {
        this.outputStringBD = outputStringBD;
    }

    public String getOutputString() {
        return outputStringBH;
    }

    public void setOutputString(String outputString) {
        this.outputStringBH = outputString;
    }
    void binaryToHexadecimal(String binaryInt) {
        int[] hex = new int[1000];
        int i = 1;
        int j = 0; 
        int rem = 0;
        int dec = 0; 
        int bin = 0;
        
        StringBuilder sb = new StringBuilder();
        
        bin = Integer.parseInt(binaryInt);
        
        
        sb.setLength(0);
        while (bin > 0) {
        rem = bin % 2;
        dec = dec + rem * i;
        i = i * 2;
        bin = bin / 10;
        }
        i = 0;
        while (dec != 0) {
        hex[i] = dec % 16;
        dec = dec / 16;
        i++;
        }
       
       for (j = i - 1; j >= 0; j--)
       {
       if (hex[j] > 9) 
       {
        sb.append((char)(hex[j] + 55));
       } else
       {
       sb.append(hex[j]);
       }
      }
     outputStringBH = sb.toString();
     
}

    void binaryToDecimal (String binaryInt) {
    int binNum = 0;
    int decNum = 0;
    int j = 1;
    int remainder = 0;
     
     binNum = Integer.parseInt(binaryInt);
     
     while (binNum!= 0) 
     {
     remainder = binNum % 10;
     decNum = decNum + remainder * j;
     j = j * 2;
     binNum = binNum / 10;
     }
    
     outputStringBD = Integer.toString(decNum);
     
    
    }

}
