-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 08, 2018 at 08:34 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `to4ka`
--
CREATE DATABASE IF NOT EXISTS `to4ka` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `to4ka`;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `ID` int(11) NOT NULL,
  `NAME` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `PARENT_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`ID`, `NAME`, `PARENT_ID`) VALUES
(1, 'Knifes', NULL),
(2, 'Bubbles', NULL),
(3, 'Bubbles1', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `mobile_tokens`
--

DROP TABLE IF EXISTS `mobile_tokens`;
CREATE TABLE `mobile_tokens` (
  `ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `TOKEN` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `DEVICE_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `prices`
--

DROP TABLE IF EXISTS `prices`;
CREATE TABLE `prices` (
  `ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `PRICE` float NOT NULL,
  `ON_DATE` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `ID` int(11) NOT NULL,
  `NAME` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `CURRENT_COUNT` int(11) DEFAULT NULL,
  `NOTIFICATION_COUNT` int(11) DEFAULT NULL,
  `DESCRIPTION` text CHARACTER SET cp1251 COLLATE cp1251_bin,
  `CATEGORY_ID` int(11) DEFAULT NULL,
  `IMAGE` text COLLATE utf8_bin,
  `CURRENT_PRICE_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `ID` int(11) NOT NULL,
  `PRODUCT_ID` int(11) NOT NULL,
  `COUNT` int(11) NOT NULL,
  `SALE_DATE` datetime NOT NULL,
  `SUMM` float NOT NULL,
  `PRICE` float NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `productsByProductId_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks` (
  `ID` int(11) NOT NULL,
  `DESCRIPTION` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `DUE_DATE` datetime NOT NULL,
  `NOTIF_BEFORE_MINUTES` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `FINISHED` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `FIO` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `USERNAME` text COLLATE utf8_bin NOT NULL,
  `PASSWORD` text COLLATE utf8_bin NOT NULL,
  `PHONE` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `COMMENT` text CHARACTER SET cp1251 COLLATE cp1251_bin NOT NULL,
  `IS_VOVA` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `mobile_tokens`
--
ALTER TABLE `mobile_tokens`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_cp7n1bd328njug3fn9590m30b` (`ID`),
  ADD KEY `mobile_tokens_ibfk_1` (`USER_ID`);

--
-- Indexes for table `prices`
--
ALTER TABLE `prices`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_jfgae00y7nytoh7ih11n52jee` (`ID`),
  ADD KEY `prices_ibfk_1` (`PRODUCT_ID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_38cdqoaf39eu3mubej9y1kr8i` (`ID`),
  ADD KEY `products_ibfk_1` (`CATEGORY_ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_qe6uwevnj0hkxxy6gxscsk5yr` (`ID`),
  ADD KEY `sales_ibfk_1` (`PRODUCT_ID`),
  ADD KEY `sales_ibfk_2` (`USER_ID`),
  ADD KEY `FKir23hrdivkowhj9l4gmy642on` (`productsByProductId_ID`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `UK_sjqc932v436nhauloo41yisbx` (`ID`),
  ADD KEY `tasks_ibfk_1` (`USER_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `mobile_tokens`
--
ALTER TABLE `mobile_tokens`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `prices`
--
ALTER TABLE `prices`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sales`
--
ALTER TABLE `sales`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mobile_tokens`
--
ALTER TABLE `mobile_tokens`
  ADD CONSTRAINT `FK2n3idonop08a4806mc17x19qy` FOREIGN KEY (`ID`) REFERENCES `mobile_tokens` (`ID`),
  ADD CONSTRAINT `mobile_tokens_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`);

--
-- Constraints for table `prices`
--
ALTER TABLE `prices`
  ADD CONSTRAINT `FKjuadi6k6m10yttc1wnrcu334g` FOREIGN KEY (`ID`) REFERENCES `prices` (`ID`),
  ADD CONSTRAINT `prices_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `products` (`ID`) ON DELETE NO ACTION;

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FK9764tap50no8d6qcdj2tfg4vf` FOREIGN KEY (`ID`) REFERENCES `products` (`ID`),
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`CATEGORY_ID`) REFERENCES `categories` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `FK8tnuckrtbqiql0c2u0c6r6vnl` FOREIGN KEY (`ID`) REFERENCES `sales` (`ID`),
  ADD CONSTRAINT `FKir23hrdivkowhj9l4gmy642on` FOREIGN KEY (`productsByProductId_ID`) REFERENCES `products` (`ID`),
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `products` (`ID`) ON DELETE NO ACTION,
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION;

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `FKrrr2ltfbc661eiqb2mfop9p92` FOREIGN KEY (`ID`) REFERENCES `tasks` (`ID`),
  ADD CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
