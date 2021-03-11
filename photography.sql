-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 14, 2020 at 01:46 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `photography`
--

-- --------------------------------------------------------

--
-- Table structure for table `contest`
--

CREATE TABLE `contest` (
  `ContestId` int(11) NOT NULL,
  `ContestName` varchar(50) NOT NULL,
  `ContestType` varchar(50) NOT NULL,
  `StartDate` varchar(200) NOT NULL,
  `EndDate` varchar(200) NOT NULL,
  `ContestDescription` text NOT NULL,
  `ContestStatus` varchar(50) NOT NULL,
  `ContestPhotoPath` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `contest`
--

INSERT INTO `contest` (`ContestId`, `ContestName`, `ContestType`, `StartDate`, `EndDate`, `ContestDescription`, `ContestStatus`, `ContestPhotoPath`) VALUES
(1, 'Contest', 'Votting Based Unpaid', '2020-08-21', '2020-08-31', 'adcsdv<div><br></div><div><ul><li>sgfhfg</li><li>gfhbt</li></ul></div>', 'Upcomming', 'Contest1.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `contestxuser`
--

CREATE TABLE `contestxuser` (
  `contestXUserId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `ContestId` int(11) NOT NULL,
  `ContestImagePath` varchar(200) NOT NULL,
  `UploadDateTime` datetime NOT NULL,
  `SocialProfileUrl` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `imageofweek`
--

CREATE TABLE `imageofweek` (
  `ImageOfWeekId` int(11) NOT NULL,
  `ImageOfWeekPhotoPath` varchar(200) NOT NULL,
  `SocialProfileUrl` varchar(100) NOT NULL,
  `SocialPhotoUrl` varchar(100) NOT NULL,
  `DeclarationDate` varchar(50) NOT NULL,
  `ImageDescription` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `imageofweek`
--

INSERT INTO `imageofweek` (`ImageOfWeekId`, `ImageOfWeekPhotoPath`, `SocialProfileUrl`, `SocialPhotoUrl`, `DeclarationDate`, `ImageDescription`) VALUES
(14, 'Contest3.jpg', 'kalp', 'asdfgh', '2020-08-10', 'my photo'),
(15, 'contest2.jpg', 'url', 'photo url is asd', '2020-08-11', 'ftgyhbun');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `PaymentTypesId` int(11) NOT NULL,
  `PaymentTypeName` varchar(50) NOT NULL,
  `PaymentTypeDescrption` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `paymentxuser`
--

CREATE TABLE `paymentxuser` (
  `PaymentXUserId` int(11) NOT NULL,
  `PaymentId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PayFor` varchar(50) NOT NULL,
  `PaymentAmount` varchar(50) NOT NULL,
  `PaymentDateTime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `PermissionId` int(11) NOT NULL,
  `PermissionGroup` varchar(50) NOT NULL,
  `PermissionGroup2` varchar(50) NOT NULL,
  `PermissionName` text NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `photocategory`
--

CREATE TABLE `photocategory` (
  `CategoryId` int(11) NOT NULL,
  `CategoryName` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL,
  `CategoryPhotoPath` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photocategory`
--

INSERT INTO `photocategory` (`CategoryId`, `CategoryName`, `Description`, `CategoryPhotoPath`) VALUES
(2, 'Food', 'Food Photos', 'food.jpg'),
(3, 'Abstract', 'Abstract Photos', 'abstract.jpg'),
(5, 'Animal', 'Animal Photos', 'animal.jpg'),
(6, 'Animated', 'Animated Photos', 'animated.jpg'),
(7, 'Celebration', 'Celebration Photos', 'celebration.jpg'),
(8, 'Space', 'Space Photos', 'space.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `photographytips`
--

CREATE TABLE `photographytips` (
  `PhotographyTipsId` int(11) NOT NULL,
  `TipsTypeId` int(11) NOT NULL,
  `PhtographyTipsPhotoPath` varchar(100) NOT NULL,
  `PhotographyTipsDescription` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `photographytips`
--

INSERT INTO `photographytips` (`PhotographyTipsId`, `TipsTypeId`, `PhtographyTipsPhotoPath`, `PhotographyTipsDescription`) VALUES
(1, 2, '118105168-118106149_436.JPG', 'dfghgjhkg'),
(2, 2, '773907536-773907557_7669.JPG', 'amazing tips');

-- --------------------------------------------------------

--
-- Table structure for table `plans`
--

CREATE TABLE `plans` (
  `PlansId` int(11) NOT NULL,
  `PlansName` varchar(50) NOT NULL,
  `PlansPrice` varchar(50) NOT NULL,
  `Description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `plans`
--

INSERT INTO `plans` (`PlansId`, `PlansName`, `PlansPrice`, `Description`) VALUES
(2, 'Basic', '500 INR /Month', '=> 5 free download photos.'),
(3, 'Pro', '1000 INR / Month', '=> 15 free download Photos.'),
(4, 'Premium', '5000 INR / Month', '=> Unlimited download Photos.');

-- --------------------------------------------------------

--
-- Table structure for table `plansxuser`
--

CREATE TABLE `plansxuser` (
  `PlansXUserId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PlansId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `rolepermission`
--

CREATE TABLE `rolepermission` (
  `RolePermissionId` int(11) NOT NULL,
  `RoleId` int(11) NOT NULL,
  `PermissionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `RoleId` int(11) NOT NULL,
  `RoleName` varchar(50) NOT NULL,
  `Description` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`RoleId`, `RoleName`, `Description`) VALUES
(1, 'Admin', 'Admin'),
(2, 'User', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `tipstype`
--

CREATE TABLE `tipstype` (
  `TipsTypeId` int(11) NOT NULL,
  `TipsTypeName` varchar(50) NOT NULL,
  `TipsTypeDescription` varchar(50) DEFAULT NULL,
  `TipsTypePhotoPath` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tipstype`
--

INSERT INTO `tipstype` (`TipsTypeId`, `TipsTypeName`, `TipsTypeDescription`, `TipsTypePhotoPath`) VALUES
(2, 'Mobile Photography', 'Mobile Photography', 'contest2.jpg'),
(3, 'DSLR Photography', 'DSLR Photography tips', '14952-15303_000.JPG');

-- --------------------------------------------------------

--
-- Table structure for table `userrole`
--

CREATE TABLE `userrole` (
  `UserRoleId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `RoleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `userrole`
--

INSERT INTO `userrole` (`UserRoleId`, `UserId`, `RoleId`) VALUES
(2, 2, 1),
(3, 3, 2),
(4, 4, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UserId` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `MiddleName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `EmailId` varchar(100) NOT NULL,
  `Password` text NOT NULL,
  `ProfilePhoto` text NOT NULL,
  `SocialProfileURL` varchar(100) NOT NULL,
  `IsDisable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UserId`, `FirstName`, `MiddleName`, `LastName`, `EmailId`, `Password`, `ProfilePhoto`, `SocialProfileURL`, `IsDisable`) VALUES
(2, 'kalp', 'R', 'Kansara', 'kapskansara164@gmail.com', 'PBKDF2WithHmacSHA256:2048:qorJ6dmrerXnfz0NOvKFed7TBef+/776pt2TjTJtHmc=:8KbLUCozallQTP37uGL/CctqYTtLC0N/P7tyMZ+J7G8=', 'DSC_0164.JPG', 'www.instagram.com/kalp.kansara', 0),
(3, 'Jeminee', 's', 'Patel', 'jemineepatel@gmail.com', 'PBKDF2WithHmacSHA256:2048:IFtnylInySUppCx/AH3/4atABym9lOzZNwrz/vTPwdw=:nlRWyZ/fH3h2jqve70aRC2nws0HTRL3r9dKzt9tO+mI=', 'DSC_0104.JPG', 'www.instagram.com/jeminee_patel', 0),
(4, 'kalp', 'R', 'Kansara', 'kapskansara164@gmail.com', 'PBKDF2WithHmacSHA256:2048:Un9cqsUWzNY5tLDnncvYL3eQmfcTxpdPwh+xU1W1I74=:9kiOchrnRgqKVcnWgJuM1s+Eur7AtEUC0tRIhk2S19U=', 'abc.jpeg', 'www.instagram.com/kalp.kansara', 0);

-- --------------------------------------------------------

--
-- Table structure for table `useruploadphoto`
--

CREATE TABLE `useruploadphoto` (
  `UserUploadPhotoId` int(11) NOT NULL,
  `CategoryId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `PhotoDescription` varchar(200) DEFAULT NULL,
  `IsApprove` tinyint(1) NOT NULL,
  `PhotoPathOriginal` text NOT NULL,
  `PhotoPathwithWM` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `useruploadphoto`
--

INSERT INTO `useruploadphoto` (`UserUploadPhotoId`, `CategoryId`, `UserId`, `PhotoDescription`, `IsApprove`, `PhotoPathOriginal`, `PhotoPathwithWM`) VALUES
(51, 2, 3, 'asd', 0, '14952-15303_000.JPG', NULL),
(52, 2, 3, 'dfg', 0, '33198520-33198880_212.JPG', NULL),
(55, 3, 4, 'zxc', 0, '39382768-39383666_298.JPG', NULL),
(56, 3, 4, 'vbn', 0, '67168280-67168642_346.JPG', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vottingxcontest`
--

CREATE TABLE `vottingxcontest` (
  `VottingXContestId` int(11) NOT NULL,
  `ContestId` int(11) NOT NULL,
  `ContestXUserId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `VottingCount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `winner`
--

CREATE TABLE `winner` (
  `WinnerId` int(11) NOT NULL,
  `ContestId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `ContestXUserId` int(11) NOT NULL,
  `Description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contest`
--
ALTER TABLE `contest`
  ADD PRIMARY KEY (`ContestId`);

--
-- Indexes for table `contestxuser`
--
ALTER TABLE `contestxuser`
  ADD PRIMARY KEY (`contestXUserId`),
  ADD KEY `fk_contestxuser_userId` (`UserId`),
  ADD KEY `fk_contestxuser_contestId` (`ContestId`);

--
-- Indexes for table `imageofweek`
--
ALTER TABLE `imageofweek`
  ADD PRIMARY KEY (`ImageOfWeekId`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`PaymentTypesId`);

--
-- Indexes for table `paymentxuser`
--
ALTER TABLE `paymentxuser`
  ADD PRIMARY KEY (`PaymentXUserId`),
  ADD KEY `fk_paymentxuser_paymentId` (`PaymentId`),
  ADD KEY `fk_paymentxuser_UserId` (`UserId`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`PermissionId`);

--
-- Indexes for table `photocategory`
--
ALTER TABLE `photocategory`
  ADD PRIMARY KEY (`CategoryId`);

--
-- Indexes for table `photographytips`
--
ALTER TABLE `photographytips`
  ADD PRIMARY KEY (`PhotographyTipsId`),
  ADD KEY `fk_photographytips_tipstypeId` (`TipsTypeId`);

--
-- Indexes for table `plans`
--
ALTER TABLE `plans`
  ADD PRIMARY KEY (`PlansId`);

--
-- Indexes for table `plansxuser`
--
ALTER TABLE `plansxuser`
  ADD PRIMARY KEY (`PlansXUserId`),
  ADD KEY `fk_plansxuser_userId` (`UserId`),
  ADD KEY `fk_plansxuser_plansId` (`PlansId`);

--
-- Indexes for table `rolepermission`
--
ALTER TABLE `rolepermission`
  ADD PRIMARY KEY (`RolePermissionId`),
  ADD KEY `fk_rolepermission_roleId` (`RoleId`),
  ADD KEY `fk_rolepermission_permissionId` (`PermissionId`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`RoleId`);

--
-- Indexes for table `tipstype`
--
ALTER TABLE `tipstype`
  ADD PRIMARY KEY (`TipsTypeId`);

--
-- Indexes for table `userrole`
--
ALTER TABLE `userrole`
  ADD PRIMARY KEY (`UserRoleId`),
  ADD KEY `fk_userrole_userId` (`UserId`),
  ADD KEY `fk_userrole_roleId` (`RoleId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UserId`);

--
-- Indexes for table `useruploadphoto`
--
ALTER TABLE `useruploadphoto`
  ADD PRIMARY KEY (`UserUploadPhotoId`),
  ADD KEY `fk_useruploadphto_categoryId` (`CategoryId`),
  ADD KEY `fk_useruploadphto_userId` (`UserId`);

--
-- Indexes for table `vottingxcontest`
--
ALTER TABLE `vottingxcontest`
  ADD PRIMARY KEY (`VottingXContestId`),
  ADD KEY `fk_vottingxcontest_contestId` (`ContestId`),
  ADD KEY `fk_vottingxcontest_contestxuserId` (`ContestXUserId`),
  ADD KEY `fk_vottingxcontest_userId` (`UserId`);

--
-- Indexes for table `winner`
--
ALTER TABLE `winner`
  ADD PRIMARY KEY (`WinnerId`),
  ADD KEY `fk_winner_contestId` (`ContestId`),
  ADD KEY `fk_winner_userId` (`UserId`),
  ADD KEY `fk_winner_userxcontestId` (`ContestXUserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contest`
--
ALTER TABLE `contest`
  MODIFY `ContestId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `contestxuser`
--
ALTER TABLE `contestxuser`
  MODIFY `contestXUserId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `imageofweek`
--
ALTER TABLE `imageofweek`
  MODIFY `ImageOfWeekId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `PaymentTypesId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paymentxuser`
--
ALTER TABLE `paymentxuser`
  MODIFY `PaymentXUserId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `PermissionId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `photocategory`
--
ALTER TABLE `photocategory`
  MODIFY `CategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `photographytips`
--
ALTER TABLE `photographytips`
  MODIFY `PhotographyTipsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `plans`
--
ALTER TABLE `plans`
  MODIFY `PlansId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `plansxuser`
--
ALTER TABLE `plansxuser`
  MODIFY `PlansXUserId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rolepermission`
--
ALTER TABLE `rolepermission`
  MODIFY `RolePermissionId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `RoleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tipstype`
--
ALTER TABLE `tipstype`
  MODIFY `TipsTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `userrole`
--
ALTER TABLE `userrole`
  MODIFY `UserRoleId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `useruploadphoto`
--
ALTER TABLE `useruploadphoto`
  MODIFY `UserUploadPhotoId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `vottingxcontest`
--
ALTER TABLE `vottingxcontest`
  MODIFY `VottingXContestId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `winner`
--
ALTER TABLE `winner`
  MODIFY `WinnerId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contestxuser`
--
ALTER TABLE `contestxuser`
  ADD CONSTRAINT `fk_contestxuser_contestId` FOREIGN KEY (`ContestId`) REFERENCES `contest` (`ContestId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_contestxuser_userId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `paymentxuser`
--
ALTER TABLE `paymentxuser`
  ADD CONSTRAINT `fk_paymentxuser_UserId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_paymentxuser_paymentId` FOREIGN KEY (`PaymentId`) REFERENCES `payment` (`PaymentTypesId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `photographytips`
--
ALTER TABLE `photographytips`
  ADD CONSTRAINT `fk_photographytips_tipstypeId` FOREIGN KEY (`TipsTypeId`) REFERENCES `tipstype` (`TipsTypeId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `plansxuser`
--
ALTER TABLE `plansxuser`
  ADD CONSTRAINT `fk_plansxuser_plansId` FOREIGN KEY (`PlansId`) REFERENCES `plans` (`PlansId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_plansxuser_userId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rolepermission`
--
ALTER TABLE `rolepermission`
  ADD CONSTRAINT `fk_rolepermission_permissionId` FOREIGN KEY (`PermissionId`) REFERENCES `permission` (`PermissionId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_rolepermission_roleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `userrole`
--
ALTER TABLE `userrole`
  ADD CONSTRAINT `fk_userrole_roleId` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`RoleId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_userrole_userId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `useruploadphoto`
--
ALTER TABLE `useruploadphoto`
  ADD CONSTRAINT `fk_useruploadphto_categoryId` FOREIGN KEY (`CategoryId`) REFERENCES `photocategory` (`CategoryId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_useruploadphto_userId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `vottingxcontest`
--
ALTER TABLE `vottingxcontest`
  ADD CONSTRAINT `fk_vottingxcontest_contestId` FOREIGN KEY (`ContestId`) REFERENCES `contest` (`ContestId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_vottingxcontest_contestxuserId` FOREIGN KEY (`ContestXUserId`) REFERENCES `contestxuser` (`contestXUserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_vottingxcontest_userId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `winner`
--
ALTER TABLE `winner`
  ADD CONSTRAINT `fk_winner_contestId` FOREIGN KEY (`ContestId`) REFERENCES `contest` (`ContestId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_winner_userId` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_winner_userxcontestId` FOREIGN KEY (`ContestXUserId`) REFERENCES `contestxuser` (`contestXUserId`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
