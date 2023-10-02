-- Cajero 1
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES 
        ('carlos', '12345', 'Carlos Pérez', 1, 'Cajero'),
        ('mari10', '0000', 'Maria Lopez', 1, 'Cajero'),
        ('peter', '1234', 'Pedro Gonzalez', 1, 'Cajero'),
        ('ana', '0000', 'Ana De Leon', 1, 'Cajero');

-- Bodega 1
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES 
        ('bodega1', 'clave1', 'Luis Torres', 1, 'Bodega');
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES 
        ('manuel', 'clave1', 'Manuel Silva', 1, 'Inventario');
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES  
        ('admin1', 'clave1', 'Carmen Rodríguez', 1, 'Administrador');



-- Cajero 2
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES 
        ('cajero3', 'clave3', 'Juan Rodríguez', 2, 'Cajero'),
        ('cajero3', 'clave3', 'Dayana Lopez', 2, 'Cajero'),
        ('cajero3', 'clave3', 'Dulce Gomez', 2, 'Cajero'),
        ('cajero4', 'clave4', 'Daniel Batz', 2, 'Cajero');
-- Bodega 4
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES  
        ('bodega4', 'clave4', 'Sofía Morales', 2, 'Bodega');
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES  
        ('inventario3', 'clave3', 'Lorenzo González', 2, 'Inventario');

-- Cajero 5
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES
        ('cajero5', 'clave5', 'Pedro García', 3, 'Cajero');
        ('cajero5', 'clave5', 'Jorge Cruz', 3, 'Cajero');
        ('cajero5', 'clave5', 'Santiago Leon', 3, 'Cajero');        
        ('cajero5', 'clave5', 'Alex Martinez', 3, 'Cajero');
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES 
        ('bodega5', 'clave5', 'Elena Vargas', 3, 'Bodega');
INSERT INTO control_super.empleado (usuario, contrasenia, nombre, sucursal, tipo) 
    VALUES 
        ('inventario5', 'clave5', 'Roberto Díaz', 3, 'Inventario');


/*Inserts de clientes*/
INSERT INTO control_clientes.cliente (nit, nombre, telefono, dinero_gastado, dinero_membresia)
VALUES ('45454545', 'Carlos Martínez', '555-5678', 2800.00, 100.00);

INSERT INTO control_clientes.cliente (nit, nombre, telefono, dinero_gastado, dinero_membresia)
VALUES ('987654321', 'Sofía Rodríguez', '555-9876', 1800.50, 30.00);

INSERT INTO control_clientes.cliente (nit, nombre, telefono, dinero_gastado, dinero_membresia)
VALUES ('12532134', 'Juan Pérez', '555-4321', 2200.75, 60.00);

INSERT INTO control_clientes.cliente (nit, nombre, telefono, dinero_gastado, dinero_membresia)
VALUES ('11111111', 'María García', '555-8765', 3500.25, 80.00);
INSERT INTO control_clientes.cliente (nit, nombre, telefono, dinero_gastado, dinero_membresia)
VALUES ('22222222', 'Ana López', '555-1234', 1500.00, 50.00);
INSERT INTO control_clientes.cliente (nit, nombre, telefono, dinero_gastado, dinero_membresia)
VALUES ('C/F', '', '', 0.00, 0.00);


