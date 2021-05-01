package com.core.eventdetails.dao;

import com.core.constans.FieldConstants;
import com.core.constans.QueryConstants;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Seat;
import com.core.eventdetails.rowmapper.EventMapper;
import com.core.eventdetails.rowmapper.SeatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CoreEventDetailsDAOimpl implements ICoreEventDetailsDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CoreEventDetailsDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Event> getEvents() {
        try {
            return namedParameterJdbcTemplate.query(QueryConstants.GET_EVENTS, new EventMapper());
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public Event getEventDetails(long eventId) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        Event event = new Event(eventId);
        List<Seat> seats = null;
        try {
             seats = namedParameterJdbcTemplate.query(QueryConstants.GET_EVENT_SEATS, namedParameters, new SeatMapper());
        } catch (DataAccessException e) {
            // logger
        }
        event.setSeats(seats);
        return event;
    }
}
