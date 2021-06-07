-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 07, 2021 at 08:19 AM
-- Server version: 5.7.31
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodappdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
CREATE TABLE IF NOT EXISTS `bill` (
  `bill_no` int(11) NOT NULL AUTO_INCREMENT,
  `bill_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mobileno` varchar(15) NOT NULL,
  PRIMARY KEY (`bill_no`)
) ENGINE=MyISAM AUTO_INCREMENT=159 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_no`, `bill_date`, `mobileno`) VALUES
(136, '2021-03-15 02:39:01', '9998252337'),
(135, '2021-03-11 04:49:10', '9998252337'),
(134, '2021-03-11 04:44:49', '9998252337'),
(133, '2021-03-11 04:44:02', '9998252337'),
(132, '2021-03-11 04:40:34', '9998252337'),
(131, '2021-03-11 04:40:07', '9998252337'),
(130, '2021-03-11 04:39:25', '9998252337'),
(129, '2021-03-11 04:37:30', '9998252337'),
(128, '2021-03-11 04:33:59', '9998252337'),
(127, '2021-03-11 04:24:22', '9998252337'),
(126, '2021-03-11 04:20:11', '9998252337'),
(125, '2021-03-11 04:13:37', '9998252337'),
(124, '2021-03-11 04:09:04', '9998252337'),
(123, '2021-03-11 04:08:32', '9998252337'),
(122, '2021-02-20 15:05:54', '9998252337'),
(121, '2021-02-20 09:39:54', '9998252337'),
(120, '2021-02-20 09:39:06', '9998252337'),
(119, '2021-02-20 09:30:28', '9998252337'),
(118, '2021-02-20 09:29:29', '9998252337'),
(117, '2021-02-20 09:26:15', '9998252337'),
(116, '2021-02-20 09:16:29', '9998252337'),
(115, '2021-02-20 09:09:45', '9998252337'),
(114, '2021-02-20 08:56:42', '9998252337'),
(113, '2021-02-20 08:44:29', '9998252337'),
(112, '2021-02-20 08:41:10', '9998252337'),
(111, '2021-02-20 08:40:33', '9998252337'),
(110, '2021-02-20 08:39:56', '9998252337'),
(109, '2021-02-20 08:38:27', '9998252337'),
(108, '2021-02-20 08:33:26', '9998252337'),
(107, '2021-02-20 08:27:13', '9998252337'),
(106, '2021-02-20 08:26:33', '9998252337'),
(105, '2021-02-20 08:25:06', '9998252337'),
(104, '2021-02-20 08:15:21', '9998252337'),
(103, '2021-02-20 08:14:36', '9998252337'),
(137, '2021-03-15 03:51:42', ''),
(138, '2021-03-17 08:32:46', '9998252337'),
(139, '2021-03-17 09:00:00', ''),
(140, '2021-03-17 09:03:16', ''),
(141, '2021-03-17 09:05:44', '9998252337'),
(142, '2021-03-17 09:06:14', ''),
(143, '2021-03-17 09:08:11', '9998252337'),
(144, '2021-03-17 09:08:33', '9998252337'),
(145, '2021-03-17 09:31:07', '9998252637'),
(146, '2021-03-17 09:57:53', '9998252637'),
(147, '2021-03-17 09:59:35', '9998252637'),
(148, '2021-03-17 10:16:32', '9998252637'),
(149, '2021-03-17 16:42:49', '9998252337'),
(150, '2021-06-07 06:19:41', '9998252337'),
(151, '2021-06-07 06:19:56', '9998252337'),
(152, '2021-06-07 06:22:05', '9998252337'),
(153, '2021-06-07 06:27:53', '9998252337'),
(154, '2021-06-07 06:42:24', '9998252337'),
(155, '2021-06-07 07:04:05', '9998252337'),
(156, '2021-06-07 07:10:41', '9998252337'),
(157, '2021-06-07 07:18:56', '9998252337'),
(158, '2021-06-07 07:19:16', '9998252337');

-- --------------------------------------------------------

--
-- Table structure for table `bill_det`
--

DROP TABLE IF EXISTS `bill_det`;
CREATE TABLE IF NOT EXISTS `bill_det` (
  `bill_no` int(11) NOT NULL,
  `itemid` int(11) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bill_det`
--

