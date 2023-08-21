/* The system can handle insertion of any flight information */
INSERT INTO Flight VALUES 
('F540', 550.00, '11:10:00', '2023-07-01', '11:00:00', '2023-08-01', 300, 'A01', 'DAL-ATL');

/* The system can handle insertion of any customer information */
INSERT INTO CUSTOMER VALUES
("DBC@YAHOO.COM","NATE","M","DIAZ","874950","28 N ST","1990-08-08");

/* The system can handle insertion of any dependent of customer information */
INSERT INTO DEPENDENT VALUES
("ANINDA","C","LACE","1958-03-03","MOTHER","ACA@GMAIL.COM");

/* The system can handle insertion of any employee of a travel agency information */
INSERT INTO EMPLOYEE VALUES
("1071","2458","258741258","01","88","123654","Joshua","jp@gmail.com","1058-9-21","2ndstreet","NYC","30055","manager","TA111");

/* The system can handle insertion of any reservation made */
INSERT INTO RESERVATION VALUES
('RES72', 200.00, 800.00, 600.00, 3, 'ACC04',"BCD@GMAIL.COM");

/* getting date of flight numbers of flights that have a specific price*/
SELECT f.flightNumber 
FROM FLIGHT f
WHERE price < 400;

/* getting date of arrival of flights that fly out of a specific airport */
SELECT f.dateOfDeparture
FROM FLIGHT f 
WHERE f.routeID LIKE "%NYC%";

/* acquiring flight number of flights that fly a specific route */
SELECT f.flightNumber 
from flight f
where f.routeID = "HOU-ATL";

/* acquiring deposit amount from the reservation table of a specific customer */
select r.deposit
from reservation r
where r.customerEmail = "johndoe@example.com";

/* select first and last name of customer who made reservations */
select firstName, lastName
from reservation r, customer c
where r.customerEmail = c.emailID;


