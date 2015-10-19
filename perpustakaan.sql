-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 03 Jan 2014 pada 14.56
-- Versi Server: 5.5.32
-- Versi PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `perpustakaan`
--
CREATE DATABASE IF NOT EXISTS `perpustakaan` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `perpustakaan`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `Nama` varchar(50) NOT NULL,
  `user_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`Nama`, `user_id`, `password`) VALUES
('dea', 'bedil', '12345'),
('msgsk', 'ngfks', '367272'),
('Deny', 'Den A', '12345');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
  `IDBuku` varchar(5) NOT NULL,
  `Judul` varchar(50) DEFAULT NULL,
  `Author` varchar(50) DEFAULT NULL,
  `Penerbit` varchar(50) DEFAULT NULL,
  `Rak` varchar(7) DEFAULT NULL,
  `Stock` int(5) NOT NULL,
  PRIMARY KEY (`IDBuku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`IDBuku`, `Judul`, `Author`, `Penerbit`, `Rak`, `Stock`) VALUES
('M0002', 'Membuat Program Berbasis Java', 'Ahmad Mulyadi', 'IPB Press', 'M021', 3),
('N0001', 'Menempuh Batas', 'HerdiandKun', 'Kompas Gramedia', 'M022', 4),
('N0002', 'Jalan Kumbang', 'Rahardian', 'Bukune', 'J002', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `Nim` varchar(9) NOT NULL,
  `IDBuku` varchar(5) NOT NULL,
  `tglPinjam` text NOT NULL,
  `tglJatuhTempo` text NOT NULL,
  `tglKembali` text NOT NULL,
  `denda` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `peminjaman`
--

INSERT INTO `peminjaman` (`Nim`, `IDBuku`, `tglPinjam`, `tglJatuhTempo`, `tglKembali`, `denda`) VALUES
('J3A112156', 'N0001', '15-12-2013', '20-12-2013', '3-1-2014', '7000'),
('J3C112167', 'N0001', '14-12-2013', '19-12-2013', '3-1-2014', '7500'),
('J3C112167', 'N0001', '21-11-2013', '26-11-2013', '3-12-2013', '3500'),
('J3C112167', 'M0002', '3-1-2014', '08-01-2014', '10-1-2014', '1000'),
('J3A112132', 'M0002', '3-1-2014', '08-01-2014', 'null', '0');

-- --------------------------------------------------------

--
-- Struktur dari tabel `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `ID` varchar(6) NOT NULL,
  `Nim` varchar(9) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `PK` varchar(100) NOT NULL,
  `Alamat` varchar(200) NOT NULL,
  `Masa_Aktif` varchar(50) NOT NULL,
  `noHP` varchar(12) NOT NULL,
  PRIMARY KEY (`Nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `student`
--

INSERT INTO `student` (`ID`, `Nim`, `Nama`, `PK`, `Alamat`, `Masa_Aktif`, `noHP`) VALUES
('112132', 'J3A112132', 'Muthia Hanifa', 'Komunikasi', 'Jl Babakan Raya 23', '21-12-2014', '081132823211'),
('112156', 'J3A112156', 'Meta Indira', 'Komunikasi', 'Lodaya 1', '06-04-2014', '081231128238'),
('112167', 'J3C112167', 'Herdiyan Septa N', 'Manajemen Informatika', 'Jl Malabar Ujung', '14-08-2014', '081515657140'),
('112131', 'J3D112156', 'Deni Maulana', 'Teknik Komputer', 'Logasa gang semut', '11-06-2014', '081282829737');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
