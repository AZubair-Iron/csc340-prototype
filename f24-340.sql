-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 05:07 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `f24-340`
--

-- --------------------------------------------------------

--
-- Table structure for table `animals`
--

CREATE TABLE `animals` (
  `animalid` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `habitat` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `scientific_name` varchar(255) DEFAULT NULL,
  `species` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `animals`
--

INSERT INTO `animals` (`animalid`, `description`, `habitat`, `name`, `scientific_name`, `species`) VALUES
(2, 'description1', 'Coral Reefs', 'Marlin', 'Amphiprioninae', 'Clownfish'),
(3, 'a blue bird', 'forests', 'Blue Jay', 'Cyanocitta cristata', 'Bird'),
(4, 'a poison frog', 'forest islands', 'Blue poison dart frog', 'Dendrobates tinctorius azureus', 'Frog'),
(52, 'fox native to North Africa.', 'desert', 'Fennec fox', 'Vulpes zerda', 'Fox'),
(152, 'I was thinking of the dog from GotG3', 'space', 'Cosmo', 'Dog', 'Dog'),
(8800, 'Predatory arachnids.', 'desert', 'Emperor Scorpion', 'Scorpiones', 'Scorpion'),
(8880, 'Orange and white striped fish.', 'Coral Reefs', 'Nemo', 'Amphiprioninae', 'Clownfish'),
(8888, 'Large, powerfully built cat. The second largest cat species.', 'Savanna', 'Asiatic Lion', 'Panthera Leo', 'Lion'),
(2, 'description1', 'Coral Reefs', 'Marlin', 'Amphiprioninae', 'Clownfish'),
(3, 'a blue bird', 'forests', 'Blue Jay', 'Cyanocitta cristata', 'Bird'),
(4, 'a poison frog', 'forest islands', 'Blue poison dart frog', 'Dendrobates tinctorius azureus', 'Frog'),
(52, 'fox native to North Africa.', 'desert', 'Fennec fox', 'Vulpes zerda', 'Fox'),
(152, 'I was thinking of the dog from GotG3', 'space', 'Cosmo', 'Dog', 'Dog'),
(8800, 'Predatory arachnids.', 'desert', 'Emperor Scorpion', 'Scorpiones', 'Scorpion'),
(8880, 'Orange and white striped fish.', 'Coral Reefs', 'Nemo', 'Amphiprioninae', 'Clownfish'),
(8888, 'Large, powerfully built cat. The second largest cat species.', 'Savanna', 'Asiatic Lion', 'Panthera Leo', 'Lion');

-- --------------------------------------------------------

--
-- Table structure for table `animals_seq`
--

CREATE TABLE `animals_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `animals_seq`
--

INSERT INTO `animals_seq` (`next_val`) VALUES
(251),
(251);

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `user_id` int(11) NOT NULL,
  `aplication` varchar(255) NOT NULL,
  `coach` varchar(255) NOT NULL,
  `rank` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  `game_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`user_id`, `aplication`, `coach`, `rank`, `year`, `game_id`) VALUES