/*Insertamos productos bodega sucursal central*/
INSERT INTO control_inventario.producto (id_producto, nombre, descripcion, cantidad, precio, id_sucursal)
VALUES
('SKU201', 'Leche', 'Leche fresca de 1 litro', 200, 2.99, 1),
    ('SKU202', 'Arroz', 'Arroz blanco de 1kg', 150, 1.99, 1),
    ('SKU203', 'Frijoles', 'Frijoles negros de 500g', 100, 1.49, 1),
    ('SKU204', 'Aceite de Cocina', 'Aceite vegetal de 1 litro', 120, 3.99, 1),
    ('SKU205', 'Azúcar', 'Azúcar refinada de 2kg', 80, 2.49, 1),
    ('SKU206', 'Sal', 'Sal de mesa de 500g', 60, 0.99, 1),
    ('SKU207', 'Harina', 'Harina de trigo de 2kg', 90, 1.79, 1),
    ('SKU208', 'Pasta', 'Pasta de espagueti de 500g', 110, 1.29, 1),
    ('SKU209', 'Sopa enlatada', 'Sopa de pollo enlatada', 70, 1.69, 1),
    ('SKU210', 'Cereal', 'Cereal de maíz de 500g', 45, 3.49, 1),
    ('SKU211', 'Galletas', 'Galletas de chocolate', 120, 2.99, 1),
    ('SKU212', 'Pan', 'Pan blanco fresco', 200, 1.49, 1),
    ('SKU213', 'Mantequilla', 'Mantequilla de 200g', 85, 2.29, 1),
    ('SKU214', 'Queso', 'Queso cheddar de 250g', 70, 3.99, 1),
    ('SKU215', 'Yogur', 'Yogur de fresa de 150g', 110, 0.99, 1),
    ('SKU216', 'Huevos', 'Docena de huevos frescos', 50, 2.99, 1),
    ('SKU217', 'Carne de Res', 'Carne de res de 500g', 65, 6.99, 1),
    ('SKU218', 'Pollo', 'Pollo entero', 40, 4.49, 1),
    ('SKU219', 'Pavo', 'Pavo entero', 15, 12.99, 1),
    ('SKU220', 'Pescado', 'Filete de pescado fresco', 30, 9.99, 1),
    ('SKU221', 'Cerdo', 'Carne de cerdo de 1kg', 55, 5.99, 1),
    ('SKU222', 'Jamón', 'Jamón de 200g', 75, 3.49, 1),
    ('SKU223', 'Salchichas', 'Salchichas de 500g', 90, 2.79, 1),
    ('SKU224', 'Tocino', 'Tocino ahumado de 250g', 65, 4.99, 1),
    ('SKU225', 'Vegetales Frescos', 'Mezcla de vegetales frescos', 70, 2.49, 1),
    ('SKU226', 'Frutas Frescas', 'Selección de frutas frescas', 60, 3.99, 1),
    ('SKU227', 'Zanahorias', 'Zanahorias frescas', 40, 0.99, 1),
    ('SKU228', 'Tomates', 'Tomates orgánicos', 55, 1.79, 1),
    ('SKU229', 'Cebollas', 'Cebollas amarillas', 45, 1.29, 1),
    ('SKU230', 'Papas', 'Papas russet de 5kg', 30, 2.99, 1),
    ('SKU231', 'Manzanas', 'Manzanas rojas', 65, 0.79, 1),
    ('SKU232', 'Plátanos', 'Plátanos maduros', 80, 0.49, 1),
    ('SKU233', 'Naranjas', 'Naranjas frescas', 70, 0.69, 1),
    ('SKU234', 'Uvas', 'Uvas rojas sin semillas', 45, 2.49, 1),
    ('SKU235', 'Fresas', 'Fresas frescas', 55, 2.99, 1),
    ('SKU236', 'Sandías', 'Sandías enteras', 20, 3.99, 1),
    ('SKU237', 'Limones', 'Limones frescos', 75, 0.39, 1),
    ('SKU238', 'Lechuga', 'Lechuga iceberg', 50, 1.49, 1),
    ('SKU239', 'Espinacas', 'Espinacas orgánicas', 30, 2.29, 1),
    ('SKU240', 'Pepinos', 'Pepinos frescos', 65, 0.89, 1),
    ('SKU241', 'Brócoli', 'Brócoli fresco', 40, 1.99, 1),
    ('SKU242', 'Queso Cottage', 'Queso cottage bajo en grasa', 35, 2.99, 1),
    ('SKU243', 'Yogur Griego', 'Yogur griego de vainilla', 50, 1.29, 1),
    ('SKU244', 'Mango', 'Mango fresco', 75, 0.99, 1),
    ('SKU245', 'Piña', 'Piña fresca', 60, 1.49, 1),
    ('SKU246', 'Cerezas', 'Cerezas frescas', 45, 3.99, 1),
    ('SKU247', 'Melocotones', 'Melocotones maduros', 55, 2.49, 1),
    ('SKU248', 'Kiwi', 'Kiwi fresco', 40, 0.79, 1),
    ('SKU249', 'Pimientos', 'Pimientos rojos', 65, 1.99, 1),
    ('SKU250', 'Aguacate', 'Aguacates maduros', 70, 1.29, 1),
   ('ELE001', 'Horno Eléctrico', 'Horno eléctrico con convección', 30, 199.99, 1),
   ('ELE002', 'Lavadora de Ropa', 'Lavadora automática de carga frontal', 25, 399.99, 1),
   ('ELE003', 'Secadora de Ropa', 'Secadora eléctrica de ropa', 20, 349.99, 1),
   ('ELE004', 'Lavavajillas', 'Lavavajillas empotrable', 15, 549.99, 1),
   ('ELE005', 'Refrigeradora', 'Refrigeradora de doble puerta', 18, 699.99, 1),
   ('ELE006', 'Cafetera de Goteo', 'Cafetera programable', 35, 59.99, 1),
   ('ELE007', 'Licuadora de Alta Potencia', 'Licuadora de 1000W', 40, 69.99, 1),
   ('ELE008', 'Tostadora de Pan', 'Tostadora de 2 ranuras', 30, 29.99, 1),
   ('ELE009', 'Freidora de Aire', 'Freidora sin aceite', 20, 89.99, 1),
   ('ELE010', 'Robot de Cocina', 'Robot de cocina multifunción', 15, 149.99, 1),
   ('ELE011', 'Aspiradora Robot', 'Aspiradora automática', 10, 249.99, 1),
   ('ELE012', 'Máquina de Coser', 'Máquina de coser electrónica', 12, 199.99, 1),
   ('ELE013', 'Ventilador de Torre', 'Ventilador oscilante', 25, 49.99, 1),
   ('ELE014', 'Ventilador de Techo', 'Ventilador de techo con luz', 18, 69.99, 1),
   ('ELE015', 'Calefactor Eléctrico', 'Calefactor portátil', 20, 39.99, 1),
   ('ELE016', 'Aire Acondicionado', 'Aire acondicionado split', 8, 299.99, 1),
   ('ELE017', 'Deshumidificador', 'Deshumidificador eléctrico', 12, 89.99, 1),
   ('ELE018', 'Purificador de Aire', 'Purificador de aire HEPA', 15, 149.99, 1),
   ('ELE019', 'Calentador de Agua', 'Calentador de agua eléctrico', 10, 199.99, 1),
   ('ELE020', 'Dispensador de Agua', 'Dispensador de agua fría/caliente', 8, 69.99, 1),
   ('ELE021', 'Batidora de Mano', 'Batidora de mano inalámbrica', 30, 79.99, 1),
   ('ELE022', 'Procesador de Alimentos', 'Procesador de alimentos de 12 tazas', 25, 129.99, 1),
   ('ELE023', 'Hervidor de Agua', 'Hervidor eléctrico de acero inoxidable', 22, 34.99, 1),
   ('ELE024', 'Plancha de Vapor', 'Plancha de vapor con suela de cerámica', 28, 44.99, 1),
   ('ELE025', 'Batidora Planetaria', 'Batidora planetaria de 5.5 cuartos', 15, 169.99, 1),
   ('ELE026', 'Molinillo de Café', 'Molinillo de café eléctrico', 20, 24.99, 1),
   ('ELE027', 'Tetera Eléctrica', 'Tetera eléctrica de vidrio', 18, 39.99, 1),
   ('ELE028', 'Máquina para Hacer Pan', 'Máquina automática para hacer pan', 12, 79.99, 1),
   ('ELE029', 'Plancha para Waffles', 'Plancha para waffles antiadherente', 22, 29.99, 1),
   ('ELE030', 'Máquina de Palomitas de Maíz', 'Máquina de palomitas de aire caliente', 16, 34.99, 1),
   ('ELE031', 'Máquina de Hacer Donas', 'Máquina para hacer donas de 6 cavidades', 10, 49.99, 1),
   ('ELE032', 'Licuadora de Inmersión', 'Licuadora de mano con accesorios', 18, 44.99, 1),
   ('ELE033', 'Horno de Pizza', 'Horno eléctrico para pizza', 15, 79.99, 1),
   ('ELE034', 'Máquina para Hacer Pasta', 'Máquina manual para hacer pasta', 10, 69.99, 1),
   ('ELE035', 'Batidora de Pedestal', 'Batidora de pedestal de 6 velocidades', 14, 54.99, 1),
   ('ELE036', 'Exprimidor de Cítricos', 'Exprimidor eléctrico de cítricos', 18, 29.99, 1),
   ('ELE037', 'Máquina de Algodón de Azúcar', 'Máquina de algodón de azúcar con carrito', 10, 129.99, 1),
   ('ELE038', 'Máquina de Gofres', 'Máquina para hacer gofres belgas', 20, 39.99, 1),
   ('ELE039', 'Licuadora Personal', 'Licuadora personal de viaje', 28, 19.99, 1),
   ('ELE040', 'Máquina de Hot Dogs', 'Máquina para hacer hot dogs', 15, 49.99, 1),
   ('ELE041', 'Máquina de Cupcakes', 'Máquina para hacer cupcakes', 12, 59.99, 1),
    ('ELE042', 'Batidora de Pie', 'Batidora de pie con tazón de acero inoxidable', 22, 89.99, 1),
   ('ELE043', 'Máquina para Hacer Helados', 'Máquina eléctrica para hacer helados', 18, 69.99, 1),
   ('ELE044', 'Máquina de Crepas', 'Máquina para hacer crepas y panqueques', 16, 49.99, 1),
   ('ELE045', 'Molinillo de Especias', 'Molinillo eléctrico para especias', 25, 24.99, 1),
   ('ELE046', 'Olla Arrocera', 'Olla arrocera eléctrica de 10 tazas', 20, 34.99, 1),
   ('ELE047', 'Máquina de Helados Soft', 'Máquina de helados suaves', 14, 99.99, 1),
   ('ELE048', 'Tostadora de Pan de Lujo', 'Tostadora de pan de lujo con pantalla táctil', 18, 59.99, 1),
   ('ELE049', 'Exprimidor de Zumos', 'Exprimidor de zumos eléctrico', 30, 44.99, 1),
   ('ELE050', 'Cocina de Inducción', 'Cocina de inducción portátil de 1800W', 12, 129.99, 1);

