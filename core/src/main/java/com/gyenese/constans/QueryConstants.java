package com.gyenese.constans;

public final class QueryConstants {

    public static final String VALIDATE_TOKEN = "SELECT COUNT(1)\n"
                                               + "FROM Users U\n"
                                               + "         INNER JOIN UserDevice UD on U.USER_ID = UD.USER_ID\n"
                                               + "         INNER JOIN UserToken UT on U.USER_ID = UT.USER_ID\n"
                                               + "WHERE U.USER_ID = :USER_ID\n"
                                               + "  AND U.EMAIL = :EMAIL\n"
                                               + "  AND UD.DEVICE_HASH = :DEVICE_HASH\n"
                                               + "  AND UT.TOKEN = :TOKEN;";
}
