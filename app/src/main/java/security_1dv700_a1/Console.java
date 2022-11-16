package security_1dv700_a1;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {
  Scanner scan = new Scanner(System.in, "utf-8");

  public String printMenu() {
    System.out.println();
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

    return input;
  }

  public int printEnterShiftKeyCaesar() {
    System.out.print("Enter Shift Key: ");
    int shiftKey = scan.nextInt();
    scan.nextLine();
    return shiftKey;
  }

  public int printEnterKeyTransposition() {
    System.out.print("Enter Key (between 3-10): ");
    int shiftKey = scan.nextInt();
    return shiftKey;
  }

  public String printEnterMessage() {
    System.out.print("Enter Your Message: ");
    String message = scan.nextLine();
    return message;
  }

  public void printCaesarEncryptedText(String cipherText) {
    System.out.println("\n" + "Encrypted message: " + "\n" + cipherText + "\n"); 
  }

  public void printCaesarDecryptedText(String decryptedText) {
    System.out.println(decryptedText);
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
      // https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values - Tips and inspiration
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
