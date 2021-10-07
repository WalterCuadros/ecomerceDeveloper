CREATE DATABASE IF NOT EXISTS gangazo;
USE gangazo;

CREATE TABLE cliente(
id 		int(255) auto_increment not null,
nombre	varchar(20),
cedula	varchar(255),
tarjeta varchar(255),
email	varchar(255),
CONSTRAINT pk_cliente PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE tipo_producto(
id 		int(255) auto_increment not null,
nombre	varchar(20),
CONSTRAINT pk_tipo_producto PRIMARY KEY(id)
)ENGINE=InnoDb;

CREATE TABLE producto(
id 		int(255) auto_increment not null,
codigo_barras	varchar(20),
nombre	varchar(255),
tipo_producto_id int(255) not null,
marca varchar(255),
fecha_vencimiento datetime,
precio	decimal(55),
descuento decimal(55),
CONSTRAINT pk_cliente PRIMARY KEY(id),
CONSTRAINT fk_producto_tipo_producto FOREIGN KEY(tipo_producto_id) REFERENCES tipo_producto(id)
)ENGINE=InnoDb;





CREATE TABLE carrito(
id  	int(255) auto_increment not null,
cliente_id int(255) not null,
is_active boolean not null,
CONSTRAINT pk_carrito PRIMARY KEY(id),
CONSTRAINT fk_carrito_cliente FOREIGN KEY(cliente_id) REFERENCES cliente(id)
)ENGINE=InnoDb;



CREATE TABLE productoCarrito(
id 		int(255) auto_increment not null,
cantidad_producto	int(255),
producto_id	int(255) not null,
in_carrito boolean not null,
carrito_id int(255) not null,
CONSTRAINT pk_producto_carrito PRIMARY KEY(id),
CONSTRAINT fk_productoCarrito_producto FOREIGN KEY(producto_id) REFERENCES producto(id),
CONSTRAINT fk_productoCarrito_carrito FOREIGN KEY(carrito_id) REFERENCES carrito(id)
)ENGINE=InnoDb;




CREATE TABLE compra(
id 		int(255) auto_increment not null,
valor_obsequio	decimal(55),
valor_total	decimal(55),
fecha_compra TIMESTAMP DEFAULT CURRENT_TIMESTAMP  
ON UPDATE CURRENT_TIMESTAMP,
carrito_id int(255) not null,
CONSTRAINT pk_compra PRIMARY KEY(id),
CONSTRAINT fk_compra_carrito FOREIGN KEY(carrito_id) REFERENCES carrito(id)
)ENGINE=InnoDb;


INSERT INTO tipo_producto (nombre) VALUES 
('Comestibles'),('Liquidos'),('Aseo');

INSERT INTO producto (codigo_barras, nombre, tipo_producto_id, marca, fecha_vencimiento, precio, descuento) VALUES
('AAA1111', 'PAPAS FRITAS', 1, 'FRITO LAY', '2021-10-27 00:00:00', 30000.00, 500.00),
('AAA1112', 'PONQUE EMPACADO', 1, 'RAMO', '2021-9-12 00:00:00', 32000.00, 600.00),
('AAA1113', 'GALLETAS', 1, 'NOEL', '2021-10-04 00:00:00', 50000.00, 800.00),
('AAA1114', 'CEREAL', 1, 'NESTLE', '2021-10-04 00:00:00', 43000.00, 0.00),
('BBB1111', 'LECHE', 2, 'COLANTA', '2021-08-27 00:00:00', 20000.00, 500.00),
('BBB1112', 'YOGURT', 2, 'ALPINA', '2021-10-12 00:00:00', 42000.00, 600.00),
('BBB1113', 'JUGO NATURAL', 2, 'DEL VALLE', '2021-09-04 00:00:00', 45000.00, 800.00),
('BBB1114', 'GASEOSA', 2, 'PEPSI', '2021-09-04 00:00:00', 27000.00, 0.00),
('CCC1111', 'DETERGENTE', 3, '3D', '2022-08-27 00:00:00', 120000.00, 500.00),
('CCC1112', 'SUAVIZANTE', 3, 'SAMPIC', '2022-10-12 00:00:00', 144000.00, 600.00),
('CCC1113', 'JABON', 3, 'SUPER', '2022-09-04 00:00:00', 75000.00, 800.00),
('CCC1114', 'LAVALOZA', 3, 'SUPER', '2022-09-04 00:00:00', 35000.00, 0.00);
