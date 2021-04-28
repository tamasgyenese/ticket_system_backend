DROP TABLE IF EXISTS Users;

CREATE TABLE Users
(
    USER_ID INTEGER NOT NULL,
    NAME    VARCHAR NOT NULL,
    EMAIL   VARCHAR NOT NULL,
    CONSTRAINT users_PK PRIMARY KEY (USER_ID)
);

--
DROP TABLE IF EXISTS UserDevice;

CREATE TABLE UserDevice
(
    USER_ID     INTEGER NOT NULL,
    DEVICE_HASH VARCHAR NOT NULL,
    CONSTRAINT userdevice_user_FK FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID),
    CONSTRAINT userdevice_UI UNIQUE (USER_ID, DEVICE_HASH)
);

--
DROP TABLE IF EXISTS UserToken;

CREATE TABLE UserToken
(
    USER_ID INTEGER NOT NULL,
    TOKEN   VARCHAR NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID),
    CONSTRAINT usertoken_UI UNIQUE (USER_ID, TOKEN)
);


DROP TABLE IF EXISTS UserBankCard;

CREATE TABLE UserBankCard
(
    USER_ID     INTEGER NOT NULL,
    CARD_ID     VARCHAR NOT NULL,
    CARD_NUMBER VARCHAR NOT NULL,
    CVC         INTEGER NOT NULL,
    NAME        VARCHAR NOT NULL,
    AMOUNT      INTEGER DEFAULT 0,
    CURRENCY    VARCHAR NOT NULL,
    CONSTRAINT userbankcard_PK PRIMARY KEY (CARD_ID),
    CONSTRAINT userbankcard_user_FK FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID),
    CONSTRAINT userbankcard_UI UNIQUE (CARD_NUMBER)

);