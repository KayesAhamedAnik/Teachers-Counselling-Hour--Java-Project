-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2019 at 07:50 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `q04`
--

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `facultyId` varchar(15) NOT NULL,
  `name` varchar(30) NOT NULL,
  `department` varchar(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `roomNo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`facultyId`, `name`, `department`, `email`, `roomNo`) VALUES
('1234', 'Nuzat Alam', 'EEE', 'nuzat@aiub.edu', '42012');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`) VALUES
('1234', '1234'),
('9595', '936523'),
('9999', '320818'),
('admin', 'admin'),
('kayes', '851170');

-- --------------------------------------------------------

--
-- Table structure for table `tsftable`
--

CREATE TABLE `tsftable` (
  `facultyId` varchar(10) NOT NULL,
  `day` varchar(10) NOT NULL DEFAULT '" "',
  `8-9` varchar(20) NOT NULL DEFAULT '" "',
  `9-10` varchar(20) NOT NULL DEFAULT '" "',
  `10-11` varchar(20) NOT NULL DEFAULT '" "',
  `11-12` varchar(20) NOT NULL DEFAULT '" "',
  `12-1` varchar(20) NOT NULL DEFAULT '" "',
  `1-2` varchar(20) NOT NULL DEFAULT '" "',
  `2-3` varchar(20) NOT NULL DEFAULT '" "',
  `3-4` varchar(20) NOT NULL DEFAULT '" "',
  `4-5` varchar(20) NOT NULL DEFAULT '" "'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tsftable`
--

INSERT INTO `tsftable` (`facultyId`, `day`, `8-9`, `9-10`, `10-11`, `11-12`, `12-1`, `1-2`, `2-3`, `3-4`, `4-5`) VALUES
('1234', 'Sunday', 'Counselling Hour ', 'Class Hour ', 'Counselling Hour ', '', 'Counselling Hour ', 'Counselling Hour ', 'Counselling Hour ', 'Class Hour ', 'Counselling Hour '),
('1234', 'Monday', 'Counselling Hour ', 'Class Hour ', 'Counselling Hour ', '', 'Counselling Hour ', 'Counselling Hour ', 'Counselling Hour ', 'Class Hour ', 'Counselling Hour '),
('1234', 'Wednesday', '', '', 'Class Hour ', '', '', 'Counselling Hour ', 'Class Hour ', '', ''),
('1234', 'Tuesday', '', 'Class Hour ', '', '', '', '', '', '', ''),
('1234', 'Sunday', '', '', '', '', '', '', '', '', ''),
('1234', 'Monday', '', '', '', '', '', '', '', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`facultyId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `tsftable`
--
ALTER TABLE `tsftable`
  ADD KEY `facultyId` (`facultyId`) USING BTREE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