INSERT INTO control_inventario.estanteria (id_producto, id_sucursal, numero_pasillo, cantidad)
VALUES
    -- Pasillo 1
    ('SKU201', 1, 1, 25),
    ('SKU202', 1, 1, 30),
    ('SKU203', 1, 1, 28),
    ('SKU204', 1, 1, 30),
    ('SKU205', 1, 1, 28),
    ('SKU206', 1, 1, 25),
    ('SKU207', 1, 1, 30),
    ('SKU208', 1, 1, 28),
    ('SKU209', 1, 1, 30),
    ('SKU210', 1, 1, 28),
    ('SKU211', 1, 2, 25),
    ('SKU212', 1, 2, 30),
    ('SKU213', 1, 2, 28),
    ('SKU214', 1, 2, 30),
    ('SKU215', 1, 2, 28),
    ('SKU216', 1, 2, 25),
    ('SKU217', 1, 2, 30),
    ('SKU218', 1, 2, 28),
    ('SKU219', 1, 2, 30),
    ('SKU220', 1, 2, 28),
    ('SKU221', 1, 3, 25),
    ('SKU222', 1, 3, 30),
    ('SKU223', 1, 3, 28),
    ('SKU224', 1, 3, 30),
    ('SKU225', 1, 3, 28),
    ('SKU226', 1, 3, 25),
    ('SKU227', 1, 3, 30),
    ('SKU228', 1, 3, 28),
    ('SKU229', 1, 3, 30),
    ('SKU230', 1, 1, 28),
    ('ELE001', 1, 1, 5),
    ('ELE002', 1, 2, 5),
    ('ELE003', 1, 3, 5),
    ('ELE004', 1, 4, 5),
    ('ELE005', 1, 5, 5),
    ('ELE006', 1, 6, 5),
    ('ELE007', 1, 7, 5),
    ('ELE008', 1, 8, 5),
    ('ELE009', 1, 9, 5),
    ('ELE010', 1, 10, 5),
    ('ELE011', 1, 1, 5),
    ('ELE012', 1, 2, 5),
    ('ELE013', 1, 3, 5),
    ('ELE014', 1, 4, 5),
    ('ELE015', 1, 5, 5),
    ('ELE016', 1, 6, 5),
    ('ELE017', 1, 7, 5),
    ('ELE018', 1, 8, 5),
    ('ELE019', 1, 9, 5),
    ('ELE020', 1, 10, 5),
    ('ELE021', 1, 1, 5),
    ('ELE022', 1, 2, 5),
    ('ELE023', 1, 3, 5),
    ('ELE024', 1, 4, 5),
    ('ELE025', 1, 5, 5),
    ('ELE026', 1, 6, 5),
    ('ELE027', 1, 7, 5),
    ('ELE028', 1, 8, 5),
    ('ELE029', 1, 9, 5),
    ('ELE030', 1, 10, 5),
    ('ELE031', 1, 1, 5),
    ('ELE032', 1, 2, 5),
    ('ELE033', 1, 3, 5),
    ('ELE034', 1, 4, 5),
    ('ELE035', 1, 5, 5),
    ('ELE036', 1, 6, 5),
    ('ELE037', 1, 7, 5),
    ('ELE038', 1, 8, 5),
    ('ELE039', 1, 9, 5),
    ('ELE040', 1, 10, 5),
    ('ELE041', 1, 1, 5),
    ('ELE042', 1, 2, 5),
    ('ELE043', 1, 3, 5),
    ('ELE044', 1, 4, 5),
    ('ELE045', 1, 5, 5),
    ('ELE046', 1, 6, 5),
    ('ELE047', 1, 7, 5),
    ('ELE048', 1, 8, 5),
    ('ELE049', 1, 9, 5),
    ('ELE050', 1, 10, 5);

