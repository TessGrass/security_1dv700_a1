package security_1dv700_a1.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashTester {
  Hash hasher = new Hash();

  public void similarString(String message) {
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
   printSimilarStringResult(resultOfSpreadability, numberOfStrings);
   printOnlyUniqueHashes(resultOfUniqueHashes);
  }

  public void validateHashLength() {
    int errorMin = 0;
    int errorMax = 256;
    int numberOfErrors = 0;
    int numberOfStrings = 0;

    for (int i = 0; i < 100; i++) {
      String message = randomString();
      String hashString = hasher.hashString(message);
      int hash = Integer.valueOf(hashString);

      if (hash < errorMin || hash > errorMax) {
        numberOfErrors++;
      }
      numberOfStrings++;
    }
    printValidateHashLengthResult(numberOfErrors, numberOfStrings);
  }

  private String randomString () {
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

  private void printSimilarStringResult(Map<String, Integer> map, int numberOfStrings) {
    System.out.println("------Hash Spread among Similar Strings Result -----");
    System.out.println("Number of similar strings used: " + numberOfStrings);
    System.out.println("Hashes generated: ");
      // https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values - Tips and inspiration
    map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println); // instead of numbers.forEach(x -> System.out.println(x));
  }

  private void printValidateHashLengthResult(int numberOfErrors, int numberOfStrings) {
    System.out.println("\n------Hash Length Validation Result-----");
    System.out.println("Number of random strings used: " + numberOfStrings);
    System.out.println("Number of hash outside range 000 - 256: " + numberOfErrors);
  }

  private void printOnlyUniqueHashes(HashMap<String, Integer> uniqueHashes) {
    System.out.println("\n------Unique Hashes Result -----");
    System.out.println("Number of unique Hashes: " + uniqueHashes.size());
    System.out.println(uniqueHashes.keySet());
  }
}

