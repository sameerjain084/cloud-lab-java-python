import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class JavaWeb {
    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress(8080), 0
        );

        server.createContext("/", (HttpExchange exchange) -> {

            String response = "Hello from Java Cloud Lab!";

            exchange.sendResponseHeaders(200, response.length());

            OutputStream output = exchange.getResponseBody();
            output.write(response.getBytes());
            output.close();
        });

        server.start();

        System.out.println("Java server running at http://127.0.0.1:8080");
    }
}
