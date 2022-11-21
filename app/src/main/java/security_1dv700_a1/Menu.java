package security_1dv700_a1;
import security_1dv700_a1.hash.Hash;
import security_1dv700_a1.hash.HashTester;

public class Menu {
  Main main = new Main();
  Hash hash = new Hash();
  HashTester hashTester = new HashTester();
  Console console = new Console();
  
  public void mainMenu() {
    String input = console.printMenu();    
    handleInput(input);
  }

  private void handleInput(String input) {
      
    if (input.equals("1")) {
      int shiftKey = console.printEnterShiftKeyCaesar();
      String path = console.printEnterSearchPath();
      main.runCaesarEncrypter(shiftKey, path);
    }

    if (input.equals("2")) {
      int shiftKey = console.printEnterShiftKeyCaesar();
      String path = console.printEnterSearchPath();
      main.runCaesarDecrypter(shiftKey, path);
    }

    if (input.equals("3")) {
      int shiftKey = console.printEnterKeyTransposition();
      Boolean isNumberWithinRange = false;

      while (!isNumberWithinRange) {
      isNumberWithinRange = validateNumberRange(shiftKey);
      }
      String path = console.printEnterSearchPath();
      main.runTranspositionEncrypter(shiftKey, path);
    }

    if (input.equals("4")) {
      int shiftKey = console.printEnterKeyTransposition();
      String path = console.printEnterSearchPath();
      main.runTranspositionDecrypter(shiftKey, path);
    }

    if (input.equals("5")) {
      String messageToBeHashed = console.printEnterMessage();
      String hashedText = hash.hashString(messageToBeHashed);
      console.printHashedText(hashedText);
    }

    if (input.equals("6")) {
      String message = "Testing the hash string!";
      hashTester.addLetterToString(message);
/*       hashTester.changeLetterInString(); */
/*         hashTester.validateHashLength(); */
    }

    if (input.equals("7")) {
      int shiftKey = console.printEnterNumberOfCycles();
      String path = console.printEnterSearchPath();
      main.runDecryptCipherWithoutSpecificKey(shiftKey, path);
    }
}
  
  private Boolean validateNumberRange(int number) {
    int minKey = 2;
    int maxKey = 11;
    if(number > minKey && number < maxKey) {
      return true;
    }
    return false;
  }
}