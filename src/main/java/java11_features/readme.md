# Java 11 Features

Java 11, a long-term support (LTS) release, introduces a variety of new features, improvements, and deprecations that enhance developer productivity, application performance, and modernize the language.

---

## 1. New String Methods
Java 11 adds several utility methods to the `String` class for easier manipulation:
- **`isBlank()`**: Checks if a string is empty or contains only whitespace.
- **`lines()`**: Splits a string into a stream of lines.
- **`repeat(int count)`**: Repeats the string a specified number of times.

---

## 2. Local-Variable Syntax for Lambda Parameters
Java 11 allows the use of the `var` keyword for lambda parameters, enabling a more concise and flexible syntax:
```java
(var x, var y) -> x + y;
```

---

## 3. HTTP Client API
The new `HttpClient` API provides support for modern web communication:
- Supports **HTTP/2** and **WebSocket**.
- Simplifies sending synchronous and asynchronous HTTP requests.

Example:
```java
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://example.com"))
    .build();
HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
System.out.println(response.body());
```

---

## 4. Java Flight Recorder (JFR)
Java Flight Recorder is a low-overhead profiling and diagnostics tool for capturing data about JVM and application performance.

---

## 5. Z Garbage Collector (ZGC)
A scalable, low-latency garbage collector that minimizes pause times and supports large heap sizes.

---

## 6. Removal of Java EE and CORBA Modules
Java EE and CORBA modules have been removed from the JDK to streamline the platform.

---

## 7. New File Methods in `java.nio.file`
Simplified file handling with:
- **`Files.writeString()`**: Writes a string to a file.
- **`Files.readString()`**: Reads the content of a file as a string.

Example:
```java
Path path = Files.writeString(Files.createTempFile("example", ".txt"), "Hello, Java 11!");
String content = Files.readString(path);
System.out.println(content);
```

---

## 8. Dynamic Class-File Constants
The `ConstantDynamic` feature introduces a more flexible mechanism for representing constants in class files.

---

## 9. Improved `java.util.Optional` Methods
New methods for enhanced handling of optional values:
- **`isEmpty()`**: Checks if the `Optional` is empty.
- **`or(Supplier<? extends T> supplier)`**: Provides an alternative value if the `Optional` is empty.

---

## 10. Enhanced `java.util.stream` Methods
- **`Stream.toList()`**: Collects stream elements into an immutable list.

Example:
```java
List<String> list = Stream.of("a", "b", "c").toList();
```

---

## 11. Launch Single-File Source-Code Programs (JEP 330)
Run single Java source files directly without prior compilation:
```bash
java HelloWorld.java
```

---

## 12. Pattern Matching for `instanceof` (Preview)
Simplifies type checks in `instanceof` operations:
```java
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

---

## 13. Records (Preview)
A concise syntax for defining data carrier classes:
```java
record Point(int x, int y) {}
```

---

## 14. Sealed Classes (Preview)
Restrict which classes can extend or implement a class:
```java
sealed class Shape permits Circle, Square {}
```

---

## 15. Strongly Encapsulate JDK Internals
Improves security and maintainability by enforcing strong encapsulation of JDK internals.

---

## 16. New `java.util` Collection Methods
New factory methods for creating immutable collections:
- **`List.of()`**
- **`Set.of()`**
- **`Map.of()`**

Example:
```java
List<String> immutableList = List.of("a", "b", "c");
```

---

## 17. Javadoc Search (JEP 372)
Enhanced Javadoc includes a built-in search feature for quick navigation.

---

## 18. Non-Volatile Mapped Byte Buffers (JEP 347)
Improves I/O performance by enabling non-volatile byte buffers for memory-mapped files.

---

## 19. Deprecate the Security Manager for Removal (JEP 362)
The Security Manager is deprecated, paving the way for modern security practices.

---

## 20. Unicode 11.0 Support (JEP 374)
Updated Unicode support ensures better handling of internationalization and localization.

---

### Performance and Security Enhancements
- **Garbage Collection**: Various improvements across different GC algorithms.
- **Security Updates**: Regular updates to ensure the JDK remains secure.

---

These features collectively make Java 11 a powerful release for modern application development.
