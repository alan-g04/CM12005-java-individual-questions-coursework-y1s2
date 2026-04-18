import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VigenereCipher implements Cipher {

    public VigenereCipher() {}

    public String encrypt(String message_filename, String key_filename) {
        if (message_filename == null || key_filename == null) return null;
        
        String message = readFile(message_filename);
        String key = readFile(key_filename);
        
        if (message == null || key == null) return null;

        message = message.toUpperCase();
        key = key.toUpperCase();

        if (message.isEmpty() || key.isEmpty()) return message;

        String preparedKey = prepareKey(message, key);
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char m = message.charAt(i);
            char k = preparedKey.charAt(i);
            
            if (Character.isLetter(m) && Character.isLetter(k)) {
                int shift = k - 'A';
                char encryptedChar = (char) (((m - 'A') + shift) % 26 + 'A');
                encrypted.append(encryptedChar);
            } else {
                encrypted.append(m);
            }
        }

        return encrypted.toString();
    }

    public String decrypt(String message_filename, String key_filename) {
        if (message_filename == null || key_filename == null) return null;
        
        String message = readFile(message_filename);
        String key = readFile(key_filename);
        
        if (message == null || key == null) return null;

        message = message.toUpperCase();
        key = key.toUpperCase();

        if (message.isEmpty() || key.isEmpty()) return message;

        String preparedKey = prepareKey(message, key);
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char m = message.charAt(i);
            char k = preparedKey.charAt(i);
            
            if (Character.isLetter(m) && Character.isLetter(k)) {
                int shift = k - 'A';
                char decryptedChar = (char) (((m - 'A') - shift + 26) % 26 + 'A');
                decrypted.append(decryptedChar);
            } else {
                decrypted.append(m);
            }
        }

        return decrypted.toString();
    }

    private String prepareKey(String message, String key) {
        int targetLength = message.length();
        StringBuilder repeated = new StringBuilder();

        while (repeated.length() < targetLength) {
            repeated.append(key);
        }

        String trimmed = repeated.substring(0, targetLength);
        return new StringBuilder(trimmed).reverse().toString();
    }

    private String readFile(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename))).trim();
        } catch (IOException e) {
            return null; 
        }
    }
}