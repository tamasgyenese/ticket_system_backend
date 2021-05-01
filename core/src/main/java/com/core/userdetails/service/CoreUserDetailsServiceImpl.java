package com.core.userdetails.service;

import com.core.constans.Messages;
import com.core.constans.FieldConstants;
import com.core.userdetails.dao.ICoreUserDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
public class CoreUserDetailsServiceImpl implements ICoreUserDetailsService {

    private final ICoreUserDetailsDAO iCoreUserDetailsDAO;

    @Autowired
    public CoreUserDetailsServiceImpl(ICoreUserDetailsDAO iCoreUserDetailsDAO) {
        this.iCoreUserDetailsDAO = iCoreUserDetailsDAO;
    }

    @Override
    @Transactional
    public long isValidToken(String token64) {
        if (token64 == null || "".equals(token64)) {
            return Messages.ERROR_CODE_10051;
        }
        String[] values = decodedString(token64);
        if (values == null || values.length !=3) {
            return Messages.ERROR_CODE_10051;
        }
        String email = values[0];
        long id = Long.parseLong(values[1]);
        String deviceHash = values[2];

        return iCoreUserDetailsDAO.isValidToken(email, id, deviceHash, token64) == 1 ? Messages.SUCCESS_CODE : Messages.ERROR_CODE_10050;
    }






    public String[] decodedString(String token64) {
        byte[] decodedBytes = Base64.getDecoder().decode(token64);
        String decodedString = new String(decodedBytes);
        return decodedString.split(FieldConstants.TOKEN_SEPARATOR);
    }
}