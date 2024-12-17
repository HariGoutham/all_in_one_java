package java_interview;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

/**
 * Comprehensive Java I/O and Exception Handling Guide
 *
 * Topics Covered:
 * 1. Introduction to Exception Handling
 * 2. Checked vs. Unchecked Exceptions
 * 3. Try-with-Resources
 * 4. File and Path Handling
 * 5. Directory Operations
 * 6. File Reading Techniques
 * 7. File Writing Techniques
 * 8. File and Directory Manipulation
 * 9. Serialization
 */
public class Java13IOExceptionHandlingGuide {

    // 1. Exception Handling Demonstration
    public static void demonstrateExceptionHandling() {
        System.out.println("--- Exception Handling ---");

        try {
            // Intentional division by zero to trigger exception
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
    }

    // 2. Checked vs. Unchecked Exceptions
    public static void demonstrateExceptionTypes() {
        System.out.println("\n--- Exception Types ---");

        // Unchecked Exception (Runtime Exception)
        try {
            String str = null;
            System.out.println(str.length()); // NullPointerException
        } catch (RuntimeException e) {
            System.out.println("Unchecked Exception: " + e);
        }

        // Checked Exception
        try {
            // Simulating a checked exception
            readFile("nonexistent.txt");
        } catch (IOException e) {
            System.out.println("Checked Exception: " + e);
        }
    }

    // Method with checked exception
    private static void readFile(String filename) throws IOException {
        throw new IOException("File not found");
    }

    // 3. Try-with-Resources Demonstration
    public static void demonstrateTryWithResources() {
        System.out.println("\n--- Try-with-Resources ---");

        // Automatic resource management
        try (
                FileInputStream fis = new FileInputStream("sample.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    // 4. File and Path Handling
    public static void demonstrateFileAndPathHandling() {
        System.out.println("\n--- File and Path Handling ---");

        // Creating Path objects
        Path path = Paths.get("sample.txt");

        System.out.println("File Name: " + path.getFileName());
        System.out.println("Parent Directory: " + path.getParent());
        System.out.println("Absolute Path: " + path.toAbsolutePath());
    }

    // 5. Directory Operations
    public static void demonstrateDirectoryOperations() {
        System.out.println("\n--- Directory Operations ---");

        // List directory contents
        try {
            Path dir = Paths.get(".");

            // Simple directory listing
            System.out.println("Directory Contents:");
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
                for (Path entry : stream) {
                    System.out.println(entry.getFileName());
                }
            }

            // Recursive directory walk
            System.out.println("\nRecursive Directory Walk:");
            Files.walk(dir)
                    .filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Directory operation error: " + e);
        }
    }

    // 6. File Reading Techniques
    public static void demonstrateFileReading() {
        System.out.println("\n--- File Reading Techniques ---");

        // Using Scanner
        try (Scanner scanner = new Scanner(new File("sample.txt"))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        }

        // Using Files.readAllLines()
        try {
            List<String> lines = Files.readAllLines(
                    Paths.get("sample.txt"),
                    Charset.defaultCharset()
            );
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    // 7. File Writing Techniques
    public static void demonstrateFileWriting() {
        System.out.println("\n--- File Writing Techniques ---");

        // Using BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            writer.write("Hello, World!");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Writing error: " + e);
        }

        // Using Files.write()
        try {
            List<String> lines = Arrays.asList("Line 1", "Line 2", "Line 3");
            Files.write(
                    Paths.get("output.txt"),
                    lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("File write error: " + e);
        }
    }

    // 8. File Manipulation
    public static void demonstrateFileManipulation() {
        System.out.println("\n--- File Manipulation ---");

        try {
            // Copying files
            Files.copy(
                    Paths.get("source.txt"),
                    Paths.get("destination.txt"),
                    StandardCopyOption.REPLACE_EXISTING
            );

            // Deleting files
            Files.deleteIfExists(Paths.get("temp.txt"));
        } catch (IOException e) {
            System.out.println("File manipulation error: " + e);
        }
    }

    // 9. Serialization Demonstration
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + "}";
        }
    }

    public static void demonstrateSerialization() {
        System.out.println("\n--- Serialization ---");

        Person person = new Person("John Doe", 30);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("person.ser"))) {
            oos.writeObject(person);
        } catch (IOException e) {
            System.out.println("Serialization error: " + e);
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("person.ser"))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e);
        }
    }

    // Additional Advanced File Handling Techniques
    public static void demonstrateAdvancedFileOperations() {
        System.out.println("\n--- Advanced File Operations ---");

        // Random Access File Demonstration
        try (RandomAccessFile randomFile = new RandomAccessFile("random.txt", "rw")) {
            // Writing to specific positions
            randomFile.writeUTF("Hello");
            randomFile.seek(0);

            // Reading from specific positions
            String content = randomFile.readUTF();
            System.out.println("Random Access Content: " + content);
        } catch (IOException e) {
            System.out.println("Random Access File Error: " + e);
        }
    }

    // Custom Exception Creation
    public static class CustomFileException extends Exception {
        public CustomFileException(String message) {
            super(message);
        }
    }

    // Exception Chaining and Handling
    public static void demonstrateExceptionChaining() {
        System.out.println("\n--- Exception Chaining ---");

        try {
            processFile("example.txt");
        } catch (CustomFileException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());

            // Original cause investigation
            if (e.getCause() != null) {
                System.out.println("Original Cause: " + e.getCause());
            }
        }
    }

    private static void processFile(String filename) throws CustomFileException {
        try {
            // Simulated file processing with potential errors
            if (!new File(filename).exists()) {
                throw new FileNotFoundException("File not found: " + filename);
            }
        } catch (FileNotFoundException e) {
            // Exception chaining
            throw new CustomFileException("Processing failed for " + filename);
        }
    }

    // Advanced NIO.2 File Watching
    public static void demonstrateFileWatching() {
        System.out.println("\n--- File Watching Service ---");

        try {
            Path dir = Paths.get(".");
            WatchService watchService = FileSystems.getDefault().newWatchService();

            dir.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE
            );

            // Non-blocking watch (would typically be in a separate thread)
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println(
                            "Event kind: " + event.kind() +
                                    " - File affected: " + event.context()
                    );
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("File watching error: " + e);
        }
    }

    // Character Encoding Handling
    public static void demonstrateCharacterEncoding() {
        System.out.println("\n--- Character Encoding ---");

        try {
            // Reading with specific character encoding
            Path path = Paths.get("unicode.txt");
            List<String> lines = Files.readAllLines(
                    path,
                    Charset.forName("UTF-8")
            );

            lines.forEach(line -> {
                System.out.println("Line: " + line);
                // Demonstrate character-level analysis
                line.chars().forEach(ch ->
                        System.out.println("Char: " + (char)ch + ", Unicode: " + ch)
                );
            });
        } catch (IOException e) {
            System.out.println("Encoding error: " + e);
        }
    }

    // Temporary File Handling
    public static void demonstrateTemporaryFiles() {
        System.out.println("\n--- Temporary File Handling ---");

        try {
            // Create temporary file
            Path tempFile = Files.createTempFile("prefix", ".txt");
            System.out.println("Temporary File Created: " + tempFile);

            // Write to temporary file
            Files.write(tempFile, "Temporary content".getBytes());

            // Delete on exit (optional)
            tempFile.toFile().deleteOnExit();
        } catch (IOException e) {
            System.out.println("Temporary file error: " + e);
        }
    }

    // Comprehensive Error Handling Strategy
    public static void demonstrateComprehensiveErrorHandling() {
        System.out.println("\n--- Comprehensive Error Handling ---");

        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println("Uncaught exception in thread " + thread);
            throwable.printStackTrace();
        });

        // Example of logging unhandled exceptions
        try {
            // Simulated risky operation
            int[] array = new int[5];
            System.out.println(array[10]); // Will cause ArrayIndexOutOfBoundsException
        } catch (Exception e) {
            // Comprehensive logging
            System.err.println("Error Details:");
            System.err.println("Message: " + e.getMessage());
            System.err.println("Exception Type: " + e.getClass().getName());

            // Log stack trace
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        demonstrateExceptionHandling();
        demonstrateExceptionTypes();
        demonstrateTryWithResources();
        demonstrateFileAndPathHandling();
        demonstrateFileReading();
        demonstrateFileWriting();
        demonstrateFileManipulation();
        demonstrateSerialization();
        demonstrateDirectoryOperations();
        demonstrateAdvancedFileOperations();
        demonstrateExceptionChaining();
        demonstrateFileWatching();
        demonstrateCharacterEncoding();
        demonstrateTemporaryFiles();
        demonstrateComprehensiveErrorHandling();
    }
}