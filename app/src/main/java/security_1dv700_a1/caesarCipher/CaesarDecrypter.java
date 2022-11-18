package security_1dv700_a1.caesarCipher;

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
          int keyValue = (pos - decryptionKey) % modulus; 
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
}