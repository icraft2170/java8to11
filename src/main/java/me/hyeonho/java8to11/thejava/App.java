package me.hyeonho.java8to11.thejava;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class App {

    public static void main(String[] args) throws InterruptedException {

        Instant instant = Instant.now();
        System.out.println("instant(UTC) = " + instant); // 기준시 UTC, GMT
        System.out.println("-------------------------------------");

        ZoneId zone = ZoneId.systemDefault();
        System.out.println("zone = " + zone);

        System.out.println("-------------------------------------");

        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println("zonedDateTime = " + zonedDateTime);

        System.out.println("-------------------------------------");

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println("localDateTimeNow = " + localDateTimeNow);

        LocalDateTime localDateTimeOf = LocalDateTime.of(1997, Month.JULY, 12, 0, 0);
        System.out.println("localDateTimeOf = " + localDateTimeOf);

        System.out.println("-------------------------------------");

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("nowInKorea = " + nowInKorea);

        System.out.println("-------------------------------------");

        LocalDate localDateNow = LocalDate.now();
        System.out.println("localDateNow = " + localDateNow);

        System.out.println("-------------------------------------");
        LocalDate today = LocalDate.now();
        LocalDate myBirthDay = LocalDate.of(2022, Month.JULY, 12);

        Period between = Period.between(today, myBirthDay);
        System.out.println("between = " + between.get(ChronoUnit.DAYS));

        Period until = today.until(myBirthDay);
        System.out.println("until = " + until.get(ChronoUnit.DAYS));
        System.out.println("-------------------------------------");

        Instant now = Instant.now();
        Instant plus = now.plus(10, ChronoUnit.SECONDS);
        Duration btDuration = Duration.between(now, plus);
        System.out.println("btDuration = " + btDuration.get(ChronoUnit.SECONDS));

        System.out.println("-------------------------------------");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");


        LocalDateTime nw = LocalDateTime.now();
        System.out.println("nw = " + nw.format(dateTimeFormatter));
        LocalDate parse = LocalDate.parse("07/12/1997", dateTimeFormatter);
        System.out.println("parse = " + parse);

    }



}