/*Insertamos productos bodega sucursal norte*/
INSERT INTO control_inventario.producto (id_producto, nombre, descripcion, cantidad, precio, id_sucursal)
VALUES
('WKU201', 'Leche', 'Leche fresca de 1 litro', 200, 2.99, 2),
('WKU202', 'Arroz', 'Arroz blanco de 1kg', 150, 1.99, 2),
('WKU203', 'Frijoles', 'Frijoles negros de 500g', 100, 1.49, 2),
('WKU204', 'Aceite de Cocina', 'Aceite vegetal de 1 litro', 120, 3.99, 2),
('WKU205', 'Azúcar', 'Azúcar refinada de 2kg', 80, 2.49, 2),
('WKU206', 'Sal', 'Sal de mesa de 500g', 60, 0.99, 2),
('WKU207', 'Harina', 'Harina de trigo de 2kg', 90, 1.79, 2),
('WKU208', 'Pasta', 'Pasta de espagueti de 500g', 110, 1.29, 2),
('WKU209', 'Sopa enlatada', 'Sopa de pollo enlatada', 70, 1.69, 2),
('WKU210', 'Cereal', 'Cereal de maíz de 500g', 45, 3.49, 2),
('WKU211', 'Galletas', 'Galletas de chocolate', 120, 2.99, 2),
('WKU212', 'Pan', 'Pan blanco fresco', 200, 1.49, 2),
('WKU213', 'Mantequilla', 'Mantequilla de 200g', 85, 2.29, 2),
('WKU214', 'Queso', 'Queso cheddar de 250g', 70, 3.99, 2),
('WKU215', 'Yogur', 'Yogur de fresa de 150g', 110, 0.99, 2),
('WKU216', 'Huevos', 'Docena de huevos frescos', 50, 2.99, 2),
('WKU217', 'Carne de Res', 'Carne de res de 500g', 65, 6.99, 2),
('WKU218', 'Pollo', 'Pollo entero', 40, 4.49, 2),
('WKU219', 'Pavo', 'Pavo entero', 15, 12.99, 2),
('WKU220', 'Pescado', 'Filete de pescado fresco', 30, 9.99, 2),
('WKU221', 'Cerdo', 'Carne de cerdo de 1kg', 55, 5.99, 2),
('WKU222', 'Jamón', 'Jamón de 200g', 75, 3.49, 2),
('WKU223', 'Salchichas', 'Salchichas de 500g', 90, 2.79, 2),
('WKU224', 'Tocino', 'Tocino ahumado de 250g', 65, 4.99, 2),
('WKU225', 'Vegetales Frescos', 'Mezcla de vegetales frescos', 70, 2.49, 2),
('WKU226', 'Frutas Frescas', 'Selección de frutas frescas', 60, 3.99, 2),
('WKU227', 'Zanahorias', 'Zanahorias frescas', 40, 0.99, 2),
('WKU228', 'Tomates', 'Tomates orgánicos', 55, 1.79, 2),
('WKU229', 'Cebollas', 'Cebollas amarillas', 45, 1.29, 2),
('WKU230', 'Papas', 'Papas russet de 5kg', 30, 2.99, 2),
('WKU231', 'Manzanas', 'Manzanas rojas', 65, 0.79, 2),
('WKU232', 'Plátanos', 'Plátanos maduros', 80, 0.49, 2),
('WKU233', 'Naranjas', 'Naranjas frescas', 70, 0.69, 2),
('WKU234', 'Uvas', 'Uvas rojas sin semillas', 45, 2.49, 2),
('WKU235', 'Fresas', 'Fresas frescas', 55, 2.99, 2),
('WKU236', 'Sandías', 'Sandías enteras', 20, 3.99, 2),
('WKU237', 'Limones', 'Limones frescos', 75, 0.39, 2),
('WKU238', 'Lechuga', 'Lechuga iceberg', 50, 1.49, 2),
('WKU239', 'Espinacas', 'Espinacas orgánicas', 30, 2.29, 2),
('WKU240', 'Pepinos', 'Pepinos frescos', 65, 0.89, 2),
('WKU241', 'Brócoli', 'Brócoli fresco', 40, 1.99, 2),
('WKU242', 'Queso Cottage', 'Queso cottage bajo en grasa', 35, 2.99, 2),
('WKU243', 'Yogur Griego', 'Yogur griego de vainilla', 50, 1.29, 2),
('WKU244', 'Mango', 'Mango fresco', 75, 0.99, 2),
('WKU245', 'Piña', 'Piña fresca', 60, 1.49, 2),
('WKU246', 'Cerezas', 'Cerezas frescas', 45, 3.99, 2),
('WKU247', 'Melocotones', 'Melocotones maduros', 55, 2.49, 2),
('WKU248', 'Kiwi', 'Kiwi fresco', 40, 0.79, 2),
('WKU249', 'Pimientos', 'Pimientos rojos', 65, 1.99, 2),
('WKU250', 'Aguacate', 'Aguacates maduros', 70, 1.29, 2),
('DLE001', 'Horno Eléctrico', 'Horno eléctrico con convección', 30, 199.99, 2),
('DLE002', 'Lavadora de Ropa', 'Lavadora automática de carga frontal', 25, 399.99, 2),
('DLE003', 'Secadora de Ropa', 'Secadora eléctrica de ropa', 20, 349.99, 2),
('DLE004', 'Lavavajillas', 'Lavavajillas empotrable', 15, 549.99, 2),
('DLE005', 'Refrigeradora', 'Refrigeradora de doble puerta', 18, 699.99, 2),
('DLE006', 'Cafetera de Goteo', 'Cafetera programable', 35, 59.99, 2),
('DLE007', 'Licuadora de Alta Potencia', 'Licuadora de 1000W', 40, 69.99, 2),
('DLE008', 'Tostadora de Pan', 'Tostadora de 2 ranuras', 30, 29.99, 2),
('DLE009', 'Freidora de Aire', 'Freidora sin aceite', 20, 89.99, 2),
('DLE010', 'Robot de Cocina', 'Robot de cocina multifunción', 15, 149.99, 2),
('DLE011', 'Aspiradora Robot', 'Aspiradora automática', 10, 249.99, 2),
('DLE012', 'Máquina de Coser', 'Máquina de coser electrónica', 12, 199.99, 2),
('DLE013', 'Ventilador de Torre', 'Ventilador oscilante', 25, 49.99, 2),
('DLE014', 'Ventilador de Techo', 'Ventilador de techo con luz', 18, 69.99, 2),
('DLE015', 'Calefactor Eléctrico', 'Calefactor portátil', 20, 39.99, 2),
('DLE016', 'Aire Acondicionado', 'Aire acondicionado split', 8, 299.99, 2),
('DLE017', 'Deshumidificador', 'Deshumidificador eléctrico', 12, 89.99, 2),
('DLE018', 'Purificador de Aire', 'Purificador de aire HEPA', 15, 149.99, 2),
('DLE019', 'Calentador de Agua', 'Calentador de agua eléctrico', 10, 199.99, 2),
('DLE020', 'Dispensador de Agua', 'Dispensador de agua fría/caliente', 8, 69.99, 2),
('DLE021', 'Batidora de Mano', 'Batidora de mano inalámbrica', 30, 79.99, 2),
('DLE022', 'Procesador de Alimentos', 'Procesador de alimentos de 12 tazas', 25, 129.99, 2),
('DLE023', 'Hervidor de Agua', 'Hervidor eléctrico de acero inoxidable', 22, 34.99, 2),
('DLE024', 'Plancha de Vapor', 'Plancha de vapor con suela de cerámica', 28, 44.99, 2);

