use flightreservation;
insert into airline values 
("USAA","USAirlines","US"),
("United","UnitedAirlines","US"),
("QatarAir","QatarAirlines","QA"),
("SaudiAir","SaudiAirlines","SA");

insert into airplane values 
("a12","Boeing",25,"USAA"),
("b23","Airbus",45,"United"),
("c34","Boeing",56,"Qatar"),
("d54","Airbus",67,"SA");

select * from airplane;

insert into airport values 
("ATL","Hartsfield","Downtown","Atlanta","30025","USA"),
("LAX","LosAirport","DowntownLA","LosAngeles","70125","USA"),
("JFk","John Kennedy","DowntownNY","New York","40055","USA");

insert into customer values 
("abc@gmail.com","Omar","A.","Madjitov","770875895","22 street","1234-12-14"),
("nbcc@gmail.com","lamar","A.","jack","772855895","25 street","1274-8-23"),
("xbc@gmail.com","damar","A.","hamlin","870875295","12 street","1999-02-12");

insert into dependent values 
("rakim","b.","karim","1478-6-24","son","abc@gmail.com"),
("rahim","c.","barim","1428-7-15","daughter","nbcc@gmail.com"),
("farim","d.","labik","1728-7-15","nephew","xbc@gmail.com");

insert into employee values 
("1234","2587","125748","00","88","258741","Abu","abc@gmail.com","1258-9-21","12street","atl","30044","accnt","12345"),
("1235","1587","125648","01","78","248741","ibu","bbc@gmail.com","1358-9-21","17street","ctl","00044","lawyer","22345"),
("2234","3587","125848","10","98","278741","bibu","nbc@gmail.com","1858-4-11","20street","col","20044","admin","52345");

INSERT INTO Flight VALUES 
('FL001', 250.00, '18:00:00', '2023-05-01', '12:00:00', '2023-05-01', 100, 'Q77', 'ATL-NYC'),
('FL002', 300.00, '20:00:00', '2023-05-02', '14:00:00', '2023-05-02', 50, 'P78', 'LAS-HOU'),
('FL003', 200.00, '22:00:00', '2023-05-03', '16:00:00', '2023-05-03', 75, 'R34', 'COL-CHI');

INSERT INTO RequestInfo VALUES 
('FL001', 'ACC01'),
('FL002', 'ACC02'),
('FL003', 'ACC03');

INSERT INTO Reservation (reservationID, balance, price, deposit, seatsBooked, accountNum)
VALUES ('RES01', 150.00, 300.00, 75.00, 2, 'ACC01'),
       ('RES02', 200.00, 350.00, 100.00, 3, 'ACC02'),
       ('RES03', 100.00, 200.00, 50.00, 1, 'ACC03');

INSERT INTO Route (routeID, distance)
VALUES ('ATL-NYC', 500),
       ('LAS-COL', 750),
       ('CHI-ARI', 1000);

INSERT INTO TravelAgency (accountNumber, name, countryCode, areaCode, phoneNumber)
VALUES ('ACC01', 'Agency One', 1, 123, 4567890),
       ('ACC02', 'Agency Two', 1, 234, 5678901),
       ('ACC03', 'Agency Three', 1, 345, 6789012);

insert into route values 
("ATL-LAS",6000);
select * from route;


