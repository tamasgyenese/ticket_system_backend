package com.core.eventdetails.dao;

import com.core.constans.FieldConstants;
import com.core.constans.Messages;
import com.core.constans.QueryConstants;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Seat;
import com.core.eventdetails.rowmapper.EventMapper;
import com.core.eventdetails.rowmapper.SeatMapper;
import com.core.exception.CoreDAOException;
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
    public List<Event> getEvents() throws CoreDAOException {
        try {
            return namedParameterJdbcTemplate.query(QueryConstants.GET_EVENTS, new EventMapper());
        } catch (Exception e) {
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }

    @Override
    public Event getEventDetails(long eventId) throws CoreDAOException {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        Event event = new Event(eventId);
        List<Seat> seats = null;
        try {
             seats = namedParameterJdbcTemplate.query(QueryConstants.GET_EVENT_SEATS, namedParameters, new SeatMapper());
        } catch (Exception e) {
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
        event.setSeats(seats);
        return event;
    }

    @Override
    public long validateEvent(long eventId, String seatId) throws CoreDAOException {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        namedParameters.put(FieldConstants.DB_ID, seatId);
        try {
            return namedParameterJdbcTemplate.queryForObject(QueryConstants.VALIDATE_EVENT, namedParameters, Long.class);
        } catch (Exception e) {
            e.getMessage();
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }

    @Override
    public void reserveSeat(long eventId, String seatId) throws CoreDAOException {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        namedParameters.put(FieldConstants.DB_ID, seatId);
        try {
            namedParameterJdbcTemplate.update(QueryConstants.RESERVE_SEAT, namedParameters);
        } catch (Exception e){
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }
}
