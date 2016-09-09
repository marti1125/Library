CREATE DATABASE Library;

USE Library;

-- Main tables

CREATE TABLE Author
(
idAuthor int NOT NULL AUTO_INCREMENT,
lastname varchar(50) NULL,
motherslastname varchar(50) NULL,
name varchar(50) NULL,
nationality varchar(50) NULL,
email varchar(60) NULL,
amountofbooks int NULL,
PRIMARY KEY (idAuthor)
);

CREATE TABLE Editorial
(
idEditorial int NOT NULL AUTO_INCREMENT,
name varchar(100) NOT NULL,
agent varchar(100) NULL,
address varchar(100) NULL,
phonenumber varchar(20) NULL,
PRIMARY KEY (idEditorial)
);

CREATE TABLE Category
(
idCategory int NOT NULL AUTO_INCREMENT,
description varchar(100) NOT NULL,
PRIMARY KEY (idCategory)
);


CREATE TABLE Book
(
idBook int NOT NULL AUTO_INCREMENT,
idCategory int NOT NULL,
idEditorial int NOT NULL,
title varchar(50) NOT NULL,
amountofpages int NULL,
language varchar(50) NOT NULL,
PRIMARY KEY (idBook),
FOREIGN KEY (idCategory) REFERENCES Category(idCategory),
FOREIGN KEY (idEditorial) REFERENCES Editorial(idEditorial)
);

CREATE TABLE AuthorBook
(
idAuthor int NOT NULL,
idBook int NOT NULL,
PRIMARY KEY (idAuthor, idBook),
FOREIGN KEY (idAuthor) REFERENCES Author(idAuthor),
FOREIGN KEY (idBook) REFERENCES Book(idBook)
);

CREATE TABLE TypeDemand
(
idTypeDemand int NOT NULL AUTO_INCREMENT,
description varchar(150) NULL,
PRIMARY KEY (idTypeDemand)
);

-- level of Demand H(High), M(Medium), L(Low)
CREATE TABLE LevelDemandBook
(
idLevelDemandBook int NOT NULL AUTO_INCREMENT,
idBook int NOT NULL,
idTypeDemand int NULL,
manytimes int NULL,
datecreation datetime NULL,
datelastupdate datetime NULL,
PRIMARY KEY (idLevelDemandBook),
FOREIGN KEY (idBook) REFERENCES Book(idBook),
FOREIGN KEY (idTypeDemand) REFERENCES TypeDemand(idTypeDemand)
);

CREATE TABLE Distributor
(
idDistributor int NOT NULL AUTO_INCREMENT,
code varchar(11) NOT NULL,
name varchar(200) NOT NULL,
address varchar(200) NULL,
phonenumber varchar(30) NULL,
email varchar(30) NULL,
PRIMARY KEY (idDistributor)
);

CREATE TABLE DistributorBook
(
idDistributor int NOT NULL,
idBook int NOT NULL,
PRIMARY KEY (idDistributor, idBook),
FOREIGN KEY (idDistributor) REFERENCES Distributor(idDistributor),
FOREIGN KEY (idBook) REFERENCES Book(idBook)
);

CREATE TABLE KindofUser
(
idKindofUser int NOT NULL AUTO_INCREMENT,
description varchar(200) NOT NULL,
PRIMARY KEY (idKindofUser)
);

CREATE TABLE User
(
idUser int NOT NULL AUTO_INCREMENT,
idKindofUser int NOT NULL,
username varchar(45) NOT NULL,
password varchar(45) NOT NULL,
lastname varchar(50) NULL,
motherslastname varchar(50) NULL,
name varchar(100) NULL,
photo varchar(100) NULL,
PRIMARY KEY (idUser),
FOREIGN KEY (idKindofUser) REFERENCES KindofUser(idKindofUser)
);

CREATE TABLE University
(
idUniversity int NOT NULL AUTO_INCREMENT,
name varchar(200) NOT NULL,
address varchar(200) NULL,
PRIMARY KEY (idUniversity)
);

