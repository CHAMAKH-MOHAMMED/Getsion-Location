-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 09 avr. 2025 à 22:53
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestionlocation`
--

-- --------------------------------------------------------

--
-- Structure de la table `contrat`
--

CREATE TABLE `contrat` (
  `ID` int(10) NOT NULL,
  `VoitureID` int(10) NOT NULL,
  `NomC` varchar(255) DEFAULT NULL,
  `PrenomC` varchar(255) DEFAULT NULL,
  `Cin` varchar(255) DEFAULT NULL,
  `NContrat` varchar(255) DEFAULT NULL,
  `EtatOcation` varchar(255) DEFAULT NULL,
  `LicenceConduit` varchar(255) DEFAULT NULL,
  `DateDebut` date DEFAULT NULL,
  `DateFin` date DEFAULT NULL,
  `Prix` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `contrat`
--

INSERT INTO `contrat` (`ID`, `VoitureID`, `NomC`, `PrenomC`, `Cin`, `NContrat`, `EtatOcation`, `LicenceConduit`, `DateDebut`, `DateFin`, `Prix`) VALUES
(8, 3, 'Durand', 'Pierre', 'EF123789', 'D123456', 'En cours', 'B34567890', '2025-04-10', '2025-05-10', '1800'),
(15, 2, 'ABDO', 'TST_UPDATED', 'SJNJ55', 'C1744194477862', 'Terminée', 'SHDH5', '2025-04-04', '2025-04-11', '2000'),
(16, 3, 'Durand', 'arnod', 'EF123789', 'C1744206311955', 'Au Cours', 'B34567890', '2025-04-02', '2025-05-10', '814000.0'),
(20, 2, 'Test', 'User', 'TEST123', 'C999999', 'En cours', 'LIC123', '2025-04-09', '2025-04-09', '1000'),
(21, 2, 'Test', 'User', 'TEST123', 'C999999', 'En cours', 'LIC123', '2025-04-09', '2025-04-09', '1000'),
(22, 2, 'Test', 'User', 'TEST123', 'C999999', 'En cours', 'LIC123', '2025-04-09', '2025-04-09', '1000'),
(23, 2, 'Test', 'User', 'TEST123', 'C999999', 'En cours', 'LIC123', '2025-04-09', '2025-04-09', '1000'),
(30, -1, 'Test', 'User', 'TEST123', 'INVALID', 'En cours', 'LIC123', '2025-04-09', '2025-04-09', '1000');

-- --------------------------------------------------------

--
-- Structure de la table `voiture`
--

CREATE TABLE `voiture` (
  `ID` int(10) NOT NULL,
  `Marque` varchar(255) DEFAULT NULL,
  `Modèle` varchar(255) DEFAULT NULL,
  `Année` varchar(255) DEFAULT NULL,
  `Immatriculation` varchar(255) DEFAULT NULL,
  `TypeCarburant` varchar(255) DEFAULT NULL,
  `Kilométrage` varchar(255) DEFAULT NULL,
  `Couleur` varchar(255) DEFAULT NULL,
  `NombrePortes` varchar(255) DEFAULT NULL,
  `TypeTransmission` varchar(255) DEFAULT NULL,
  `NuméroChâssis` varchar(255) DEFAULT NULL,
  `Prix` varchar(255) DEFAULT NULL,
  `Etat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `voiture`
--

INSERT INTO `voiture` (`ID`, `Marque`, `Modèle`, `Année`, `Immatriculation`, `TypeCarburant`, `Kilométrage`, `Couleur`, `NombrePortes`, `TypeTransmission`, `NuméroChâssis`, `Prix`, `Etat`) VALUES
(2, 'Honda', 'Civic', '2018', 'XYZ456', 'Diesel', '45000', 'Noir', '4', 'Automatique', '23456789012345678', '18000', 'Indisponible'),
(3, 'Ford', 'Focus', '2021', 'LMN789', 'Essence', '15000', NULL, NULL, 'Manuelle', '34567890123456789', '22000', 'Indisponible'),
(4, 'Chevrolet', 'Cruze', '2019', 'DEF234', 'Diesel', '30000', NULL, NULL, 'Manuelle', '45678901234567890', '19000', 'Indisponible'),
(5, 'BMW', '3 Series', '2022', 'GHI567', 'Diesel', '10000', NULL, NULL, 'Manuelle', '56789012345678901', '35000', 'Indisponible'),
(7, 'Volkswagen', 'Golf', '2021', 'MNO123', 'Essence', '12000', NULL, NULL, 'Auto', '78901234567890123', '25000', 'disponible'),
(9, 'Mercedes-Benz', 'C-Class', '2022', 'STU789', 'Essence', '8000', 'Argent', '4', 'Automatique', '90123456789012345', '45000', 'disponible'),
(10, 'Renault', 'Clio', '2019', 'VWX012', 'Essence', '35000', NULL, NULL, 'Manuelle', '01234567890123456', '13000', 'Indisponible'),
(61, 'Audi H', 'S5', '2020', 'JKL89777', 'Essence', '20000', NULL, NULL, 'Auto', '67890123456789012', '30000', 'disponible'),
(98, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(101, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `contrat`
--
ALTER TABLE `contrat`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `voiture`
--
ALTER TABLE `voiture`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID` (`ID`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `contrat`
--
ALTER TABLE `contrat`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT pour la table `voiture`
--
ALTER TABLE `voiture`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=199;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
