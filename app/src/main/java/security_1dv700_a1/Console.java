package security_1dv700_a1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {
  Scanner scan = new Scanner(System.in, "utf-8");

  public String printMenu() {
    System.out.println("\n" + "== Caesar-Cipher Main Menu ==");
    System.out.println("1. Encrypt Text - Caesar Cipher");
    System.out.println("2. Decrypt Text - Caesar Cipher");
    System.out.println("3. Encrypt Text - Transposition Cipher");
    System.out.println("4. Decrypt Text - Transposition Cipher");
    System.out.println("5. Hash Text");
    System.out.println("6. Test Hash");
    System.out.println("7. Bonus: Decrypt Text Without Known Key - Caesar");
  
    System.out.print("\n" + "Input choice: ");
    String input = scan.nextLine();

    return input;
  }

  public int printEnterShiftKeyCaesar() {
    int key = 0;
    try {
    System.out.print("Enter Shift Key: ");
    String shiftKey = scan.nextLine();
    key = Integer.parseInt(shiftKey);
    } catch (NumberFormatException nfe) {
      System.out.println("Please enter a valid number");
      printEnterShiftKeyCaesar();
    }
    return key;
  }

  public int printEnterNumberOfCycles() {
    int key = 0;
    try {
    System.out.println("You don't have a known key? No problem! Let's try them all at once!");
    System.out.println("We'll start with key 1 and cycle through each key until we reach your end key.");
    System.out.println("(This is will only read, not write, anything to file. It's just a little bonus functionality)");
    System.out.println();
    System.out.print("Enter End Key: ");
    String shiftKey = scan.nextLine();
    key = Integer.parseInt(shiftKey);
    } catch (NumberFormatException nfe) {
      System.out.println("Please enter a valid number");
      printEnterNumberOfCycles();

    }
    return key;
  }

  public int printEnterKeyTransposition() {
    int key = 0;
    try {
    System.out.print("Enter Key (between 3-10): ");
    String shiftKey = scan.nextLine();
    key = Integer.parseInt(shiftKey);
    } catch (NumberFormatException nfe) {
      System.out.println("Please enter a valid number");
      printEnterKeyTransposition();
    }
    return key;
  }

  public String printEnterMessage() {
    System.out.print("Enter Your Message: ");
    String message = scan.nextLine();
    return message;
  }

  public String printEnterSearchPath() {
    System.out.println("Enter the path to your textfile. The path must start with /src/" + "\nFor example: /src/main/java/security_1dv700_a1/fileReader/messageCaesar.txt");
    System.out.print("Enter Your Path: ");
    String path = scan.nextLine();
    return path;
  }

  public void printCaesarEncryptedText(String cipherText) {
    System.out.println("\n" + "Encrypted message: " + "\n" + cipherText + "\n"); 
  }

  public void printCaesarDecryptedText(String decryptedText) {
    System.out.println(decryptedText);
  }

  public void printBruteForcedText(int key, String text) {
    System.out.println("Key used: " + key);
    System.out.println(text + "\n");
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

  public void printHashedText(String text) {
    System.out.println("Hashed value: " + text);
  }

  public void printSimilarStringResult(Map<String, Integer> map, int numberOfStrings) {
    System.out.println("------Hash Spread among Similar Strings Result -----");
    System.out.println("Number of similar strings used: " + numberOfStrings);
    System.out.println("Hashes generated: ");
    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println); // instead of numbers.forEach(x -> System.out.println(x));
  }

  public void printValidateHashLengthResult(int numberOfErrors, int numberOfStrings) {
    System.out.println("\n------Hash Length Validation Result-----");
    System.out.println("Number of random strings used: " + numberOfStrings);
    System.out.println("Number of hash outside range 000 - 256: " + numberOfErrors);
  }

  public void printOnlyUniqueHashes(HashMap<String, Integer> uniqueHashes) {
    System.out.println("\n------Unique Hashes Result -----");
    System.out.println("Number of unique Hashes: " + uniqueHashes.size());
    System.out.println(uniqueHashes.keySet());
  }
}
