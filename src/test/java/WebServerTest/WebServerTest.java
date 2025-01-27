package WebServerTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import edu.escuelaing.arep.HttpServer;

public class WebServerTest {

    private static final String URL = "http://localhost:35000/";
    private static boolean isHttpServerStarted = false;
    private static HttpServer socket;


    @Before
    public void setUp() throws IOException, URISyntaxException {
        if (!isHttpServerStarted) {
            startHttpServer();
        }
    }

    private static void startHttpServer() throws IOException, URISyntaxException {
        try {
            socket = new HttpServer();
            socket.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldLoadStaticFile() throws Exception {
        String file = "/index.html";
        try {
            URL requestUrl = new URL(URL + file);
            HttpURLConnection request = (HttpURLConnection) requestUrl.openConnection();
            request.setRequestMethod("GET");
            int responseCode = request.getResponseCode();
            assertEquals(200, responseCode);
            socket.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
