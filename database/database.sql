-- MySQL dump 10.13  Distrib 5.7.11, for Win64 (x86_64)
--
-- Host: localhost    Database: javaee
-- ------------------------------------------------------
-- Server version	5.7.11-log

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

--
-- Table structure for table `candidature`
--

DROP TABLE IF EXISTS `candidature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidature` (
  `id_candidature` int(4) NOT NULL AUTO_INCREMENT,
  `id_offre` int(4) NOT NULL,
  `nomFichier` varchar(255) NOT NULL,
  `position` varchar(30) NOT NULL,
  PRIMARY KEY (`id_candidature`),
  KEY `id_offre` (`id_offre`),
  CONSTRAINT `candidature_ibfk_1` FOREIGN KEY (`id_offre`) REFERENCES `offre_emploi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidature`
--

LOCK TABLES `candidature` WRITE;
/*!40000 ALTER TABLE `candidature` DISABLE KEYS */;
INSERT INTO `candidature` VALUES (21,18,'cv.pdf','C++ Developper'),(22,18,'Aymen\'s Résumé (5).pdf','C++ Developper');
/*!40000 ALTER TABLE `candidature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conges`
--

DROP TABLE IF EXISTS `conges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conges` (
  `matricule` varchar(255) NOT NULL,
  `datedeb` date NOT NULL,
  `jours_demande` int(4) NOT NULL,
  `type_conge` varchar(255) NOT NULL,
  `reponse` varchar(30) NOT NULL DEFAULT 'Unseen',
  PRIMARY KEY (`matricule`,`datedeb`,`jours_demande`),
  CONSTRAINT `conges_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `noms` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conges`
--

LOCK TABLES `conges` WRITE;
/*!40000 ALTER TABLE `conges` DISABLE KEYS */;
INSERT INTO `conges` VALUES ('1001','2016-07-20',15,'Illness','Unseen'),('1004','2016-06-01',5,'Annuel','accepted');
/*!40000 ALTER TABLE `conges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `execution`
--

DROP TABLE IF EXISTS `execution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `execution` (
  `matricule` varchar(255) NOT NULL,
  `id_mission` int(4) NOT NULL,
  PRIMARY KEY (`matricule`,`id_mission`),
  KEY `id_mission` (`id_mission`),
  CONSTRAINT `execution_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `noms` (`matricule`),
  CONSTRAINT `execution_ibfk_2` FOREIGN KEY (`id_mission`) REFERENCES `mission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `execution`
--

LOCK TABLES `execution` WRITE;
/*!40000 ALTER TABLE `execution` DISABLE KEYS */;
/*!40000 ALTER TABLE `execution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formation` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `service` varchar(30) NOT NULL,
  `theme` varchar(255) NOT NULL,
  `priorite` int(2) NOT NULL,
  `dure_moy` int(4) NOT NULL,
  `budget` float DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `etat` varchar(30) DEFAULT 'demande',
  `lieu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation`
--

LOCK TABLES `formation` WRITE;
/*!40000 ALTER TABLE `formation` DISABLE KEYS */;
INSERT INTO `formation` VALUES (3,'Software development','Datawarhouse',3,15,1000,'2016-04-20','2016-05-04','Archive','Tunisia'),(4,'Finance','aaaaaaaaaaa',10,20,1000,'2016-05-05','2016-05-20','canceled','Sfax'),(5,'Finance','blabalaa',5,15,1000,'2016-05-05','2016-05-20','Archive','Sfax'),(6,'Finance','blabalaa',5,15,1000,'2016-05-05','2016-05-20','canceled','Sfax'),(7,'Finance','blabalaa',5,15,1000,'2016-05-05','2016-05-20','Archive','Sfax'),(8,'Finance','blabalaa',5,15,1000,'2016-05-05','2016-05-20','requested','Sfax'),(9,'Finance','blabalaa',5,15,1000,'2016-05-18','2016-05-20','canceled','Sfax'),(10,'Finance','blabalaa',5,15,1000,'2016-05-20','2016-06-12','refused','Sfax');
/*!40000 ALTER TABLE `formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `source` varchar(255) NOT NULL,
  `destination` varchar(255) NOT NULL,
  `objet` text NOT NULL,
  `contenu` text NOT NULL,
  `date` date NOT NULL,
  `etat` varchar(30) DEFAULT 'Non vu',
  PRIMARY KEY (`id`),
  KEY `source` (`source`),
  KEY `destination` (`destination`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`source`) REFERENCES `noms` (`matricule`),
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`destination`) REFERENCES `noms` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission`
--

DROP TABLE IF EXISTS `mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mission` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `service` varchar(30) NOT NULL,
  `objet` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `date_debut` date NOT NULL,
  `dure` int(4) NOT NULL,
  `lieu` varchar(255) NOT NULL,
  `etat` varchar(30) DEFAULT 'Non vu',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission`
--

LOCK TABLES `mission` WRITE;
/*!40000 ALTER TABLE `mission` DISABLE KEYS */;
INSERT INTO `mission` VALUES (1,'Marketing','kkkkkkkkkkkk','pffffffffff','2016-05-17',15,'Sfax','Validé');
/*!40000 ALTER TABLE `mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `noms`
--

DROP TABLE IF EXISTS `noms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `noms` (
  `matricule` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `position` varchar(255) NOT NULL,
  `deb_contrat` date NOT NULL,
  `fin_contrat` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `service` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  `ville` varchar(30) NOT NULL,
  `pays` varchar(30) NOT NULL,
  `paie_heure` float NOT NULL,
  `pex_heure` float NOT NULL,
  PRIMARY KEY (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `noms`
--

LOCK TABLES `noms` WRITE;
/*!40000 ALTER TABLE `noms` DISABLE KEYS */;
INSERT INTO `noms` VALUES ('1000','admin','John','Doe','HR Director','2016-01-01','2019-01-01','john.doe@gmail.com','+216 55465213','HR','admin','Manouba - Tunis','Manouba','Tunisia',20,30),('1001','bruno123','Bruno','Nash','Chef Executif','2016-02-01','2018-02-01','bruno.nash@gmail.com','+216 55465214 ','Software Development','bruno','Manouba - Tunis','Manouba','Tunisia',18,25),('1004','bradley123','Bradley','Greer','C++ Developper','2016-02-06','2017-02-06','bradley.greer@gmail.com','+216 55478213','Software Development','brafley1','Manouba - Tunis','Manouba','Tunisia',15,20);
/*!40000 ALTER TABLE `noms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre_emploi`
--

DROP TABLE IF EXISTS `offre_emploi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offre_emploi` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `position` varchar(30) NOT NULL,
  `competences` varchar(255) NOT NULL,
  `experience` int(4) NOT NULL,
  `description` text NOT NULL,
  `date_limite` date NOT NULL,
  `date_pub` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre_emploi`
--

LOCK TABLES `offre_emploi` WRITE;
/*!40000 ALTER TABLE `offre_emploi` DISABLE KEYS */;
INSERT INTO `offre_emploi` VALUES (18,'C++ Developper','C++ / Code Blocks / English',2,'medium experienced C ++ developer','2016-08-06','2016-05-23');
/*!40000 ALTER TABLE `offre_emploi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participants` (
  `matricule` varchar(255) NOT NULL,
  `id_formation` int(4) NOT NULL,
  PRIMARY KEY (`matricule`,`id_formation`),
  KEY `id_formation` (`id_formation`),
  CONSTRAINT `participants_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `noms` (`matricule`),
  CONSTRAINT `participants_ibfk_2` FOREIGN KEY (`id_formation`) REFERENCES `formation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pointage`
--

DROP TABLE IF EXISTS `pointage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pointage` (
  `matricule` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`matricule`,`date`),
  CONSTRAINT `pointage_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `noms` (`matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pointage`
--

LOCK TABLES `pointage` WRITE;
/*!40000 ALTER TABLE `pointage` DISABLE KEYS */;
INSERT INTO `pointage` VALUES ('1001','2016-03-02 08:00:00','enter'),('1001','2016-03-02 20:00:00','out'),('1001','2016-03-03 08:00:00','enter'),('1001','2016-03-03 20:00:00','out'),('1001','2016-04-01 08:00:00','enter'),('1001','2016-04-01 20:00:00','out');
/*!40000 ALTER TABLE `pointage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recrutement`
--

DROP TABLE IF EXISTS `recrutement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recrutement` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `service` varchar(30) NOT NULL,
  `position` varchar(30) NOT NULL,
  `competences` varchar(255) NOT NULL,
  `experience` int(4) NOT NULL,
  `etat` varchar(20) NOT NULL DEFAULT 'requested',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recrutement`
--

LOCK TABLES `recrutement` WRITE;
/*!40000 ALTER TABLE `recrutement` DISABLE KEYS */;
INSERT INTO `recrutement` VALUES (14,'Software Development','C++ Developper','C++ / Code Blocks / English',2,'published');
/*!40000 ALTER TABLE `recrutement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salaire`
--

DROP TABLE IF EXISTS `salaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salaire` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `matricule` varchar(255) NOT NULL,
  `nb_heures` float NOT NULL,
  `nb_extra` float NOT NULL,
  `prime` float NOT NULL,
  `impots` float NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `matricule` (`matricule`),
  CONSTRAINT `salaire_ibfk_1` FOREIGN KEY (`matricule`) REFERENCES `noms` (`matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salaire`
--

LOCK TABLES `salaire` WRITE;
/*!40000 ALTER TABLE `salaire` DISABLE KEYS */;
INSERT INTO `salaire` VALUES (60,'1000',140,30,30,10,'2016-01-31'),(61,'1000',115,30,30,10,'2016-02-29'),(62,'1000',130,15,30,10,'2016-03-31'),(63,'1000',150,20,50,50,'2016-04-30'),(64,'1001',12,0,10,5,'2016-05-01'),(65,'1001',12,0,20,5,'2016-05-01'),(66,'1001',12,0,20,5,'2016-05-01'),(67,'1001',12,0,10,5,'2016-05-01');
/*!40000 ALTER TABLE `salaire` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-14 14:25:07
