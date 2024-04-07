import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigTest {

    @Test
    public void testDebugMode() {
        boolean debug = Config.DEBUG;
        Assertions.assertFalse(debug);
    }

    @Test
    public void testAuthenticationType() {
        String authenticationType = Config.authenticationType;
        Assertions.assertEquals("", authenticationType);
    }

    @Test
    public void testWorkspaceId() {
        String workspaceId = Config.workspaceId;
        Assertions.assertEquals("", workspaceId);
    }

    @Test
    public void testReportId() {
        String reportId = Config.reportId;
        Assertions.assertEquals("", reportId);
    }

    @Test
    public void testClientId() {
        String clientId = Config.clientId;
        Assertions.assertEquals("", clientId);
    }

    @Test
    public void testPbiUsername() {
        String pbiUsername = Config.pbiUsername;
        Assertions.assertEquals("", pbiUsername);
    }

    @Test
    public void testPbiPassword() {
        String pbiPassword = Config.pbiPassword;
        Assertions.assertEquals("", pbiPassword);
    }

    @Test
    public void testTenantId() {
        String tenantId = Config.tenantId;
        Assertions.assertEquals("", tenantId);
    }

    @Test
    public void testAppSecret() {
        String appSecret = Config.appSecret;
        Assertions.assertEquals("", appSecret);
    }

    @Test
    public void testAuthorityUrl() {
        String authorityUrl = Config.authorityUrl;
        Assertions.assertEquals("https://login.microsoftonline.com/", authorityUrl);
    }

    @Test
    public void testScopeBase() {
        String scopeBase = Config.scopeBase;
        Assertions.assertEquals("https://analysis.windows.net/powerbi/api/.default", scopeBase);
    }
}