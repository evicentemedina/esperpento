-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 15-03-2018 a las 20:38:29
-- Versión del servidor: 5.6.33
-- Versión de PHP: 7.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

DROP DATABASE `esperpento`;
CREATE DATABASE `esperpento` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `esperpento`;

CREATE TABLE `users` (
  `name` varchar(25) NOT NULL PRIMARY KEY,
  `passwd` varchar(50) NOT NULL,
  `icon` varchar(4) NULL DEFAULT NULL,
  `reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_con` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `communities` (
  `name` varchar(25) NOT NULL PRIMARY KEY,
  `descrip` varchar(255) NULL DEFAULT NULL,
  `icon` varchar(4) NULL DEFAULT NULL,
  `color` char(6) NULL DEFAULT NULL,
  `bg_color` char(6) NULL DEFAULT NULL,
  `admin` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `threads` (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(100) NOT NULL,
  `content` varchar(2500) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upvotes` mediumint(8) UNSIGNED NOT NULL DEFAULT '0',
  `downvotes` mediumint(8) UNSIGNED NOT NULL DEFAULT '0',
  `last_edited` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `community` varchar(25) NOT NULL,
  `user` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comments` (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `content` text(1000) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `upvotes` mediumint(8) UNSIGNED NOT NULL DEFAULT '0',
  `downvotes` mediumint(8) UNSIGNED NOT NULL DEFAULT '0',
  `last_edited` timestamp NULL DEFAULT NULL,
  `parent` mediumint(8) UNSIGNED NULL DEFAULT NULL,
  `thread` mediumint(8) UNSIGNED NOT NULL,
  `user` mediumint(8) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `chatrooms` (
  `name` varchar(25) NOT NULL PRIMARY KEY,
  `descrip` varchar(255) NULL DEFAULT NULL,
  `icon` varchar(4) NULL DEFAULT NULL,
  `community` varchar(25) NOT NULL,
  `admin` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `messages` (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `content` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `room` varchar(25) NOT NULL,
  `user` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users_communities` (
  `user` varchar(25) NOT NULL,
  `community` varchar(25) NOT NULL,
  CONSTRAINT PK_users_communities PRIMARY KEY(`user`, `community`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `votes` (
  `user` varchar(25) NOT NULL,
  `comment` mediumint(8) UNSIGNED NOT NULL,
  `vote` boolean NOT NULL,
  CONSTRAINT PK_votes PRIMARY KEY(`user`, `comment`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
