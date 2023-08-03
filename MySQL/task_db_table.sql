CREATE TABLE user (
	userId INT PRIMARY KEY AUTO_INCREMENT,
	firstName VARCHAR(50) NOT NULL,
	lastName VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL UNIQUE,
	mobile VARCHAR(20) NOT NULL,
	language VARCHAR(50) NOT NULL,
	expirationDate TIMESTAMP NOT NULL,
	gender VARCHAR(10) NOT NULL,
	username VARCHAR(50) NOT NULL UNIQUE,
	hashPassword VARCHAR(255) NOT NULL,
	hashPassword2 VARCHAR(255) NOT NULL,
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL
);

CREATE TABLE account (
	accountId INT PRIMARY KEY AUTO_INCREMENT,
	accountName VARCHAR(255) NOT NULL,
	isActive BOOLEAN NOT NULL,
	numberOfUsers INT,
	timeZone VARCHAR(50),
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL
);

CREATE TABLE gpsPosition (
	positionId INT PRIMARY KEY AUTO_INCREMENT,
	latitude DECIMAL(11, 7) NOT NULL,
	longitude DECIMAL(11, 7) NOT NULL,
	positionDate TIMESTAMP NOT NULL,
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	speed DECIMAL(6, 2) NOT NULL,
	deviceId INT NOT NULL,
	isValid BOOLEAN NOT NULL,
	deviceStatus INT NOT NULL,
	currentDriver INT NOT NULL,
	accountId INT NOT NULL,
	CONSTRAINT fk_gpsPosition_account
	FOREIGN KEY (accountId)
	REFERENCES account (accountId),
	CONSTRAINT fk_gpsPosition_device
	FOREIGN KEY (deviceId)
	REFERENCES device (deviceId)
);

CREATE TABLE vehicle (
	vehicleId INT PRIMARY KEY AUTO_INCREMENT,
	deviceId INT NOT NULL,
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	vehicleBrand VARCHAR(50) NOT NULL,
	vehicleModel VARCHAR(50) NOT NULL,
	colour VARCHAR(50) NOT NULL,
	plateNumber VARCHAR(10) NOT NULL,
	horsePower INT NOT NULL,
	vehicleCategory INT NOT NULL, 
	defaultDriver INT NOT NULL,
	accountId INT NOT NULL,
	lastPositionId INT NOT NULL,
	CONSTRAINT fk_vehicle_users
	FOREIGN KEY (defaultDriver)
	REFERENCES user(userId),
	CONSTRAINT fk_vehicle_device
	FOREIGN KEY (deviceId)
	REFERENCES device(deviceId),
	CONSTRAINT fk_vehicle_account
	FOREIGN KEY (accountId)
	REFERENCES account (accountId),
	CONSTRAINT fk_vehicle_gpsPosition
	FOREIGN KEY (lastPositionId)
	REFERENCES gpsPosition(positionId)
);

CREATE TABLE device (
	deviceId INT PRIMARY KEY AUTO_INCREMENT,
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	extId VARCHAR(50) NOT NULL,
	typeId INT NOT NULL,
	deviceCategory TINYINT NOT NULL,
	accountId INT NOT NULL,
	CONSTRAINT fk_device_account
	FOREIGN KEY (accountId)
	REFERENCES account (accountId)
);

CREATE TABLE periph (
	periphId INT PRIMARY KEY AUTO_INCREMENT,
	deviceId INT NOT NULL,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255) NOT NULL,
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	isActive BOOLEAN NOT NULL,
	textParam TEXT NOT NULL,
	accountId INT NOT NULL,
	CONSTRAINT fk_device_periph
	FOREIGN KEY (deviceId)
	REFERENCES device(deviceId),
	CONSTRAINT fk_periph_account
	FOREIGN KEY (accountId)
	REFERENCES account(accountId)
);

CREATE TABLE `group` (
	groupId INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser int NOT NULL,
	accountId INT NOT NULL,
	isActive BOOLEAN NOT NULL,
	CONSTRAINT fk_group_account
	FOREIGN KEY (accountId)
	REFERENCES account(accountId)
);

CREATE TABLE groups_vehicles(
	id INT PRIMARY KEY AUTO_INCREMENT,
	groupId INT NOT NULL,
	vehicleId INT NOT NULL,
    creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	CONSTRAINT fk_groups_vehicles_group
	FOREIGN KEY (groupId)
	REFERENCES `group` (groupId),
	CONSTRAINT fk_groups_vehicles_vehicle
	FOREIGN KEY (vehicleId)
	REFERENCES vehicle(vehicleId)
);

CREATE TABLE groups_devices (
	id INT PRIMARY KEY AUTO_INCREMENT,
	groupId INT NOT NULL,
	deviceId INT NOT NULL,
    creationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	creationUser INT NOT NULL,
	modificationDate TIMESTAMP NOT NULL DEFAULT NOW(),
	modificationUser INT NOT NULL,
	CONSTRAINT groups_devices_group
	FOREIGN KEY (groupId)
	REFERENCES `group`(groupId),
	CONSTRAINT groups_devices_device
	FOREIGN KEY (deviceId)
	REFERENCES device(deviceId)
);
