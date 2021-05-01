INSERT INTO Users (USER_ID, NAME, EMAIL)
VALUES (1000, 'Teszt Aladár', 'teszt.aladar@otpmobil.com');
INSERT INTO Users (USER_ID, NAME, EMAIL)
VALUES (2000, 'Teszt Benedek', 'teszt.benedek@otpmobil.com');
INSERT INTO Users (USER_ID, NAME, EMAIL)
VALUES (3000, 'Teszt Cecília', 'teszt.cecilia@otpmobil.com');
----------
INSERT INTO UserDevice(USER_ID, DEVICE_HASH)
VALUES (1000, 'F67C2BCBFCFA30FCCB36F72DCA22A817');
INSERT INTO UserDevice(USER_ID, DEVICE_HASH)
VALUES (1000, '0F1674BD19D3BBDD4C39E14734FFB876');
INSERT INTO UserDevice(USER_ID, DEVICE_HASH)
VALUES (1000, '3AE5E9658FBD7D4048BD40820B7D227D');
INSERT INTO UserDevice(USER_ID, DEVICE_HASH)
VALUES (2000, 'FADDFEA562F3C914DCC81956682DB0FC');
INSERT INTO UserDevice(USER_ID, DEVICE_HASH)
VALUES (3000, 'E68560872BDB2DF2FFE7ADC091755378');
----------
INSERT INTO UserToken (USER_ID, TOKEN)
VALUES (1000, 'dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJkY2N0MyQkNCRkNGQTMwRkNDQjM2RjcyRENBMjJBODE3');
INSERT INTO UserToken (USER_ID, TOKEN)
VALUES (2000, 'dGVzenQuYmVuZWRla0BvdHBtb2JpbC5jb20mMjAwMCZGQURERkVBNTYyRjNDOTE0RENDODE5NTY2ODJEQjBGQw==');
INSERT INTO UserToken (USER_ID, TOKEN)
VALUES (3000, 'dGVzenQuY2VjaWxpYUBvdHBtb2JpbC5jb20mMzAwMCZFNjg1NjA4NzJCREIyREYyRkZFN0FEQzA5MTc1NTM3OA==');
INSERT INTO UserToken (USER_ID, TOKEN)
VALUES (1000, 'dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJjBGMTY3NEJEMTlEM0JCREQ0QzM5RTE0NzM0RkZCODc2');
INSERT INTO UserToken (USER_ID, TOKEN)
VALUES (1000, 'dGVzenQuYWxhZGFyQG90cG1vYmlsLmNvbSYxMDAwJjNBRTVFOTY1OEZCRDdENDA0OEJENDA4MjBCN0QyMjdE');
----------
INSERT INTO UserBankCard (USER_ID, CARD_ID, CARD_NUMBER, CVC, NAME, AMOUNT, CURRENCY)
VALUES (1000, 'C0001', '5299706965433676', 123, 'Test Aladár', 1000, 'HUF');
INSERT INTO UserBankCard (USER_ID, CARD_ID, CARD_NUMBER, CVC, NAME, AMOUNT, CURRENCY)
VALUES (2000, 'C0002', '5390508354245119', 456, 'Test Benedek', 2000, 'HUF');
INSERT INTO UserBankCard (USER_ID, CARD_ID, CARD_NUMBER, CVC, NAME, AMOUNT, CURRENCY)
VALUES (3000, 'C0003', '4929088924014470', 789, 'Test Teszt Cecília', 3000, 'HUF');
----------
INSERT INTO Event(EVENT_ID, TITLE, LOCATION, START_TIME, END_TIME) VALUES ( 1, 'Szilveszteri zártkörű rendezvény','Greenwich',timestamp '2020-10-12 21:22:23',timestamp '2020-10-12 22:22:23');
INSERT INTO Event(EVENT_ID, TITLE, LOCATION, START_TIME, END_TIME) VALUES ( 2, 'Májusi mulatság','Budapest',timestamp '2020-05-01 10:00:00',timestamp '2020-05-01 22:22:23');
INSERT INTO Event(EVENT_ID, TITLE, LOCATION, START_TIME, END_TIME) VALUES ( 3, 'Necc party','Debrecen',timestamp '2020-11-12 21:22:23',timestamp '2020-11-13 22:22:23');
----------
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S1',1,2000,'HUF',false);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S2',1,3000,'HUF',false);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S3',1,4000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S4',1,5000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S5',1,6000,'HUF',false);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S6',1,7000,'HUF',false);

INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S1',2,2000,'HUF',false);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S2',2,3000,'HUF',false);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S3',2,4000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S4',2,5000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S5',2,6000,'HUF',false);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S6',2,7000,'HUF',false);

INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S1',3,2000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S2',3,3000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S3',3,4000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S4',3,5000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S5',3,6000,'HUF',true);
INSERT INTO Seat(ID, EVENT_ID, PRICE,CURRENCY, RESERVED) VALUES ( 'S6',3,7000,'HUF',true);
