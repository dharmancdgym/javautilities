import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.net.MalformedURLException;
import java.util.concurrent.ExecutionException;

public class AzureADServiceTest {

    @Test
    public void testGetAccessTokenUsingMasterUser() throws MalformedURLException, InterruptedException, ExecutionException {
        String clientId = "your-client-id";
        String username = "your-username";
        String password = "your-password";

        String accessToken = AzureADService.getAccessTokenUsingMasterUser(clientId, username, password);

        Assertions.assertNotNull(accessToken);
        // Add more assertions to validate the access token if needed
        // For example:
        Assertions.assertTrue(accessToken.length() > 0, "Access token should not be empty");
        Assertions.assertTrue(accessToken.startsWith("Bearer "), "Access token should start with 'Bearer '");
    }

    @Test
    public void testGetAccessTokenUsingServicePrincipal() throws MalformedURLException, InterruptedException, ExecutionException {
        String clientId = "your-client-id";
        String tenantId = "your-tenant-id";
        String appSecret = "your-app-secret";

        String accessToken = AzureADService.getAccessTokenUsingServicePrincipal(clientId, tenantId, appSecret);

        Assertions.assertNotNull(accessToken);
        // Add more assertions to validate the access token if needed
        // For example:
        Assertions.assertTrue(accessToken.length() > 0, "Access token should not be empty");
        Assertions.assertTrue(accessToken.startsWith("Bearer "), "Access token should start with 'Bearer '");
    }

    @Test
    public void testGetAccessToken() throws MalformedURLException, InterruptedException, ExecutionException {
        String accessToken = AzureADService.getAccessToken();

        Assertions.assertNotNull(accessToken);
        // Add more assertions to validate the access token if needed
        // For example:
        Assertions.assertTrue(accessToken.length() > 0, "Access token should not be empty");
        Assertions.assertTrue(accessToken.startsWith("Bearer "), "Access token should start with 'Bearer '");
    }
}