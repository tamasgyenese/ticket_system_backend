package com.core.constans;

/**
 * SQL queries
 */
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

    public static final String VALIDATE_PAYMENT = "SELECT CASE\n"
                                                + "           WHEN UBC.CARD_ID <> :CARD_ID THEN 10100\n"
                                                + "           WHEN UBC.AMOUNT < (SELECT max(S.PRICE)\n"
                                                + "                              FROM Seat S\n"
                                                + "                                       INNER JOIN Event E ON S.EVENT_ID = E.EVENT_ID\n"
                                                + "                              WHERE E.EVENT_ID = :EVENT_ID\n"
                                                + "                                AND S.ID = ID) THEN 10101\n"
                                                + "           ELSE 0\n"
                                                + "           END AS MSG\n"
                                                + "FROM Users U\n"
                                                + "         INNER JOIN UserBankCard UBC ON U.USER_ID = UBC.USER_ID\n"
                                                + "WHERE U.USER_ID = :USER_ID";

    public static final String VALIDATE_EVENT = "SELECT CASE\n"
                                              + "           WHEN NOT EXISTS(\n"
                                              + "                   SELECT 1 FROM Event E WHERE E.EVENT_ID = :EVENT_ID\n"
                                              + "               ) THEN 20001\n"
                                              + "           WHEN NOT EXISTS(\n"
                                              + "                   SELECT 1\n"
                                              + "                   FROM Seat S\n"
                                              + "                   WHERE S.EVENT_ID = :EVENT_ID\n"
                                              + "                     AND S.ID= :ID\n"
                                              + "               ) THEN 20002\n"
                                              + "           WHEN (SELECT S2.RESERVED FROM Seat S2 WHERE S2.EVENT_ID = :EVENT_ID AND S2.ID = :ID) THEN 20010\n"
                                              + "           WHEN current_timestamp() > (SELECT E2.START_TIME FROM Event E2 WHERE E2.EVENT_ID = :EVENT_ID) THEN 20011\n"
                                              + "           ELSE 0\n"
                                              + "           END AS MSG;";

    public static final String RESERVE_SEAT = "UPDATE Seat S \n"
                                           +  "    SET s.RESERVED = TRUE\n"
                                           +  "WHERE S.EVENT_ID=:EVENT_ID AND S.ID=:ID;";


    public static final String CHARGE_MONEY = "UPDATE USERBANKCARD\n"
                                            + "SET AMOUNT = AMOUNT - (SELECT PRICE\n"
                                            + "                       FROM SEAT\n"
                                            + "                                INNER JOIN EVENT E on SEAT.EVENT_ID = E.EVENT_ID\n"
                                            + "                       WHERE E.EVENT_ID = :EVENT_ID\n"
                                            + "                         AND ID = :ID\n"
                                            + "                       LIMIT 1)\n"
                                            + "WHERE CARD_ID = :CARD_ID;";

}
