package java8_features.j8_5_date_time_apis;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates new Date/Time APIs introduced in Java 8, such as LocalDate, LocalTime,
 * LocalDateTime, Period, Duration, Instant, ZonedDateTime, ZoneId, and DateTimeFormatter.
 */
public class DateTimeExamples {

    public static void main(String[] args) {

        // LocalDate Example - Represents a date (no time or timezone)
        LocalDate localDate = LocalDate.of(2023, 12, 15);
        System.out.println("LocalDate: " + localDate);

        // LocalTime Example - Represents a time (no date or timezone)
        LocalTime localTime = LocalTime.of(14, 30);
        System.out.println("LocalTime: " + localTime);

        // LocalDateTime Example - Represents a date and time (no timezone)
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("LocalDateTime: " + localDateTime);

        // Period Example - Represents a period of time in terms of days, months, and years
        Period period = Period.between(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));
        System.out.println("Period (between dates): " + period);

        Period customPeriod = Period.ofYears(2).plusMonths(3).plusDays(10);
        System.out.println("Custom Period: " + customPeriod);

        // Duration Example - Represents a duration of time in hours, minutes, etc.
        Duration duration = Duration.between(LocalTime.of(10, 0), LocalTime.of(14, 30));
        System.out.println("Duration (between times): " + duration);

        Duration customDuration = Duration.ofHours(5).plusMinutes(45);
        System.out.println("Custom Duration: " + customDuration);

        // Instant Example - Represents a moment in time since the epoch (Jan 1, 1970)
        Instant instant = Instant.now();
        System.out.println("Current Instant: " + instant);

        // ZonedDateTime Example - Represents a date and time with timezone information
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
        System.out.println("ZonedDateTime: " + zonedDateTime);

        // ZoneId Example - Represents a timezone ID
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        System.out.println("ZoneId: " + zoneId);

        // ZoneOffset Example - Represents a fixed offset from UTC
        ZoneOffset zoneOffset = ZoneOffset.ofHours(-5);
        System.out.println("ZoneOffset: " + zoneOffset);

        // DateTimeFormatter Example - Formatting and parsing dates/times
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = localDateTime.format(formatter);
        System.out.println("Formatted LocalDateTime: " + formattedDateTime);

        LocalDate parsedDate = LocalDate.parse("15-12-2023", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Parsed LocalDate: " + parsedDate);

        // TimeZone-specific ZonedDateTime Formatting
        DateTimeFormatter zonedFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println("Formatted ZonedDateTime: " + zonedDateTime.format(zonedFormatter));

        // Demonstrating time differences using Period and Duration
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 1);
        Period periodBetween = Period.between(startDate, endDate);
        System.out.println("Years: " + periodBetween.getYears() + ", Months: " + periodBetween.getMonths() + ", Days: " + periodBetween.getDays());

        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(16, 30);
        Duration durationBetween = Duration.between(startTime, endTime);
        System.out.println("Hours: " + durationBetween.toHours() + ", Minutes: " + durationBetween.toMinutesPart());

    }
}

