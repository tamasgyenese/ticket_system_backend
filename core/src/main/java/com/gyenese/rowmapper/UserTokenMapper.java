package com.gyenese.rowmapper;

import com.gyenese.constans.FieldConstants;
import com.gyenese.model.UserToken;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper for UserToken class
 */

public class UserTokenMapper implements RowMapper<UserToken> {

    @Override
    public UserToken mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserToken userToken = new UserToken();
        userToken.setUserId(rs.getLong(FieldConstants.DB_FIELD_USER_ID));
        userToken.setToken(rs.getString(FieldConstants.DB_FIELD_TOKEN));
        return userToken;
    }
}
