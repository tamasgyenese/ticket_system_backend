package com.core.mock;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Class for generate hard coded mock object for API response
 */
public class GenerateMock {


    public static List<Event> generateEvents() {

        Event event1 = new Event(1, "Szilveszteri zártkörű rendezvény", "Greenwich", new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));
        Event event2 = new Event(2, "Májusi mulatság", "Budapest", new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));
        Event event3 = new Event(3, "Necc party", "Debrecen", new Timestamp(new Date().getTime()), new Timestamp(new Date().getTime()));

        return Arrays.asList(event1, event2, event3);
    }

    public static List<Event> generateEventsWithSeats() {
        Seat seat1 = new Seat(1, 1000, "HUF", true);
        Seat seat2 = new Seat(2, 1000, "HUF", false);
        Seat seat3 = new Seat(3, 1000, "HUF", true);
        Seat seat4 = new Seat(4, 1000, "HUF", false);
        Seat seat5 = new Seat(5, 1000, "HUF", true);
        Seat seat6 = new Seat(6, 1000, "HUF", false);

        List<Seat> seats = Arrays.asList(seat1, seat2, seat3, seat4, seat5, seat6);

        Event event1 = new Event(1, seats);
        Event event2 = new Event(2, seats);
        Event event3 = new Event(3, seats);

        return Arrays.asList(event1, event2, event3);
    }
}