INSERT INTO control_inventario.estanteria (id_producto, id_sucursal, numero_pasillo, cantidad)
VALUES
    -- Pasillo 1
    ('SKU201', 2, 4, 25),
    ('WKU202', 2, 4, 30),
    ('WKU203', 2, 4, 28),
    ('WKU204', 2, 4, 30),
    ('WKU205', 2, 4, 28),
    ('WKU206', 2, 4, 25),
    ('WKU207', 2, 4, 30),
    ('WKU208', 2, 4, 28),
    ('WKU209', 2, 4, 30),
    ('WKU210', 2, 4, 28),
    ('WKU211', 2, 1, 25),
    ('WKU212', 2, 1, 30),
    ('WKU213', 2, 1, 28),
    ('WKU214', 2, 1, 30),
    ('WKU215', 2, 1, 28),
    ('WKU216', 2, 1, 25),
    ('WKU217', 2, 1, 30),
    ('WKU218', 2, 1, 28),
    ('WKU219', 2, 1, 30),
    ('WKU220', 2, 1, 28),
    ('WKU221', 2, 2, 25),
    ('WKU222', 2, 2, 30),
    ('WKU223', 2, 2, 28),
    ('WKU224', 2, 2, 30),
    ('WKU225', 2, 2, 28),
    ('WKU226', 2, 2, 25),
    ('WKU227', 2, 2, 30),
    ('WKU228', 2, 2, 28),
    ('WKU229', 2, 2, 30),
    ('WKU230', 2, 4, 28),
    ('DLE001', 2, 4, 5),
    ('DLE002', 2, 4, 5),
    ('DLE003', 2, 4, 5),
    ('DLE004', 2, 4, 5),
    ('DLE005', 2, 4, 5),
    ('DLE006', 2, 4, 5),
    ('DLE007', 2, 4, 5),
    ('DLE008', 2, 4, 5),
    ('DLE009', 2, 4, 5),
    ('DLE010', 2, 10, 5),
    ('DLE011', 2, 1, 5),
    ('DLE012', 2, 2, 5),
    ('DLE013', 2, 3, 5),
    ('DLE014', 2, 4, 5),
    ('DLE015', 2, 5, 5),
    ('DLE016', 2, 6, 5),
    ('DLE017', 2, 7, 5),
    ('DLE018', 2, 8, 5),
    ('DLE019', 2, 9, 5),
    ('DLE020', 2, 10, 5),
    ('DLE021', 2, 1, 5),
    ('DLE022', 2, 2, 5),
    ('DLE023', 2, 3, 5),
    ('DLE024', 2, 4, 5);

