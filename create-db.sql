DROP SCHEMA IF EXISTS storedb;
CREATE SCHEMA storedb;


use storedb;


SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS category;
CREATE TABLE category (
 id int(11) NOT NULL AUTO_INCREMENT,
 catname varchar(128) DEFAULT NULL,
 PRIMARY KEY (id),
 CONSTRAINT catname_unique UNIQUE (catname)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS subcategory;
CREATE TABLE subcategory (
 id int(11) NOT NULL AUTO_INCREMENT,
 subcatname varchar(128) DEFAULT NULL,
 cat_id int(11) DEFAULT NULL,
 PRIMARY KEY (id),
 KEY FK_CATEGORY_idx (cat_id),
 CONSTRAINT FK_CATEGORY FOREIGN KEY (cat_id) REFERENCES category (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT subcatname_unique UNIQUE (subcatname)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS product;
CREATE TABLE product (
 id int(11) NOT NULL AUTO_INCREMENT,
 prodname varchar(45) DEFAULT NULL,
 qty int(11) DEFAULT NULL,
 subcat_id int(11) DEFAULT NULL,
 PRIMARY KEY (id),
 KEY FK_SUBCATEGORY_idx (subcat_id),
 CONSTRAINT FK_SUBCATEGORY FOREIGN KEY (subcat_id) REFERENCES subcategory (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
 CONSTRAINT prodname_unique UNIQUE (prodname)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
 id int(11) NOT NULL AUTO_INCREMENT,
 username varchar(128) DEFAULT NULL,
 password varchar(45) DEFAULT NULL,
 email varchar(45) DEFAULT NULL,
 PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS cart;
CREATE TABLE cart (
 id int(11) NOT NULL AUTO_INCREMENT,
 custid int(11) NOT NULL ,
 prodid int(11) NOT NULL,
 PRIMARY KEY (id),
 KEY FK_CUST_idx (custid),
 CONSTRAINT FK_CUST FOREIGN KEY (custid) REFERENCES customer (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
 KEY FK_PROD_idx (prodid),
 CONSTRAINT FK_PROD FOREIGN KEY (prodid) REFERENCES product (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


SET FOREIGN_KEY_CHECKS = 1;
