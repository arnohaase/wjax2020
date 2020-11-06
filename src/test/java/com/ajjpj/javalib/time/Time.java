package com.ajjpj.javalib.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

/**
 * @author arno
 */
public class Time {
    @Test
    void testInstant() {
        Instant now = Instant.now();
        Instant later = Instant.now();

        System.out.println(now.isBefore(later));
        System.out.println(now);
        System.out.println(now.plusSeconds(20));
        System.out.println(now.minus(1, ChronoUnit.HOURS));

        System.out.println(now.until(later, ChronoUnit.NANOS));
    }

    @Test
    void testLocalDateTime() {
        LocalDate fourthOfJuly = LocalDate.of(2020, 7, 4);
        LocalDateTime noonOfFourth = LocalDateTime.of(2020, 7, 4, 12, 0, 0);

        System.out.println(noonOfFourth.getDayOfWeek());
        System.out.println(noonOfFourth.getDayOfYear());

        LocalDateTime today = LocalDateTime.of(2020, 11, 6, 15, 41, 0);

        System.out.println(noonOfFourth.until(today, ChronoUnit.DAYS));
    }

    @Test
    void testTimeZone() {
        Instant now = Instant.now();

        ZoneId zone = ZoneId.of("Europe/Berlin");
        LocalDateTime inEurope = now.atZone(zone).toLocalDateTime();
        LocalDateTime inGmt = now.atZone(ZoneId.of("GMT")).toLocalDateTime();

        System.out.println(inEurope);
        System.out.println(inGmt);
    }

    @Test
    void testClock() {
        Clock clock = Clock.fixed(Instant.ofEpochSecond(123456789), ZoneId.of("GMT"));
//        Clock clock = Clock.systemDefaultZone();

        System.out.println(Instant.now(clock));
        System.out.println(Instant.now(clock));
        System.out.println(Instant.now(clock));
        System.out.println(Instant.now(clock));
    }

    // Übung:
    //  * Wochentag des eigenen Geburtstags ermitteln
    //  * 10.000 ten Tag seit dem Geburtstag
    //  * wie lange dauert eine System.gc()
    //    * testbar machen


    @Test
    void testFormat() {
        Instant now = Instant.now();
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(now));

        // Jackson: JavaTimeModule registrieren, WRITE_DATES_AS_TIMESTAMPS setzen
    }

}
