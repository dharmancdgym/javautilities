import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class PowerBIServiceTest {

    @Test
    public void testGetEmbedConfig() throws Exception {
        String accessToken = "your-access-token";
        String workspaceId = "your-workspace-id";
        String reportId = "your-report-id";
        String datasetId = "your-dataset-id";

        EmbedConfig embedConfig = PowerBIService.getEmbedConfig(accessToken, workspaceId, reportId, datasetId);

        Assertions.assertNotNull(embedConfig);
        Assertions.assertNotNull(embedConfig.embedReports);
        Assertions.assertEquals(1, embedConfig.embedReports.size());
        Assertions.assertNotNull(embedConfig.embedToken);
    }

    @Test
    public void testGetEmbedConfigMultipleReports() throws Exception {
        String accessToken = "your-access-token";
        String workspaceId = "your-workspace-id";
        List<String> reportIds = Arrays.asList("report-id-1", "report-id-2");
        List<String> datasetIds = Arrays.asList("dataset-id-1", "dataset-id-2");

        EmbedConfig embedConfig = PowerBIService.getEmbedConfig(accessToken, workspaceId, reportIds, datasetIds);

        Assertions.assertNotNull(embedConfig);
        Assertions.assertNotNull(embedConfig.embedReports);
        Assertions.assertEquals(2, embedConfig.embedReports.size());
        Assertions.assertNotNull(embedConfig.embedToken);
    }

    @Test
    public void testGetEmbedConfigMultipleReportsEmptyIds() throws Exception {
        String accessToken = "your-access-token";
        String workspaceId = "your-workspace-id";
        List<String> reportIds = Arrays.asList();
        List<String> datasetIds = Arrays.asList();

        Assertions.assertThrows(RuntimeException.class, () -> {
            PowerBIService.getEmbedConfig(accessToken, workspaceId, reportIds, datasetIds);
        });
    }

    @Test
    public void testGetEmbedConfigInvalidReportId() throws Exception {
        String accessToken = "your-access-token";
        String workspaceId = "your-workspace-id";
        String reportId = "";

        Assertions.assertThrows(RuntimeException.class, () -> {
            PowerBIService.getEmbedConfig(accessToken, workspaceId, reportId);
        });
    }

    @Test
    public void testGetEmbedConfigInvalidWorkspaceId() throws Exception {
        String accessToken = "your-access-token";
        String workspaceId = "";
        String reportId = "your-report-id";
        String datasetId = "your-dataset-id";

        Assertions.assertThrows(RuntimeException.class, () -> {
            PowerBIService.getEmbedConfig(accessToken, workspaceId, reportId, datasetId);
        });
    }
}