package security_1dv700_a1;

import security_1dv700_a1.encrypter.CaesarEncrypter;
import security_1dv700_a1.encrypter.CaesarDecrypter;
import security_1dv700_a1.encrypter.Encrypter;
import security_1dv700_a1.encrypter.Decrypter;
import security_1dv700_a1.fileReader.TextReader;

import java.util.ArrayList;

public class Main {
  String[] engDictionary;
  String plainText;
  String encryptedText;

  Encrypter<Integer> caesarEncrypter = new CaesarEncrypter();
  Decrypter<Integer> caesarDecrypter = new CaesarDecrypter();

  public Main() {
    TextReader englishDictionary = new TextReader("/src/main/java/fileReader/englishWords.txt");
    TextReader topSecretMessage = new TextReader("/src/main/java/fileReader/topSecretMessage.txt");
    this.encryptedText = topSecretMessage.readFromFile().toLowerCase();
    this.engDictionary = englishDictionary.readFromFile().split("\n");
  }

  public String runEncrypter(int shiftKey) {
    TextReader notSoSecretMessage = new TextReader("/src/main/java/fileReader/notSoSecretMessage.txt");
    this.plainText = notSoSecretMessage.readFromFile().toLowerCase();
    int shiftKeyEncryption = shiftKey;
    
    String cipherText = caesarEncrypter.encryptPlainText(shiftKeyEncryption, this.plainText);
    return cipherText;
  }


  public ArrayList<String> runDecrypter(int rotation) {
    int keyRotation = rotation;
    ArrayList<String> caesarString = decryptCipherText(keyRotation, this.encryptedText);
    
    printDecryptedText(caesarString);
    return caesarString;
  }

  public void printDecryptedText(ArrayList<String> decryptedText) {
    int shiftKeyDecryption = 1;

    for (String s : decryptedText) {
      System.out.println("Key " + shiftKeyDecryption + ": " + s);
       shiftKeyDecryption++;
      }

  }
  private ArrayList<String> decryptCipherText(int cycles, String encodedText) {
    ArrayList<String> decryptedWords = new ArrayList<String>();
    for (int i = 1; i <= cycles; i++) {
      decryptedWords.add(caesarDecrypter.decryptCipherText(i, encodedText));
    }
    return decryptedWords;
  }

  private boolean isWordValid(String sentence) {
    String[] strArray = sentence.split(" ");
    for (String s : strArray) {
      for (String w : engDictionary) {
           if (w.equals(s)) {
            return true;
           }
       }
  }
  return false;
}
}

