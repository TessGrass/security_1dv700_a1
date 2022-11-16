package security_1dv700_a1.caesarCipher;

public interface Decrypter<T> {

  public String decryptCipherText(T key, String encodedMessage);
}
