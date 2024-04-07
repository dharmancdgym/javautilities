import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportConfigTest {

    @Test
    public void testGetJSONObject() {
        ReportConfig reportConfig = new ReportConfig();
        reportConfig.reportId = "123";
        reportConfig.embedUrl = "https://example.com/report";
        reportConfig.reportName = "Sales Report";

        String expectedJson = "{\"reportId\":\"123\",\"embedUrl\":\"https://example.com/report\",\"reportName\":\"Sales Report\"}";

        Assertions.assertEquals(expectedJson, reportConfig.getJSONObject().toString());
    }

    @Test
    public void testDefaultValues() {
        ReportConfig reportConfig = new ReportConfig();

        Assertions.assertEquals("", reportConfig.reportId);
        Assertions.assertEquals("", reportConfig.embedUrl);
        Assertions.assertEquals("", reportConfig.reportName);
        Assertions.assertFalse(reportConfig.isEffectiveIdentityRolesRequired);
        Assertions.assertFalse(reportConfig.isEffectiveIdentityRequired);
        Assertions.assertFalse(reportConfig.enableRLS);
        Assertions.assertNull(reportConfig.username);
        Assertions.assertNull(reportConfig.roles);
    }
}