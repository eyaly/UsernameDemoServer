import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class UsernameServer {
    public static void main(String[] args) throws IOException {
        int port = 4000;

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new UsernameHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server started on port " + port);
    }
}

class UsernameHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();

        if (requestMethod.equalsIgnoreCase("GET")) {
            String path = exchange.getRequestURI().getPath();

            if (path.equals("/give_me_valid_username")) {
                String response = "standard_user";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                String response = "Invalid path";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }
}
