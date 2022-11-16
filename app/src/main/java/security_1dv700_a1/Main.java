package security_1dv700_a1;

import security_1dv700_a1.caesarCipher.Decrypter;
import security_1dv700_a1.caesarCipher.Encrypter;
import security_1dv700_a1.caesarCipher.CaesarDecrypter;
import security_1dv700_a1.caesarCipher.CaesarEncrypter;
import security_1dv700_a1.transpositionCipher.TranspositionDecrypter;
import security_1dv700_a1.transpositionCipher.TranspositionEncrypter;
import security_1dv700_a1.fileReader.TextReader;

public class Main {
  String encryptedText;

  Console console = new Console();

  public void runCaesarEncrypter(int shiftKey) {
    Encrypter<Integer> caesarEncrypter = new CaesarEncrypter();
    TextReader textReader = new TextReader("/src/main/java/security_1dv700_a1/fileReader/messageCaesar.txt");
    String plainText = textReader.readFromFile().toLowerCase();
    String cipherText = caesarEncrypter.encryptPlainText(shiftKey, plainText);

    textReader.writeToFile(cipherText);
    console.printCaesarEncryptedText(cipherText);
  }

  public void runCaesarDecrypter(int key) {
    Decrypter<Integer> caesarDecrypter = new CaesarDecrypter();
    TextReader textReader = new TextReader("/src/main/java/security_1dv700_a1/fileReader/messageCaesar.txt");
    String encryptedText = textReader.readFromFile().toLowerCase(); 
    String decryptedText = caesarDecrypter.decryptCipherText(key, encryptedText);

    textReader.writeToFile(decryptedText);
    console.printCaesarDecryptedText(decryptedText);
  }

  public void runTranspositionEncrypter(int key) {
    TranspositionEncrypter transEncrypter = new TranspositionEncrypter();
    TextReader textReader = new TextReader("/src/main/java/security_1dv700_a1/fileReader/message.txt");
    String plainText = textReader.readFromFile().toLowerCase();
    String cipherText = transEncrypter.runEncrypter(key, plainText);
    
    textReader.writeToFile(cipherText);
    console.printTranspositionEncryptedText(cipherText);
  }

  public void runTranspositionDecrypter(int key) {
    TranspositionDecrypter transDecrypter = new TranspositionDecrypter();
    TextReader textReader = new TextReader("/src/main/java/security_1dv700_a1/fileReader/message.txt");
    String encryptedText = textReader.readFromFile().toLowerCase();
    String decryptedMessage = transDecrypter.runTransDecrypter(key, encryptedText);
    
    textReader.writeToFile(decryptedMessage);
    console.printTranspositionDecryptedText(decryptedMessage);
  }

  private void writeToFile(String text) {

  }






/*   private boolean isWordValid(String sentence) {
    String[] strArray = sentence.split(" ");
    for (String s : strArray) {
      for (String w : engDictionary) {
           if (w.equals(s)) {
            return true;
           }
       }
  }
  return false;
} */
}

