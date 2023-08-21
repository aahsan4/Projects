create database FlightReservation;
use FlightReservation;

create table Airline (
	airlineCode varchar(10) PRIMARY KEY,
    companyName varchar(20) NOT NULL,
    country varchar(2) 
) ;

create table Airplane (
	planeID varchar(3) PRIMARY KEY,
    model varchar(10) NOT NULL,
    numberOfSeats int NOT NULL,
    airlineCode varchar(10) references Airline (airlineCode)
) ;
    
create table Route (
	routeID varchar(7) primary key,
    distance int
);

create table Airport (
	airportID varchar(3) PRIMARY KEY,
    airportName varchar(30) NOT NULL,
    streetName varchar(20) NOT NULL,
    city varchar(10) NOT NULL,
	zip varchar(5) NOT NULL,
    country varchar(10) NOT NULL
) ;

create table Flight (
	flightNumber varchar(5) PRIMARY KEY,
	price double,
    timeOfArrival time,
	dateOfArrival date,
	timeOfDeparture time,
    dateOfDeparture date,
    availableSeats int,
    planeID varchar(3) references Airplane (planeID),
    routeID varchar(7) references Airline (routeID)
) ;

create table TravelAgency (
	accountNumber varchar(5) PRIMARY KEY,
    name varchar(20),
    countryCode int,
    areaCode int,
    phoneNumber int
) ;

create table Employee (
	employeeID varchar(4) PRIMARY KEY,
    passcode varchar(7) NOT NULL,
    SSN varchar(9) unique,
    countryCode int,
    areaCode int,
    phoneNumber int,
    name varchar(20),
    email varchar(15),
    DOB date,
    streetName varchar(10),
    city varchar(10),
    zipCode varchar(5),
    jobTitle varchar(10),
    accountNum varchar(5) references TravelAgency (accountNumber)
) ;

create table Reservation (
	reservationID varchar(5) PRIMARY KEY,
    balance double,
    price double,
    deposit double,
    seatsBooked int,
    accountNum varchar(5) references TravelAgency (accountNumber)
) ;

create table Customer (
	emailID varchar(20) PRIMARY KEY,
    firstName varchar(10),
    middleInitial varchar(10),
    lastName varchar(10),
    phoneNumber varchar(10),
    billingAddress varchar(10),
    DOB date
);

create table Dependent (
	firstName varchar(10) PRIMARY KEY,
    middleInitial varchar(10),
    lastName varchar(10),
    DOB date,
    relationWCustomer varchar(10),
    email varchar(20) references Customer (emailID)
) ;

create table RequestInfo (
	flightNum varchar(10), accNum varchar(5) primary key 
    
);

create table Serves (
	email varchar(20), accNum varchar(5) primary key 
);

INSERT INTO Serves (email, accNum)
VALUES ('example1@example.com', 'ACC01'),
       ('example2@example.com', 'ACC02'),
       ('example3@example.com', 'ACC03');













