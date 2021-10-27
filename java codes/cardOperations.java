/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_cs;

import java.util.List;
import javax.smartcardio.ATR;
import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author as
 */
public class cardOperations {
    
    public static void readATR() throws CardException {
    
    TerminalFactory terminalFactory = TerminalFactory.getDefault();
    List<CardTerminal> cardTerminals = terminalFactory.terminals().list();
        
        if (cardTerminals.isEmpty()) {
            System.out.println("Skipping the test: " +"no card terminals available");
            return;
        }
        CardTerminal cardTerminal = cardTerminals.get(0);        
        Card card = cardTerminal.connect("*");        
               
        CardChannel channel = card.getBasicChannel();
             
        ATR atr1 = card.getATR();
        byte[] atrBytes1 = atr1.getBytes();
        
        
       System.out.print("card ATR:");
	
	for(byte c1 : atrBytes1) 
        System.out.format("%02X", c1);
        System.out.print("\n");
        card.disconnect(true);
		    
    }
    
    
     public static void sendAnApduCommand(byte[] apduCommand) throws CardException {
         TerminalFactory terminalFactory = TerminalFactory.getDefault();
         List<CardTerminal> cardTerminals = terminalFactory.terminals().list();
         CardTerminal cardTerminal = cardTerminals.get(0);        
         Card card = cardTerminal.connect("*"); 
         CardChannel channel = card.getBasicChannel();
             
      
            ResponseAPDU  resp1 = channel.transmit(new CommandAPDU((byte) apduCommand[0], (byte) apduCommand[1],(byte) apduCommand[2],  (byte) apduCommand[3], (byte)apduCommand[4]));
      
     
        String s1 = resp1.toString();
        String s2 =DatatypeConverter.printHexBinary(resp1.getData());
         
     System.out.println(s1+"\nCard Response Data:" +s2);
      card.disconnect(true);
     }         
}