(1, 'For fun', 'Arsal Zubair', 'Immortal 2', 4, 4),
(2, 'TEST', 'Arsal Zubair', 'Immortal 2', 4, 4),
(52, 'Test', 'Test', 'Test', 4, 4),
(102, 'it for fun', 'Arsal Zubair', 'Immortal 2', 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `application_seq`
--

CREATE TABLE `application_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application_seq`
--

INSERT INTO `application_seq` (`next_val`) VALUES
(201),
(151),
(151);

-- --------------------------------------------------------

--
-- Table structure for table `banned_list`
--

CREATE TABLE `banned_list` (
  `user_id` int(11) NOT NULL,
  `offense` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `banned_list`
--

INSERT INTO `banned_list` (`user_id`, `offense`, `status`, `user_name`) VALUES
(2, 'aim bot', 'Banned', 'C. H. Eater B01'),
(5, 'wall hacks', 'Banned', 'C. H. Eater B01s'),
(52, 'Offensive Language', 'Banned', 'TheBan420');

-- --------------------------------------------------------

--
-- Table structure for table `banned_list_seq`
--

CREATE TABLE `banned_list_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `banned_list_seq`
--

INSERT INTO `banned_list_seq` (`next_val`) VALUES
(1),
(201),
(201);

-- --------------------------------------------------------

--
-- Table structure for table `calendar`
--

CREATE TABLE `calendar` (
  `eventid` int(11) NOT NULL,
  `attending` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `participating` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `calendar`
--

INSERT INTO `calendar` (`eventid`, `attending`, `date`, `location`, `name`, `participating`) VALUES
(1, 'NO', '12/8/2024, 6:00pm - 9:00pm', 'EUC', 'Overwatch event', 'YES'),
(2, 'NO', '12/1/2024, 6:00pm - 9:00pm', 'EUC', 'Overwatch event', 'NO'),
(52, 'YES', '11/19/2024, 6:00pm - 9:00pm', 'EUC', 'Valorant event', 'YES'),
(352, '50', '12/20/2024, 6:00pm - 9:00pm', 'EUC', 'Overwatch event', '10');

-- --------------------------------------------------------

--
-- Table structure for table `calendar_seq`
--

CREATE TABLE `calendar_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `calendar_seq`
--

INSERT INTO `calendar_seq` (`next_val`) VALUES
(1),
(451),
(451);

-- --------------------------------------------------------

--
-- Table structure for table `coaches`
--

CREATE TABLE `coaches` (
  `coach_id` int(11) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `game` varchar(255) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `user_id` int(11) NOT NULL,
  `schedule_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coaches`
--

INSERT INTO `coaches` (`coach_id`, `content`, `game`, `rank`, `rating`, `user_id`, `schedule_id`) VALUES
(100, 'Test Words', 'Valorant', 'Immortal 2', 5, 99, NULL),
(101, 'I am a top 500 Overwatch player, who specializes in DPS and Support, but I have a lot of team experience if you are looking for that.', 'Overwatch', 'Grandmaster', 4.7, 101, NULL),
(102, 'Long string of text I had to write to test if this wrapping even worked or if someone decided to write a 9 paragraph essays within content fun fun\r\n', 'Valorant', 'Bronze 3', 1, 102, NULL),
(103, 'Test ', 'League of Legends', 'Emerald', 0, 100, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `coaches_seq`
--

CREATE TABLE `coaches_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coaches_seq`
--

INSERT INTO `coaches_seq` (`next_val`) VALUES
(1),
(151),
(151);

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL,
  `mess_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `author_id` int(11) NOT NULL,
  `time_posted` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`comment_id`, `mess_id`, `content`, `author_id`, `time_posted`) VALUES
(1, 1, 'Comment 1!', 2, '2024-11-06 18:04:32'),
(2, 2, 'Comment 2!', 1, '2024-11-06 18:04:32'),
(1, 1, 'Comment 1!', 2, '2024-11-06 18:04:32'),
(2, 2, 'Comment 2!', 1, '2024-11-06 18:04:32');

-- --------------------------------------------------------

--
-- Table structure for table `comments_seq`
--

CREATE TABLE `comments_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `comments_seq`
--

INSERT INTO `comments_seq` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `user_id` bigint(20) NOT NULL,
  `account_status` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customers_seq`
--

CREATE TABLE `customers_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `customers_seq`
--

INSERT INTO `customers_seq` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `customer_events`
--

CREATE TABLE `customer_events` (
  `customer_user_id` int(11) NOT NULL,
  `events` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_games`
--

CREATE TABLE `customer_games` (
  `customer_user_id` int(11) NOT NULL,
  `games` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `game_id` int(11) NOT NULL,
  `game` varchar(255) DEFAULT NULL,
  `game_icon` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `steam_app_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`game_id`, `game`, `game_icon`, `name`, `steam_app_id`) VALUES
(2, 'Apex Legends', '/image/apex-legends.jpg', NULL, '1172470'),
(4, 'Valorant', '/image/valorant.jpg', NULL, NULL),
(102, 'Overwatch', '/images/overwatch.jpg', NULL, '2357570');

-- --------------------------------------------------------

--
-- Table structure for table `games_seq`
--

CREATE TABLE `games_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `games_seq`
--

INSERT INTO `games_seq` (`next_val`) VALUES
(201);

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `member_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `team_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `tag` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`member_id`, `role`, `team_id`, `user_id`, `tag`) VALUES
(99, 'Coach', 99, 99, 'Ironic'),
(100, 'Player', 99, 100, 'Pandex'),
(101, 'Sub', 99, 101, 'Z0mbi3'),
(102, 'Manager', 99, 102, 'MasterChief'),
(105, 'Player', 99, 103, 'HarborMain1997\r\n'),
(106, 'Player', 99, 104, 'FadeMain1234'),
(107, 'Player', 99, 105, '123456'),
(108, 'Player', 99, 106, 'AmazingName');

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE `messages` (
  `mess_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `author_id` bigint(20) NOT NULL,
  `time_posted` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`mess_id`, `title`, `description`, `author_id`, `time_posted`) VALUES
(1, 'Title1', 'Description 1.', 1, '2024-11-06 18:04:06'),
(2, 'Title2', 'Description 2.', 2, '2024-11-06 18:04:06'),
(1, 'Title1', 'Description 1.', 1, '2024-11-06 18:04:06'),
(2, 'Title2', 'Description 2.', 2, '2024-11-06 18:04:06');

-- --------------------------------------------------------

--
-- Table structure for table `messages_seq`
--

CREATE TABLE `messages_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `messages_seq`
--

INSERT INTO `messages_seq` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `posts`
--

CREATE TABLE `posts` (
  `post_id` int(11) NOT NULL,
  `content` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `offense` varchar(255) NOT NULL,
  `recount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`id`, `name`, `offense`, `recount`) VALUES
(1, 'NooB01', 'wall hacks', 98),
(3, 'NooB01420', 'aim hacks', 200),
(4, 'NooB0142', 'aim hacks', 250);

-- --------------------------------------------------------

--
-- Table structure for table `reports_seq`
--

CREATE TABLE `reports_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reports_seq`
--

INSERT INTO `reports_seq` (`next_val`) VALUES
(1),
(101),
(101);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `comment_id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `coach_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`comment_id`, `comment`, `rating`, `coach_id`, `user_id`) VALUES
(1, 'Hello World!', 5, 100, 100),
(2, 'Test', 5, 101, 100),
(3, '2', 5, 101, 100),
(52, 'Good guy!', 5, 102, 100),
(100, 'Amazing Coach!', 5, 100, 105);

-- --------------------------------------------------------

--
-- Table structure for table `reviews_seq`
--

CREATE TABLE `reviews_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews_seq`
--

INSERT INTO `reviews_seq` (`next_val`) VALUES
(151),
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `date` date DEFAULT NULL,
  `end_time` time(6) DEFAULT NULL,
  `start_time` time(6) DEFAULT NULL,
  `schedule_id` int(11) NOT NULL,
  `coach_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`date`, `end_time`, `start_time`, `schedule_id`, `coach_id`, `user_id`) VALUES
('2024-12-12', '02:40:00.000000', '02:00:00.000000', 120, 100, 101),
('2024-12-12', '14:00:00.000000', '13:00:00.000000', 1002, 100, 101),
('2024-12-12', '16:50:00.000000', '13:48:00.000000', 1003, 101, 100),
('2024-12-12', '19:00:00.000000', '17:00:00.000000', 1052, 101, NULL),
('2024-12-12', '16:00:00.000000', '14:00:00.000000', 1102, 101, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `schedules_seq`
--

CREATE TABLE `schedules_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedules_seq`
--

INSERT INTO `schedules_seq` (`next_val`) VALUES
(1201);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `gpa` double NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `students_seq`
--

CREATE TABLE `students_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `team_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL,
  `match_day` varchar(255) DEFAULT NULL,
  `scoreline` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`team_id`, `name`, `game_id`, `match_day`, `scoreline`) VALUES
(99, 'Varsity', 4, 'Wednesday 7PM', '3-2'),
(100, 'Junior Varsity', 4, 'Wednesday 7PM', '1-3');

-- --------------------------------------------------------

--
-- Table structure for table `teams_seq`
--

CREATE TABLE `teams_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teams_seq`
--

INSERT INTO `teams_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `account_status` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `account_status`, `email`, `major`, `name`, `password`) VALUES
(99, 'Player', 'ak@gmail.com', 'CS', 'Arsal', '12345'),
(100, 'Player', 'am@gmail.com', 'CS', 'Connor', 'Password'),
(101, 'Sub', 'cm@gmail.com', 'CS', 'John', 'Password'),
(102, 'Manager', 'lm@gmail.com', 'CS', 'Mario', 'Password'),
(103, 'Player', 'JM@gmail.com\r\n', 'CS', 'Joseph', '12345\r\n'),
(104, 'Player', 'ca@gmail.com', 'Business', 'Carter', '12345\r\n'),
(105, 'Player', 'gg@gmail.com', 'Psychology', 'Austin', '12345'),
(106, 'Player', 'dm@gmail.com', 'Biology', 'Damon', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `users_seq`
--

CREATE TABLE `users_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users_seq`
--

INSERT INTO `users_seq` (`next_val`) VALUES
(1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `FKky75hidpcnlovqqfeoi7ao1s8` (`game_id`);

--
-- Indexes for table `banned_list`
--
ALTER TABLE `banned_list`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `calendar`
--
ALTER TABLE `calendar`
  ADD PRIMARY KEY (`eventid`);

--
-- Indexes for table `coaches`
--
ALTER TABLE `coaches`
  ADD PRIMARY KEY (`coach_id`),
  ADD KEY `FKo2s6iuqyundkjflwh6ps8d0f0` (`user_id`),
  ADD KEY `FK7mbt027ytnb2asdifjaqi5rvb` (`schedule_id`);

--
-- Indexes for table `customer_events`
--
ALTER TABLE `customer_events`
  ADD KEY `FKiaejswxs8574pkqqu363knbju` (`customer_user_id`);

--
-- Indexes for table `customer_games`
--
ALTER TABLE `customer_games`
  ADD KEY `FKprvuirsxqkhukttgrt8kgodh8` (`customer_user_id`);

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`game_id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `FKf4xefr0g300jkn6um58gf0l6i` (`team_id`),
  ADD KEY `FKpj3n6wh5muoeakc485whgs3x5` (`user_id`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `FK5lidm6cqbc7u4xhqpxm898qme` (`user_id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `FK81aqkrnfg0ge1p6w0lgsvj12h` (`coach_id`),
  ADD KEY `FKcgy7qjc1r99dp117y9en6lxye` (`user_id`);

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `FK8niii0bijph8ugrwub27ntheu` (`coach_id`),
  ADD KEY `FKd4y4xekwahv9boo6lc8gfl3jv` (`user_id`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`team_id`),
  ADD KEY `FKm56w9dhr7b4tc6fort2hcx4qn` (`game_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application`
--
ALTER TABLE `application`
  ADD CONSTRAINT `FKky75hidpcnlovqqfeoi7ao1s8` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`);

--
-- Constraints for table `coaches`
--
ALTER TABLE `coaches`
  ADD CONSTRAINT `FK7mbt027ytnb2asdifjaqi5rvb` FOREIGN KEY (`schedule_id`) REFERENCES `schedules` (`schedule_id`),
  ADD CONSTRAINT `FKo2s6iuqyundkjflwh6ps8d0f0` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `customer_events`
--
ALTER TABLE `customer_events`
  ADD CONSTRAINT `FKiaejswxs8574pkqqu363knbju` FOREIGN KEY (`customer_user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `customer_games`
--
ALTER TABLE `customer_games`
  ADD CONSTRAINT `FKprvuirsxqkhukttgrt8kgodh8` FOREIGN KEY (`customer_user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `FKf4xefr0g300jkn6um58gf0l6i` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`),
  ADD CONSTRAINT `FKpj3n6wh5muoeakc485whgs3x5` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `FK5lidm6cqbc7u4xhqpxm898qme` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FK81aqkrnfg0ge1p6w0lgsvj12h` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`coach_id`),
  ADD CONSTRAINT `FKcgy7qjc1r99dp117y9en6lxye` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `FK8niii0bijph8ugrwub27ntheu` FOREIGN KEY (`coach_id`) REFERENCES `coaches` (`coach_id`),
  ADD CONSTRAINT `FKd4y4xekwahv9boo6lc8gfl3jv` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `teams`
--
ALTER TABLE `teams`
  ADD CONSTRAINT `FKm56w9dhr7b4tc6fort2hcx4qn` FOREIGN KEY (`game_id`) REFERENCES `games` (`game_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
