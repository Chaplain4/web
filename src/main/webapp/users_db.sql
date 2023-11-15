-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3307
-- Время создания: Ноя 15 2023 г., 21:21
-- Версия сервера: 5.6.41
-- Версия PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `users_db`
--

-- --------------------------------------------------------

--
-- Структура таблицы `employees`
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
-- Дамп данных таблицы `employees`
--

INSERT INTO `employees` (`id`, `name`, `last_name`, `age`, `office_id`, `passport_id`, `updated_ts`, `created_ts`) VALUES
(1, 'Bill', 'Stranger', 35, 1, 1, NULL, '2023-09-25 18:28:44'),
(2, 'Mike', 'Stranger', 55, 1, 2, NULL, '2023-09-25 18:28:44'),
(3, 'John', 'Stranger', 35, 1, 3, NULL, '2023-09-27 16:55:28'),
(4, 'Ivan', 'Ivanov', 37, 4, 4, NULL, '2023-09-27 16:58:47'),
(7, 'Olga', 'Stranger', 18, 3, 6, NULL, '2023-09-27 18:32:16');

-- --------------------------------------------------------

--
-- Структура таблицы `offices`
--

CREATE TABLE `offices` (
  `id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `address` varchar(256) NOT NULL,
  `phone 1` varchar(128) NOT NULL,
  `phone 2` varchar(128) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `offices`
--

INSERT INTO `offices` (`id`, `title`, `address`, `phone 1`, `phone 2`, `postal_code`, `updated_ts`, `created_ts`) VALUES
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
-- Структура таблицы `passport`
--

CREATE TABLE `passport` (
  `id` int(11) NOT NULL,
  `personal_id` varchar(9) NOT NULL,
  `ind_id` varchar(20) NOT NULL,
  `exp_ts` date NOT NULL,
  `created_ts` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `passport`
--

INSERT INTO `passport` (`id`, `personal_id`, `ind_id`, `exp_ts`, `created_ts`) VALUES
(1, 'MP9831021', 'A7897846OP23', '2024-01-20', '2014-01-20'),
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
(16, 'MP0987654', '2345678AO76PB6', '2023-10-31', '2018-10-31');

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_ts` timestamp NULL DEFAULT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `name`, `details`, `created_ts`, `updated_ts`) VALUES
(1, 'Admin', 'Admin role', NULL, NULL),
(2, 'General User', 'Default role', NULL, NULL),
(3, 'Manager', 'Manager role', NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pwd` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `details` varchar(1024) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `role` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_ts` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `pwd`, `details`, `role`, `is_active`, `created_ts`, `updated_ts`) VALUES
(1, 'John', 'John@gmail.com', '123', 'Some details', 'Admin', 1, '2023-11-12 13:13:43', NULL),
(2, 'Bob', 'Bob@gmail.com', '321', 'Some details', 'Manager', 1, '2023-11-12 13:13:43', NULL),
(3, 'Mike', 'Mike@gmail.com', '321', 'Some details', 'General user', 1, '2023-11-12 13:13:43', NULL),
(7, 'info', 'chaplain04@gmail.com', 'oExZuYyiKJ39ZJA9hkRo5A', NULL, 'General User', 1, '2023-11-13 18:52:06', NULL),
(8, 'John1', 'john1@gmail.com', 'oExZuYyiKJ39ZJA9hkRo5A', NULL, 'General User', 1, '2023-11-15 16:32:05', '2023-11-15 16:33:57');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `passport_id` (`passport_id`),
  ADD KEY `fk_office_id_offices_pk_id` (`office_id`);

--
-- Индексы таблицы `offices`
--
ALTER TABLE `offices`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_index` (`name`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_users_role_roles_fk_name` (`role`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT для таблицы `offices`
--
ALTER TABLE `offices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT для таблицы `passport`
--
ALTER TABLE `passport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `fk_office_id_offices_pk_id` FOREIGN KEY (`office_id`) REFERENCES `offices` (`id`),
  ADD CONSTRAINT `fk_passport_id_passport_pk_id` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`);

--
-- Ограничения внешнего ключа таблицы `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_role_roles_fk_name` FOREIGN KEY (`role`) REFERENCES `roles` (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
