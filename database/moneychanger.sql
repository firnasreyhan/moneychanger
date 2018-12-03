-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Des 2018 pada 10.23
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
('IDR', 0, 0, 0),
('USD', 14258, 14250, 14242);

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
('IDR', 1, 1, 1),
('USD', 1, 1, 1);

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
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`ID_TRANSAKSI`, `NIK`, `NAMA`, `MATAUANG_AWAL`, `NOMINAL_AWAL`, `MATAUANG_TUKAR`, `NOMINAL_TUKAR`, `TGL_TRANSAKSI`) VALUES
(1, '3507130308980001', 'Reyhan', 'IDR', 100000, 'USD', 6.99, '2018-12-03 02:58:00');

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
  MODIFY `ID_TRANSAKSI` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
