package java_interview;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.concurrent.*;
import java.util.logging.*;
import java.net.http.*;
import java.time.Duration;

/**
 * Comprehensive Java Networking Guide
 *
 * Covers:
 * 1. Basic Socket Programming
 * 2. Multithreaded Networking
 * 3. NIO Networking
 * 4. UDP Communication
 * 5. High-Level Networking APIs
 * 6. HTTP Communication
 * 7. WebSocket Communication
 */
public class Java15NetworkingGuide {
    private static final Logger LOGGER = Logger.getLogger(Java15NetworkingGuide.class.getName());

    // 1. Basic Socket Programming
    public static void demonstrateBasicSocketCommunication() {
        System.out.println("\n--- Basic Socket Communication ---");

        // Server Thread
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8888)) {
                System.out.println("Server listening on port 8888");
                Socket socket = serverSocket.accept();

                // Input and Output Streams
                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
                ) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Server Received: " + inputLine);
                        out.println("Server Response: " + inputLine.toUpperCase());
                    }
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Server Error", e);
            }
        }).start();

        // Client Thread
        new Thread(() -> {
            try (Socket socket = new Socket("localhost", 8888);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                // Send messages
                out.println("Hello Server");
                out.println("How are you?");

                // Read responses
                String response;
                while ((response = in.readLine()) != null) {
                    System.out.println("Client Received: " + response);
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Client Error", e);
            }
        }).start();
    }

    // 2. Multithreaded Server
    public static class MultiThreadedServer {
        public static void start() {
            System.out.println("\n--- Multithreaded Server ---");

            try (ServerSocket serverSocket = new ServerSocket(9999)) {
                System.out.println("Multithreaded Server running on port 9999");

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    // Handle each client in a separate thread
                    new ClientHandler(clientSocket).start();
                }
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Server Error", e);
            }
        }

        private static class ClientHandler extends Thread {
            private Socket clientSocket;

            public ClientHandler(Socket socket) {
                this.clientSocket = socket;
            }

            public void run() {
                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("Received: " + inputLine);
                        out.println("Response: " + inputLine);
                    }
                } catch (IOException e) {
                    LOGGER.log(Level.SEVERE, "Client Handler Error", e);
                }
            }
        }
    }

    // 3. NIO Networking
    public static void demonstrateNIONetworking() {
        System.out.println("\n--- NIO Networking ---");

        try {
            // NIO Channel Example
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));

            // ByteBuffer Operations
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put("Hello NIO".getBytes(StandardCharsets.UTF_8));
            buffer.flip();

            socketChannel.write(buffer);

            // Selector for Non-Blocking I/O
            Selector selector = Selector.open();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            selector.select();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "NIO Error", e);
        }
    }

    // 4. UDP Communication
    public static void demonstrateUDPCommunication() {
        System.out.println("\n--- UDP Communication ---");

        // UDP Server
        new Thread(() -> {
            try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("UDP Server Received: " + message);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "UDP Server Error", e);
            }
        }).start();

        // UDP Client
        new Thread(() -> {
            try (DatagramSocket clientSocket = new DatagramSocket()) {
                InetAddress IPAddress = InetAddress.getByName("localhost");
                byte[] sendData = "Hello UDP".getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "UDP Client Error", e);
            }
        }).start();
    }

    // 5. HTTP Communication with Modern APIs
    public static void demonstrateHTTPCommunication() {
        System.out.println("\n--- HTTP Communication ---");

        try {
            // HTTP Client
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // GET Request
            HttpRequest getRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.example.com/data"))
                    .build();

            HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("GET Response: " + response.body());

            // POST Request
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.example.com/post"))
                    .POST(HttpRequest.BodyPublishers.ofString("{'key':'value'}"))
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> postResponse = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("POST Response: " + postResponse.body());
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "HTTP Communication Error", e);
        }
    }

    // 6. WebSocket Communication
