-- 1 Select all vehicles, that have attached device
SELECT vehicleBrand, vehicleModel, colour FROM vehicle WHERE deviceId IS NOT NULL;

SELECT vehicleBrand, vehicleModel, colour FROM vehicle AS v
JOIN device AS d ON v.deviceId = d.deviceId;

-- 2 Select all devices with more than one periph attached
SELECT extId, COUNT(p.name) AS count_of_periph FROM device AS d
JOIN periph AS p ON d.deviceId = p.deviceId
GROUP BY d.deviceId
HAVING count_of_periph > 1;

-- 3 Select all vehicles with more than 50 hp
SELECT * FROM vehicle WHERE horsePower > 50;

-- 4 Select all entities for one specific account (all vehicles, devices and periphs)
SELECT vehicleBrand, extId, p.name, a.accountId, accountName FROM account AS a
JOIN periph AS p ON a.accountId = p.accountId
JOIN device AS d ON p.deviceId = d.deviceId
JOIN vehicle AS v ON d.deviceId = v.deviceId
WHERE a.accountId = 72;

-- 5 Select all periphs for a specific vehicle, ordered by modification date descending
SELECT vehicleId, vehicleBrand, vehicleModel, v.modificationDate, name FROM vehicle AS v
JOIN device AS d ON v.deviceId = d.deviceId
JOIN periph AS p ON d.deviceId = p.deviceId
ORDER BY v.modificationDate DESC;

-- 6 Select all gpsPositions for a specific device, that occurred the last 7 days
SELECT latitude, longitude, positionDate, d.deviceId, extId FROM gpsPosition AS gp
JOIN device AS d ON gp.deviceId = d.deviceId
WHERE positionDate > NOW() - INTERVAL 700 DAY AND d.deviceId = 34;

-- 7 Select first name and last name (in one column) of all the users, that are active
SELECT CONCAT(firstName, ' ', lastName) AS full_name FROM user
WHERE NOW() < expirationDate;

-- 8 Select all users that haven’t filled their emails
SELECT * FROM user WHERE email IS NULL;

-- 9 Select all vehicles that have ‘3’ in the plate number
SELECT vehicleBrand, vehicleModel, colour, horsePower, plateNumber FROM vehicle
WHERE plateNumber LIKE '%3%';

-- 10 Select the last 10 added devices
SELECT deviceId, extId, creationDate FROM device
ORDER BY creationDate DESC
LIMIT 10;

-- 11 Select 5 vehicles with minimal hp
SELECT vehicleBrand, horsePower FROM vehicle
ORDER BY horsePower
LIMIT 5;

-- 12 Select all the positions and vehicles, for which a specific user has been a driver
SELECT firstName, latitude, longitude, positionDate FROM user AS u
JOIN gpsPosition AS gp ON u.userId = gp.currentDriver
WHERE userId = 9;

-- 13 Select the average speed of the positions for a specific account
SELECT accountName, ROUND(AVG(speed), 2) AS average_speed, COUNT(positionId) AS count FROM account AS a
JOIN gpsPosition AS gp ON a.accountId = gp.accountId
GROUP BY a.accountId
HAVING a.accountName = 42133238;

-- 14 
