package security_1dv700_a1.caesarCipher;

import java.util.ArrayList;

public class CaesarDecrypter implements Decrypter<Integer> {
  public static final String ENGLISHALPHABET = "abcdefghijklmnopqrstuvwxyz";
  
  @Override
  public String decryptCipherText(Integer decryptionKey, String cipherText) {
    cipherText = cipherText.toLowerCase();
    int modulus = 26;
    String plainText = "";

    for (int i = 0; i < cipherText.length() - 1; i++) {
      if (!isCharInString(cipherText.charAt(i))) {
        plainText += cipherText.charAt(i);
      } else {
          int pos = ENGLISHALPHABET.indexOf(cipherText.charAt(i));
          int keyValue = (pos - decryptionKey) % modulus; // Modulus of difference of alphabet letter and key
          if (keyValue < 0) {
            keyValue = modulus + keyValue;
          }
        char decryptedLetter = ENGLISHALPHABET.charAt(keyValue);
        plainText += decryptedLetter;
      }
    }
    return plainText;
  }

  public boolean isCharInString(char character) {
    char[] englishAlphabet = ENGLISHALPHABET.toCharArray();

    for (char letter : englishAlphabet) {
      if (letter == character) {
        return true;
      }    
    }
    return false;
  }

  public void decryptCipherWithoutKey(int cycles, String encryptedText) {
      ArrayList<String> decryptedWords = new ArrayList<String>();
      for (int i = 1; i <= cycles; i++) {
        decryptedWords.add(decryptCipherText(i, encryptedText));
        System.out.println(decryptedWords);
      }
/*       return decryptedWords; */
  }


  public String decryptCipherText2(Integer decryptionKey, String cipherText) {
    cipherText = cipherText.toLowerCase();
    int modulus = 256;
    String plainText = "";


    for (int i = 0; i < cipherText.length(); i++) {
/*       if (cipherText.charAt(i) == ' ') {
        plainText += " ";
      } else { */
        int pos = cipherText.charAt(i);
        int keyValue = (pos - decryptionKey) % modulus; // Modulus of difference of alphabet letter and key

        if (keyValue < 0) {
          keyValue = modulus + keyValue;
        }

        char decryptedLetter = ((char)(int)keyValue);
        plainText += decryptedLetter;
/*       } */
    }
    return plainText;
  }
}