CREATE TABLE Institute
(
idInstitute int NOT NULL AUTO_INCREMENT,
name varchar(200) NOT NULL,
address varchar(200) NULL,
PRIMARY KEY (idInstitute)
);

CREATE TABLE StudyCenterUser
(
idStudyCenterUser int NOT NULL AUTO_INCREMENT,
idUser int NOT NULL,
idUniversity int NULL,
idInstitute int NULL,
PRIMARY KEY (idStudyCenterUser, idUser),
FOREIGN KEY (idUser) REFERENCES User(idUser),
FOREIGN KEY (idUniversity) REFERENCES University(idUniversity),
FOREIGN KEY (idInstitute) REFERENCES Institute(idInstitute)
);


-- Status type: E(Enable), S(Stole), C(Cancel), L(Lost)
CREATE TABLE License
(
idLicense int NOT NULL AUTO_INCREMENT,
idUser int NOT NULL,
status char(1) NOT NULL,
observation varchar(100) NULL,
dateexpiration datetime NULL,
PRIMARY KEY (idLicense),
FOREIGN KEY (idUser) REFERENCES User(idUser)
);

CREATE TABLE TypeofRequest
(
idTypeofRequest int NOT NULL AUTO_INCREMENT,
description varchar(100) NULL,
PRIMARY KEY (idTypeofRequest)
);

CREATE TABLE Loan
(
idLoan int NOT NULL AUTO_INCREMENT,
dateloan date NULL,
datereturn date NULL,
returned bit(1) NULL,
outdate bit(1) NULL,
realdateuser datetime NULL,
amountbooks int NULL,
observation varchar(100) NULL,
datecreation datetime NULL,
datelastupdate datetime NULL,
PRIMARY KEY (idLoan)
);

CREATE TABLE LoanBook
(
idLoanBook int NOT NULL AUTO_INCREMENT,
idTypeofRequest int NOT NULL,
idBook int NOT NULL,
idLicense int NOT NULL,
PRIMARY KEY (idLoanBook, idTypeofRequest, idBook, idLicense),
FOREIGN KEY (idTypeofRequest) REFERENCES TypeofRequest(idTypeofRequest),
FOREIGN KEY (idBook) REFERENCES Book(idBook),
FOREIGN KEY (idLicense) REFERENCES License(idLicense)
);

CREATE TABLE ReadingRoom
(
idReadingRoom int NOT NULL AUTO_INCREMENT,
capacity int NULL,
status bit(1) NULL,
observation nvarchar(255) NULL,
PRIMARY KEY (idReadingRoom)
);

CREATE TABLE LoanReadingRoom
(
idLoanReadingRoom int NOT NULL AUTO_INCREMENT,
idReadingRoom int NOT NULL,
idLicense int NOT NULL,
enable bit(1) NULL,
date datetime NULL,
starttime datetime NULL,
finishtime datetime NULL,
datecreation datetime NULL,
datelastupdate datetime NULL,
PRIMARY KEY (idLoanReadingRoom),
FOREIGN KEY (idReadingRoom) REFERENCES ReadingRoom(idReadingRoom),
FOREIGN KEY (idLicense) REFERENCES License(idLicense)
);

CREATE TABLE HistoryRequirement
(
idHistoryRequirement int NOT NULL AUTO_INCREMENT,
idTypeofRequest int NULL,
idLoan int NULL,
idBook int NULL,
idLoanReadingRoom int NULL,
datecreation datetime NULL,
datelastupdate datetime NULL,
PRIMARY KEY (idHistoryRequirement),
FOREIGN KEY (idTypeofRequest) REFERENCES TypeofRequest(idTypeofRequest),
FOREIGN KEY (idLoan) REFERENCES Loan(idLoan),
FOREIGN KEY (idBook) REFERENCES Book(idBook),
FOREIGN KEY (idLoanReadingRoom) REFERENCES LoanReadingRoom(idLoanReadingRoom)
);
