package security_1dv700_a1.encrypter;

public interface Decrypter<T> {

  public String decryptCipherText(T key, String encodedMessage);
}
