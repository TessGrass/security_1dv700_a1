package security_1dv700_a1.transpositionCipher;

import java.util.ArrayList;

import security_1dv700_a1.Console;

public class TranspositionEncrypter {

  public String runEncrypter(int theKey, String theNotSoSecretMessage) {
    ArrayList<Character> charMessage = new ArrayList<Character>();
    String plainText = theNotSoSecretMessage;
    int key = theKey;
    int count = 0;
    int rows = 0;

    for (int i = 0; i < plainText.length(); i++) {
      charMessage.add(extractEachLetterInMessage(plainText, i));
      count++;
    }
    rows = (count / key) + 1;
    
    String cipherText = encryptMessage(key, rows, charMessage);
    return cipherText;
  }   

  private static Character extractEachLetterInMessage(String plainText, int i) {
    return plainText.charAt(i);
  }   

private static String encryptMessage(int key, int numberOfRowsNeeded, ArrayList<Character> text) {
  ArrayList<Character> plainText = text;
  int columns = key;
  int rows = numberOfRowsNeeded;
  char[][] twoArr = new char[rows][columns];
  int lengthPlainText = 0;

  /**
   * Pushes the string message into the 2D array, starting at [0][0]. Fills the array horizontally.
   */
  for(int i = 0; i < rows; i++) {
    for(int j = 0; j < columns; j++) {
      if (lengthPlainText < plainText.size()) {
        twoArr[i][j] = plainText.get(lengthPlainText);
        lengthPlainText++;
      }
    }
  }

  int startColumn = 0;
  int endColumn = 1;
  String encryptedMessage = "";
  Boolean isStartColumnLessThanMaxColumns = true;
   
  /**
   * Encrypts the message by pushing it into the 2D array. Starts at [0][0] and then pushes into the String, going top to bottom - row by row.
   */
  while(isStartColumnLessThanMaxColumns) {
    
    for(int i = 0; i < rows; i++) {
      for(int j = startColumn; j < endColumn; j++) {
        encryptedMessage += twoArr[i][j];                
      }
    }
    startColumn++;
    endColumn++;

    if(startColumn == columns) {
      isStartColumnLessThanMaxColumns = false;
    }
  }
  return encryptedMessage;
}
}
