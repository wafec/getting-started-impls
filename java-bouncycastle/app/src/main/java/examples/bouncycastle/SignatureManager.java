package examples.bouncycastle;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface SignatureManager {
    String signMessage( String message ) throws GeneralSecurityException, IOException;
    Boolean validateMessage( String message, String signature ) throws GeneralSecurityException, IOException;
}
