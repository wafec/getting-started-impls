package examples.bouncycastle;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.Security;
import java.util.Optional;

public class SignatureManagerImplTest {
    @BeforeEach
    public void setUp() {
        Security.addProvider(new BouncyCastleProvider() );
    }

    @Test
    public void signMessage_validateMessage() throws GeneralSecurityException, IOException {
        SignatureManagerImpl sut = new SignatureManagerImpl(
                getClass().getResource("/public.pem").getFile(),
                getClass().getResource("/private.pem").getFile()
        );

        String signature = sut.signMessage( "test" );
        Boolean validate = sut.validateMessage( "test", signature );

        Assertions.assertTrue( validate );
    }
}
