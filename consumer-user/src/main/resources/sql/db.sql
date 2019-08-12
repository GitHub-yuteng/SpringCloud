CREATE TABLE `city`
(
  `id`   int(11) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE =utf8_bin

CREATE TABLE `ticket`
(
  `id`    int(11) NOT NULL AUTO_INCREMENT,
  `name`  varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `stock` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE =utf8_bin

CREATE TABLE `tid_cid`
(
  `tid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE =utf8_bin

CREATE TABLE `user`
(
  `id`        int(11) NOT NULL AUTO_INCREMENT,
  `name`      varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password`  varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone`     int(20) DEFAULT NULL,
  `logintime` datetime                      DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE =utf8_bin
