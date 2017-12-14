/*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE DATABASE IF NOT EXISTS v95vttmn90vrsksh;
USE `v95vttmn90vrsksh`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: robocode
-- ------------------------------------------------------
-- Server version	5.1.68-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Add Access table
DROP TABLE IF EXISTS Access; 
CREATE TABLE Access(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(20),
	CONSTRAINT pk_access PRIMARY KEY(id)
);

INSERT INTO `Access` VALUES (NULL, 'group.read');
INSERT INTO `Access` VALUES (NULL, 'group.write');
INSERT INTO `Access` VALUES (NULL, 'role.write');
INSERT INTO `Access` VALUES (NULL, 'role.read');

-- Add Role_Access table, reference to Access table using Foreign Key access_id
DROP TABLE IF EXISTS Role_Access;
CREATE TABLE Role_Access(
	role_id INT NOT NULL,  
	access_id INT NOT NULL, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT pk_Role_Access PRIMARY KEY(role_id), 
	CONSTRAINT fk_RA_Acccess FOREIGN KEY (access_id) REFERENCES Access(id) ON DELETE CASCADE
); 

-- Add Role table, reference to Role_relation table using Foreign Key id
-- Must enforce 'CONSTRAINT fk_role_RR FOREIGN KEY (id) REFERENCE Role_Relation(id)' later
DROP TABLE IF EXISTS Role; 
CREATE TABLE Role(
	name VARCHAR(20), 
	id INT NOT NULL AUTO_INCREMENT, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	update_time DATETIME ON UPDATE CURRENT_TIMESTAMP, 
	CONSTRAINT pk_role PRIMARY KEY(name), 
	CONSTRAINT fk_role_RA FOREIGN KEY (id) REFERENCES Role_Access(role_id) ON DELETE CASCADE
); 

-- CREATE Role_Relation table, reference to Role table using foreign key to_role_id
DROP TABLE IF EXISTS Role_Relation; 
CREATE TABLE Role_Relation(
	from_role_id INT NOT NULL, 
	to_role_id INT NOT NULL, 
	type VARCHAR(20), 
	CONSTRAINT pk_ID PRIMARY KEY(from_role_id), 
	CONSTRAINT fk_RA_role FOREIGN KEY (to_role_id) REFERENCES Role(id)
); 

-- Enforce relation from Role to role relation
ALTER TABLE Role ADD CONSTRAINT FOREIGN KEY (id) REFERENCES Role_Relation (from_role_id) ON DELETE CASCADE;

-- Create table Group_Role, referencing to role table
DROP TABLE IF EXISTS Group_Role; 
CREATE TABLE Group_Role(
	group_id INT NOT NULL, 
	role_id INT NOT NULL, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT pk_group_role PRIMARY KEY(group_id), 
	CONSTRAINT fk_gr_role FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE CASCADE ON UPDATE CASCADE
); 

-- Create table Group, referencing to group role
DROP TABLE IF EXISTS Groups; 
CREATE TABLE Groups(
	id INT NOT NULL AUTO_INCREMENT, 
	name VARCHAR(20) NOT NULL, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT pk_Group PRIMARY KEY (name), 
	CONSTRAINT fk_group_gr FOREIGN KEY (id) REFERENCES Group_Role(group_id) ON DELETE CASCADE ON UPDATE CASCADE
); 

-- Create table User_Group, referencing to Group
DROP TABLE IF EXISTS User_Group; 
CREATE TABLE User_Group(
	usr_id VARCHAR(80) NOT NULL, 
	group_id INT NOT NULL, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT pk_User_Group PRIMARY KEY(usr_id), 
	CONSTRAINT fk_UG_G FOREIGN KEY (group_id) REFERENCES Groups(id) ON DELETE CASCADE ON UPDATE CASCADE
); 

-- Create table User_role, referencing to role table
DROP TABLE IF EXISTS User_Role; 
CREATE TABLE User_Role(
	usr_id VARCHAR(80) NOT NULL, 
	role_id INT NOT NULL, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT pk_user_role PRIMARY KEY(usr_id), 
	CONSTRAINT fk_UR_role FOREIGN KEY (role_id) REFERENCES Role(id) ON DELETE CASCADE ON UPDATE CASCADE
); 

-- Create table user, reference to User_Role and User_Group
DROP TABLE IF EXISTS User; 
CREATE TABLE User(
	id INT AUTO_INCREMENT, 
	userID VARCHAR(80) DEFAULT NULL, 
	create_time DATETIME DEFAULT CURRENT_TIMESTAMP, 
	CONSTRAINT pk_user PRIMARY KEY(id), 
	CONSTRAINT UNIQUE(userID), 
	CONSTRAINT fk_user_UG FOREIGN KEY (userID) REFERENCES User_group(usr_id) ON DELETE CASCADE ON UPDATE CASCADE, 
	CONSTRAINT fk_user_UR FOREIGN KEY (userID) REFERENCES User_role(usr_id) ON DELETE CASCADE ON UPDATE CASCADE 
); 

--
-- Table structure for table `battlestat`
--

DROP TABLE IF EXISTS `battlestat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `battlestat` (
  `Rank` int(11) DEFAULT NULL,
  `RobotName` varchar(30) DEFAULT NULL,
  `TotalScore` int(11) DEFAULT NULL,
  `PercentofTotal` int(11) DEFAULT NULL,
  `Survival` int(11) DEFAULT NULL,
  `SurvivalBonus` int(11) DEFAULT NULL,
  `BulletDmg` int(11) DEFAULT NULL,
  `BulletBonus` int(11) DEFAULT NULL,
  `RamDmg2` int(11) DEFAULT NULL,
  `RamBonus` int(11) DEFAULT NULL,
  `1sts` int(11) DEFAULT NULL,
  `2nds` int(11) DEFAULT NULL,
  `3rds` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `battlestat`
--

LOCK TABLES `battlestat` WRITE;
/*!40000 ALTER TABLE `battlestat` DISABLE KEYS */;
/*!40000 ALTER TABLE `battlestat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `robot`
--

DROP TABLE IF EXISTS `robot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `robot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userID` varchar(80) DEFAULT NULL,
  `packageID` varchar(80) DEFAULT NULL,
  `robotID` varchar(80) DEFAULT NULL,
  `dataaccess` varchar(4) DEFAULT NULL,
  `filepath` longtext,
  `CreatedDate` varchar(200) DEFAULT NULL,
  `UpdatedDate` varchar(200) DEFAULT NULL,
  `RobotCode` longtext,
  `file` longblob,
  `tid` int DEFAULT 0,                                    
  `rid` int DEFAULT 0,                               
  PRIMARY KEY (`id`), 
  CONSTRAINT fk_robot_user FOREIGN KEY(userID) REFERENCES User(userID)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `robot`
--

-- Column does not match error
LOCK TABLES `robot` WRITE;
/*!40000 ALTER TABLE `robot` DISABLE KEYS */;
INSERT INTO `robot` VALUES (
  '',
  'User',
  'sample',
  'Crazy',
  'Y',
  'C:/robocode/robots/sample/Crazy.java',
  'Mon Jan 25 10:27:35 CST 2016',
  'Fri Sep 23 17:06:41 CDT 2016',
  '/**
 * Copyright (c) 2001-2017 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 */
package sample;


import robocode.*;

import java.awt.*;


/**
 * Crazy - a sample robot by Mathew Nelson.
 * <p>
 * This robot moves around in a crazy pattern.
 *
 * @author Mathew A. Nelson (original)
 * @author Flemming N. Larsen (contributor)
 */
public class Crazy extends AdvancedRobot {
	boolean movingForward;

	/**
	 * run: Crazy''s main run function
	 */
	public void run() {
		// Set colors
		setBodyColor(new Color(0, 200, 0));
		setGunColor(new Color(0, 150, 50));
		setRadarColor(new Color(0, 100, 100));
		setBulletColor(new Color(255, 255, 100));
		setScanColor(new Color(255, 200, 200));

		// Loop forever
		while (true) {
			// Tell the game we will want to move ahead 40000 -- some large number
			setAhead(40000);
			movingForward = true;
			// Tell the game we will want to turn right 90
			setTurnRight(90);
			// At this point, we have indicated to the game that *when we dao something*,
			// we will want to move ahead and turn right.  That''s what "set" means.
			// It is important to realize we have not done anything yet!
			// In order to actually move, we''ll want to call a method that
			// takes real time, such as waitFor.
			// waitFor actually starts the action -- we start moving and turning.
			// It will not return until we have finished turning.
			waitFor(new TurnCompleteCondition(this));
			// Note:  We are still moving ahead now, but the turn is complete.
			// Now we''ll turn the other way...
			setTurnLeft(180);
			// ... and wait for the turn to finish ...
			waitFor(new TurnCompleteCondition(this));
			// ... then the other way ...
			setTurnRight(180);
			// .. and wait for that turn to finish.
			waitFor(new TurnCompleteCondition(this));
			// then back to the top to dao it all again
		}
	}

	/**
	 * onHitWall:  Handle collision with wall.
	 */
	public void onHitWall(HitWallEvent e) {
		// Bounce off!
		reverseDirection();
	}

	/**
	 * reverseDirection:  Switch from ahead to back & vice versa
	 */
	public void reverseDirection() {
		if (movingForward) {
			setBack(40000);
			movingForward = false;
		} else {
			setAhead(40000);
			movingForward = true;
		}
	}

	/**
	 * onScannedRobot:  Fire!
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	/**
	 * onHitRobot:  Back up!
	 */
	public void onHitRobot(HitRobotEvent e) {
		// If we''re moving the other robot, reverse!
		if (e.isMyFault()) {
			reverseDirection();
		}
	}
}',
  NULL, 
  0, 
  0);
/*!40000 ALTER TABLE `robot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `totalstat`
--

DROP TABLE IF EXISTS `totalstat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `totalstat` (
  `Rank` int(11) DEFAULT NULL,
  `RobotName` varchar(30) DEFAULT NULL,
  `TotalScore` int(11) DEFAULT NULL,
  `PercentofTotal` int(11) DEFAULT NULL,
  `1sts` int(11) DEFAULT NULL,
  `2nds` int(11) DEFAULT NULL,
  `3rds` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `totalstat`
--

LOCK TABLES `totalstat` WRITE;
/*!40000 ALTER TABLE `totalstat` DISABLE KEYS */;
/*!40000 ALTER TABLE `totalstat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trial`
--

DROP TABLE IF EXISTS `trial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trial` (
  `robotname` varchar(255) DEFAULT NULL,
  `robotcode` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trial`
--

LOCK TABLES `trial` WRITE;
/*!40000 ALTER TABLE `trial` DISABLE KEYS */;
/*!40000 ALTER TABLE `trial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'robocode'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-11 11:23:35



