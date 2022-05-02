package examples.bouncycastle;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public abstract class AbstractSignatureManager {
    private final String publicKeyPemFile;
    private final String privateKeyPemFile;

    public AbstractSignatureManager(
            String publicKeyPemFile,
            String privateKeyPemFile
    ) {
        this.publicKeyPemFile = publicKeyPemFile;
        this.privateKeyPemFile = privateKeyPemFile;
    }

    protected PublicKey readPublicKey() throws GeneralSecurityException, IOException {
        KeyFactory factory = KeyFactory.getInstance( "RSA" );

        try ( FileReader keyReader = new FileReader( publicKeyPemFile ) ) {
            PemReader pemReader = new PemReader( keyReader );
            PemObject pemObject = pemReader.readPemObject();
            byte[] content = pemObject.getContent();
            X509EncodedKeySpec publicKeySpecification = new X509EncodedKeySpec( content );
            return factory.generatePublic( publicKeySpecification );
        }
    }

    protected PrivateKey readPrivateKey() throws GeneralSecurityException, IOException {
        KeyFactory factory = KeyFactory.getInstance( "RSA" );

        try ( FileReader keyReader = new FileReader( privateKeyPemFile ) ) {
            PemReader pemReader = new PemReader( keyReader );
            PemObject pemObject = pemReader.readPemObject();
            byte[] content = pemObject.getContent();
            PKCS8EncodedKeySpec privateKeySpecification = new PKCS8EncodedKeySpec( content );
            return factory.generatePrivate( privateKeySpecification );
        }
    }
}
