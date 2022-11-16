package security_1dv700_a1.hash;

import java.util.Hashtable;


public class Hash {
  int test = 0;
  int numberOfErrors = 0;

  public int hashString (String theMessage) {
    String message = theMessage;
    int max = 256;
    int hash = 0;
    int add = 37;
/*     getNumberFromHashModule(); */

      for (int i = 0; i < message.length(); i++) {
        char character = message.charAt(i);
        int ascii = (int) character;
        Boolean isNumberEven = isNumberEven(ascii);

/*         if (isNumberEven) {
          hash = hash + ((ascii - message.length() + 1) * message.length() + 2);
        } else {
          hash = hash + ((ascii - message.length() + 1) * (i + 1));
        } */

            hash = hash + (ascii * (i + ascii * ascii));
/*         hash = hash + ascii + (ascii * i) * 2; */
/*         hash = hash % max; */
      }
      hash = (int)(hash % max);
      /* System.out.println(hash); */
/*       System.out.println(String.format("%03d", hash)); */

      return hash;
}

private Boolean isNumberEven(int number) {
  if(number % 2 == 0) {
    return true;
  }
  return false;
}
/* private int getNumberFromHashModule (String s) {
  Hashtable<String, Integer> table = new Hashtable<String, Integer>();
  table.put("a", 43);
  table.put("b", 230);
  table.put("f", 2);
  table.put("r", 64);
  table.put("c", 125);
  table.put("v", 92);
  table.put("t", 23);
  table.put("n", 120);
  table.put("p", 5);
  table.put("s", 84);
  table.put("g", 33);

  int res = (int) s;
  if (table.containsKey(s)) {
    int value = table.get(s);
    res = value;
  }

  return res;
} */

}