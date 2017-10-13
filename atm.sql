CREATE DATABASE ATM;
USE ATM;

CREATE TABLE Customer (
ID INTEGER NOT NULL AUTO_INCREMENT,
firstName VARCHAR(50) NOT NULL,
lastName VARCHAR(30) NOT NULL,
JMBG CHAR(13) UNIQUE NOT NULL,
email VARCHAR(40),
PRIMARY KEY(ID)
);

create TABLE Account (
customerID INT,
username VARCHAR(20) UNIQUE NOT NULL,
pin VARCHAR(15) NOT NULL,
balance DECIMAL DEFAULT 0,
foreign key(customerID) references Customer(ID)
);

INSERT INTO Customer(firstName,lastName,JMBG,email) VALUES ('Tamara','Paocic','2108992150123','tamara.paocic@hotmail.com');
INSERT INTO Account(username,pin,customerID) VALUES ('tamara.p','147741',1);


INSERT INTO Customer(firstName,lastName,JMBG,email) VALUES ('Doris','Laco','2108992846146','docy@hotmail.com');
INSERT INTO Account(username,pin,customerID) VALUES ('doriiiis','1234',2);

INSERT INTO Customer(firstName,lastName,JMBG) VALUES ('Admin','','0000000000000','atmadmin@el.si');
INSERT INTO Account(username,pin,customerID) VALUES ('admin','comoestas,77',3);

INSERT INTO Customer(firstName,lastName,JMBG) VALUES ('Mirela','Dzindo','4500890000120');
INSERT INTO Account(username,pin,customerID) VALUES ('mirelaa','4444',4);

UPDATE Account SET Balance = 2000 WHERE customerID = 1;

SELECT username, pin FROM ATM.Account;

select * from account;

SELECT * FROM CUSTOMER;



