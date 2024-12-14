# Java Stream API - Complete Reference

The **Java Stream API** is a powerful tool introduced in Java 8 for processing collections of data in a functional programming style. This document provides a complete reference to all available methods in the Stream API, categorized for better readability.

---

## Table of Contents
- [Stream Creation](#stream-creation)
- [Intermediate Operations](#intermediate-operations)
  - [Transforming Streams](#transforming-streams)
  - [Sorting and Peeking](#sorting-and-peeking)
  - [Filtering](#filtering)
  - [Limiting and Skipping](#limiting-and-skipping)
- [Terminal Operations](#terminal-operations)
  - [Matching](#matching)
  - [Finding](#finding)
  - [Iterating](#iterating)
  - [Reducing](#reducing)
  - [Collecting](#collecting)
  - [Counting](#counting)
  - [Min/Max](#minmax)
  - [Converting to Array](#converting-to-array)
- [Short-Circuiting Operations](#short-circuiting-operations)
- [Specialized Streams](#specialized-streams)
- [Static Utility Methods (Collectors API)](#static-utility-methods-collectors-api)
- [New Methods in Java 16+](#new-methods-in-java-16)

---

## Stream Creation

### **1. Static Factory Methods**
- `Stream.of(T... values)`
- `Stream.ofNullable(T value)` (Java 9)
- `Stream.empty()`
- `Stream.generate(Supplier<? extends T> s)`
- `Stream.iterate(T seed, UnaryOperator<T> f)`
- `Stream.iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)` (Java 9)

### **2. From Collections and Arrays**
- `Collection.stream()`
- `Collection.parallelStream()`
- `Arrays.stream(T[] array)`
- `Arrays.stream(T[] array, int startInclusive, int endExclusive)`

### **3. From BufferedReader**
- `BufferedReader.lines()`

### **4. Primitive Streams**
- `IntStream`, `LongStream`, `DoubleStream` via `Stream<T>` methods or factory methods.

### **5. Files and Directories**
- `Files.lines(Path path)`
- `Files.lines(Path path, Charset cs)`

### **6. Other Sources**
- `Pattern.splitAsStream(CharSequence input)`
- `Random.ints()`, `Random.longs()`, `Random.doubles()`

---

## Intermediate Operations

### **Transforming Streams**
- `map(Function<? super T, ? extends R> mapper)`
- `flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)`
- `flatMapToInt(Function<? super T, ? extends IntStream> mapper)` (and similar for `LongStream`, `DoubleStream`)
- `distinct()` (removes duplicates)

### **Sorting and Peeking**
- `sorted()` (natural order)
- `sorted(Comparator<? super T> comparator)`
- `peek(Consumer<? super T> action)`

### **Filtering**
- `filter(Predicate<? super T> predicate)`
- `takeWhile(Predicate<? super T> predicate)` (Java 9)
- `dropWhile(Predicate<? super T> predicate)` (Java 9)

### **Limiting and Skipping**
- `limit(long maxSize)`
- `skip(long n)`

---

## Terminal Operations

### **Matching**
- `anyMatch(Predicate<? super T> predicate)`
- `allMatch(Predicate<? super T> predicate)`
- `noneMatch(Predicate<? super T> predicate)`

### **Finding**
- `findFirst()`
- `findAny()`

### **Iterating**
- `forEach(Consumer<? super T> action)`
- `forEachOrdered(Consumer<? super T> action)` (ensures encounter order)

### **Reducing**
- `reduce(BinaryOperator<T> accumulator)`
- `reduce(T identity, BinaryOperator<T> accumulator)`
- `reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`

### **Collecting**
- `collect(Collector<? super T, A, R> collector)`
- `collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)`

### **Counting**
- `count()`

### **Min/Max**
- `min(Comparator<? super T> comparator)`
- `max(Comparator<? super T> comparator)`

### **Converting to Array**
- `toArray()`
- `toArray(IntFunction<A[]> generator)`

---

## Short-Circuiting Operations
- `limit(long maxSize)` (intermediate)
- `skip(long n)` (intermediate)
- `findFirst()` (terminal)
- `findAny()` (terminal)
- `anyMatch(Predicate<? super T> predicate)` (terminal)
- `allMatch(Predicate<? super T> predicate)` (terminal)
- `noneMatch(Predicate<? super T> predicate)` (terminal)

---

## Specialized Streams

### **Primitive Streams**
- `IntStream`, `LongStream`, `DoubleStream` provide specialized versions of `Stream` with additional methods:
  - `range(int startInclusive, int endExclusive)`
  - `rangeClosed(int startInclusive, int endInclusive)`
  - `average()`
  - `sum()`
  - `max()`, `min()`
  - `mapToObj(Function<? super T, ? extends U>)`
  - `mapToInt(ToIntFunction<? super T>)` (and similar for `Long` and `Double`)

### **Parallel Streams**
- `parallel()`
- `sequential()`
- `unordered()`

---

## Static Utility Methods (Collectors API)
- `Collectors.toList()`
- `Collectors.toSet()`
- `Collectors.toMap()`
- `Collectors.groupingBy()`
- `Collectors.partitioningBy()`
- `Collectors.joining()`
- `Collectors.averagingInt()`, `averagingDouble()`, `averagingLong()`
- `Collectors.summingInt()`, `summingDouble()`, `summingLong()`
- `Collectors.reducing()`

---

## New Methods in Java 16+
- `toList()` (Java 16) – Creates an unmodifiable list from a stream.

---

### Example Usage
```java
List<String> names = List.of("Alice", "Bob", "Charlie", "David");

// Intermediate and Terminal Operations
List<String> result = names.stream()
    .filter(name -> name.startsWith("A"))
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

System.out.println(result); // Output: [ALICE]
```

---

### Contribute
Feel free to fork this repository and make updates or suggest improvements to keep this reference up to date!
