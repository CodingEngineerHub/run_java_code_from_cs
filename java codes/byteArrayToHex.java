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
public class byteArrayToHex  {
public static String byteArrayToHex(byte[] a) {
StringBuilder sb = new StringBuilder(a.length * 2);
for(byte b: a)
sb.append(String.format("%02x", b));
return sb.toString();
}
    
}
