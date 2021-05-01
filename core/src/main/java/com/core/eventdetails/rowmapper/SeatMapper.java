package com.core.eventdetails.rowmapper;

import com.core.constans.FieldConstants;
import com.core.eventdetails.model.Seat;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeatMapper implements RowMapper<Seat> {

    @Override
    public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
        Seat seat = new Seat();
        seat.setId(rs.getString(FieldConstants.DB_ID));
        seat.setPrice(rs.getLong(FieldConstants.DB_PRICE));
        seat.setCurrency(rs.getString(FieldConstants.DB_FIELD_CURRENCY));
        seat.setReserved(rs.getBoolean(FieldConstants.DB_RESERVED));
        return seat;
    }
}
