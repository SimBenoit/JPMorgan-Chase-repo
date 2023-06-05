package com.jpmc.theater;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

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