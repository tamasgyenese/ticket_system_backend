package com.core.rowmapper;

import com.core.constans.FieldConstants;
import com.core.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper for User class
 */

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getLong(FieldConstants.DB_FIELD_USER_ID));
        user.setName(rs.getString(FieldConstants.DB_FIELD_NAME));
        user.setEmail(rs.getString(FieldConstants.DB_FIELD_EMAIL));
        return user;
    }
}
