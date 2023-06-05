package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountTests {
    Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
    @Test
    void specialMovieWith50PercentDiscount() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(2,30)));
        assertEquals(10, showing.getMovieFee());

        System.out.println(Duration.ofMinutes(90));
    }
    @Test
    void firstMovieOfTheDay() {
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(2,30)));
        assertEquals(9.5, showing.getMovieFee());
        
        System.out.println(Duration.ofMinutes(90));
    }
    @Test
    void secondMovieOfTheDay() {
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(2,30)));
        assertEquals(10.5, showing.getMovieFee());
        
        System.out.println(Duration.ofMinutes(90));
    }
    @Test
    void movie25PercentDiscountTimeOfDay() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),10, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(14, 30)));
        assertEquals(7.5, showing.getMovieFee());
        
        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieDiscount7OfMonth() {
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023,7,7), LocalTime.of(2,30)));
        assertEquals(11.5, showing.getMovieFee());
        
        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movieNoDicsounts() {
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.of(2023,6,6), LocalTime.of(2,30)));
        assertEquals(12.5, showing.getMovieFee());
        
        System.out.println(Duration.ofMinutes(90));
    }
}
