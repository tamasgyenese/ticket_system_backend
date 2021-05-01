package com.core.userdetails.rowmapper;

import com.core.constans.FieldConstants;
import com.core.userdetails.model.UserDevice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper for UserDevice class
 */

public class UserDeviceMapper implements RowMapper<UserDevice> {

    @Override
    public UserDevice mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDevice userDevice = new UserDevice();
        userDevice.setUserId(rs.getLong(FieldConstants.DB_FIELD_USER_ID));
        userDevice.setDeviceHash(rs.getString(FieldConstants.DB_FIELD_DEVICE_HASH));
        return userDevice;
    }
}
