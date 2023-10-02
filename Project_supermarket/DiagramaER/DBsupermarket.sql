CREATE DATABASE supermarket;

CREATE SCHEMA control_inventario;
CREATE SCHEMA control_clientes;
CREATE SCHEMA control_super;
CREATE SCHEMA control_ventas;


CREATE TABLE control_super.sucursal(
    id_sucursal SERIAL NOT NULL ,
    nombre VARCHAR (50) NOT NULL UNIQUE , 
    direccion VARCHAR (128),
    PRIMARY KEY(id_sucursal) 
);

CREATE TABLE control_super.empleado(
    id_empleado SERIAL NOT NULL ,
    usuario VARCHAR(10),
    contrasenia VARCHAR(24),
    nombre VARCHAR (50) NOT NULL UNIQUE, 
    sucursal INT NOT NULL,
    tipo VARCHAR NOT NULL,
    FOREIGN KEY(sucursal) REFERENCES control_super.sucursal(id_sucursal),
    PRIMARY KEY(id_empleado) 
);

CREATE TABLE control_ventas.caja (
    id_empleado SERIAL NOT NULL,
    numero_caja INT,
    FOREIGN KEY(id_empleado) REFERENCES control_super.empleado(id_empleado),
    PRIMARY KEY(id_empleado)
);

CREATE TABLE control_clientes.tarjeta (
	id_tarjeta SERIAL NOT NULL,
	tipo VARCHAR(12) NOT NULL,
	puntos_acumulados INTEGER NOT NULL,
	PRIMARY KEY(id_tarjeta)
	);

CREATE TABLE control_clientes.cliente (
	nit VARCHAR(12) NOT NULL,
	nombre VARCHAR(60) NOT NULL,
	telefono VARCHAR(12),
    dinero_gastado DECIMAL(8,2),
    dinero_membresia DECIMAL(8,2),
	PRIMARY KEY(nit)
	);

CREATE TABLE control_inventario.producto(
    id_producto VARCHAR(12) NOT NULL,
    nombre VARCHAR(45),
    descripcion TEXT NOT NULL,
    cantidad INTEGER,
    precio DECIMAL,
    id_sucursal INT,
    FOREIGN KEY(id_sucursal) REFERENCES control_super.sucursal(id_sucursal),
    PRIMARY KEY(id_producto,)
);

CREATE TABLE control_inventario.estanteria(
    id_producto VARCHAR(12) NOT NULL,
    id_sucursal INT,
    numero_pasillo INT NOT NULL,
    cantidad INTEGER,
    FOREIGN KEY(id_producto) REFERENCES control_inventario.producto(id_producto),
    FOREIGN KEY(id_sucursal) REFERENCES control_super.sucursal(id_sucursal),
    PRIMARY KEY(id_producto, id_sucursal)
);

CREATE TABLE control_ventas.venta(
    id_venta VARCHAR(12) NOT NULL,
    fecha DATE DEFAULT  CURRENT_DATE,
    nit VARCHAR(12) NOT NULL,
    id_empleado  INT NOT NULL,
    id_sucursal INT NOT NULL,
    total_con_descuento DECIMAL(9,2),
    total_sin_descuento DECIMAL(9,2),
    FOREIGN KEY(nit) REFERENCES control_clientes.cliente(nit),
    FOREIGN KEY(id_empleado) REFERENCES control_super.empleado(id_empleado),
    FOREIGN KEY(id_sucursal) REFERENCES control_super.sucursal(id_sucursal),
    PRIMARY KEY(id_venta)
);

CREATE TABLE control_ventas.lista_de_priductos(
    id_venta VARCHAR(12) NOT NULL,
    id_producto VARCHAR(12) NOT NULL,
    cantidad INT,
    FOREIGN KEY(id_venta) REFERENCES control_ventas.venta(id_venta),
    FOREIGN KEY(id_producto) REFERENCES control_inventario.producto(id_producto),
    PRIMARY KEY(id_venta, id_producto)
);



INSERT INTO control_super.sucursal (nombre, direccion)
VALUES ('Sucursal Central', '12 avenida, 4-12 zona 1, Quetzaltenango');

-- Insertar la Sucursal Norte
INSERT INTO control_super.sucursal (nombre, direccion)
VALUES ('Sucursal Norte', '4ta calle 24-32 zona 3, Quetzaltenango');

-- Insertar la Sucursal Sur
INSERT INTO control_super.sucursal (nombre, direccion)
VALUES ('Sucursal Sur', 'AVenida las americas 5-23 zona 9, Quetzaltenango');







INSERT INTO control_inventario.producto (id_producto, nombre, descripcion, cantidad, precio, id_sucursal)
 VALUES
   ('SKU001', 'Arroz', 'Arroz blanco de 1kg', 200, 12.99, 1),
   ('SKU002', 'Frijoles', 'Frijoles negros de 500g', 150, 5.99, 1),
   ('SKU003', 'Aceite de Cocina', 'Aceite vegetal de 1 litro', 100, 15.49, 1),
   ('SKU004', 'Leche', 'Leche entera de 1 litro', 120, 9.99, 1),
   ('SKU005', 'Pan', 'Pan blanco fresco', 300, 3.49, 1);
