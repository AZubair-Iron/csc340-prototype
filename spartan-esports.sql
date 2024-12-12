-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2024 at 05:55 PM
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
-- Database: `spartan-esports`
--

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
  `game_id` int(11) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`user_id`, `aplication`, `coach`, `rank`, `year`, `game_id`, `status`) VALUES
(3, 'for fun', 'Arsal Zubair', 'Immortal 2', 4, 100, 'PENDING');

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
(101);

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
(123, 'wall hacks', 'Banned', 'W@llHackboi88'),
(789, 'offensive language', 'Not Banned', 'Mr.Soup');

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
(1);

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
(66, '40', '12/12/24', 'EUC', 'Valorant event', '15'),
(88, '50', '12/15/24', 'EUC', 'Overwatch event', '12'),
(120, '50', '12/20/24', 'Greensboro Complex', 'Apex event', '10');

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
(1);

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
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coaches`
--

INSERT INTO `coaches` (`coach_id`, `content`, `game`, `rank`, `rating`, `user_id`) VALUES
(100, 'Hi I am Arsal Zubair, and I am a coach for Valorant, I peaked Immortal 3, blah blah blah.', 'Valorant', 'Immortal 3', 5, 1),
(101, 'Hi I am Connor Tenmat, and I am an Overwatch Coach, blah blah blah', 'Overwatch', 'Grandmaster', 5, 2);

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
(1);

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `game_id` int(11) NOT NULL,
  `game` varchar(255) DEFAULT NULL,
  `game_icon` varchar(255) DEFAULT NULL,
  `steam_app_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`game_id`, `game`, `game_icon`, `steam_app_id`) VALUES
(100, 'Valorant', '/images/valorant.jpg', NULL),
(101, 'Apex Legends', '/images/apex.jpg', '1172470'),
(102, 'Overwatch', '/images/overwatch.jpg', '2357570');

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
(1);

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `member_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `team_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`member_id`, `role`, `tag`, `team_id`, `user_id`) VALUES
(100, 'Player', 'Ironic', 52, 1),
(101, 'Player', 'Pandex', 52, 2),
(102, 'Player', 'Loonatic', 52, 3),
(103, 'Player', 'Xie', 52, 4),
(104, 'Player', 'Jason', 52, 5),
(106, 'Sub', 'Agaggoin', 52, 6),
(107, 'Sub', 'Simple', 52, 7),
(108, 'Manager', 'Goat', 52, 9),
(109, 'Coach', 'James', 52, 8);

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
(88, 'Chea T. Er', 'wallhacks', 50),
(420, 'SomeChe@t1ngB01', 'offensive language, wall hacks', 69);

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
(1);

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
(100, 'Great Coach!', 5, 100, 3);

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
(251);

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `schedule_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `end_time` time(6) NOT NULL,
  `start_time` time(6) NOT NULL,
  `coach_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`schedule_id`, `date`, `end_time`, `start_time`, `coach_id`, `user_id`) VALUES
(1, '2024-12-12', '15:00:00.000000', '14:00:00.000000', 100, 2),
(2, '2024-12-12', '14:00:00.000000', '13:00:00.000000', 100, NULL);

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
(101);

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `team_id` int(11) NOT NULL,
  `match_day` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `scoreline` varchar(255) DEFAULT NULL,
  `game_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`team_id`, `match_day`, `name`, `scoreline`, `game_id`) VALUES
(52, 'Wednesday', 'Dusk', '3-2', 100),
(53, 'Tuesday', 'Varsity', '4-0', 101);

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
(151);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `name`, `password`, `status`) VALUES
(1, 'akzubair@uncg.edu', 'Arsal Zubair', '123456', 'Admin'),
(2, 'cnt@uncg.edu', 'Connor Tenmat', 'Connor2901!', 'Player'),
(3, 'BL@uncg.edu', 'Brandon Looney', '123456', 'Admin'),
(4, 'jxie@uncg.edu', 'Jack Xie', '123456', 'Admin'),
(5, 'JSM@uncg.edu', 'John Smith', '123456', 'Player'),
(6, 'ag@uncg.edu', 'Andrew Garfield', '123456', 'Player'),
(7, 'simple@uncg.edu', 'Simmions', '123456', 'Coach'),
(8, 'Ja@uncg.edu', 'Jacob', '123456', 'Player'),
(9, 'da@uncg.edu', 'Dakota', '123456', 'Player'),
(100, 'sample@email.com', 'S@mpleB01', '123456', 'Student');

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
  ADD KEY `FKo2s6iuqyundkjflwh6ps8d0f0` (`user_id`);

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
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=110;

--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

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
  ADD CONSTRAINT `FKo2s6iuqyundkjflwh6ps8d0f0` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

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
