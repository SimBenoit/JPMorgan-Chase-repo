package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    /**
     * @param customer which customer made the reservation
     * @param showing which showing is the reservation for
     * @param audienceCount how many tickets are to be sold
     * Reservation simply makes the link between customer and showing
     * calculates the fee for a certain viewing of a movie
     */
    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = customer;
        this.showing = showing;
        this.audienceCount = audienceCount;
    }

    //Reservation only used to track which customer bought how many of which showing
    public double totalFee() {
        return showing.getMovieFee()*audienceCount;   
    }
}