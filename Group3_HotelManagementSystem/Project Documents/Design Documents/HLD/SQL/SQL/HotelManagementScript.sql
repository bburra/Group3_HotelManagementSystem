DROP table hotel cascade constraints;
DROP table room_details cascade constraints;
DROP table booking_details cascade constraints;
DROP table user_details cascade constraints;
DROP table hotel_teaser;


CREATE TABLE hotel(
	hotel_id NUMBER(4) PRIMARY KEY,
	city VARCHAR2(10),
	hotel_name VARCHAR2(20),
	address VARCHAR2(50),
	description VARCHAR2(50),
	avg_rate_per_night NUMBER(8,2),
	phone_no1 VARCHAR2(10),
	phone_no2 VARCHAR2(10),
	rating NUMBER(1),
	email VARCHAR2(30),
	fax VARCHAR2(15)
);


CREATE TABLE room_details(
	room_id NUMBER(4) PRIMARY KEY,
	hotel_id NUMBER(4),
	room_no VARCHAR(4),
	room_type VARCHAR2(25) CHECK(room_type in('Standard non A/C room','Standard A/C room','Executive A/C room','Deluxe A/C room')),
	per_night_rate NUMBER(8,2),
	availability VARCHAR(4) CHECK(availability IN ('YES','NO')),
	FOREIGN KEY(hotel_id) REFERENCES hotel(hotel_id) on delete cascade
	);

CREATE TABLE user_details(
	user_id NUMBER(4)PRIMARY KEY,
	password VARCHAR2(15),
	role VARCHAR2(10),
	user_name VARCHAR2(30),
	mobile_no VARCHAR2(10),
	phone VARCHAR2(10),
	address VARCHAR2(100),
	email VARCHAR2(50)
);
	
CREATE TABLE booking_details(
	booking_id NUMBER(4) PRIMARY KEY,
	hotel_id NUMBER(4),
	room_id NUMBER(4), 
	user_id NUMBER(4),
	booked_from DATE,
	booked_to DATE,
	no_of_adults NUMBER(2), 
	no_of_children NUMBER(2),
	amount NUMBER(8,2),
	FOREIGN KEY(room_id) REFERENCES room_details(room_id) ON DELETE CASCADE,
	FOREIGN KEY(user_id) REFERENCES user_details(user_id) ON DELETE CASCADE,
	FOREIGN KEY(hotel_id) REFERENCES hotel(hotel_id) ON DELETE CASCADE
);



CREATE TABLE hotel_teaser(
	comm VARCHAR2(50)
);


insert into user_details values(1,'1rohit1','Customer','Rohit','9414252120','0122275641','Jaipur,Rajasthan','rohit@gmail.com');
insert into user_details values(2,'1bhuvnesh1','Customer','Bhuvnesh','9452103694','0253256314','Hyderabad,Telangana','bhuvnesh@gmail.com');
insert into user_details values(3,'1neha1','Customer','Neha','9789523642','0258236452','Haryana','neha@gmail.com');
insert into user_details values(4,'1safique1','Customer','Safique','9154625369','0253456123','Jhunjhunoo,Rajasthan','safique@gmail.com');
insert into user_details values(5,'1akash1','Customer','Akash','8754625312','0122275641','Meerut,UP','akash@gmail.com');
insert into user_details values(6,'1mihir1','Customer','Mihir','8012354692','0210369528','Meerut,UP','mihir@gmail.com');
insert into user_details values(7,'1kavita1','Customer','Kavita','7584623156','0145789256','Hyderabad,Telangana','kavita@gmail.com');
insert into user_details values(8,'1raunaq1','Customer','Raunaq','8596245621','0321295632','Meerut,UP','raunaq@gmail.com');
insert into user_details values(9,'1vinay1','Customer','Vinay','9758964236','0156425635','Hyderabad,AP','vinay@gmail.com');
insert into user_details values(10,'1nisha1','Customer','Nisha','9012356986','0142563895','Bhopal,MP','nisha@gmail.com');


