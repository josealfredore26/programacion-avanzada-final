insert into administrador values ("1234567890", "administrador1@email.com", "Emiliano Zuleta", "emiliano123", 1);

insert into administrador_hotel values ("2345678901", "administradorHotel1@email.com", "Nicolas Mendoza", "colacho123", 95);
insert into administrador_hotel values ("3729278392", "administradorHotel2@email.com", "Julio Mendoza", "julio123", 96);
insert into administrador_hotel values ("4623829300", "administradorHotel3@email.com", "Hector Zuleta", "hector123", 97);
insert into administrador_hotel values ("3820275222", "administradorHotel4@email.com", "Ivan Zuleta", "ivan123", 98);

insert into ciudad (codigo, nombre) values (1, "Bogota");
insert into ciudad (codigo, nombre) values (2, "Medellin");
insert into ciudad (codigo, nombre) values (3, "Cartagena");
insert into ciudad (codigo, nombre) values (4, "Manizales");

insert into hotel (codigo, direccion, nombre, numero_de_estrellas, destino_codigo) values (1, "Bogota Avenida Goku  ", "Hotel Ciudad Fria", 5, 1);
insert into hotel (codigo, direccion, nombre, numero_de_estrellas, destino_codigo) values (2, "Medellin Avenida Hogwarts", "Hotel Ciudad De Las Luces", 5, 2);
insert into hotel (codigo, direccion, nombre, numero_de_estrellas, destino_codigo) values (3, "Cartagena Avenida Vegeta", "Hotel Ciudad Amurallada", 5, 1);
insert into hotel (codigo, direccion, nombre, numero_de_estrellas, destino_codigo) values (4, "Manizales Avenida Albus", "Hotel Ciudad Manizales", 5, 1);

insert into habitacion (codigo, numero, precio, hotel_codigo) values (1, 1, 2000000, 1);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (2, 2, 2000000, 1);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (3, 3, 2000000, 1);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (4, 4, 2000000, 1);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (5, 1, 2500000, 2);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (6, 2, 2500000, 2);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (7, 3, 2500000, 2);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (8, 4, 2500000, 2);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (9, 1, 1000000, 3);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (10, 2, 1000000, 3);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (11, 3, 1000000, 3);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (12, 4, 1000000, 3);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (13, 1, 3000000, 4);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (14, 2, 3000000, 4);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (15, 3, 3000000, 4);
insert into habitacion (codigo, numero, precio, hotel_codigo) values (16, 4, 3000000, 4);

insert  into cama (codigo, numero, tipo, habitacion_codigo) values (1, 1, 0, 1);
insert  into cama (codigo, numero, tipo, habitacion_codigo) values (2, 1, 1, 2);
insert  into cama (codigo, numero, tipo, habitacion_codigo) values (3, 1, 0, 5);
insert  into cama (codigo, numero, tipo, habitacion_codigo) values (4, 1, 1, 9);
insert  into cama (codigo, numero, tipo, habitacion_codigo) values (5, 1, 2, 13);

insert into caracteristica (codigo, contenido) values (1, "Piscina");
insert into caracteristica (codigo, contenido) values (2, "Buffet");
insert into caracteristica (codigo, contenido) values (3, "Aire acondicionado");
insert into caracteristica (codigo, contenido) values (4, "Balcon");
insert into caracteristica (codigo, contenido) values (5, "Television");

insert into cliente values ("1000000001", "josecliente@email.com", "Jose Ramirez", "josepassword", 1);
insert into cliente values ("1000000002", "camilocliente@email.com", "Camilo Quintero", "camilopassword", 2);
insert into cliente values ("1000000003", "juancliente@email.com", "Juan Fonseca", "juanpassword", 3);

insert into vuelo (codigo, cantidad_de_sillas, destino_codigo, origen_codigo, fecha) values (1, 10, 1, 3, "2022-12-05");
insert into vuelo (codigo, cantidad_de_sillas, destino_codigo, origen_codigo, fecha) values (2, 10, 2, 4, "2022-12-06");
insert into vuelo (codigo, cantidad_de_sillas, destino_codigo, origen_codigo, fecha) values (3, 10, 1, 2, "2022-12-07");
insert into vuelo (codigo, cantidad_de_sillas, destino_codigo, origen_codigo, fecha) values (4, 10, 2, 3, "2022-12-08");
insert into vuelo (codigo, cantidad_de_sillas, destino_codigo, origen_codigo, fecha) values (5, 10, 1, 4, "2022-12-09");

insert into reserva (codigo, costo_total, cantidad_de_clientes, fecha_inicio, fecha_final, cliente_cedula, vuelo_codigo) values (1, 500000, 1, "2022-04-26", "2022-04-30", "1000000001", 1);

insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (1, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (2, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (3, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (4, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (5, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (6, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (7, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (8, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (9, 1, 1, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (10, 1, 10, 300000, 1);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (11, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (12, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (13, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (14, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (15, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (16, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (17, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (18, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (19, 1, 1, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (20, 1, 10, 300000, 2);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (21, 1, 1, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (22, 1, 2, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (23, 1, 3, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (24, 1, 4, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (25, 1, 5, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (26, 1, 6, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (27, 1, 7, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (28, 1, 8, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (29, 1, 9, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (30, 1, 10, 300000, 3);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (31, 1, 1, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (32, 1, 2, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (33, 1, 3, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (34, 1, 4, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (35, 1, 5, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (36, 1, 6, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (37, 1, 7, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (38, 1, 8, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (39, 1, 9, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (40, 1, 10, 300000, 4);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (41, 1, 1, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (42, 1, 2, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (43, 1, 3, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (44, 1, 4, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (45, 1, 5, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (46, 1, 6, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (47, 1, 7, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (48, 1, 8, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (49, 1, 9, 300000, 5);
insert into silla (codigo, disponibilidad, numero, valor, vuelo_codigo) values (50, 1, 10, 300000, 5);

insert into comentario (codigo, calificacion, comentario, hotel_codigo) values (1, 5, "Que chimba so", 1);
insert into comentario (codigo, calificacion, comentario, hotel_codigo) values (2, 10, "Una maravilla", 2);
insert into comentario (codigo, calificacion, comentario, hotel_codigo) values (3, 6, "Increible", 3);
insert into comentario (codigo, calificacion, comentario, hotel_codigo) values (4, 3, "Unico!!", 4);


insert into caracteristica_habitaciones values (3, 1);
insert into caracteristica_habitaciones values (4, 1);
insert into caracteristica_habitaciones values (5, 1);

insert into caracteristica_hoteles values (1, 1);
insert into caracteristica_hoteles values (2, 1);

insert into cliente_telefono values ("1000000001", "31752582");
insert into cliente_telefono values ("1000000001", "30056348");

insert into reserva_habitaciones values (1, 1);
insert into reserva_habitaciones values (1, 2);
insert into reserva_habitaciones values (1, 3);

insert into reserva_sillas values (1, 1);