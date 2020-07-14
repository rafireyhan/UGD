-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versi server:                 10.4.13-MariaDB - mariadb.org binary distribution
-- OS Server:                    Win64
-- HeidiSQL Versi:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Membuang struktur basisdata untuk ugd
CREATE DATABASE IF NOT EXISTS `ugd` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `ugd`;

-- membuang struktur untuk table ugd.dokter
CREATE TABLE IF NOT EXISTS `dokter` (
  `ID_Dokter` varchar(50) NOT NULL,
  `Nama` varchar(20) DEFAULT NULL,
  `Spesialis` varchar(10) DEFAULT NULL,
  `Jadwal` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_Dokter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel ugd.dokter: ~5 rows (lebih kurang)
/*!40000 ALTER TABLE `dokter` DISABLE KEYS */;
INSERT INTO `dokter` (`ID_Dokter`, `Nama`, `Spesialis`, `Jadwal`) VALUES
	('1', 'Setiawan', 'Mata', 'Senin'),
	('2', 'Budi', 'Ginjal', 'Selasa'),
	('3', 'Mimin', 'Paru-Paru', 'Rabu'),
	('4', 'Winda', 'Hati', 'Kamis'),
	('5', 'Petrik', 'Ginjal', 'Jumat');
/*!40000 ALTER TABLE `dokter` ENABLE KEYS */;

-- membuang struktur untuk table ugd.pasien
CREATE TABLE IF NOT EXISTS `pasien` (
  `ID_Pasien` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` varchar(20) DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `Umur` varchar(2) DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  `Wali` varchar(50) DEFAULT NULL,
  `Keterangan` varchar(50) DEFAULT NULL,
  `Tanggal_masuk` varchar(10) DEFAULT NULL,
  `Triage` varchar(10) DEFAULT NULL,
  `Status` varchar(50) DEFAULT NULL,
  `ID_Dokter` varchar(50) NOT NULL,
  `ID_Ruang` varchar(50) NOT NULL,
  PRIMARY KEY (`ID_Pasien`),
  KEY `ID_Dokter` (`ID_Dokter`),
  KEY `ID_Ruang` (`ID_Ruang`),
  CONSTRAINT `FK_pasien_dokter` FOREIGN KEY (`ID_Dokter`) REFERENCES `dokter` (`ID_Dokter`) ON UPDATE CASCADE,
  CONSTRAINT `FK_pasien_ruang` FOREIGN KEY (`ID_Ruang`) REFERENCES `ruang` (`ID_Ruang`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel ugd.pasien: ~16 rows (lebih kurang)
/*!40000 ALTER TABLE `pasien` DISABLE KEYS */;
INSERT INTO `pasien` (`ID_Pasien`, `Nama`, `Gender`, `Umur`, `Alamat`, `Wali`, `Keterangan`, `Tanggal_masuk`, `Triage`, `Status`, `ID_Dokter`, `ID_Ruang`) VALUES
	(1, 'Supriatna', 'Wanita', '89', 'Kosambi', 'Songo', 'hidup', '7/14/20', 'Triage 3', 'Sehat', '2', '3'),
	(3, 'Sumanto', 'Wanita', '20', 'Katamso', 'Supriatna', 'Sehat', '01/02/12', 'Triage 3', 'Pulang', '1', '1'),
	(4, 'Sinti', 'Wanita', '21', 'Ahmad Yani', 'Mira', 'Pingsan', '01/07/00', 'Triage 2', 'Sembuh', '2', '3'),
	(5, 'ASD', 'Pria', '22', 'asdasd', 'asdasd', 'asdasd', '01/02/22', 'Triage 2', 'asd', '2', '2'),
	(6, 'qweeqw', 'Pria', '11', 'qweqwe', 'qweeqw', 'eqwqew', '01/01/22', 'Triage 2', 'qewqew', '2', '2'),
	(7, '', 'Pria', '', '', '', '', '', 'Triage 1', '', '1', '1'),
	(8, '', 'Pria', '', '', '', '', '01/02/21', 'Triage 1', '', '1', '1'),
	(9, '', 'Pria', '', '', '', '', '', 'Triage 1', '', '1', '1'),
	(10, '', 'Pria', '', '', '', '', '', 'Triage 1', '', '1', '1'),
	(11, '', 'Pria', '', '', '', '', '', 'Triage 1', '', '1', '1'),
	(12, '', 'Pria', '', '', 's', '', '', 'Triage 1', '', '1', '1'),
	(13, '', 'Pria', '', '', 'a', 'a', '01/02/01', 'Triage 1', 'a', '1', '1'),
	(14, '', 'Pria', '', '', 's', 's', '01/02/02', 'Triage 1', 'd', '1', '1'),
	(15, '', 'Pria', '2', '', 'adwa', 'sdawa', '7/14/20', 'Triage 1', 'asdw', '1', '1'),
	(16, 'Asep', 'Wanita', '21', 'Ahmad Yani', 'Mira', 'Pingsan', '01/07/00', 'Triage 2', 'Sembuh', '2', '3'),
	(17, 's', 'Pria', '', '', 'ss', 'sss', '7/14/20', 'Triage 1', 'sss', '3', '4'),
	(18, 'Didin', 'Pria', '22', 'Katamso', 'Asep', 'Kecelakaan', '07/10/19', 'Triage 3', 'DIpulangkan', '2', '2');
/*!40000 ALTER TABLE `pasien` ENABLE KEYS */;

-- membuang struktur untuk table ugd.ruang
CREATE TABLE IF NOT EXISTS `ruang` (
  `ID_Ruang` varchar(50) NOT NULL,
  `Nama` varchar(15) DEFAULT NULL,
  `Status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_Ruang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Membuang data untuk tabel ugd.ruang: ~4 rows (lebih kurang)
/*!40000 ALTER TABLE `ruang` DISABLE KEYS */;
INSERT INTO `ruang` (`ID_Ruang`, `Nama`, `Status`) VALUES
	('1', 'Melati', 'Tersedia'),
	('2', 'Mawar', 'Tersedia'),
	('3', 'Tulip', 'Tersedia'),
	('4', 'Anggrek', 'Tersedia');
/*!40000 ALTER TABLE `ruang` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
