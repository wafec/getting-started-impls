package examples.bouncycastle;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import javax.crypto.Cipher;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class SignatureManagerImpl extends AbstractSignatureManager implements SignatureManager {
    public SignatureManagerImpl(
            String publicKeyPemFile,
            String privateKeyPemFile
    ) {
        super( publicKeyPemFile, privateKeyPemFile );
    }

    @Override
    public String signMessage(String message) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance( "RSA" );
        cipher.init( Cipher.ENCRYPT_MODE, readPrivateKey() );
        MessageDigest messageDigest = MessageDigest.getInstance( "SHA-256" );
        byte[] messageHash = messageDigest.digest( message.getBytes( StandardCharsets.UTF_8 ) );
        byte[] signature = cipher.doFinal( messageHash );
        return Base64.getEncoder().encodeToString( signature );
    }

    @Override
    public Boolean validateMessage( String message, String signature ) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance( "RSA" );
        cipher.init( Cipher.DECRYPT_MODE, readPublicKey() );
        byte[] messageHash = cipher.doFinal( Base64.getDecoder().decode( signature ) );
        MessageDigest messageDigest = MessageDigest.getInstance( "SHA-256" );
        byte[] newMessageHash = messageDigest.digest( message.getBytes( StandardCharsets.UTF_8 ) );
        return Arrays.equals( messageHash, newMessageHash );
    }
}
