
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 20, 2015 at 03:47 PM
-- Server version: 5.1.69
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `u642446441_youtu`
--

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cost` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `seller_id` int(11) DEFAULT NULL,
  `bids` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FULLTEXT KEY `cost` (`cost`),
  FULLTEXT KEY `cost_2` (`cost`),
  FULLTEXT KEY `name` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `cost`, `seller_id`, `bids`) VALUES
(1, 'Brand New iMac Computer', '885.06', 28, 40),
(2, 'used diaper from my sister', '801.84', 28, 471),
(3, 'Fresh apple pie', '988.33', 34, 487),
(4, 'New gym socks', '940.37', 41, 495),
(5, 'Weedwacker only slightly used', '682.33', 65, 403),
(6, 'New ipad stolen from best buy', '546.67', 78, 277),
(7, 'Book about having babies', '701.46', 78, 556),
(8, 'Woman jeans', '130.95', 23, 279),
(9, 'traditional carpet', '227.91', 58, 394),
(10, 'shows', '691.11', 76, 295),
(11, 'beer', '79.34', 1, 278),
(12, 'box of frogs', '77.21', 37, 170),
(13, 'laptop', '493.39', 2, 126),
(14, 'bed', '496.91', 85, 147),
(15, 'thumbelina', '545.61', 70, 466),
(16, 'stove', '103.52', 83, 596),
(17, 'shampoing', '272.12', 6, 108),
(18, 'stove', '264.21', 11, 29),
(19, 'microwave', '660.13', 6, 60),
(20, 'computer', '67.70', 1, 77),
(21, 'awesome alien computer', '872.39', 14, 111),
(22, 'new curtain for bedroom', '324.28', 94, 174),
(23, '3 boxes of frogs', '30.48', 6, 328),
(24, 'newspaper', '813.85', 86, 403),
(25, 'pan', '139.97', 24, 322),
(26, 'baby coat', '620.63', 52, 619),
(27, 'supercomputer', '151.99', 86, 34),
(28, 'Shufflester', '373.14', 10, 358),
(29, 'refrigerator', '860.90', 20, 474),
(30, 'gold necklace', '402.53', 52, 651),
(31, '7 boxes of frogs', '393.28', 6, 82),
(32, '48 boxes of frogs', '302.47', 68, 655),
(33, 'used car', '5700.5', 12, 509),
(34, 'gold earring', '328.01', 5, 212),
(35, 'scarf', '629.09', 71, 643),
(36, 'hairdryer', '130.55', 12, 71),
(37, 'play station', '256', 12, 87),
(38, 'bikini', '243.82', 12, 346),
(39, 'air conditioner ', '204.76', 12, 686),
(40, 'baby seat', '206.88', 13, 357),
(41, 'baby soap', '1.49', 74, 307),
(42, 'baby bottle', '125.36', 18, 278),
(43, 'Twitterlist', '69.74', 92, 478),
(44, 'Jayo', '807.12', 75, 582),
(45, 'Jatri', '456.33', 33, 306),
(46, 'Wikizz', '714.29', 80, 491),
(47, 'Twitterbridge', '928.97', 10, 98),
(48, 'Agimba', '204.39', 7, 387),
(49, 'Meevee', '169.94', 90, 112),
(50, 'Fivebridge', '353.47', 5, 99),
(51, 'Jaxworks', '296.30', 60, 70),
(52, 'Realpoint', '216.02', 64, 178),
(53, 'Skipstorm', '261.07', 64, 454),
(54, 'Thoughtbridge', '759.87', 29, 420),
(55, 'Cogibox', '43.69', 84, 336),
(56, 'Skinix', '146.85', 25, 312),
(57, 'Thoughtworks', '18.62', 93, 334),
(58, 'Twitternation', '916.97', 100, 464),
(59, 'Youopia', '725.61', 38, 454),
(60, 'Eamia', '906.61', 21, 145),
(61, 'Zoombeat', '309.98', 94, 640),
(62, 'Quatz', '799.10', 79, 351),
(63, 'Mudo', '32.57', 99, 369),
(64, 'Rhybox', '203.93', 26, 185),
(65, 'Babbleblab', '451.66', 62, 232),
(66, 'Zoozzy', '746.41', 54, 545),
(67, 'Wikizz', '993.06', 15, 310),
(68, 'Zoombox', '367.93', 15, 141),
(69, 'Reallinks', '756.04', 26, 94),
(70, 'Shufflester', '652.72', 93, 630),
(71, 'Jetpulse', '482.97', 37, 347),
(72, 'Minyx', '834.23', 84, 265),
(73, 'Photojam', '411.57', 53, 522),
(74, 'Photofeed', '358.93', 17, 393),
(75, 'Yamia', '119.07', 81, 150),
(76, 'Jabbertype', '147.49', 2, 366),
(77, 'Mynte', '221.60', 60, 336),
(78, 'Devbug', '175.36', 86, 94),
(79, 'Einti', '915.96', 52, 369),
(80, 'Yabox', '913.18', 32, 523),
(81, 'Skynoodle', '799.71', 43, 221),
(82, 'Skynoodle', '354.81', 63, 32),
(83, 'Bluezoom', '185.87', 40, 441),
(84, 'Topicware', '549.39', 3, 114),
(85, 'Rooxo', '976.30', 45, 382),
(86, 'Gabtype', '837.82', 31, 660),
(87, 'Rooxo', '122.51', 16, 369),
(88, 'Jatri', '548.83', 55, 308),
(89, 'Yabox', '748.64', 56, 128),
(90, 'Linkbuzz', '582.75', 67, 49),
(91, 'Centimia', '603.25', 25, 223),
(92, 'Devify', '332.73', 65, 539),
(93, 'Yambee', '733.56', 14, 200),
(94, 'Oyope', '882.47', 2, 194),
(95, 'Buzzshare', '251.70', 92, 475),
(96, 'Muxo', '580.62', 4, 183),
(97, 'Flipbug', '320.47', 89, 491),
(98, 'Ainyx', '297.66', 52, 283),
(99, 'Topicblab', '499.75', 50, 247),
(100, 'Jaxworks', '850.49', 96, 183);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
