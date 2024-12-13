/*
 	drop table carrito_productos;
	drop table compras_productos;
	drop table compras;
	drop table medios_pago;
	drop table productos;
	drop table categorias;
	drop table usuarios;	
 */

create table usuarios(
	id_usuario SERIAL primary key,
	nombres varchar(80),
	apellidos varchar(80),
	identificacion varchar(10),
	username varchar(90),
	password varchar(100),
	telefono varchar(10),
	fecha_creacion timestamp
);

alter table usuarios alter column fecha_creacion set default now();

insert into usuarios(nombres, apellidos, identificacion, telefono, username, password) 
	select 'Nicolas', 'Jaiquel Rubio', '1019990889', '3016027717', 'nico.java', 'sapoo';
insert into usuarios(nombres, apellidos, identificacion, telefono, username, password) 
	select 'Alex', 'Pinzon', '1122334455', '2233445511', 'alex', 'sapo';
insert into usuarios(nombres, apellidos, identificacion, telefono, username, password) 
	select 'Jose Manuel', 'Degado Patiño', '5544332211', '0987654321', 'joselon', 'sapooo';

select * from usuarios;

create table categorias(
	id_categoria SERIAL primary key,
	nombre varchar(60),
	fecha_creacion timestamp
);

alter table categorias alter column fecha_creacion set default now();

insert into categorias(nombre) select 'Electronicos';
insert into categorias(nombre) select 'Ropa';
insert into categorias(nombre) select 'Videojuegos';

select * from categorias;

create table productos(
	id_producto SERIAL primary key,
	id_categoria int,
	nombre varchar(80),
	stock int,
	precio decimal(16, 2),
	codigo_barras varchar(200),
	fecha_creacion timestamp
);

alter table productos alter column fecha_creacion set default now();
alter table productos add constraint fk_productos_categorias foreign key(id_categoria)
	references categorias(id_categoria);

insert into productos(nombre, id_categoria, stock, codigo_barras, precio)
	select 'Televisor LG 4K', 1, 40, '10i2nwqihd981212d89h1', 399.99;
insert into productos(nombre, id_categoria, stock, codigo_barras, precio)
	select 'Oversized T-shirt', 2, 50, '1923u12h182183239h', 12.99;
insert into productos(nombre, id_categoria, stock, codigo_barras, precio)
	select 'Playstation 5', 3, 80, 'ijdsaoij12aoi123121', 499.99;

select * from productos;

create table medios_pago(
	id_medio_pago SERIAL primary key,
	nombre varchar(50),
	abreviatura varchar(3),
	fecha_creacion timestamp
);

alter table medios_pago alter column fecha_creacion set default now();

insert into medios_pago(nombre, abreviatura) select 'tarjeta debito', 'tb';
insert into medios_pago(nombre, abreviatura) select 'efectivo', 'efc';
insert into medios_pago(nombre, abreviatura) select 'tarjeta credito', 'tc';

create table compras(
	id_compra SERIAL primary key,
	id_usuario int,
	id_medio_pago int,
	fecha_creacion timestamp
);

alter table compras alter column fecha_creacion set default now();
alter table compras add constraint fk_compras_usuario foreign key(id_usuario)
	references usuarios(id_usuario);
alter table compras add constraint fk_compras_medios_pago foreign key(id_medio_pago)
	references medios_pago(id_medio_pago);

insert into compras(id_usuario, id_medio_pago) select 1, 2;
insert into compras(id_usuario, id_medio_pago) select 2, 3;

select u.nombres, u.apellidos, mp.nombre as medio_pago, mp.abreviatura from compras as p
inner join usuarios as u on p.id_usuario = u.id_usuario
inner join medios_pago as mp on p.id_medio_pago = mp.id_medio_pago;

create table compras_producto(
	id_producto int,
	id_compra int,
	cantidad int,
	total decimal(20, 2),
	fecha_creacion timestamp,
	primary key(id_producto, id_compra)
);

alter table compras_producto alter column fecha_creacion set default now();
alter table compras_producto add constraint fk_compras_producto_productos foreign key(id_producto)
	references productos(id_producto);
alter table compras_producto add constraint fk_compras_producto_compras foreign key(id_compra)
	references compras(id_compra);

insert into compras_producto(id_producto, id_compra, cantidad, total)
	select 3, 1, 1, 499.99;
insert into compras_producto(id_producto, id_compra, cantidad, total)
	select 1, 2, 1, 399.99;
	
select cp.cantidad, cp.total, cp.fecha_creacion, p.nombre, ct.nombre as categoria, u.nombres, u.apellidos from compras_producto cp
inner join productos p on cp.id_producto = p.id_producto
inner join categorias ct on p.id_categoria = ct.id_categoria
inner join compras c on cp.id_compra = c.id_compra
inner join usuarios u on c.id_usuario = u.id_usuario;
	

create table carrito_productos(
	id_usuario int,
	id_producto int,
	cantidad int,
	total decimal(20, 2),
	fecha_creacion timestamp,
	primary key (id_usuario, id_producto)
);

alter table carrito_productos alter column fecha_creacion set default now();
alter table carrito_productos add constraint fk_carrito_productos_usuarios foreign key(id_usuario)
	references usuarios(id_usuario);
alter table carrito_productos add constraint fk_carrito_productos_productos foreign key(id_producto)
	references productos(id_producto);

insert into carrito_productos(id_usuario, id_producto, cantidad, total)
	select 1, 1, 1, 399.99;

insert into carrito_productos(id_usuario, id_producto, cantidad, total)
	select 1, 2, 1, 12.99;

select u.nombres, u.apellidos, p.nombre, c.nombre as nombre_categoria, p.precio, cart.cantidad, cart.total 
from carrito_productos as cart
inner join usuarios u on cart.id_usuario = u.id_usuario 
inner join productos p on cart.id_producto = p.id_producto
inner join categorias c on p.id_categoria = c.id_categoria;


