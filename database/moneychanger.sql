-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Des 2018 pada 10.43
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moneychanger`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kurs`
--

CREATE TABLE `kurs` (
  `ID_KURS` varchar(3) NOT NULL,
  `KURS_JUAL` float DEFAULT '0',
  `KURS_TENGAH` float DEFAULT '0',
  `KURS_BELI` float DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kurs`
--

INSERT INTO `kurs` (`ID_KURS`, `KURS_JUAL`, `KURS_TENGAH`, `KURS_BELI`) VALUES
('AUD', 10484, 10444, 10404),
('CAD', 10972, 10932, 10892),
('EUR', 16499, 16449, 16399),
('GBP', 18476, 18426, 18376),
('IDR', 0, 0, 0),
('JPY', 129.88, 128.18, 126.48),
('SGD', 10584, 10560, 10536),
('USD', 14473, 14465, 14457);

-- --------------------------------------------------------

--
-- Struktur dari tabel `stok`
--

CREATE TABLE `stok` (
  `ID_KURS` varchar(3) NOT NULL,
  `SATUAN` int(11) DEFAULT '0',
  `PULUHAN` int(11) DEFAULT '0',
  `RATUSAN` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `stok`
--

INSERT INTO `stok` (`ID_KURS`, `SATUAN`, `PULUHAN`, `RATUSAN`) VALUES
('AUD', 100, 100, 100),
('CAD', 100, 100, 100),
('EUR', 100, 100, 100),
('GBP', 100, 100, 100),
('IDR', 100, 100, 100),
('JPY', 100, 100, 100),
('SGD', 100, 100, 100),
('USD', 100, 100, 100);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `ID_TRANSAKSI` int(11) NOT NULL,
  `NIK` varchar(16) DEFAULT NULL,
  `NAMA` varchar(100) DEFAULT NULL,
  `MATAUANG_AWAL` varchar(3) DEFAULT NULL,
  `NOMINAL_AWAL` float DEFAULT NULL,
  `MATAUANG_TUKAR` varchar(3) DEFAULT NULL,
  `NOMINAL_TUKAR` float DEFAULT NULL,
  `TGL_TRANSAKSI` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kurs`
--
ALTER TABLE `kurs`
  ADD PRIMARY KEY (`ID_KURS`);

--
-- Indeks untuk tabel `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`ID_KURS`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`ID_TRANSAKSI`),
  ADD KEY `FK_RELATIONSHIP_2` (`MATAUANG_AWAL`),
  ADD KEY `FK_RELATIONSHIP_3` (`MATAUANG_TUKAR`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `ID_TRANSAKSI` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `stok`
--
ALTER TABLE `stok`
  ADD CONSTRAINT `FK_RELATIONSHIP_4` FOREIGN KEY (`ID_KURS`) REFERENCES `kurs` (`ID_KURS`);

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FK_RELATIONSHIP_2` FOREIGN KEY (`MATAUANG_AWAL`) REFERENCES `kurs` (`ID_KURS`),
  ADD CONSTRAINT `FK_RELATIONSHIP_3` FOREIGN KEY (`MATAUANG_TUKAR`) REFERENCES `kurs` (`ID_KURS`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
