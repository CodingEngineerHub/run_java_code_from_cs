/*
This application get a text file convert it to byte array and send this byte array to smart card
*/
package java_cs;
/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
 
/**
 * @test
 * @bug 8046343
 * @summary Make sure that direct protocol is available
 * @run main/manual TestDirect
 */
 
// This test requires special hardware.


 import  javax.smartcardio.*;
 import java.util.List;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
 import java.io.File;  // Import the File class
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.FileNotFoundException;
import static java_cs.byteArrayToHex.byteArrayToHex;
import static java_cs.hexStringToByteArray.hexStringToByteArray;
import static java_cs.cardOperations.readATR;
import java_cs.readFile;

import java.util.*;

public class Java_CS  {   

    public static void main(String[] args) throws Exception {
        readFile yourFile= new readFile();
//Type your file name          
  String fileName="filename.txt";
  String userFileData="";
 
  userFileData=yourFile.readFile(fileName);

  cardOperations.readATR();      
  System.out.println(userFileData);
 byte[] apduCommand= hexStringToByteArray.hexStringToByteArray(userFileData);
    	
   cardOperations.sendAnApduCommand(apduCommand);
       
   
    
    }	
}
