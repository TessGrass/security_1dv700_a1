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
/*     String mess = "Tesss";
    hash.hashString(mess); */
    System.out.println("\n" + "== Caesar-Cipher Main Menu ==");
    System.out.println("1. Encrypt Text - Caesar Cipher");
    System.out.println("2. Decrypt Text - Caesar Cipher");
    System.out.println("3. Encrypt Text - Transposition Cipher");
    System.out.println("4. Decrypt Text - Transposition Cipher");
    System.out.println("5. Hash Text");
    System.out.println("6. Test Hash");
    System.out.println("Q. Quit");
  
    System.out.print("\n" + "Input choice: ");
    String input = scan.nextLine();
    
    handleInput(input);
    
  }

  private void handleInput(String input) {
      
    if (input.equals("1")) {
      int shiftKey = printEnterShiftKeyCaesar();
      main.runCaesarEncrypter(shiftKey);
    }

    if (input.equals("2")) {
      int shiftKey = printEnterShiftKeyCaesar();
       main.runCaesarDecrypter(shiftKey);
    }

    if (input.equals("3")) {
      int shiftKey = printEnterKeyTransposition();
       main.runTranspositionEncrypter(shiftKey);
    }

/*     if (input.equals("4")) {
      int shiftKey = printEnterKeyTransposition();
       main.runTranspositionDecrypter(shiftKey);
    } */

    if (input.equals("5")) {
      String messageToBeHashed = printEnterMessage();
      hash.hashString(messageToBeHashed);
    }

    if (input.equals("6")) {
      String message = "Testing the hash string!";
      hashTester.testWithSimilarString(message);
    }
}

  private int printEnterShiftKeyCaesar() {
    System.out.print("Enter Shift Key: ");
    int shiftKey = scan.nextInt();
    scan.nextLine();
    return shiftKey;
  }

  private int printEnterKeyTransposition() {
    Boolean isNumberNotWithinRange = true;
    int shiftKey = 0;

    while(isNumberNotWithinRange) {
      System.out.print("Enter Key (between 3-10): ");
      shiftKey = scan.nextInt();
      isNumberNotWithinRange = validateInput(shiftKey, isNumberNotWithinRange);
    }
    return shiftKey;
  }
  
  private Boolean validateInput(int number, boolean range) {
    int minKey = 2;
    int maxKey = 11;
    if(number > minKey && number < maxKey) {
      return false;
    }
    return true;
  }
  
  private String printEnterMessage() {
    System.out.print("Enter Your Message: ");
    String message = scan.nextLine();
    return message;
  }
}