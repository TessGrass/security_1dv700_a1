package security_1dv700_a1.encrypter;

public interface Encrypter<T> {

  public String encryptPlainText(T key, String plainMessage);
}
