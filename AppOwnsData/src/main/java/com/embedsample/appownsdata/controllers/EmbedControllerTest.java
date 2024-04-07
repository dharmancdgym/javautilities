import com.embedsample.appownsdata.services.AzureADService;
import com.embedsample.appownsdata.services.PowerBIService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmbedControllerTest {

    @Mock
    private AzureADService azureADService;

    @Mock
    private PowerBIService powerBIService;

    @InjectMocks
    private EmbedController embedController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEmbedReportHome() {
        // Arrange

        // Act
        ModelAndView modelAndView = embedController.embedReportHome();

        // Assert
        assertEquals("EmbedReport", modelAndView.getViewName());
    }

    @Test
    public void testEmbedInfoController_Success() throws Exception {
        // Arrange
        String accessToken = "testAccessToken";
        String expectedResponse = "{\"embedToken\":\"testEmbedToken\",\"embedReports\":[],\"tokenExpiry\":\"testTokenExpiry\"}";

        when(azureADService.getAccessToken()).thenReturn(accessToken);
        when(powerBIService.getEmbedConfig(anyString(), anyString(), anyString())).thenReturn(new EmbedConfig());

        // Act
        ResponseEntity<String> responseEntity = embedController.embedInfoController();

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
        verify(azureADService, times(1)).getAccessToken();
        verify(powerBIService, times(1)).getEmbedConfig(anyString(), anyString(), anyString());
    }

    @Test
    public void testEmbedInfoController_Error() throws Exception {
        // Arrange
        String errorMessage = "Test error message";

        when(azureADService.getAccessToken()).thenThrow(new RuntimeException(errorMessage));

        // Act
        ResponseEntity<String> responseEntity = embedController.embedInfoController();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
        verify(azureADService, times(1)).getAccessToken();
        verify(powerBIService, never()).getEmbedConfig(anyString(), anyString(), anyString());
    }
}