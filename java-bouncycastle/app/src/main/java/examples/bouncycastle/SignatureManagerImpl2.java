package examples.bouncycastle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.util.Base64;

public class SignatureManagerImpl2 extends AbstractSignatureManager implements SignatureManager {
    public SignatureManagerImpl2(
            String publicKeyPemFile,
            String privateKeyPemFile
    ) {
        super( publicKeyPemFile, privateKeyPemFile );
    }
    @Override
    public String signMessage(String message) throws GeneralSecurityException, IOException {
        Signature signature = Signature.getInstance( "SHA256WithRSA" );
        signature.initSign( readPrivateKey() );
        signature.update( message.getBytes( StandardCharsets.UTF_8 ) );
        byte[] digitalSignature = signature.sign();
        return Base64.getEncoder().encodeToString( digitalSignature );
    }

    @Override
    public Boolean validateMessage(String message, String signature) throws GeneralSecurityException, IOException {
        Signature signatureAlg = Signature.getInstance( "SHA256WithRSA" );
        signatureAlg.initVerify( readPublicKey() );
        signatureAlg.update( message.getBytes( StandardCharsets.UTF_8 ) );
        return signatureAlg.verify( Base64.getDecoder().decode( signature ) );
    }
}
