package security_1dv700_a1;

import security_1dv700_a1.caesarCipher.Decrypter;
import security_1dv700_a1.caesarCipher.Encrypter;
import security_1dv700_a1.caesarCipher.CaesarDecrypter;
import security_1dv700_a1.caesarCipher.CaesarEncrypter;
import security_1dv700_a1.transpositionCipher.TranspositionDecrypter;
import security_1dv700_a1.transpositionCipher.TranspositionEncrypter;
import security_1dv700_a1.fileReader.TextReader;

import java.util.ArrayList;

public class Main {
  String[] engDictionary;
  String encryptedText;

  Console console = new Console();

  public void runCaesarEncrypter(int shiftKey) {
    Encrypter<Integer> caesarEncrypter = new CaesarEncrypter();
    TextReader notSoSecretMessage = new TextReader("/src/main/java/security_1dv700_a1/fileReader/notSoSecretMessage.txt");
    String plainText = notSoSecretMessage.readFromFile().toLowerCase();
    int shiftKeyEncryption = shiftKey;
    
    String cipherText = caesarEncrypter.encryptPlainText(shiftKeyEncryption, plainText);
    console.printCaesarEncryptedText(cipherText);
  }

  public void runCaesarDecrypter(int key) {
    TextReader topSecretMessage = new TextReader("/src/main/java/security_1dv700_a1/fileReader/topSecretMessage.txt");
    this.encryptedText = topSecretMessage.readFromFile().toLowerCase();
    int shiftKey = key;
    ArrayList<String> caesarString = decryptCipherText(shiftKey, this.encryptedText);
    
    console.printCaesarDecryptedText(caesarString);
  }

  private ArrayList<String> decryptCipherText(int cycles, String encodedText) {
    Decrypter<Integer> caesarDecrypter = new CaesarDecrypter();
    ArrayList<String> decryptedWords = new ArrayList<String>();
    for (int i = 1; i <= cycles; i++) {
      decryptedWords.add(caesarDecrypter.decryptCipherText(i, encodedText));
    }
    return decryptedWords;
  }

  public void runTranspositionEncrypter(int key) {
    TranspositionEncrypter transEncrypter = new TranspositionEncrypter();
    TextReader textReader = new TextReader("/src/main/java/security_1dv700_a1/fileReader/message.txt");
    String plainText = textReader.readFromFile().toLowerCase();
    String cipherText = transEncrypter.runEncrypter(key, plainText);
    
    textReader.writeToFile(cipherText);
    console.printTranspositionEncryptedText(cipherText);
    runTranspositionDecrypter(key, cipherText);

  }

  public void runTranspositionDecrypter(int key, String text) {
    TranspositionDecrypter transDecrypter = new TranspositionDecrypter();
    TextReader textReader = new TextReader("/src/main/java/security_1dv700_a1/fileReader/message.txt");
    this.encryptedText = textReader.readFromFile().toLowerCase();
    String decryptedMessage = transDecrypter.runTransDecrypter(key, text);
    
    textReader.writeToFile(decryptedMessage);
    console.printTranspositionDecryptedText(decryptedMessage);
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

