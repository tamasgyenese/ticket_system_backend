package com.gyenese.service;

import com.gyenese.constans.FieldConstants;
import com.gyenese.dao.ICoreValidatorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class CoreServiceImpl implements ICoreService{

    private final ICoreValidatorDAO iCoreValidatorDAO;

    @Autowired
    public CoreServiceImpl(ICoreValidatorDAO iCoreValidatorDAO) {
        this.iCoreValidatorDAO = iCoreValidatorDAO;
    }

    @Override
    public boolean isValidToken(String token64) {
        String[] values = decodedString(token64);
        if (values == null) { return false;}
        if (values.length != 3) {return false;}

        return iCoreValidatorDAO.isValidToken(values[0],Long.parseLong(values[1]),values[2],token64);
    }






    public String[] decodedString(String token64) {
        byte[] decodedBytes = Base64.getDecoder().decode(token64);
        String decodedString = new String(decodedBytes);
        return decodedString.split(FieldConstants.TOKEN_SEPARATOR);
    }
}
