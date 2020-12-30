-- MySQL dump 10.13  Distrib 5.7.28, for Win64 (x86_64)
--
-- Host: localhost    Database: dbblog
-- ------------------------------------------------------
-- Server version	5.7.28-log

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
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `CatId` int(11) NOT NULL AUTO_INCREMENT,
  `CatNombre` varchar(255) NOT NULL,
  `CatEstado` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`CatId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'+cat+',1),(2,'Joy- Funcinoa',1),(3,'Somali',1),(4,'asd',1),(5,'qwe',1),(6,'Noloolo',1);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentarios` (
  `ComId` int(11) NOT NULL AUTO_INCREMENT,
  `ComIDPost` int(11) NOT NULL,
  `ComIDUsuario` int(11) NOT NULL,
  `ComTexto` text NOT NULL,
  `ComContador` int(11) DEFAULT '1',
  `ComEstado` tinyint(1) DEFAULT '1',
  `ComFechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ComId`,`ComIDPost`),
  KEY `FK_PosteosComentarios1_idx` (`ComIDPost`),
  KEY `FK_UsuariosComentarios1_idx` (`ComIDUsuario`),
  CONSTRAINT `FK_IdPosteo` FOREIGN KEY (`ComIDPost`) REFERENCES `posts` (`PostId`),
  CONSTRAINT `FK_IdUsuariosComentarios` FOREIGN KEY (`ComIDUsuario`) REFERENCES `usuarios` (`UsuId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (1,1,1,'Genial! Esto es buenisimo',1,1,'2019-12-12 05:29:41'),(2,1,2,'Muy excelente, esto me encanta',1,1,'2019-12-12 05:29:41'),(3,1,3,'Me gusta, mucho!',1,1,'2019-12-12 05:29:41'),(4,1,18,'Estoy de acuerdo con los anteriores comentarios',1,1,'2019-12-12 06:06:48'),(5,1,19,'Muy bien',1,1,'2019-12-17 03:36:35'),(6,1,15,'Excelente',1,1,'2019-12-17 03:41:48'),(7,1,15,'Genial',1,1,'2019-12-17 03:50:41'),(8,1,15,'Genial',1,1,'2019-12-17 03:50:50'),(9,1,15,'Genial',1,1,'2019-12-17 03:50:52'),(10,1,15,'Genial',1,1,'2019-12-17 03:50:52'),(11,1,15,'Genial',1,1,'2019-12-17 03:50:58'),(12,1,15,'Muy bueno',1,1,'2019-12-17 04:01:21'),(13,1,15,'Ok, muy bueno',1,1,'2019-12-17 04:09:43'),(14,1,15,'Hola',1,1,'2019-12-17 04:10:54'),(15,1,17,'Bueno',1,1,'2019-12-17 04:14:26');
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts` (
  `PostId` int(11) NOT NULL AUTO_INCREMENT,
  `PostTitulos` varchar(255) NOT NULL,
  `PostDescripcion` varchar(511) NOT NULL,
  `PostTexto` text NOT NULL,
  `PostImage` varchar(255) DEFAULT NULL,
  `PostFechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PostEstado` tinyint(4) DEFAULT '1',
  `PostIDCategoria` int(11) NOT NULL,
  `PostIDUsuario` int(11) NOT NULL,
  `PostPuntaje` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`PostId`),
  KEY `FK_UsuariosPost1_idx` (`PostIDUsuario`),
  KEY `FK_CategoriasPost1_idx` (`PostIDCategoria`),
  CONSTRAINT `FK_CategoriasPost` FOREIGN KEY (`PostIDCategoria`) REFERENCES `categorias` (`CatId`),
  CONSTRAINT `FK_UsuariosPost` FOREIGN KEY (`PostIDUsuario`) REFERENCES `usuarios` (`UsuId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Autos','Los autos son geniales','Los autos son de muchos modelos y colores','Imagenes/auto1.png','2019-12-19 07:12:57',1,1,1,7),(2,'Camiones','Los camiones son geniales','Los camiones son de muchos modelos y colores','Imagenes/camion1.png','2019-12-19 06:07:17',1,1,1,7),(3,'Motos','Las motos son geniales','Las motos son de muchos modelos y colores','Imagenes/moto1.png','2019-12-19 06:07:17',1,1,1,10),(4,'Aviones','Los aviones son geniales','Los aviones son de muchos modelos y colores','Imagenes/avion1.png','2019-12-11 17:46:44',1,1,1,5),(5,'Bicicletas','Las bicicletas son geniales','Las bicicletas son de muchos modelos y colores','Imagenes/bicicleta1.png','2019-12-19 07:12:57',1,1,1,7),(6,'Mar','El mar es gigante','El mar es enorme y abarca todo el planeta tierra en su totalidad, y gran magnitud',NULL,'2019-12-11 17:46:44',1,1,15,1),(7,'Oceano','El oceano es inmenso','El oceano es el 75% del planeta',NULL,'2019-12-19 07:13:37',1,1,15,80),(8,'Rio','El rio es corto y largo','El rio puede ser corto y largo y desembocar en el mar',NULL,'2019-12-11 17:46:44',1,1,15,1),(9,'Lagunas','asddsasdasda','asdsdasdadsasdadsa','Desert.jpg','2019-12-11 17:46:44',1,1,15,1),(10,'sadsadsdasda','sadsadsadsa','sadsasdasadsad','Desert.jpg','2019-12-11 17:46:44',0,1,15,1),(11,'Musica','La musica es genial','La musica es genial e inspira','Desert.jpg','2019-12-11 17:49:00',1,1,17,1),(12,'fassfasfafasfsa','fasfsafsafsafsafsafsa','asdadsadssadsadsad','Imagenes/Desert.jpg','2019-12-17 03:24:26',1,1,15,1),(13,'sdadsadsasda','saddsadsadsadsa','saddsadsadsadsa','Imagenes/','2019-12-17 03:25:27',1,5,15,1),(14,'saddsa','sadsadsad','asdaasdsadsadsa','Imagenes/','2019-12-17 03:30:38',1,4,15,1),(15,'safsfasfa','sfafsafasfsa','sfasfafsafsa','Imagenes/','2019-12-18 02:43:03',0,1,15,1),(16,'adsfsddsfdsfdfsdsfdsfdfsdsfdfsdfsdsfdsf','sdfsdss','asasdasasfasfasfassafsasaffas','Imagenes/','2019-12-18 01:53:21',1,1,15,1),(17,'aaa','aasdvv','bbb','Imagenes/','2019-12-18 01:56:24',1,1,15,1),(18,'Posteo Arreglado','Post','Posteo','','2019-12-18 03:00:05',1,1,15,1),(19,'PostP','aaa','Posteo','Imagenes/','2019-12-18 02:54:59',0,1,15,1),(20,'Frutas','Las frutas son geniales','Las frutas son ricas','Imagenes/','2019-12-19 02:35:30',1,1,15,1);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntuacionxcomentarios`
--

DROP TABLE IF EXISTS `puntuacionxcomentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntuacionxcomentarios` (
  `PuntuacionIdComentario` int(11) NOT NULL,
  `PuntuacionIdPost` int(11) NOT NULL,
  `PuntuacionIdUsuario` int(11) NOT NULL,
  `PuntuacionPuntaje` int(11) NOT NULL,
  PRIMARY KEY (`PuntuacionIdComentario`,`PuntuacionIdPost`,`PuntuacionIdUsuario`),
  KEY `FK_PuntuacionIdPost_idx` (`PuntuacionIdComentario`),
  KEY `FK_PuntuacionIdPostUsuario_idx` (`PuntuacionIdPost`),
  KEY `FK_PuntuacionIdComentarioUsuario_idx` (`PuntuacionIdUsuario`),
  CONSTRAINT `FK_PuntuacionIdComentario` FOREIGN KEY (`PuntuacionIdPost`) REFERENCES `comentarios` (`ComIDPost`),
  CONSTRAINT `FK_PuntuacionIdComentarioUsuario` FOREIGN KEY (`PuntuacionIdComentario`) REFERENCES `comentarios` (`ComId`),
  CONSTRAINT `FK_PuntuacionIdUsuarioPuntua` FOREIGN KEY (`PuntuacionIdUsuario`) REFERENCES `usuarios` (`UsuId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntuacionxcomentarios`
--

LOCK TABLES `puntuacionxcomentarios` WRITE;
/*!40000 ALTER TABLE `puntuacionxcomentarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntuacionxcomentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntuacionxpost`
--

DROP TABLE IF EXISTS `puntuacionxpost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntuacionxpost` (
  `puntosIdPost` int(11) NOT NULL,
  `puntosIdUsuario` int(11) NOT NULL,
  `PuntuacionPuntaje` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`puntosIdPost`,`puntosIdUsuario`),
  KEY `FK_idUsuario_idx` (`puntosIdUsuario`),
  CONSTRAINT `FK_idPost` FOREIGN KEY (`puntosIdPost`) REFERENCES `posts` (`PostId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_idUsuario` FOREIGN KEY (`puntosIdUsuario`) REFERENCES `usuarios` (`UsuId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntuacionxpost`
--

LOCK TABLES `puntuacionxpost` WRITE;
/*!40000 ALTER TABLE `puntuacionxpost` DISABLE KEYS */;
INSERT INTO `puntuacionxpost` VALUES (1,1,1),(1,2,1),(1,4,1),(1,12,1),(1,14,1),(1,18,1),(2,1,1),(2,18,1),(8,1,1);
/*!40000 ALTER TABLE `puntuacionxpost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestas` (
  `ResId` int(11) NOT NULL AUTO_INCREMENT,
  `ResIDComentario` int(11) NOT NULL,
  `ResIDPost` int(11) NOT NULL,
  `ResIDUsuario` int(11) NOT NULL,
  `ResTexto` text,
  `ResEstado` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`ResId`,`ResIDComentario`,`ResIDPost`),
  KEY `FK_ComentariosRespuestas_idx` (`ResIDComentario`),
  KEY `FK_UsuariosRespuestas_idx` (`ResIDUsuario`),
  KEY `FK_PosteosRespuestas_idx` (`ResIDPost`),
  CONSTRAINT `FK_ResIdComentario` FOREIGN KEY (`ResIDComentario`) REFERENCES `comentarios` (`ComId`),
  CONSTRAINT `FK_ResIdComentarioUsuario` FOREIGN KEY (`ResIDUsuario`) REFERENCES `usuarios` (`UsuId`),
  CONSTRAINT `FK_ResIdPosteo` FOREIGN KEY (`ResIDPost`) REFERENCES `comentarios` (`ComIDPost`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `UsuId` int(11) NOT NULL AUTO_INCREMENT,
  `UsuNombre` varchar(50) NOT NULL,
  `UsuApellido` varchar(50) NOT NULL,
  `UsuEmail` varchar(255) NOT NULL,
  `UsuPassword` varchar(60) NOT NULL,
  `UsuImage` varchar(255) DEFAULT NULL,
  `UsuEstado` tinyint(4) NOT NULL DEFAULT '1',
  `UsuTipo` int(11) NOT NULL DEFAULT '1',
  `UsuUsername` varchar(50) DEFAULT NULL,
  `UsuFechaCreacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`UsuId`),
  UNIQUE KEY `UsuId_UNIQUE` (`UsuId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'a','a','a','a',NULL,1,1,NULL,'2019-12-11 17:52:24'),(2,'a','a','b','b',NULL,1,1,NULL,'2019-12-11 17:52:24'),(3,'q','q','q','q',NULL,1,1,NULL,'2019-12-11 17:52:24'),(4,'s','s','a','s',NULL,1,1,NULL,'2019-12-11 17:52:24'),(5,'123','123','213','123',NULL,1,1,NULL,'2019-12-11 17:52:24'),(6,'a','a','a','a',NULL,1,1,NULL,'2019-12-11 17:52:24'),(7,'e','e','3','e',NULL,1,1,NULL,'2019-12-11 17:52:24'),(8,'w','w','w','w',NULL,1,1,NULL,'2019-12-11 17:52:24'),(9,'rs','rs','rs','rs',NULL,1,1,NULL,'2019-12-11 17:52:24'),(10,'rs','rs','rs','rs',NULL,1,1,NULL,'2019-12-11 17:52:24'),(11,'ta','ta','ta','ta',NULL,1,1,NULL,'2019-12-11 17:52:24'),(12,'1','1','1','1',NULL,1,1,NULL,'2019-12-11 17:52:24'),(13,'7','s','s','s',NULL,1,1,NULL,'2019-12-11 17:52:24'),(14,'qwe','eqwe','asd@gm','12e',NULL,1,1,NULL,'2019-12-11 17:52:24'),(15,'Unicornio','Rosa','unicornio39@gmail.com','1','Imagenes/imagenGeneral.png',1,1,NULL,'2019-12-11 17:52:24'),(16,'paula','zamudio','pauagus.zamudio@gmail.com','tractorcito',NULL,1,1,NULL,'2019-12-11 17:52:24'),(17,'admin','admin','admin','admin',NULL,1,2,NULL,'2019-12-11 17:52:24'),(18,'cba','abc','prueba123@gmail.com','1',NULL,1,1,NULL,'2019-12-12 04:39:29'),(19,'fran','diaz','fran@gmail.com','1',NULL,1,1,NULL,'2019-12-17 03:35:14');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'dbblog'
--

--
-- Dumping routines for database 'dbblog'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-19  4:17:23
