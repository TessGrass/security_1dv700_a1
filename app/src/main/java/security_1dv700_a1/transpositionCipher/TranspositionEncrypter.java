package security_1dv700_a1.transpositionCipher;

import java.util.ArrayList;

public class TranspositionEncrypter {

  public String runEncrypter(int theKey, String theNotSoSecretMessage) {
    ArrayList<Character> charMessage = new ArrayList<Character>();
    String plainText = theNotSoSecretMessage;
    int lengthText = plainText.length();
    String letter = "x";
    int key = theKey;
    int rows = 0;

    rows = (lengthText / key) + 1;

    int gridSize = rows * key;

    int remainingLettersNeededToFillGrid = gridSize - lengthText;

    for (int i = 0; i < remainingLettersNeededToFillGrid; i++) {
        plainText = plainText + letter;
    }

    for (int i = 0; i < plainText.length(); i++) {
      charMessage.add(extractEachLetterInMessage(plainText, i));
    }
    
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
     * Encrypts the message by taking the values from the array, starting at [0][0], and then it pushes the character into the String, 
     * going top to bottom - row by row.
     */
    while(isStartColumnLessThanMaxColumns) {
      
      for(int i = 0; i < rows; i++) {
        for(int j = startColumn; j < endColumn; j++) {
          encryptedMessage += twoArr[i][j];                
        }
      }
      startColumn++;
      endColumn++;

      if (startColumn == columns) {
        isStartColumnLessThanMaxColumns = false;
      }
    }
    return encryptedMessage;
  }
}
