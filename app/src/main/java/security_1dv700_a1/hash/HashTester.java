package security_1dv700_a1.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;


public class HashTester {
  Hash hasher = new Hash();

  public String randomString () { // function goal: try to get hash value errors
    Random r = new Random();
    int low = 0;
    int high = 126;
    int wordLength = 15;
    String randomString = " ";

    for (int i = 0; i < wordLength; i++) {
      int result = r.nextInt(high-low) + low;
      char c = (char)(result);
      randomString += String.valueOf(c);
    }
    return randomString;
  }

  public void similarString(String message) {
    ArrayList<String> result = new ArrayList<String>();
    String sentence = message;
    int max = 10;
    String letter = "a";

    for (int i = 0; i < max; i++) {
      sentence += letter;
      String hash = hasher.hashString(sentence);
      result.add(hash);
    }
   statisticalOverview(result);
  }

  public void validateHashLength() {
    int errorMin = 0;
    int errorMax = 256;
    int numberOfErrors = 0;

    for (int i = 0; i < 50; i++) {
      String message = randomString();
      String hashString = hasher.hashString(message);
      int hash = Integer.valueOf(hashString);

    if(hash < errorMin || hash > errorMax) {
      numberOfErrors++;
    }
  }
  System.out.println(numberOfErrors);
  }

  private void statisticalOverview(ArrayList<String> result) {
      Map<String, Integer> map = new HashMap<>();
      /* Collections.sort(result); */
          for (String hash : result) {
/*             System.out.println(String.format("%03d", hash)); */
            map.put(hash, map.getOrDefault(hash, 0) + 1);
/*             map.put(hash, 1); */
          }
/*           System.out.println(map); */
/*           Stream<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream().sorted(Map.Entry.comparingByValue()); */
          map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println); // instead of numbers.forEach(x -> System.out.println(x));
}

private void randomizeString(String text) {
  int min = 48;
  int max = 122;
  int number = (int) ((Math.random() * (max - min)) + min);

} 
}

