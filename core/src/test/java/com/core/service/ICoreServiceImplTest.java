package com.core.service;

import com.core.eventdetails.dao.CoreEventDetailsDAOimpl;
import com.core.userdetails.dao.CoreUserDetailsDAOimpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class ICoreServiceImplTest {

    @Mock private CoreUserDetailsDAOimpl coreUserDetailsDAOimpl;
    @Mock private CoreEventDetailsDAOimpl coreEventDetailsDAOimpl;

    @InjectMocks
    private CoreServiceImpl coreService;

    @Test
    public void TestDecodedString() {
        String token = "dGVzenQuY2VjaWxpYUBvdHBtb2JpbC5jb20mMzAwMCZFNjg1NjA4NzJCREIyREYyRkZFN0FEQzA5MTc1NTM3OA==";
        String[] values = coreService.decodedString(token);
        Assert.assertEquals(3, values.length);
        Assert.assertEquals("teszt.cecilia@otpmobil.com", values[0]);
        Assert.assertEquals("3000", values[1]);

        String token2 = "d3JvbmcmdG9rZW4mdGhhdHMmbGlmZQ==";
        String[] values2 = coreService.decodedString(token2);
        Assert.assertNotEquals(3, values2.length);

    }


}