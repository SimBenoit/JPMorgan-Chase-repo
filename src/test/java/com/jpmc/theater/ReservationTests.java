package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTests {

    @Test
    void totalFee() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1),
                1,
                LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(2,30))
        );
        assertTrue(new Reservation(customer, showing, 3).totalFee() == 28.5);
    }

    @Test
    void reserveFullPrice() {
        var customer = new Customer("John Doe", "unused-id");
        var showing = new Showing(
                new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 0),
                5,
                LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(2,30))
        );
        assertTrue(new Reservation(customer, showing, 2).totalFee() == 25);
    }
}
