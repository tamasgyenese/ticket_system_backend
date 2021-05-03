package com.core.service;

import com.core.common.ServiceResponse;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Reservation;

import java.util.List;

public interface ICoreService {

    long isValidToken(String token64);

    ServiceResponse<List<Event>> getEvents(String token);

    ServiceResponse<Event> getEventDetails(long eventId, String token);

    ServiceResponse<Reservation> payValidation(long eventId, String seatId, String cardId, String token);

}
