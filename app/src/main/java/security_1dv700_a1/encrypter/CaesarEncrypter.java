package security_1dv700_a1.encrypter;

public class CaesarEncrypter implements Encrypter<Integer> {
  public static final String ENGLISHALPHABET = "abcdefghijklmnopqrstuvwxyz";


  public String encryptPlainText2(Integer shiftKey, String plainText) {
    plainText = plainText.toLowerCase();
    int modulus = 26;
    String cipherText = "";

    for (int i = 0; i < plainText.length() - 1; i++) {
      if(!isCharInString(plainText.charAt(i))) {
        cipherText += plainText.charAt(i);
      } else {
        int indexOfPlainLetter = ENGLISHALPHABET.indexOf(plainText.charAt(i));
        int indexOfCipherLetter = (indexOfPlainLetter + shiftKey) % modulus;
        char replaceValue = ENGLISHALPHABET.charAt(indexOfCipherLetter);
        cipherText += replaceValue;
      }
    }

    return cipherText;
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
  @Override
  public String encryptPlainText(Integer shiftKey, String plainText) {
    plainText = plainText.toLowerCase();
    int modulus = 256;
    String cipherText = "";

    for (int i = 0; i < plainText.length() - 1; i++) {
   // plainText.charAt(i) = letters in the incoming plainText
      int indexOfPlainLetter = plainText.charAt(i);
      int indexOfCipherLetter = (indexOfPlainLetter + shiftKey) % modulus;

      char replaceValue = ((char)(int)indexOfCipherLetter);
      System.out.println(replaceValue);
      cipherText += replaceValue;

    }

    return cipherText;
  }

}
