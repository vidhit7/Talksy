package group.chatting.application;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES {

    private static final String key = "1234567890123456"; // 16-byte key for AES-128

    public static String encrypt(String strToEncrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(strToEncrypt.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decrypt(String strToDecrypt) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(strToDecrypt));
        return new String(decrypted);
    }
}
