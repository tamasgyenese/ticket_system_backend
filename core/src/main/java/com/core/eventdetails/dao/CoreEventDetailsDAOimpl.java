package com.core.eventdetails.dao;

import com.core.constans.FieldConstants;
import com.core.constans.Messages;
import com.core.constans.QueryConstants;
import com.core.eventdetails.model.Event;
import com.core.eventdetails.model.Seat;
import com.core.eventdetails.rowmapper.EventMapper;
import com.core.eventdetails.rowmapper.SeatMapper;
import com.core.exception.CoreDAOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CoreEventDetailsDAOimpl implements ICoreEventDetailsDAO {

    Logger logger = LoggerFactory.getLogger(CoreEventDetailsDAOimpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CoreEventDetailsDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Event> getEvents() throws CoreDAOException {
        logger.debug("Getting all events");
        try {
            return namedParameterJdbcTemplate.query(QueryConstants.GET_EVENTS, new EventMapper());
        } catch (Exception e) {
            logger.error("Error during getting all events");
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }

    @Override
    public Event getEventDetails(long eventId) throws CoreDAOException {
        logger.debug("Getting event details for event: {}", eventId);
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        Event event = new Event(eventId);
        List<Seat> seats = null;
        try {
             logger.debug("Getting all seats for event:  {}", eventId);
             seats = namedParameterJdbcTemplate.query(QueryConstants.GET_EVENT_SEATS, namedParameters, new SeatMapper());
        } catch (Exception e) {
            logger.error("Error during get seats for event: {}", eventId);
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
        event.setSeats(seats);
        return event;
    }

    @Override
    public long validateEvent(long eventId, String seatId) throws CoreDAOException {
        logger.debug("Event validation for event: {} and seat: {}", eventId, seatId);
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        namedParameters.put(FieldConstants.DB_ID, seatId);
        try {
            return namedParameterJdbcTemplate.queryForObject(QueryConstants.VALIDATE_EVENT, namedParameters, Long.class);
        } catch (Exception e) {
            logger.error("Error during validate event: {} and seat: {} ", eventId, seatId);
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }

    @Override
    public void reserveSeat(long eventId, String seatId) throws CoreDAOException {
        logger.debug("Reserve seat: {} for event: {}", seatId, eventId);
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_EVENT_ID, eventId);
        namedParameters.put(FieldConstants.DB_ID, seatId);
        try {
            namedParameterJdbcTemplate.update(QueryConstants.RESERVE_SEAT, namedParameters);
        } catch (Exception e){
            logger.error("Error during reserve seat: {} for event: {}", seatId, eventId);
            throw new CoreDAOException(e.getMessage(), Messages.ERROR_CODE_20404);
        }
    }
}
