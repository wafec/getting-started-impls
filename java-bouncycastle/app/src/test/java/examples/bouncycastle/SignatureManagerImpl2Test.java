package examples.bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;

public class SignatureManagerImpl2Test {
    @BeforeEach
    public void setUp() {
        Security.addProvider( new BouncyCastleProvider() );
    }

    @Test
    public void signMessage_validate() throws GeneralSecurityException, IOException {
        SignatureManagerImpl2 sut = new SignatureManagerImpl2(
                getClass().getResource( "/public.pem" ).getFile(),
                getClass().getResource( "/private.pem" ).getFile()
        );

        String digitalSignature = sut.signMessage( "test" );
        Boolean isValid = sut.validateMessage( "test", digitalSignature );

        Assertions.assertTrue( isValid );
    }
}
