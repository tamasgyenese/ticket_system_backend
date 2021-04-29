package com.gyenese.mock;

import java.util.Objects;

public class Seat {

    private long id;
    private long price;
    private String currency;
    private boolean rserved;

    public Seat() {
    }

    public Seat(long id, long price, String currency, boolean rserved) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.rserved = rserved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isRserved() {
        return rserved;
    }

    public void setRserved(boolean rserved) {
        this.rserved = rserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return id == seat.id &&
                price == seat.price &&
                rserved == seat.rserved &&
                Objects.equals(currency, seat.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, currency, rserved);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", rserved=" + rserved +
                '}';
    }
}
