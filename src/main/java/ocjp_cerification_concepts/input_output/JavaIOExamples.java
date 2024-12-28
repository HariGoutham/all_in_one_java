package ocjp_cerification_concepts.input_output;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class JavaIOExamples {

    // 1. Basics of Java IO
    // 1.1 Understanding Streams
    // A stream is a sequence of data.
    // Types of streams: Byte Streams and Character Streams.

    // 1.2 Java IO Hierarchy
    // Common root classes/interfaces: InputStream, OutputStream, Reader, Writer.

    // 1.3 File and Stream Differences
    // Files are persistent data storage, while streams are used to transfer data.

    // 2. Byte Streams
    public void byteStreamsExample() {
        // 2.1 InputStream Example
        try (InputStream inputStream = new FileInputStream("input.txt")) {
            int data;
            while ((data = inputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 2.2 OutputStream Example
        try (OutputStream outputStream = new FileOutputStream("output.txt")) {
            String content = "Hello, Byte Streams!";
            outputStream.write(content.getBytes());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // 3. Character Streams
    public void characterStreamsExample() {
        // 3.1 Reader Example
        try (Reader reader = new FileReader("input.txt")) {
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 3.2 Writer Example
        try (Writer writer = new FileWriter("output.txt")) {
            writer.write("Hello, Character Streams!");
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 3.3 BufferedReader Example
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // 4. File IO
    public void fileIOExample() {
        File file = new File("example.txt");
        try {
            // 4.1 File Class Methods
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            System.out.println("File exists: " + file.exists());
            System.out.println("File length: " + file.length() + " bytes");
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Is file: " + file.isFile());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // 5. Standard Streams
    public void standardStreamsExample() {
        // 5.1 Predefined Streams
        System.out.println("Enter your name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        // 5.2 Redirecting Standard Output
        try (PrintStream out = new PrintStream(new FileOutputStream("output.txt"))) {
            System.setOut(out);
            System.out.println("This will be written to the file.");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage());
        }
    }

    // 6. Serialization
    public void serializationExample() {
        // 6.1 Overview
        try {
            // Serialize
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            MyObject obj = new MyObject("Hello", 123);
            oos.writeObject(obj);
            oos.close();

            // Deserialize
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
            MyObject deserializedObj = (MyObject) ois.readObject();
            ois.close();
            System.out.println("Deserialized Object: " + deserializedObj);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    // 7. Advanced Topics
    public void advancedIOExample() {
        // 7.1 Random Access Files
        try (RandomAccessFile raf = new RandomAccessFile("example.txt", "rw")) {
            raf.writeBytes("Hello, Random Access File!");
            raf.seek(0); // Move to the beginning
            System.out.println("Data: " + raf.readLine());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        // 7.2 Piped Streams
        // Example of PipedInputStream and PipedOutputStream would require threading, so it's omitted for brevity.

        // 7.3 Pushback Streams
        try (PushbackInputStream pushbackInputStream = new PushbackInputStream(new FileInputStream("input.txt"))) {
            int data;
            while ((data = pushbackInputStream.read()) != -1) {
                if (data == 'x') {
                    pushbackInputStream.unread(data); // Push back 'x'
                } else {
                    System.out.print((char) data);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // 8. New IO (NIO) Overview
    public void nioExample() {
        try {
            Path path = Paths.get("nio_example.txt");
            Files.write(path, "Hello, NIO!".getBytes());
            String content = new String(Files.readAllBytes(path));
            System.out.println("NIO File Content: " + content);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    // 9. Best Practices
    public void bestPractices() {
        // Always close streams in a finally block or use try-with-resources
        // Use buffered streams for better performance
        // Prefer character streams for text data
    }

    // 10. Exam-Oriented Practice Topics
    public void examPracticeTopics() {
        // 10.1 Difference between InputStream and Reader
        // InputStream is for byte data, while Reader is for character data.

        // 10.2 Writing custom serialization logic
        // Implementing writeObject and readObject methods in a class.

        // 10.3 Understanding the role of transient and SerialVersionUID
        // Transient fields are not serialized; SerialVersionUID ensures version compatibility.

        // 10.4 Use cases of BufferedReader vs Scanner
        // BufferedReader is faster for reading lines, while Scanner is more versatile for parsing.

        // 10.5 Random access and handling large files
        // RandomAccessFile allows seeking to any position in a file for reading/writing.
    }

    public static void main(String[] args) {
        JavaIOExamples examples = new JavaIOExamples();

        System.out.println("Byte Streams Example:");
        examples.byteStreamsExample();

        System.out.println("\nCharacter Streams Example:");
        examples.characterStreamsExample();

        System.out.println("\nFile IO Example:");
        examples.fileIOExample();

        System.out.println("\nStandard Streams Example:");
        examples.standardStreamsExample();

        System.out.println("\nSerialization Example:");
        examples.serializationExample();

        System.out.println("\nAdvanced IO Example:");
        examples.advancedIOExample();

        System.out.println("\nNIO Example:");
        examples.nioExample();

        System.out.println("\nBest Practices:");
        examples.bestPractices();

        System.out.println("\nExam-Oriented Practice Topics:");
        examples.examPracticeTopics();
    }

    // Custom class for serialization example
    static class MyObject implements Serializable {
        private String message;
        private int number;

        public MyObject(String message, int number) {
            this.message = message;
            this.number = number;
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "message='" + message + '\'' +
                    ", number=" + number +
                    '}';
        }
    }
}
