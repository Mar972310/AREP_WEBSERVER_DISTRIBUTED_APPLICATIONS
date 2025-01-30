package edu.escuelaing.arep;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 *
 * @author Maria Valentina Torres Monsalve
 */

public class HttpServer {
    private static final int PORT = 35000;
    private boolean running = true;
    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, URISyntaxException {
        HttpServer server = new HttpServer();
        server.startServer();
    }

    public void startServer() throws IOException, URISyntaxException {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("No se pudo iniciar el servidor en el puerto: " + PORT);
            throw e;
        }

        while (running) {
            try {
                System.out.println("Listo para recibir ...");
                Socket clientSocket = serverSocket.accept();
                HttpRequestHandler requestHandler = new HttpRequestHandler(clientSocket);
                requestHandler.handlerRequest();
            } catch (IOException e) {
                if (!running) {
                    System.out.println("Servidor detenido.");
                    break;
                }
                System.err.println("Error al aceptar conexión.");
            }
        }
    }

    public void stopServer() {
        running = false;
        if (serverSocket != null && !serverSocket.isClosed()) {
            try {
                serverSocket.close();
                System.out.println("Servidor detenido correctamente.");
            } catch (IOException e) {
                System.err.println("Error al cerrar el servidor: " + e.getMessage());
            }
        }
    }
}
