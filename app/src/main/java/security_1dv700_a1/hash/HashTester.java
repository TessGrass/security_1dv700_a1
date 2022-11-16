package security_1dv700_a1.hash;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import java.util.ArrayList;
import security_1dv700_a1.Console;

public class HashTester {
  Hash hasher = new Hash();
  Console console = new Console();

  public void testWithSimilarString(String message) {
    ArrayList<String> result = new ArrayList<String>();
    String sentence = message;
    String letter = "a";
    int numberOfStrings = 2000;

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

  public void validateHashLength() {
    int errorMin = 0;
    int errorMax = 256;
    int numberOfErrors = 0;
    int numberOfStrings = 0;

    for (int i = 0; i < 100; i++) {
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

  private String generateRandomString () {
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

  private Map<String, Integer> countSpreadOfTestedHashes(ArrayList<String> result) {
    Map<String, Integer> map = new HashMap<>();

    for (String hash : result) {
      map.put(hash, map.getOrDefault(hash, 0) + 1);
    }
    return map;
  }

  private HashMap<String, Integer> countUniqueHashes(ArrayList <String> result) {
    HashMap<String, Integer> uniqueHashes = new HashMap<>();

    for (int i = 0; i < result.size(); i++) {
      uniqueHashes.put(result.get(i), i);
    }
    return uniqueHashes;
  }
}

