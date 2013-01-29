CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `news_raw_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `created` timestamp NULL DEFAULT NULL,
  `raw_id` varchar(255) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `news_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` int(11) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `news_raw_item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `news_raw_item_id` (`news_raw_item_id`),
  CONSTRAINT `news_item_ibfk_1` FOREIGN KEY (`news_raw_item_id`) REFERENCES `news_raw_item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

