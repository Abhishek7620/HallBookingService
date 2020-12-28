/***

****HALL BOOKING SERVICE ***********

***/
Unable to share complete project..

Due gmail restrication  kindly follow below to run the folder
----------- ---------------------------
Install;
Just make Sure you have below:
:Maven
:IDE
:JAVA 1.8 or above;
:Any database --(MYSQL or any other

Steps;
1) Create a spring boot dummyproject.
2)name as test.
3)add everything from pom.xml
4) replace the src folder with with your src..

=----------------------------------------------------------------------------------------------------

API URLS :
//Server port in application.properties is 900 you can use either the same port or can change----

Creating HALL MASTER DATA;

Use below 
URL: localhost:{server port}/createNewHall
request:
{
	
	"hallName":"Hall-5",
	"capacity":1000
}

Booking  HALL;

URL :localhost:{server port}/bookHall

----------------------Request Packet: for hall booking service-------------------------------------

{
	
"date":"01/11/2020",
"timeDuration":"1300-1200",
"capacityRequired":50
}

EXPAILATION:
--------------
DATE sHOULD BE DD/MM/YYYY -FORMAT
TIME SHOULD BE 24 HOUR FORMAT LIKE 01:00AM --0100 and  01:00 PM--1300
capacity required should be integer format.

------------------------------------------------------------------------------------------------
Response Packet Should be like below:

{
    "id": 41,
    "hallName": "Hall-1",
    "bookingDate": "01/11/2020",
    "bookingtime": "1300-1200",
    "status": "Booked",
    "capacity": 50
}

