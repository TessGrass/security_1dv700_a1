package security_1dv700_a1.hash;

import java.util.Hashtable;

public class Hash {
  int test = 0;
  int numberOfErrors = 0;

  public String hashString (String theMessage) {
    String message = theMessage;
    int max = 256;
    int hash = 0;

    for (int i = 0; i < message.length(); i++) {
      char character = message.charAt(i);
      int ascii = (int) character;      
      hash += (ascii * (message.length() - i));
    }

    hash = (int)(hash % max);

    String hashedString = String.format("%03d", hash);
    return hashedString;
  }
}