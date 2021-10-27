/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_cs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author as
 */
public class readFile {
   public String readFile(String filename){
       
     try {
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
           System.out.println("java "+filename+" is reading....");
         filename = myReader.nextLine();
          System.out.println(filename);
        return filename;
   
      }
      myReader.close() ;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
       return null;
    
    }
}
