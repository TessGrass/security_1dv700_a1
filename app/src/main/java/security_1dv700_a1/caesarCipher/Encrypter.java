package security_1dv700_a1.caesarCipher;

public interface Encrypter<T> {

  public String encryptPlainText(T key, String plainMessage);
}
