-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Dec 18, 2023 at 11:56 PM
-- Server version: 5.7.39-log
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `dogs`
--

CREATE TABLE `dogs` (
  `id` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `breed` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dogs`
--

INSERT INTO `dogs` (`id`, `age`, `name`, `breed`) VALUES
(1, 5, 'Sharik', 'Shepherd'),
(2, 7, 'Tuzik', 'Bulldog'),
(3, 10, 'Bobik', 'Spaniel'),
(4, 9, 'Rex', 'No breed'),
(5, 9, 'Muhtar', 'Shibu inu');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) NOT NULL DEFAULT 'Stranger',
  `age` int(11) NOT NULL,
  `office_id` int(11) NOT NULL,
  `passport_id` int(11) NOT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `last_name`, `age`, `office_id`, `passport_id`, `updated_ts`, `created_ts`) VALUES
(1, 'Bill', 'Stranger', 35, 5, 1, NULL, '2023-12-18 20:18:50'),
(2, 'Mike', 'Stranger', 55, 1, 2, NULL, '2023-09-25 18:28:44'),
(3, 'John', 'Stranger', 35, 1, 3, NULL, '2023-09-27 16:55:28'),
(4, 'Ivan', 'Ivanov', 37, 4, 4, NULL, '2023-09-27 16:58:47'),
(7, 'Olga', 'Stranger', 18, 3, 6, NULL, '2023-09-27 15:32:16'),
(8, 'ad', 'added', 34, 9, 17, NULL, '2023-11-23 16:31:56'),
(9, 'fjdpass', 'feqrfb', 112, 1, 19, NULL, '2023-11-26 09:17:52');

-- --------------------------------------------------------

--
-- Table structure for table `offices`
--

CREATE TABLE `offices` (
  `id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `address` varchar(256) NOT NULL,
  `phone_1` varchar(128) NOT NULL,
  `phone_2` varchar(128) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `offices`
--

INSERT INTO `offices` (`id`, `title`, `address`, `phone_1`, `phone_2`, `postal_code`, `updated_ts`, `created_ts`) VALUES
(1, 'MAIN', 'BLR, Minsk, K.Marksa 32', '+375172416974', '+375172416975', 220111, NULL, '2023-09-27 16:32:41'),
(2, 'DEP#1', 'BLR, Minsk, K.Marksa 34', '+375172417974', '+375172417975', 220111, NULL, '2023-09-27 16:32:41'),
(3, 'DEP#2', 'BLR, Minsk, K.Marksa 35', '+375179046974', '+375172404975', 220111, NULL, '2023-09-27 16:32:41'),
(4, 'MAIN', 'GERM', '123', '321', 220222, NULL, '2023-10-16 16:00:35'),
(5, 'MAIN', 'FR', '123', '321', 220222, NULL, '2023-10-15 06:20:24'),
(6, 'MAIN 2', 'address', '123', '123', 2222222, NULL, '2023-10-11 19:41:29'),
(8, 'MAIN 2', 'address', '123', '123', 2222222, NULL, '2023-10-12 16:42:59'),
(9, 'MAIN 2', 'address', '123', '123', 2222222, NULL, '2023-10-14 12:36:05'),
(55, 'main', 'BLR', '+4567890', '+3456789', 200220, NULL, '2023-10-14 12:40:12');

-- --------------------------------------------------------

--
-- Table structure for table `passport`
--

CREATE TABLE `passport` (
  `id` int(11) NOT NULL,
  `personal_id` varchar(9) NOT NULL,
  `ind_id` varchar(20) NOT NULL,
  `exp_ts` date NOT NULL,
  `created_ts` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passport`
--

INSERT INTO `passport` (`id`, `personal_id`, `ind_id`, `exp_ts`, `created_ts`) VALUES
(1, '1323421', '156132as65426', '2024-02-22', '2019-02-22'),
(2, 'MP9131021', 'A7897846OP13', '2024-09-20', '2014-09-20'),
(3, 'MP9504021', 'A7897846OP93', '2024-03-20', '2014-03-20'),
(4, 'MP9871451', 'A7897446OP23', '2024-02-20', '2014-02-20'),
(5, 'MP9007421', 'A1792346OP23', '2023-10-27', '2019-10-27'),
(6, 'MP9837499', 'A7899346OP23', '2024-10-27', '2020-10-27'),
(11, 'MP0987654', '2345678AO76PB6', '2023-10-31', '2018-10-31'),
(12, 'MP3456765', '1115678AO76PB6', '2018-10-31', '2023-10-15'),
(13, 'MP0987654', '2345678AO76PB6', '2023-10-31', '2018-10-31'),
(14, 'MP0987654', '2345678AO76PB6', '2023-10-31', '2018-10-31'),
(15, 'MP0987654', '2345678AO76PB6', '2023-10-31', '2018-10-31'),
(16, 'MP0987654', '2345678AO76PB6', '2023-10-31', '2018-10-31'),
(17, 'fadsf', 'fadsf', '2023-12-30', '2023-11-23'),
(18, '365764571', 'fadsf5631', '2024-01-10', '2023-11-26'),
(19, '365764571', 'fadsf5631', '2024-02-10', '2023-11-26');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_ts` timestamp NULL DEFAULT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`id`, `name`, `details`, `created_ts`, `updated_ts`) VALUES
(1, 'Admin', 'Admin role', NULL, NULL),
(2, 'General User', 'Default role', NULL, NULL),
(3, 'Manager', 'Manager role', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `stats`
--

CREATE TABLE `stats` (
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(11) NOT NULL,
  `education` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `would_recommend` varchar(8) COLLATE utf8mb4_unicode_ci NOT NULL,
  `languages_known` varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `comments` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `stats`
--

INSERT INTO `stats` (`name`, `email`, `age`, `education`, `would_recommend`, `languages_known`, `comments`, `id`) VALUES
('Arthur', 'chaplain04@gmail.com', 34, 'professional', 'No', 'C++, Java, JavaScript, Angular, Spring', 'comment', 1);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pwd` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `pwd`, `details`, `role`, `is_active`, `created_ts`, `updated_ts`) VALUES
(1, 'John', 'John@gmail.com', '123', 'Some details', 'Admin', 1, '2023-11-12 13:13:43', NULL),
(2, 'Bob', 'Bob@gmail.com', '321', 'Some details', 'Manager', 1, '2023-11-12 13:13:43', NULL),
(3, 'Mike', 'Mike@gmail.com', '321', 'Some details', 'General user', 1, '2023-11-12 13:13:43', NULL),
(10, 'Arthur', 'chaplain04@gmail.com', 'NlRZVTb6axc7Sjq3FAWkeQ', 'null', 'Admin', 1, '2023-11-14 20:31:04', '2023-11-19 12:49:35');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dogs`
--
ALTER TABLE `dogs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `passport_id` (`passport_id`),
  ADD KEY `fk_office_id_offices_pk_id` (`office_id`);

--
-- Indexes for table `offices`
--
ALTER TABLE `offices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_index` (`name`);

--
-- Indexes for table `stats`
--
ALTER TABLE `stats`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_e2rndfrsx22acpq2ty1caeuyw` (`email`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users_role_roles_fk_name` (`role`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dogs`
--
ALTER TABLE `dogs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `offices`
--
ALTER TABLE `offices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT for table `passport`
--
ALTER TABLE `passport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `stats`
--
ALTER TABLE `stats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `fk_office_id_offices_pk_id` FOREIGN KEY (`office_id`) REFERENCES `offices` (`id`),
  ADD CONSTRAINT `fk_passport_id_passport_pk_id` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_role_roles_fk_name` FOREIGN KEY (`role`) REFERENCES `roles` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
