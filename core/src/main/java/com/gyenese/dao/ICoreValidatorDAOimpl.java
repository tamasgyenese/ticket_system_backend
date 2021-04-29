package com.gyenese.dao;

import com.gyenese.constans.FieldConstants;
import com.gyenese.constans.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ICoreValidatorDAOimpl  implements ICoreValidatorDAO{


    private  NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ICoreValidatorDAOimpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public boolean isValidToken(String email, long userId, String deviceHash, String token) {

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put(FieldConstants.DB_FIELD_EMAIL, email);
        namedParameters.put(FieldConstants.DB_FIELD_USER_ID, userId);
        namedParameters.put(FieldConstants.DB_FIELD_DEVICE_HASH, deviceHash);
        namedParameters.put(FieldConstants.DB_FIELD_TOKEN, token);
        try {
            return 1 == namedParameterJdbcTemplate.queryForObject(QueryConstants.VALIDATE_TOKEN, namedParameters, Integer.class);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
