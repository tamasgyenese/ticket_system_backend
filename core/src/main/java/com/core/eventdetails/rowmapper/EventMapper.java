package com.core.eventdetails.rowmapper;

import com.core.constans.FieldConstants;
import com.core.eventdetails.model.Event;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventMapper implements RowMapper<Event> {

    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setEventId(rs.getLong(FieldConstants.DB_EVENT_ID));
        event.setTitle(rs.getString(FieldConstants.DB_TITLE));
        event.setLocation(rs.getString(FieldConstants.DB_LOCATION));
        event.setStartTimeStamp(String.valueOf(rs.getTimestamp(FieldConstants.DB_START_TIME).getTime()));
        event.setEndTimeStamp(String.valueOf(rs.getTimestamp(FieldConstants.DB_END_TIME).getTime()));
        return event;
    }
}
