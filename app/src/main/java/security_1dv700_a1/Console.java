package security_1dv700_a1;

import java.util.ArrayList;

import javax.print.event.PrintEvent;

public class Console {
  
  public void printCaesarEncryptedText(String cipherText) {
    System.out.println("\n" + "Encrypted message: " + "\n" + cipherText + "\n"); 
  }

  public void printCaesarDecryptedText(ArrayList<String> decryptedText) {
    int shiftKeyDecryption = 1;

    for (String s : decryptedText) {
      System.out.println("\nKey " + shiftKeyDecryption + ":\n" + s);
       shiftKeyDecryption++;
      }
  }

  public void printTranspositionEncryptedText(String cipherText) {
    System.out.println("---Encrypted message-----");
    System.out.println(cipherText);
    System.out.println("---End of Encrypted message---");
  }

  public void printTranspositionDecryptedText(String decryptedMessage) {
    System.out.println("-----Decrypted message-----");
    System.out.println(decryptedMessage);
    System.out.println("-----End of Decrypted message------");
  }
}
