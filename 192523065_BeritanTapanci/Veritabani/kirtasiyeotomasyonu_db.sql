-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 03 Haz 2022, 10:22:20
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kirtasiyeotomasyonu_db`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `Login`
--

CREATE TABLE `Login` (
  `id` int(11) NOT NULL,
  `kullanici_adi` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `sifre` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `Login`
--

INSERT INTO `Login` (`id`, `kullanici_adi`, `sifre`) VALUES
(1, 'beritan', '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urunler`
--

CREATE TABLE `urunler` (
  `barkod_no` int(11) NOT NULL,
  `kategori` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `urun_adi` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NOT NULL,
  `alis_fiyati` double NOT NULL,
  `satis_fiyati` double NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `urunler`
--

INSERT INTO `urunler` (`barkod_no`, `kategori`, `urun_adi`, `alis_fiyati`, `satis_fiyati`, `stok`) VALUES
(1, 'defter', 'çizgili defter', 13, 30, 100),
(2, 'boya', 'sulu boya', 17, 50, 100),
(4, 'kitap', 'hikaye', 34, 125, 99),
(5, 'kalem', 'kursun kalem', 12.6, 40, 99);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `Login`
--
ALTER TABLE `Login`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `urunler`
--
ALTER TABLE `urunler`
  ADD PRIMARY KEY (`barkod_no`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `Login`
--
ALTER TABLE `Login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Tablo için AUTO_INCREMENT değeri `urunler`
--
ALTER TABLE `urunler`
  MODIFY `barkod_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1213130;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
