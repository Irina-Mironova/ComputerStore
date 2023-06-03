create table manufacturers
(
  manufacturer_id bigserial not null primary key,
  title varchar(125) not null
);

create table products
(
  id bigserial not null primary key,
  series_number varchar(125),
  manufacturer_id bigint not null references manufacturers(manufacturer_id),
  price numeric(8,2) not null,
  quantity int not null
);

create table desktop_computers
(
  id bigint not null primary key references products(id),
  form_factor varchar(15)
);

create table laptops
(
  id bigint not null primary key references products(id),
  diagonal int
);

create table monitors
(
  id bigint not null primary key references products(id),
  diagonal float
);

create table hard_disks
(
  id bigint not null primary key references products(id),
  capacity varchar(15)
);

insert into manufacturers(title)
values ('Acer'),
       ('DEXP'),
       ('HP'),
       ('ASUS'),
       ('Lenovo'),
       ('Seagate'),
       ('Toshiba'),
       ('WD');

INSERT INTO products (series_number, manufacturer_id, price, quantity)
VALUES
  ('11212', 3, 74999, 5),
  ('34512', 1, 50000, 4),
  ('34777', 2, 45000, 2),
  ('55555', 4, 59999, 3),
  ('77777', 5, 79999, 1);

INSERT INTO desktop_computers
VALUES
  (1, 'DESKTOP'),
  (2, 'DESKTOP'),
  (3, 'MONOBLOCK'),
  (4, 'NETTOP'),
  (5, 'MONOBLOCK');

INSERT INTO products (series_number, manufacturer_id, price, quantity)
VALUES
  ('14556', 5, 60000, 15),
  ('78877', 1, 65000, 4),
  ('36366', 2, 69900, 10),
  ('74747', 4, 78000, 3),
  ('99897', 5, 100000, 1);

INSERT INTO laptops
VALUES
  (6, 13),
  (7, 14),
  (8, 15),
  (9, 17),
  (10, 17);

INSERT INTO products (series_number, manufacturer_id, price, quantity)
VALUES
  ('14555', 2, 12999, 4),
  ('17852', 1, 10900, 2),
  ('96874', 2, 10999, 7),
  ('34888', 4, 12800, 6),
  ('78945', 5, 11200, 9);

INSERT INTO monitors
VALUES
  (11, 23.8),
  (12, 23.5),
  (13, 23.8),
  (14, 27),
  (15, 23.6);

INSERT INTO products (series_number, manufacturer_id, price, quantity)
VALUES
  ('14258', 6, 3699, 14),
  ('78936', 6, 3590, 12),
  ('36363', 7, 4900, 7),
  ('78952', 7, 6990, 16),
  ('17452', 8, 7990, 9);

INSERT INTO hard_disks
VALUES
  (16, '500GB'),
  (17, '1TB'),
  (18, '3TB'),
  (19, '2TB'),
  (20, '4TB');


