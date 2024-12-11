-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2024 at 08:20 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

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
(251);

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `user_id` int(11) NOT NULL,
  `coach` varchar(255) NOT NULL,
  `rank` varchar(255) NOT NULL,
  `game` varchar(255) NOT NULL,
  `year` int(4) NOT NULL,
  `aplication` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`user_id`, `coach`, `rank`, `game`, `year`, `aplication`) VALUES
(2, 'User Name New', '4', 'Overwatch', 2021, 'application data for User Name New (edited)'),
(5, 'User Name', '7', 'Overwatch', 2023, 'application data for User Name'),
(52, 'User Name 5', '3', 'Overwatch', 2020, 'application data for User Name 5');

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
(151);

-- --------------------------------------------------------

--
-- Table structure for table `banned_list`
--

CREATE TABLE `banned_list` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `offense` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `banned_list`
--

INSERT INTO `banned_list` (`user_id`, `user_name`, `offense`, `status`) VALUES
(2, 'C. H. Eater B01', 'aim bot', 'Banned'),
(5, 'C. H. Eater B01s', 'wall hacks', 'Banned'),
(52, 'TheBan420', 'Offensive Language', 'Banned');

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
(201);

-- --------------------------------------------------------

--
-- Table structure for table `calendar`
--

CREATE TABLE `calendar` (
  `eventID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `participating` varchar(255) NOT NULL,
  `attending` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `calendar`
--

INSERT INTO `calendar` (`eventID`, `name`, `date`, `location`, `participating`, `attending`) VALUES
(1, 'Overwatch event', '12/8/2024, 6:00pm - 9:00pm', 'EUC', 'YES', 'NO'),
(2, 'Overwatch event', '12/1/2024, 6:00pm - 9:00pm', 'EUC', 'NO', 'NO'),
(52, 'Valorant event', '11/19/2024, 6:00pm - 9:00pm', 'EUC', 'YES', 'YES'),
(352, 'Overwatch event', '12/20/2024, 6:00pm - 9:00pm', 'EUC', '10', '50');

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
(451);

-- --------------------------------------------------------

--
-- Table structure for table `coaches`
--

CREATE TABLE `coaches` (
  `coach_id` int(11) NOT NULL,
  `game` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rank` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `coaches`
--

INSERT INTO `coaches` (`coach_id`, `game`, `name`, `rank`, `rating`) VALUES
(1, 'League of Legends', 'New Coach', '36', 4.4),
(2, 'Valorant', 'Coach Name', '45', 1);

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
(1);

-- --------------------------------------------------------

--
-- Table structure for table `customer_events`
--

CREATE TABLE `customer_events` (
  `customer_user_id` bigint(20) NOT NULL,
  `events` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer_games`
--

CREATE TABLE `customer_games` (
  `customer_user_id` bigint(20) NOT NULL,
  `games` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `member_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `team_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`member_id`, `role`, `team_id`) VALUES
(5, 'Player', 5),
(42, 'Player', 10),
(66, 'Player', 5);

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
(1);

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `offense` varchar(255) NOT NULL,
  `recount` int(9) NOT NULL
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
(101);

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `comment_id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1);

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

--
-- Dumping data for table `students_seq`
--

INSERT INTO `students_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `team_id` int(11) NOT NULL,
  `game` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`team_id`, `game`, `name`) VALUES
(5, 'Overwatch', 'ow team'),
(10, 'Valorant', 'val team');

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
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `account_status` varchar(255) NOT NULL,
  `major` varchar(255) DEFAULT NULL,
  `games` varchar(255) DEFAULT NULL,
  `events` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `name`, `email`, `password`, `account_status`, `major`, `games`, `events`) VALUES
(1, 'user1', 'user.one@gmail.com', 'password', 'active', 'Computer Science', 'Valorant', 'Competition'),
(2, 'user2', 'user.two@gmail.com', 'password', 'banned', 'Businuss', 'League of Legends', 'Competition');

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
-- Indexes for table `animals`
--
ALTER TABLE `animals`
  ADD PRIMARY KEY (`animalid`);

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `banned_list`
--
ALTER TABLE `banned_list`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `calendar`
--
ALTER TABLE `calendar`
  ADD PRIMARY KEY (`eventID`) USING BTREE;

--
-- Indexes for table `coaches`
--
ALTER TABLE `coaches`
  ADD PRIMARY KEY (`coach_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `mess_id` (`mess_id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UKrfbvkrffamfql7cjmen8v976v` (`email`);

--
-- Indexes for table `customer_events`
--
ALTER TABLE `customer_events`
  ADD KEY `FKsp9r5o4dfpsj0lkpaqxwl0kfq` (`customer_user_id`);

--
-- Indexes for table `customer_games`
--
ALTER TABLE `customer_games`
  ADD KEY `FK6kawr8sakn6mo8rc8xj7q3gds` (`customer_user_id`);

--
-- Indexes for table `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`member_id`),
  ADD KEY `FKf4xefr0g300jkn6um58gf0l6i` (`team_id`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`mess_id`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`team_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `members`
--
ALTER TABLE `members`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `mess_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`mess_id`) REFERENCES `messages` (`mess_id`);

--
-- Constraints for table `customer_events`
--
ALTER TABLE `customer_events`
  ADD CONSTRAINT `FKsp9r5o4dfpsj0lkpaqxwl0kfq` FOREIGN KEY (`customer_user_id`) REFERENCES `customers` (`user_id`);

--
-- Constraints for table `customer_games`
--
ALTER TABLE `customer_games`
  ADD CONSTRAINT `FK6kawr8sakn6mo8rc8xj7q3gds` FOREIGN KEY (`customer_user_id`) REFERENCES `customers` (`user_id`);

--
-- Constraints for table `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `FKf4xefr0g300jkn6um58gf0l6i` FOREIGN KEY (`team_id`) REFERENCES `teams` (`team_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
