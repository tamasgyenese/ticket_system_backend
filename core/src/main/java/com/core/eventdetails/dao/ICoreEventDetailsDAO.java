package com.core.eventdetails.dao;

import com.core.eventdetails.model.Event;
import com.core.exception.CoreDAOException;

import java.util.List;

public interface ICoreEventDetailsDAO {

    List<Event> getEvents() throws CoreDAOException;

    Event getEventDetails(long eventId) throws CoreDAOException;

    long validateEvent(long eventId, String seatId) throws CoreDAOException;

    void reserveSeat(long eventId, String seatId) throws CoreDAOException;
}
