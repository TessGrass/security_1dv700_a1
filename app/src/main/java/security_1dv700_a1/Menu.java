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
      main.runCaesarEncrypter(shiftKey);
    }

    if (input.equals("2")) {
      int shiftKey = console.printEnterShiftKeyCaesar();
       main.runCaesarDecrypter(shiftKey);
    }

    if (input.equals("3")) {
      int shiftKey = console.printEnterKeyTransposition();
      Boolean isNumberWithinRange = false;

      while (!isNumberWithinRange) {
      isNumberWithinRange = validateInput(shiftKey);
      }
       main.runTranspositionEncrypter(shiftKey);
    }

    if (input.equals("4")) {
      int shiftKey = console.printEnterKeyTransposition();
       main.runTranspositionDecrypter(shiftKey);
    }

    if (input.equals("5")) {
      String messageToBeHashed = console.printEnterMessage();
      String hashedText = hash.hashString(messageToBeHashed);
      console.printHashedText(hashedText);
    }

    if (input.equals("6")) {
      String message = "Testing the hash string!";
      hashTester.testWithSimilarString(message);
    }
}
  
  private Boolean validateInput(int number) {
    int minKey = 2;
    int maxKey = 11;
    if(number > minKey && number < maxKey) {
      return true;
    }
    return false;
  }
}