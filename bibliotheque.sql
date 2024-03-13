-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           5.7.33 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Listage de la structure de la table bibliotheque. categorielivre
CREATE TABLE IF NOT EXISTS `categorielivre` (
  `idCategorie` int(5) NOT NULL AUTO_INCREMENT,
  `nomCategorie` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCategorie`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. empruntlivre
CREATE TABLE IF NOT EXISTS `empruntlivre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeLecteur` varchar(50) DEFAULT NULL,
  `codeLivre` varchar(50) DEFAULT NULL,
  `dateEmprunt` varchar(50) DEFAULT NULL,
  `dateRetour` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. enregtemporaire
CREATE TABLE IF NOT EXISTS `enregtemporaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codeLivre` varchar(50) DEFAULT NULL,
  `titreLivre` varchar(50) DEFAULT NULL,
  `nomAuteur` varchar(50) DEFAULT NULL,
  `nomCategorie` varchar(50) DEFAULT NULL,
  `datePub` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. lecteur
CREATE TABLE IF NOT EXISTS `lecteur` (
  `codeLecteur` varchar(50) NOT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(50) DEFAULT NULL,
  `genre` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`codeLecteur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. livre
CREATE TABLE IF NOT EXISTS `livre` (
  `codeLivre` varchar(50) NOT NULL,
  `titreLivre` varchar(80) DEFAULT NULL,
  `nomAuteur` varchar(50) DEFAULT NULL,
  `nomCategorie` varchar(50) DEFAULT NULL,
  `datePub` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codeLivre`),
  KEY `nomCategorie` (`nomCategorie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. retourlivre
CREATE TABLE IF NOT EXISTS `retourlivre` (
  `idRetour` int(5) NOT NULL AUTO_INCREMENT,
  `codeLecteur` varchar(50) DEFAULT NULL,
  `codeLivre` varchar(50) DEFAULT NULL,
  `dateRetour` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idRetour`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de la table bibliotheque. vente
CREATE TABLE IF NOT EXISTS `vente` (
  `idVente` int(11) NOT NULL AUTO_INCREMENT,
  `codeLivreVente` varchar(50) DEFAULT NULL,
  `titreLivreVente` varchar(50) DEFAULT NULL,
  `nomAuteurVente` varchar(50) DEFAULT NULL,
  `dateVente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idVente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- Les données exportées n'étaient pas sélectionnées.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