/*Insertamos productos bodega sucursal sur*/

INSERT INTO control_inventario.producto (id_producto, nombre, descripcion, cantidad, precio, id_sucursal)
VALUES
('SKU201', 'Leche', 'Leche fresca de 1 litro', 200, 2.99, 3),
('SKU202', 'Arroz', 'Arroz blanco de 1kg', 150, 1.99, 3),
('SKU203', 'Frijoles', 'Frijoles negros de 500g', 100, 1.49, 3),
('SKU204', 'Aceite de Cocina', 'Aceite vegetal de 1 litro', 120, 3.99, 3),
('SKU205', 'Azúcar', 'Azúcar refinada de 2kg', 80, 2.49, 3),
('SKU206', 'Sal', 'Sal de mesa de 500g', 60, 0.99, 3),
('SKU207', 'Harina', 'Harina de trigo de 2kg', 90, 1.79, 3),
('SKU208', 'Pasta', 'Pasta de espagueti de 500g', 110, 1.29, 3),
('SKU209', 'Sopa enlatada', 'Sopa de pollo enlatada', 70, 1.69, 3),
('SKU210', 'Cereal', 'Cereal de maíz de 500g', 45, 3.49, 3),
('SKU211', 'Galletas', 'Galletas de chocolate', 120, 2.99, 3),
('SKU212', 'Pan', 'Pan blanco fresco', 200, 1.49, 3),
('SKU213', 'Mantequilla', 'Mantequilla de 200g', 85, 2.29, 3),
('SKU214', 'Queso', 'Queso cheddar de 250g', 70, 3.99, 3),
('SKU215', 'Yogur', 'Yogur de fresa de 150g', 110, 0.99, 3),
('SKU216', 'Huevos', 'Docena de huevos frescos', 50, 2.99, 3),
('SKU217', 'Carne de Res', 'Carne de res de 500g', 65, 6.99, 3),
('SKU218', 'Pollo', 'Pollo entero', 40, 4.49, 3),
('SKU219', 'Pavo', 'Pavo entero', 15, 12.99, 3),
('SKU220', 'Pescado', 'Filete de pescado fresco', 30, 9.99, 3),
('SKU221', 'Cerdo', 'Carne de cerdo de 1kg', 55, 5.99, 3),
('SKU222', 'Jamón', 'Jamón de 200g', 75, 3.49, 3),
('SKU223', 'Salchichas', 'Salchichas de 500g', 90, 2.79, 3),
('SKU224', 'Tocino', 'Tocino ahumado de 250g', 65, 4.99, 3),
('SKU225', 'Vegetales Frescos', 'Mezcla de vegetales frescos', 70, 2.49, 3),
('SKU226', 'Frutas Frescas', 'Selección de frutas frescas', 60, 3.99, 3),
('SKU227', 'Zanahorias', 'Zanahorias frescas', 40, 0.99, 3),
('SKU228', 'Tomates', 'Tomates orgánicos', 55, 1.79, 3),
('SKU229', 'Cebollas', 'Cebollas amarillas', 45, 1.29, 3),
('SKU230', 'Papas', 'Papas russet de 5kg', 30, 2.99, 3),
('SKU231', 'Manzanas', 'Manzanas rojas', 65, 0.79, 3),
('SKU232', 'Plátanos', 'Plátanos maduros', 80, 0.49, 3),
('SKU233', 'Naranjas', 'Naranjas frescas', 70, 0.69, 3),
('SKU234', 'Uvas', 'Uvas rojas sin semillas', 45, 2.49, 3);

