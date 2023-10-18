CREATE SEQUENCE seq_comida;
CREATE SEQUENCE seq_menu;
CREATE SEQUENCE seq_detalle;

CREATE TABLE comida(
	id integer default nextval('seq_comida':: regclass) PRIMARY KEY not null,
	nombre varchar(200),
    descripcion varchar(200),
	precio varchar(200),
	imagen varchar(200),
	categoria varchar(200),
	estado char (1) NOT NULL DEFAULT ('A'),
);




CREATE TABLE menu(
	idmenu integer default nextval('seq_menu':: regclass) PRIMARY KEY not null,
	nombre varchar(200),
    categoria varchar(200),
	tipo varchar(200),
	estado char (1) NOT NULL DEFAULT ('A'),
);


CREATE TABLE comida_menu(
     id_foodandmenu integer default nextval('seq_detalle' :: regclass) PRIMARY KEY not null,
     categoria varchar(200),
     estado char (1) NOT NULL DEFAULT ('A'),
     id integer REFERENCES comida(id),
     idmenu integer REFERENCES menu(idmenu)
);

INSERT INTO comida_menu (categoria, estado, idmenu, id)
VALUES
    ('Hamburguesas', 'A', 1, 2)
	
INSERT INTO comida (nombre, descripcion, precio, imagen, categoria, estado)
VALUES ('Hamburguesa clásica', 'Una jugosa hamburguesa con queso y lechuga', 9.99, 'https://ejemplo.com/hamburguesa.jpg', 'Comida rápida', 'A');

INSERT INTO comida (nombre, descripcion, precio, imagen, categoria, estado)
VALUES ('Pizza de pepperoni', 'Pizza de pepperoni con una masa crujiente y salsa de tomate', 12.50, 'https://ejemplo.com/pizza.jpg', 'Pizza', 'A');

INSERT INTO comida (nombre, descripcion, precio, imagen, categoria, estado)
VALUES ('Ensalada César', 'Ensalada fresca con pollo a la parrilla y aderezo César', 8.99, 'https://ejemplo.com/ensalada.jpg', 'Ensalada', 'I');

select * from comida;
select * from menu;
select * from comida_menu;