insert into hotel values(1,'Pune','Hotel Grand','Talwade,Pune','Near MIDC Hub',1500,'9012356986','8142563895',3,'grand@gmail.com','12012');
insert into hotel values(2,'Mumbai','Hotel Alfa','Andheri,Mumbai','Near Asalpha Metro Station',1600,'8712356986','8141563895',4,'alfa@gmail.com','14365');
insert into hotel values(3,'Pune','Hotel Regent','Hinjewadi,Pune','Near MIDC Hub',1000,'9011526986','8147846895',2,'regent@gmail.com','45965');
insert into hotel values(4,'Bangalore','Hotel Surya Kiran','station road,Bangalore','Near Railway Station',5000,'7589456986','8945763895',5,'surya@gmail.com','14365');
insert into hotel values(5,'Mumbai','Hotel Satya','sakinaka,mumbai','Near Sakinaka metro Station',1300,'9048916986','7845163895',3,'satya@gmail.com','12595');
insert into hotel values(6,'Goa','Hotel Apporva','Panjim,Goa','Near All Beaches',1500,'9784556986','8485663895',3,'apoorva@gmail.com','78455');



insert into room_details values(1,1,201,'Standard A/C room',1600,'YES');
insert into room_details values(2,1,202,'Standard A/C room',1600,'YES');
insert into room_details values(3,1,203,'Standard non A/C room',1200,'YES');
insert into room_details values(4,1,301,'Executive A/C room',1800,'YES');
insert into room_details values(5,1,302,'Deluxe A/C room',2000,'YES');
insert into room_details values(6,2,101,'Deluxe A/C room',2500,'YES');
insert into room_details values(7,2,102,'Standard non A/C room',1100,'YES');
insert into room_details values(8,2,103,'Standard A/C room',1400,'YES');
insert into room_details values(9,2,104,'Standard A/C room',1600,'YES');
insert into room_details values(10,3,401,'Deluxe A/C room',1600,'YES');
insert into room_details values(11,3,402,'Standard non A/C room',1000,'YES');
insert into room_details values(12,3,403,'Standard A/C room',1300,'YES');
insert into room_details values(13,4,404,'Deluxe A/C room',1600,'YES');
insert into room_details values(14,4,405,'Executive A/C room',1800,'YES');
insert into room_details values(15,4,406,'Standard A/C room',1600,'YES');
insert into room_details values(16,4,407,'Executive A/C room',1700,'YES');
insert into room_details values(17,5,408,'Standard A/C room',1600,'YES');
insert into room_details values(18,5,409,'Deluxe A/C room',3000,'YES');
insert into room_details values(19,5,410,'Executive A/C room',2000,'YES');


insert into booking_details values(1,1,1,1,'15-nov-17','17-nov-17',2,0,1600);
insert into booking_details values(2,1,2,2,'16-nov-17','19-nov-17',3,0,4800);
insert into booking_details values(3,1,3,3,'14-nov-17','17-nov-17',2,0,3600);
insert into booking_details values(4,1,4,4,'17-nov-17','18-nov-17',2,0,1800);
insert into booking_details values(5,1,5,5,'18-nov-17','20-nov-17',3,0,4000);
insert into booking_details values(6,2,6,6,'16-nov-17','20-nov-17',2,0,10000);
insert into booking_details values(7,2,7,7,'20-nov-17','22-nov-17',2,0,2200);
insert into booking_details values(8,2,8,8,'19-nov-17','21-nov-17',3,0,2800);
insert into booking_details values(9,2,9,9,'20-nov-17','21-nov-17',2,0,1600);
insert into booking_details values(10,3,10,10,'19-nov-17','21-nov-17',2,0,3200);
insert into booking_details values(11,3,11,1,'22-nov-17','24-nov-17',3,0,2000);
insert into booking_details values(12,3,12,2,'19-nov-17','22-nov-17',2,0,3900);
insert into booking_details values(13,4,13,3,'19-nov-17','21-nov-17',3,0,3200);
insert into booking_details values(14,4,14,4,'21-nov-17','22-nov-17',2,0,1800);
insert into booking_details values(15,4,15,5,'17-nov-17','18-nov-17',2,0,1600);
insert into booking_details values(16,4,16,6,'15-nov-17','17-nov-17',2,0,3400);
insert into booking_details values(17,5,17,7,'20-nov-17','21-nov-17',2,0,1600);
insert into booking_details values(18,5,18,8,'17-nov-17','20-nov-17',3,0,9000);
insert into booking_details values(19,5,19,9,'15-nov-17','19-nov-17',2,0,8000);

commit;