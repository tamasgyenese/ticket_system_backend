package com.gyenese.service;

import com.gyenese.common.ServiceResponse;

public interface ICoreService {

    ServiceResponse<Boolean> isValidToken(String token64);
}
