-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 18, 2023 at 07:21 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `userdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `Surname/name` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `PasswordN` varchar(50) NOT NULL,
  `SecurityQuestion` varchar(50) NOT NULL,
  `SecurityAnswer` varchar(50) NOT NULL,
  `Contact` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`Surname/name`, `Email`, `Password`, `PasswordN`, `SecurityQuestion`, `SecurityAnswer`, `Contact`) VALUES
('Balla Erjona', 'erjonaballa@gmail.com', '123', '123', 'Favorite singer', 'Sing', '069');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerNo` varchar(50) NOT NULL,
  `Surname/name` varchar(50) NOT NULL,
  `PassID` varchar(50) NOT NULL,
  `Birthdate` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Contact` varchar(50) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Address` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerNo`, `Surname/name`, `PassID`, `Birthdate`, `Gender`, `Contact`, `Email`, `Address`) VALUES
('C01', 'Balla Erjona', 'A12341234B', '2000-07-02', 'Female', '0691112223', 'erjona@gmail.com', 'F-K'),
('C02', 'Balla Renis', 'B123414321R', '2004-09-13', 'Male', '0691234123', 'Renis@gmail.com', 'F-K');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `FlightID` varchar(20) NOT NULL,
  `Source` varchar(50) NOT NULL,
  `Destination` varchar(50) NOT NULL,
  `Set_Flight` date NOT NULL,
  `Departure_Time` varchar(8) NOT NULL,
  `Arrival_Time` varchar(8) NOT NULL,
  `Flight_Charge` varchar(10) NOT NULL,
  `No.Of_Seats` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`FlightID`, `Source`, `Destination`, `Set_Flight`, `Departure_Time`, `Arrival_Time`, `Flight_Charge`, `No.Of_Seats`) VALUES
('1001', 'Bergamo-rio Al Serio, Italy ', 'Munich, Germany', '2023-03-30', '08:00', '09:55', '120', 30),
('1002', 'Bergamo-rio Al Serio, Italy ', 'Munich, Germany', '2023-03-20', '08:00', '09:55', '115', 30),
('1003', 'Pristina, Kosovo', 'Munich, Germany', '2023-03-01', '16:00', '18:00', '95', 30),
('1004', 'Athens, Greece', 'Munich, Germany', '2023-03-07', '12:00', '14:40', '135', 30),
('1006', 'Munich, Germany', 'Bergamo-rio Al Serio, Italy ', '2023-03-02', '10:00', '12:00', '125', 30),
('1007', 'Munich, Germany', 'Athens, Greece', '2023-03-09', '10:00', '12:50', '140', 30),
('1009', 'Heathrow, Londra', 'Nene Tereza, Tirana', '2023-02-14', '09:00', '14:00', '250', 30),
('1010', 'Bergamo-rio Al Serio, Italy ', 'Munich, Germany', '2023-03-23', '08:00', '09:55', '115', 30);

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `TicketNo` varchar(20) NOT NULL,
  `CustomerNo` varchar(20) NOT NULL,
  `Surname/name` varchar(50) NOT NULL,
  `PassID` varchar(50) NOT NULL,
  `FlightID` varchar(20) NOT NULL,
  `Set_Flight` date NOT NULL,
  `Departure_Time` varchar(20) NOT NULL,
  `Flight_Class` varchar(20) NOT NULL,
  `Flight_Charge` double NOT NULL,
  `SeatNo` int(10) NOT NULL,
  `Amount` double NOT NULL,
  `Status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`TicketNo`, `CustomerNo`, `Surname/name`, `PassID`, `FlightID`, `Set_Flight`, `Departure_Time`, `Flight_Class`, `Flight_Charge`, `SeatNo`, `Amount`, `Status`) VALUES
('T102', 'C01', 'Balla Erjona', 'A12345678B', '1002', '2023-02-17', '08:00', 'Bussines', 115, 2, 175, 'Available'),
('T104', 'C01', 'Balla Erjona', 'A12345678B', '1004', '2023-03-07', '12:00', 'First Class', 135, 1, 243, 'Available'),
('T105', 'C01', 'Balla Erjona', 'A12345678B', '1005', '2023-02-14', '09:00', 'Bussines', 70, 2, 168, 'Available'),
('T106', 'C01', 'Balla Erjona', 'A12345678B', '1006', '2023-03-02', '10:00', 'Bussines', 125, 1, 150, 'Available'),
('T110', 'C02', 'Balla Renis', 'B12345678R', '1002', '2023-02-17', '08:00', 'Economy', 115, 1, 80.5, 'Available'),
('T112', 'C02', 'Balla Renis', 'B12345678R', '1004', '2023-03-07', '12:00', 'Bussines', 135, 1, 162, 'Available'),
('T113', 'C02', 'Balla Renis', 'B12345678R', '1005', '2023-02-14', '09:00', 'Bussines', 70, 1, 84, 'Available'),
('T122', 'C01', 'Balla Erjona', 'A12345678B', '1002', '2023-02-17', '08:00', 'First Class', 2, 115, 414, 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `SurnameName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `PasswordN` varchar(50) NOT NULL,
  `SecurityQuestion` varchar(50) NOT NULL,
  `SecurityAnswer` varchar(50) NOT NULL,
  `Contact` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`SurnameName`, `Email`, `PasswordN`, `SecurityQuestion`, `SecurityAnswer`, `Contact`) VALUES
('Bru Al', 'BruAl@gmail.com', 'bru1997', 'Grandfather\'s profession', 'helper', ''),
('Balla Jona', 'erjona@gmail.com', '1122', 'Grandfather\'s profession', 'Tregtar', '0691231231'),
('Balla Renis', 'Renis@gmail.com', 'JamRenisi', 'Favourite singer', 'Singer', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerNo`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`FlightID`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`TicketNo`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`Email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
