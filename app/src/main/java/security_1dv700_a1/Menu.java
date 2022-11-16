package security_1dv700_a1;
import java.util.Scanner;
import security_1dv700_a1.hash.Hash;
import security_1dv700_a1.hash.HashTester;

public class Menu {
  Scanner scan = new Scanner(System.in, "utf-8");
  Main main = new Main();
  Hash hash = new Hash();
  HashTester hashTester = new HashTester();

  
  public void mainMenu() {
    System.out.println();
    /* hash.hashString(); */
    hashTester.similarString();
    System.out.println("\n" + "== Caesar-Cipher Main Menu ==");
    System.out.println("1 - Encrypt Text");
    System.out.println("2 - Decrypt Text");
    System.out.println("3 - Hash Text");
    System.out.println("Q - Quit");
  
    System.out.print("\n" + "Input choice: ");
    String input = scan.nextLine();
    
    handleInput(input);
    
  }

  private void handleInput(String input) {
    int shiftKey = printEnterShiftKey();
      
    if (input.equals("1")) {
      String cipherText = main.runEncrypter(shiftKey);
      printCipherText(cipherText);
    }

    if (input.equals("2")) {
       main.runDecrypter(shiftKey);
      
     /*  System.out.println("Encrypted message: " + plainText); */
    }

    if (input.equals("3")) {
/*       hash.hashString(); */
  }
}

  private int printEnterShiftKey() {
    System.out.print("Enter Shift Key: ");
    int shiftKey = scan.nextInt();
    return shiftKey;
  }

  private void printCipherText(String cipherText) {
    System.out.println("\n" + "Encrypted message: " + cipherText + "\n"); 
  }
}