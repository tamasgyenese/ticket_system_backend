package com.core.mock;


import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * Mock POJO for API Response
 */
public class Event {

    private long eventId;
    private String title;
    private String location;
    private String startTimeStamp;
    private String endTimeStamp;

    private List<Seat> seats;

    public Event() {
    }

    public Event(long eventId, String title, String location, Timestamp startTimeStamp, Timestamp endTimeStamp) {
        this.eventId = eventId;
        this.title = title;
        this.location = location;
        this.startTimeStamp = String.valueOf(startTimeStamp.getTime());
        this.endTimeStamp = String.valueOf(endTimeStamp.getTime());
    }

    public Event(long eventId,  List<Seat> seats) {
        this.eventId = eventId;
        this.seats = seats;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Timestamp startTimeStamp) {
        this.startTimeStamp = String.valueOf(startTimeStamp.getTime());
    }

    public String getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(Timestamp endTimeStamp) {
        this.endTimeStamp = String.valueOf(endTimeStamp.getTime());
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId &&
                Objects.equals(title, event.title) &&
                Objects.equals(location, event.location) &&
                Objects.equals(startTimeStamp, event.startTimeStamp) &&
                Objects.equals(endTimeStamp, event.endTimeStamp) &&
                Objects.equals(seats, event.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, title, location, startTimeStamp, endTimeStamp, seats);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", startTimeStamp=" + startTimeStamp +
                ", endTimeStamp=" + endTimeStamp +
                ", seats=" + seats +
                '}';
    }
}
