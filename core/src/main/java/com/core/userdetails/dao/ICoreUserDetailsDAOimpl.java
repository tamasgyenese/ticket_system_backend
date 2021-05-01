package com.core.userdetails.dao;

import com.core.constans.FieldConstants;
import com.core.constans.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ICoreUserDetailsDAOimpl implements ICoreUserDetailsDAO {


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ICoreUserDetailsDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public long isValidToken(String email, long userId, String deviceHash, String token) {

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_FIELD_EMAIL, email);
        namedParameters.put(FieldConstants.DB_FIELD_USER_ID, userId);
        namedParameters.put(FieldConstants.DB_FIELD_DEVICE_HASH, deviceHash);
        namedParameters.put(FieldConstants.DB_FIELD_TOKEN, token);
        try {
            return namedParameterJdbcTemplate.queryForObject(QueryConstants.VALIDATE_TOKEN, namedParameters, Long.class);
        } catch (Exception e) {
            e.getMessage();
            return -1L;
        }
    }
}