INSERT INTO `bill_det` (`bill_no`, `itemid`, `qty`) VALUES
(111, 5, 2),
(110, 1, 2),
(109, 1, 2),
(109, 2, 2),
(109, 3, 5),
(109, 4, 5),
(109, 5, 2),
(109, 6, 2),
(109, 7, 2),
(109, 8, 5),
(109, 12, 2),
(109, 12, 2),
(109, 9, 5),
(109, 10, 5),
(109, 11, 2),
(108, 1, 1),
(108, 2, 5),
(108, 13, 5),
(108, 4, 2),
(108, 17, 2),
(108, 18, 5),
(108, 19, 5),
(108, 12, 5),
(108, 15, 5),
(108, 16, 5),
(108, 12, 5),
(108, 5, 5),
(108, 11, 5),
(107, 3, 2),
(106, 1, 5),
(106, 2, 2),
(105, 1, 5),
(104, 1, 5),
(103, 1, 2),
(103, 5, 5),
(103, 1, 5),
(103, 6, 2),
(103, 5, 5),
(112, 1, 2),
(113, 11, 2),
(113, 10, 2),
(113, 9, 2),
(113, 8, 2),
(113, 7, 2),
(113, 6, 2),
(113, 5, 2),
(113, 4, 2),
(113, 1, 2),
(113, 3, 2),
(113, 2, 2),
(113, 2, 2),
(113, 1, 2),
(113, 12, 2),
(113, 13, 2),
(113, 14, 2),
(113, 18, 5),
(114, 11, 2),
(114, 10, 2),
(114, 9, 2),
(114, 8, 2),
(114, 7, 2),
(114, 6, 2),
(114, 5, 2),
(114, 4, 2),
(114, 3, 2),
(114, 2, 2),
(114, 2, 2),
(114, 2, 2),
(114, 2, 2),
(114, 2, 2),
(114, 2, 2),
(114, 2, 2),
(114, 1, 1),
(114, 12, 2),
(114, 13, 2),
(114, 14, 2),
(114, 15, 2),
(114, 16, 2),
(114, 19, 5),
(115, 2, 5),
(115, 1, 2),
(116, 1, 2),
(117, 1, 2),
(118, 1, 8),
(119, 4, 5),
(120, 1, 5),
(121, 5, 5),
(122, 12, 2),
(123, 5, 2),
(124, 5, 5),
(125, 1, 2),
(126, 1, 2),
(127, 12, 5),
(127, 1, 6),
(127, 1, 2),
(127, 6, 5),
(127, 6, 2),
(128, 1, 1),
(128, 1, 5),
(129, 17, 2),
(130, 4, 8),
(131, 1, 5),
(131, 1, 5),
(132, 12, 5),
(133, 5, 2),
(134, 1, 6),
(135, 13, 2),
(136, 1, 5),
(137, 1, 2),
(138, 1, 1),
(139, 1, 5),
(140, 1, 56),
(140, 1, 56),
(141, 1, 56),
(142, 1, 5),
(143, 1, 5),
(144, 1, 5),
(145, 1, 5),
(146, 1, 2),
(146, 5, 5),
(146, 1, 2),
(147, 1, 5),
(148, 2, 8),
(148, 13, 2),
(149, 1, 2),
(149, 1, 2),
(149, 1, 2),
(149, 13, 2),
(149, 1, 5),
(153, 1, 5),
(154, 1, 8),
(155, 1, 2),
(156, 1, 5),
(157, 1, 5),
(158, 1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` double(11,2) NOT NULL,
  `category` varchar(50) NOT NULL,
  `photo` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `price`, `category`, `photo`) VALUES
(1, 'Margarita Pizza', 3.75, 'Pizza', 'margarita.jpg'),
(2, 'Chicken Alfredo Pizza', 5.99, 'Pizza', 'chicken_alfredo.jpg'),
(3, 'Pepperoni Lovers Pizza', 4.74, 'Pizza', 'pepperoni_lovers.jpg'),
(4, 'Plain Nutella Pizza', 3.44, 'Pizza', 'plain_nutella.jpg'),
(5, 'Philly Steak Sandwich', 2.54, 'Sandwich', 'philly_steak.jpg'),
(6, 'Spicy Chicken Sandwich', 2.37, 'Sandwich', 'spicy_chicken.jpg'),
(7, 'Hotdog Sandwich', 2.15, 'Sandwich', 'hotdog.jpg'),
(8, 'Turkey Sandwich', 2.37, 'Sandwich', 'turkey.jpg'),
(12, 'Tuna Salad', 2.59, 'Salad', 'tuna.jpg'),
(9, 'Caesar Salad', 3.01, 'Salad', 'caesar.jpg'),
(10, 'Greek Salad', 2.37, 'Salad', 'greek.jpg'),
(11, 'Arabic Salad', 1.94, 'Salad', 'arabic.jpg'),
(13, 'Pepsi', 0.52, 'Beverages', 'pepsi.jpg'),
(14, 'Diet Pepsi', 0.52, 'Beverages', 'diet_pepsi.jpg'),
(15, 'Mountain Dew', 0.52, 'Beverages', 'mountain_dew.jpg'),
(16, 'Mineral Water (Small)', 0.26, 'Beverages', 'mineral_water.jpg'),
(17, 'Boneless Wings', 3.02, 'Extra', 'boneless_wings.jpg'),
(18, 'French Fries', 0.86, 'Extra', 'french_fries.jpg'),
(19, 'Potato Wedges', 1.29, 'Extra', 'potato_wedges.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `temp_order`
--

DROP TABLE IF EXISTS `temp_order`;
CREATE TABLE IF NOT EXISTS `temp_order` (
  `mobileno` varchar(15) NOT NULL,
  `itemid` int(11) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temp_order`
--

INSERT INTO `temp_order` (`mobileno`, `itemid`, `qty`) VALUES
('98989', 1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `mobileno` varchar(15) NOT NULL,
  `password` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`mobileno`, `password`, `name`, `address`) VALUES
('9998252637', 'ankur', 'ankur', 'antilla'),
('98989', '1111', 'xbxb', 'xnxn'),
('9998252664', 'ankita', 'ankita', 'antilla'),
('99982525334', 'bharti', 'Bharti', 'Antilla'),
('9998219037', 'nagsen', 'Nagsen Tambe', 'Antilla'),
('9998252337', 'ankur', 'Ankur Tambe', 'Antilla');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
