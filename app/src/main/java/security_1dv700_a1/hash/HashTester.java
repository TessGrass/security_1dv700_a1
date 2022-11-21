package security_1dv700_a1.hash;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import security_1dv700_a1.Console;

public class HashTester {
  Hash hasher = new Hash();
  Console console = new Console();

  public void addLetterToString(String message) {
    ArrayList<String> result = new ArrayList<String>();
    String sentence = message;
    String letter = "a";
    int numberOfStrings = 3000;

    for (int i = 0; i < numberOfStrings; i++) {
      sentence += letter;
      String hash = hasher.hashString(sentence);
      result.add(hash);
    }
   Map<String, Integer> resultOfSpreadability = countSpreadOfTestedHashes(result);
   HashMap<String, Integer> resultOfUniqueHashes = countUniqueHashes(result);
   console.printSimilarStringResult(resultOfSpreadability, numberOfStrings);
   console.printOnlyUniqueHashes(resultOfUniqueHashes);
  }

  public void changeLetterInString() {
    ArrayList<String> result = new ArrayList<String>();
    String testString = "Alan Turings work gave the Allies the edge they needed to win the war in Europe.";
    char[] charArray = testString.toCharArray();
    Random random = new Random();
    Boolean isCharEqual = true;
    char character = ' ';
    String sentence = "";
    int ranNum = 0;
    int cycles = 2000;

    for (int i = 0; i < cycles; i++) {
      character = (char)(random.nextInt(26) + 'a');
    
      while (isCharEqual) {
        character = (char)(random.nextInt(26) + 'a');
        ranNum = random.nextInt(charArray.length - 0) + 0;
        isCharEqual = isCharacterEqual(character, charArray[ranNum]);
      }

      charArray[ranNum] = character;
      sentence += charArray[ranNum];
      String hash = hasher.hashString(sentence);
      result.add(hash);
      isCharEqual = true;
    }

    Map<String, Integer> resultOfSpreadability = countSpreadOfTestedHashes(result);
    HashMap<String, Integer> resultOfUniqueHashes = countUniqueHashes(result);
    console.printSimilarStringResult(resultOfSpreadability, cycles);
    console.printOnlyUniqueHashes(resultOfUniqueHashes);
  }

  private Boolean isCharacterEqual(char a, char b) {
    int compare = Character.compare(a, b);
      if (compare == 0) {;
        return true;
      }
      return false;
  }

  public void validateHashLength() {
    int errorMin = 0;
    int errorMax = 256;
    int numberOfErrors = 0;
    int numberOfStrings = 0;

    for (int i = 0; i < 1000; i++) {
      String message = generateRandomString();
      String hashString = hasher.hashString(message);
      int hash = Integer.valueOf(hashString);

      if (hash < errorMin || hash > errorMax) {
        numberOfErrors++;
      }
      numberOfStrings++;
    }
    console.printValidateHashLengthResult(numberOfErrors, numberOfStrings);
  }

  private String generateRandomString() {
    Random random = new Random();
    int low = 0;
    int high = 126;
    int wordLength = 15;
    String randomString = " ";

    for (int i = 0; i < wordLength; i++) {
      int result = random.nextInt(high-low) + low;
      char character = (char)(result);
      randomString += String.valueOf(character);
    }
    return randomString;
  }

  /**
   *  A helper method that automatically counts how many times a hash number was generated. 
   * @param result
   * @return
   */
  private Map<String, Integer> countSpreadOfTestedHashes(ArrayList<String> result) {
    Map<String, Integer> map = new HashMap<>();

    for (String hash : result) {
      map.put(hash, map.getOrDefault(hash, 0) + 1);
    }
    return map;
  }

  /**
   * A helper method that automatically counts how many of the possible 256 hash values that was generated.
   * @param result - 
   * @return
   */
  private HashMap<String, Integer> countUniqueHashes(ArrayList <String> result) {
    HashMap<String, Integer> uniqueHashes = new HashMap<>();

    for (int i = 0; i < result.size(); i++) {
      uniqueHashes.put(result.get(i), i);
    }
    return uniqueHashes;
  }
}

