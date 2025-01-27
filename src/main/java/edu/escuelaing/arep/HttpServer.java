
package edu.escuelaing.arep;
import java.net.*;
import java.io.*;
/**
 *
 * @author maritzamonsalvebautista
 */
public class HttpServer {
    private static final int port = 8080;
    private static boolean running= true;
    
    public HttpServer(){
        
    }
    
    public static void main(String[] args) throws IOException, URISyntaxException{
        HttpServer server = new HttpServer();
        server.startServer();
     
    }
    
    private void startServer() throws IOException, URISyntaxException{
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }  
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
                HttpRequestHandler requestHandler = new HttpRequestHandler(clientSocket);
                requestHandler.handlerRequest();
                
                
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
        }
    }
    
    
    
    
    
}
