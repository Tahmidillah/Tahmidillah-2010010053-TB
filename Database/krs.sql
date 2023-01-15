-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 15, 2023 at 04:06 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `krs`
--

-- --------------------------------------------------------

--
-- Table structure for table `krs`
--

CREATE TABLE `krs` (
  `nim` varchar(4) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `id_makul` varchar(4) NOT NULL,
  `makul` varchar(32) NOT NULL,
  `sks` varchar(1) NOT NULL,
  `semester` varchar(2) NOT NULL,
  `dosen` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `krs`
--

INSERT INTO `krs` (`nim`, `nama`, `id_makul`, `makul`, `sks`, `semester`, `dosen`) VALUES
('0001', 'Fikrish Shobah', 'PW01', 'Pemograman WEB', '3', '1', 'Agus'),
('0001', 'Fikrish Shobah', 'MTK1', 'Matematika 1', '3', '1', 'Budi'),
('0005', 'Tahmidillah', 'PBO2', 'Pemrograman Berbasis Objek', '2', '5', 'Bapak Edya'),
('0005', 'Tahmidillah', 'PW01', 'Pemograman WEB', '3', '1', 'Agus');

-- --------------------------------------------------------

--
-- Table structure for table `makul`
--

CREATE TABLE `makul` (
  `id_makul` varchar(4) NOT NULL,
  `makul` varchar(32) NOT NULL,
  `sks` varchar(1) NOT NULL,
  `semester` varchar(2) NOT NULL,
  `dosen` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `makul`
--

INSERT INTO `makul` (`id_makul`, `makul`, `sks`, `semester`, `dosen`) VALUES
('AG00', 'Agama', '2', '1', 'Anis'),
('BIND', 'Bahasa Indonesia', '2', '1', 'Anina'),
('PBO2', 'Pemrograman Berbasis Objek', '2', '5', 'Bapak Edya'),
('PW01', 'Pemograman WEB', '3', '1', 'Agus');

-- --------------------------------------------------------

--
-- Table structure for table `mhs`
--

CREATE TABLE `mhs` (
  `nim` varchar(4) NOT NULL,
  `nama` varchar(128) NOT NULL,
  `alamat` varchar(128) NOT NULL,
  `jenis_k` varchar(12) NOT NULL,
  `jurusan` varchar(31) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mhs`
--

INSERT INTO `mhs` (`nim`, `nama`, `alamat`, `jenis_k`, `jurusan`) VALUES
('0001', 'Fikrish Shobah', 'Troso Pec Jepara', 'Laki-laki', 'Teknik Informatika'),
('0003', 'Tahmidillah', 'Anjir Muara', 'Perempuan', '- -'),
('0004', 'Andika', 'Banjarmasin', 'Laki-laki', 'Budidaya Perairan'),
('0005', 'Tahmidillah', 'Anjir Muara', 'Laki-laki', 'Teknik Informatika');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `makul`
--
ALTER TABLE `makul`
  ADD PRIMARY KEY (`id_makul`);

--
-- Indexes for table `mhs`
--
ALTER TABLE `mhs`
  ADD PRIMARY KEY (`nim`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
