package com.core.constans;

import java.util.Map;

import static java.util.Map.entry;

public final class Messages {

    // 10050
    public static final String ERROR_MSG_10050 = "A felhasználói token nem szerepel";
    public static final long ERROR_CODE_10050 = 10050L;

    // 10051
    public static final String ERROR_MSG_10051 = "A felhasználói token lejárt vagy nem értelmezhető";
    public static final long ERROR_CODE_10051 = 10051L;

    // 10100
    public static final String ERROR_MSG_10100 = "Ez a bankkártya nem ehhez a felhasználóhoz tartozik";
    public static final long ERROR_CODE_10100 = 10100L;

    // 10101
    public static final String ERROR_MSG_10101 = "A felhasználónak nincs elegendő pénze hogy megvásárolja a jegyet!";
    public static final long ERROR_CODE_10101 = 10101L;

    // 20001
    public static final String ERROR_MSG_20001 = "Nem létezik ilyen esemény!!";
    public static final long ERROR_CODE_20001 = 20001L;

    // 20002
    public static final String ERROR_MSG_20002 = "Nem létezik ilyen szék!";
    public static final long ERROR_CODE_20002 = 20002L;

    // 20010
    public static final String ERROR_MSG_20010 = "Már lefoglalt székre nem lehet jegyet eladni!";
    public static final long ERROR_CODE_20010 = 20010L;

    // 20010
    public static final String ERROR_MSG_20011 = "Olyan eseményre ami már elkezdődött nem lehet jegyet eladni!";
    public static final long ERROR_CODE_20011 = 20011L;

    // 20404
    public static final String ERROR_MSG_20404 = "A külső rendszer nem elérhető!";
    public static final long ERROR_CODE_20404 = 20404L;

    // 90001
    public static final String ERROR_MSG_90001 = "Nem létezik ilyen esemény!";
    public static final long ERROR_CODE_90001 = 90001L;

    // 90002
    public static final String ERROR_MSG_90002 = "Nem létezik ilyen szék!";
    public static final long ERROR_CODE_90002 = 90002L;

    // 90010
    public static final String ERROR_MSG_90010 = "Már lefoglalt székre nem lehet jegyet eladni!";
    public static final long ERROR_CODE_90010 = 90010L;

    public static final Map<Long, String> messagesMap =  Map.ofEntries(
            entry(ERROR_CODE_10050, ERROR_MSG_10050),
            entry(ERROR_CODE_10051, ERROR_MSG_10051),
            entry(ERROR_CODE_10100, ERROR_MSG_10100),
            entry(ERROR_CODE_10101, ERROR_MSG_10101),
            entry(ERROR_CODE_20001, ERROR_MSG_20001),
            entry(ERROR_CODE_20002, ERROR_MSG_20002),
            entry(ERROR_CODE_20010, ERROR_MSG_20010),
            entry(ERROR_CODE_20404, ERROR_MSG_20404),
            entry(ERROR_CODE_20011, ERROR_MSG_20011),
            entry(ERROR_CODE_90001, ERROR_MSG_90001),
            entry(ERROR_CODE_90002, ERROR_MSG_90002),
            entry(ERROR_CODE_90010, ERROR_MSG_90010)
    );

    public static final long SUCCESS_CODE = 0L;



}
