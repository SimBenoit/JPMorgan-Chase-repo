package com.jpmc.theater;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class Showing {
    private static int MOVIE_CODE_SPECIAL = 1;

    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;
    private double showingFee;


    /**
     * @param movie which movie it is
     * @param sequenceOfTheDay what is the place of the movie in the daily list of movies
     * @param showStartTime what time the showing starts
     * @param showingFee calculated price of a ticket after taking into account discounts
     * Showing is the big class, where we keep track of a TicketPrice according to the time
     * people reserve specific showings
     */
    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
        this.showingFee = calculateTicketPrice();

    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return showingFee;
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    /**
     * Create an array of all eligible discounts for possible combination of discounts later on
     * Also where to add new Discounts for customers 
     * also seperated the two in case of different selection between discounts (adding them, multiplying them, etc)
    **/
    private double calculateTicketPrice() {
        ArrayList<Double> eligibleDiscounts = getEligibleDiscounts();
        if (eligibleDiscounts.size() > 0){
            double ticketPrice = movie.getTicketPrice()-eligibleDiscounts.get(0);
            return Math.round(ticketPrice * 100.0) / 100.0;
        }

        return movie.getTicketPrice();
    }

    // Lists all possible Discounts in for a showing for selection in the TicketPrice
    private ArrayList<Double> getEligibleDiscounts(){
        ArrayList<Double> Discounts = new ArrayList<Double>();

        if (movie.getSpecialCode()==MOVIE_CODE_SPECIAL){
            Discounts.add(movie.getTicketPrice()*0.2);
        }
        if (sequenceOfTheDay==1){
            Discounts.add(3.0);
        }
        if (sequenceOfTheDay==2){
            Discounts.add(2.0);
        }
        if (showStartTime.getDayOfMonth() == 7){
            Discounts.add(1.0);
        }
        if (showStartTime.getHour()>= 11 && showStartTime.getHour()<= 16){
            Discounts.add(movie.getTicketPrice()*0.25);
        }

        Collections.sort(Discounts, Collections.reverseOrder());   
        return Discounts;
    }
}