INSERT INTO control_inventario.estanteria (id_producto, id_sucursal, numero_pasillo, cantidad)
VALUES
    -- Pasillo 1
    ('SKU201', 3, 1, 25),
    ('SKU202', 3, 1, 30),
    ('SKU203', 3, 1, 28),
    ('SKU204', 3, 1, 30),
    ('SKU205', 3, 1, 28),
    ('SKU206', 3, 2, 25),
    ('SKU207', 3, 2, 30),
    ('SKU208', 3, 2, 28),
    ('SKU209', 3, 2, 30),
    ('SKU210', 3, 2, 28),
    ('SKU211', 3, 3, 25),
    ('SKU212', 3, 3, 30),
    ('SKU213', 3, 3, 28),
    ('SKU214', 3, 3, 30),
    ('SKU215', 3, 3, 28),
    ('SKU216', 3, 4, 25),
    ('SKU217', 3, 4, 30),
    ('SKU218', 3, 4, 28),
    ('SKU219', 3, 4, 30),
    ('SKU220', 3, 4, 28),
    ('SKU220', 3, 5, 28),
    ('SKU221', 3, 5, 25),
    ('SKU222', 3, 5, 30),
    ('SKU223', 3, 5, 28),
    ('SKU224', 3, 5, 30),
    ('SKU225', 3, 6, 28),
    ('SKU226', 3, 6, 25),
    ('SKU227', 3, 6, 30),
    ('SKU228', 3, 6, 28),
    ('SKU229', 3, 6, 30),
    ('SKU230', 3, 4, 28),
    ('SKU231', 3, 5, 25),
    ('SKU232', 3, 5, 30),
    ('SKU233', 3, 5, 28),
    ('SKU234', 3, 5, 30);
