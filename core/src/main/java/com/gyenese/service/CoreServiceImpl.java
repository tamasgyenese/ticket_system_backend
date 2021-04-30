package com.gyenese.service;

import com.gyenese.common.ServiceResponse;
import com.gyenese.constans.ErrorMessages;
import com.gyenese.constans.FieldConstants;
import com.gyenese.dao.ICoreValidatorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;

@Service
public class CoreServiceImpl implements ICoreService{

    private final ICoreValidatorDAO iCoreValidatorDAO;

    @Autowired
    public CoreServiceImpl(ICoreValidatorDAO iCoreValidatorDAO) {
        this.iCoreValidatorDAO = iCoreValidatorDAO;
    }

    @Override
    @Transactional
    public ServiceResponse<Boolean> isValidToken(String token64) {
        String[] values = decodedString(token64);
        if (values == null) {
            return new ServiceResponse<>(Boolean.FALSE,false,ErrorMessages.ERROR_MSG_10050, ErrorMessages.ERROR_CODE_10050);
        }
        if (values.length != 3) {
            return new ServiceResponse<>(Boolean.FALSE,false,ErrorMessages.ERROR_MSG_10051, ErrorMessages.ERROR_CODE_10051);
        }

        // TODO
        return null;
    }






    public String[] decodedString(String token64) {
        byte[] decodedBytes = Base64.getDecoder().decode(token64);
        String decodedString = new String(decodedBytes);
        return decodedString.split(FieldConstants.TOKEN_SEPARATOR);
    }
}
