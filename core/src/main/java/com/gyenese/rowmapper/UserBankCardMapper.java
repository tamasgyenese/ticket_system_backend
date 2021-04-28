package com.gyenese.rowmapper;

import com.constans.FieldConstants;
import com.gyenese.model.UserBankCard;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * RowMapper for UserBankCard class
 */

public class UserBankCardMapper implements RowMapper<UserBankCard> {

    @Override
    public UserBankCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserBankCard userBankCard = new UserBankCard();
        userBankCard.setUserId(rs.getLong(FieldConstants.DB_FIELD_USER_ID));
        userBankCard.setCardId(rs.getString(FieldConstants.DB_FIELD_CARD_ID));
        userBankCard.setCardNumber(rs.getLong(FieldConstants.DB_FIELD_CARD_NUMBER));
        userBankCard.setCvc(rs.getInt(FieldConstants.DB_FIELD_CVC));
        userBankCard.setName(rs.getString(FieldConstants.DB_FIELD_NAME));
        userBankCard.setAmount(rs.getLong(FieldConstants.DB_FIELD_AMOUNT));
        userBankCard.setCurrency(rs.getString(FieldConstants.DB_FIELD_CURRENCY));
        return userBankCard;
    }
}
