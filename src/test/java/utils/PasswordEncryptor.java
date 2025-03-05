package utils;

import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Base64;

import static java.security.spec.MGF1ParameterSpec.SHA256;
import static javax.crypto.spec.PSource.PSpecified.DEFAULT;

public class PasswordEncryptor {
    private static final String ALGORITHM = "RSA";
    private static final String MD_NAME = "SHA-256";
    private static final String MGF_NAME = "MGF1";
    private static final String TRANSFORMATION = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String SEPARATOR = "|";

    public static String encryptPassword(String password, String publicKey) {
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        String passwordFinal = password + SEPARATOR + now;

        byte[] decodePublicKey = Base64.getDecoder().decode(publicKey);

        try {
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodePublicKey);
            PublicKey rsaKey = KeyFactory.getInstance(ALGORITHM).generatePublic(keySpec);

            // Encrypt plaintext for the 'RSA_DECRYPT_OAEP_2048_SHA256' key.
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            OAEPParameterSpec oaepParams = new OAEPParameterSpec(MD_NAME, MGF_NAME, SHA256, DEFAULT);

            cipher.init(Cipher.ENCRYPT_MODE, rsaKey, oaepParams);
            byte[] bytesPass = passwordFinal.getBytes(StandardCharsets.UTF_8);

            return new String(Base64.getEncoder().encode(cipher.doFinal(bytesPass)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