//    public static void demonstrateWebSocketCommunication() {
//        System.out.println("\n--- WebSocket Communication ---");
//
//        try {
//            WebSocket.Builder builder = WebSocket.newBuilder()
//                    .connectTimeout(Duration.ofSeconds(10));
//
//            WebSocket webSocket = builder.buildAsync(
//                    URI.create("ws://localhost:8080/chat"),
//                    new WebSocket.Listener() {
//                        private CompletableFuture<String> accumulatedMessage = new CompletableFuture<>();
//                        private StringBuilder messageBuffer = new StringBuilder();
//
//                        @Override
//                        public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
//                            messageBuffer.append(data);
//
//                            if (last) {
//                                String fullMessage = messageBuffer.toString();
//                                System.out.println("Received WebSocket Message: " + fullMessage);
//
//                                // Reset for next message
//                                messageBuffer = new StringBuilder();
//                                accumulatedMessage.complete(fullMessage);
//                            }
//
//                            // Continue receiving
//                            webSocket.request(1);
//                            return accumulatedMessage;
//                        }
//
//                        @Override
//                        public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
//                            System.out.println("WebSocket Closed: " + reason);
//                            return CompletableFuture.completedFuture(null);
//                        }
//                    }
//            ).join();
//
//            // Send a message
//            webSocket.sendText("Hello WebSocket!", true);
//
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "WebSocket Error", e);
//        }
//    }

    // 7. Advanced Networking Utilities
    public static class NetworkUtilities {
        // URL and URI Parsing
        public static void demonstrateURLParsing() {
            System.out.println("\n--- URL and URI Parsing ---");

            try {
                // URL Parsing
                URL url = new URL("https://www.example.com:443/path?query=value#fragment");
                System.out.println("Protocol: " + url.getProtocol());
                System.out.println("Host: " + url.getHost());
                System.out.println("Port: " + url.getPort());
                System.out.println("Path: " + url.getPath());

                // URI Creation
                URI uri = url.toURI();
                System.out.println("URI Query: " + uri.getQuery());
                System.out.println("URI Fragment: " + uri.getFragment());
            } catch (MalformedURLException | URISyntaxException e) {
                LOGGER.log(Level.SEVERE, "URL/URI Parsing Error", e);
            }
        }

        // Network Interface Exploration
        public static void demonstrateNetworkInterfaces() {
            System.out.println("\n--- Network Interfaces ---");

            try {
                Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
                while (interfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = interfaces.nextElement();

                    System.out.println("Interface Name: " + networkInterface.getName());
                    System.out.println("Display Name: " + networkInterface.getDisplayName());
                    System.out.println("Is Loopback: " + networkInterface.isLoopback());
                    System.out.println("Is Up: " + networkInterface.isUp());

                    // IP Addresses
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        System.out.println("  IP Address: " + inetAddress.getHostAddress());
                    }
                    System.out.println("---");
                }
            } catch (SocketException e) {
                LOGGER.log(Level.SEVERE, "Network Interface Error", e);
            }
        }

        // Proxy Configuration
        public static void demonstrateProxyConfiguration() {
            System.out.println("\n--- Proxy Configuration ---");

            // System-wide Proxy
            System.setProperty("http.proxyHost", "proxy.example.com");
            System.setProperty("http.proxyPort", "8080");

            // Programmatic Proxy Selection
            Proxy proxy = new Proxy(Proxy.Type.HTTP,
                    new InetSocketAddress("proxy.example.com", 8080));

            try {
                URL url = new URL("http://www.example.com");
                URLConnection connection = url.openConnection(proxy);
                connection.connect();

                System.out.println("Connected via Proxy: " + proxy);
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "Proxy Connection Error", e);
            }
        }
    }

    // 8. Secure Network Communication
    public static void demonstrateSSLCommunication() {
        System.out.println("\n--- SSL/TLS Communication ---");

        try {
            // SSL Context Initialization
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, null, null);

            // SSL Socket Factory
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();

            // Create Secure Socket
            try (SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket("secure.example.com", 443)) {
                // Enable Protocols
                sslSocket.setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.3"});

                // Handshake
                sslSocket.startHandshake();

                // Secure Communication
                try (
                        PrintWriter out = new PrintWriter(new BufferedWriter(
                                new OutputStreamWriter(sslSocket.getOutputStream())));
                        BufferedReader in = new BufferedReader(new InputStreamReader(
                                sslSocket.getInputStream()))
                ) {
                    out.println("Secure Hello");
                    out.flush();

                    String response = in.readLine();
                    System.out.println("Secure Response: " + response);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "SSL Communication Error", e);
        }
    }

    public static void main(String[] args) {
        demonstrateBasicSocketCommunication();
        MultiThreadedServer.start();
        demonstrateNIONetworking();
        demonstrateUDPCommunication();
        demonstrateHTTPCommunication();
        ///demonstrateWebSocketCommunication();

        // Additional Networking Utilities
        NetworkUtilities.demonstrateURLParsing();
        NetworkUtilities.demonstrateNetworkInterfaces();
        NetworkUtilities.demonstrateProxyConfiguration();

        demonstrateSSLCommunication();
    }
}