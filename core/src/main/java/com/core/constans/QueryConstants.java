package com.core.constans;

public final class QueryConstants {

    public static final String VALIDATE_TOKEN = "SELECT COUNT(1)\n"
                                              + "FROM Users U\n"
                                              + "         INNER JOIN UserDevice UD on U.USER_ID = UD.USER_ID\n"
                                              + "         INNER JOIN UserToken UT on U.USER_ID = UT.USER_ID\n"
                                              + "WHERE U.USER_ID = :USER_ID\n"
                                              + "  AND U.EMAIL = :EMAIL\n"
                                              + "  AND UD.DEVICE_HASH = :DEVICE_HASH\n"
                                              + "  AND UT.TOKEN = :TOKEN;";

    public static final String GET_EVENTS = "SELECT * FROM Event";

    public static final String GET_EVENT_SEATS = "SELECT S.ID, S.PRICE, S.CURRENCY, S.RESERVED FROM Seat S\n"
                                               + "INNER JOIN Event E on S.EVENT_ID = E.EVENT_ID\n"
                                               + "WHERE E.EVENT_ID=:EVENT_ID;";

}
