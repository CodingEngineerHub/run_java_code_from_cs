/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_cs;

/**
 *
 * @author as
 */
public class hexStringToByteArray {
    public static byte[] hexStringToByteArray(String s) {
    int len = s.length();
    byte[] dataHex = new byte[len / 2];
    for (int i = 0; i < len; i += 2) {
        dataHex[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                             + Character.digit(s.charAt(i+1), 16));
    }
     
    return dataHex;
    
}
}
