package security_1dv700_a1.transpositionCipher;

import java.util.ArrayList;

public class TranspositionDecrypter {

  public String runDecrypter(int key, String secretMessage) {
    ArrayList<Character> messageArr = new ArrayList<Character>();
    String cipherText = secretMessage;
    int columns = key;
    int count = 0;
    int rows = 0;

    for (int i = 0; i < cipherText.length(); i++) {
      messageArr.add(cipherText.charAt(i));
      count++;
    }

    rows = count / columns;

    /**
     * Pushes the message into the 2D-array starting at [0,0]. It takes the first column and then pushes four characters vertically / into that row,
     * it continues to do so until all the characters have been pushed into the array.
     */
    char[][] twoArr = new char[rows][columns];
    int lengthMessage = 0;
    
    for (int j = 0; j < columns; j++){
      for (int i = 0; i < rows; i++) {
        twoArr[i][j] = messageArr.get(lengthMessage);
        lengthMessage++;
      }
    }

    /**
     * Loops out the 2D-array at starting position [0,0]. It then goes through it horizontally / columns.
     */
    String decryptedMessage = "";
  
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        decryptedMessage += twoArr[i][j];
      }
    }
    return decryptedMessage;
  }
}
