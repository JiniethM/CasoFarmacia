CREATE DATABASE Farmacia_Rosales_DB
GO

USE Farmacia_Rosales_DB

--Tabla Empleado----------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [Empleado] (
  [Id_Empleado] INT  IDENTITY(1,1) PRIMARY KEY,
  [Nombre_1] VARCHAR(32)NOT NULL,
  [Nombre_2] VARCHAR(32),
  [Apellido_1] VARCHAR(32)NOT NULL,
  [Apellido_2] VARCHAR(32),
  [Numero_Celular] VARCHAR(8)NOT NULL,
  [Gmail] NVARCHAR(50),
  [Direccion] VARCHAR(200)NOT NULL,
  [Hora_Entrada] TIME NOT NULL,
  [Hora_Salida] TIME NOT NULL
)
GO



--Tabla Clientes----------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [Cliente] (
  [Id_Cliente] INT IDENTITY(1,1) PRIMARY KEY ,
  [Nombre_1] VARCHAR(32)NOT NULL,
  [Nombre_2] VARCHAR(32),
  [Apellido_1] VARCHAR(32)NOT NULL,
  [Apellido_2] VARCHAR(32),
  [Numero_Celular] VARCHAR(8)NOT NULL,
  [Direccion] VARCHAR(200) NOT NULL
)
GO



--Tabla Ventas----------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE [Venta] (
  [Id_Venta] INT  IDENTITY(1,1) PRIMARY KEY,
  [Fecha_Hora] DATETIME NOT NULL,
  [Id_Cliente] INT NOT NULL,
  [Id_Empleado] INT 
)
GO


--Tabla Presentacione----------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE [Presentacion] (
  [Id_Presentacion] INT IDENTITY(1,1)PRIMARY KEY,
  [Nombre_Presentacion] VARCHAR(50) NOT NULL,
  [Detalle] VARCHAR(70) NOT NULL
)
GO



--Tabla Categoria----------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE [Categoria] (
  [Id_Categoria] INT IDENTITY(1,1) PRIMARY KEY,
  [Nombre_Categoria] VARCHAR(50) NOT NULL,
  [Descripcion] VARCHAR(70) NOT NULL
 
)
GO




--Tabla Productos----------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE [Producto] (
  [Id_Producto] INT  IDENTITY(1,1) PRIMARY KEY,
  [Nombre] VARCHAR(50) NOT NULL,
  [Descripcion] VARCHAR(200),
  [Cantidad_Producto] INT NOT NULL,
  [Precio_Compra] DECIMAL(8,2),
  [Precio_Venta] DECIMAL(8,2),
  [Imagen_Producto] IMAGE ,
  [Fecha_Caducidad] DATE NOT NULL,
  [Id_Categoria] INT NOT NULL,
  [Id_Presentacion] INT NOT NULL,
  [Id_Laboratorio] INT NOT NULL
)
GO



--Tabla Producto_Proveedor

CREATE TABLE [Producto_Proveedor] (
  [Id_Producto_Proveedor] INT IDENTITY(1,1) PRIMARY KEY,
  [Id_Proveedor] INT NOT NULL,
  [Id_Producto] INT NOT NULL,
)
GO



--Tabla Proveedore----------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE [Proveedor] (
  [Id_Proveedor] INT IDENTITY(1,1)PRIMARY KEY,
  [Nombre_1] VARCHAR(32) NOT NULL,
  [Nombre_2] VARCHAR(32) ,
  [Apellido_1] VARCHAR(32)NOT NULL,
  [Apellido_2] VARCHAR(32),
  [Gmail] NVARCHAR(50) NOT NULL,
  [Numero_Celular] VARCHAR(8) NOT NULL,
  [Direccion] VARCHAR(200) NOT NULL
)
GO




--Tabla Laboratorios----------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE [Laboratorio] (
  [Id_Laboratorio] INT  IDENTITY(1,1) PRIMARY KEY,
  [Nombre] VARCHAR(50) NOT NULL
)
GO




--Tabla Ventas_Productos----------------------------------------------------------------------------------------------------------------------------------


CREATE TABLE [Venta_Producto] (
  [Id_Venta_Producto] INT IDENTITY(1,1) PRIMARY KEY,
  [Cantidad] INT NOT NULL,
  [Descuento] DECIMAL(8,2) NOT NULL,
  [Id_Venta] INT NOT NULL,
  [Id_Producto] INT NOT NULL
)
GO


--Tabla Compra--------------------------------------------------------------------------

CREATE TABLE [Compra] (
  [Id_Compra] INT  IDENTITY(1,1) PRIMARY KEY,
  [Fecha_Compra] DATE,
  [Id_Proveedor] INT
)
GO


--Tabla Compra_Producto-------------------------------------------------------------------------

CREATE TABLE [Compra_Producto] (
  [Id_Compra_Producto] INT  IDENTITY(1,1) PRIMARY KEY,
  [Id_Compra] INT,
  [Id_Producto] INT
)
GO


--Conexiones de tabla----------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE [Compra]
ADD CONSTRAINT [FK_Compra_Proveedor] 
FOREIGN KEY ([Id_Proveedor])
REFERENCES [Proveedor] ([Id_Proveedor])
GO

ALTER TABLE [Venta_Producto]
ADD CONSTRAINT [FK_Venta_Producto_Producto]
FOREIGN KEY ([Id_Producto]) 
REFERENCES [Producto] ([Id_Producto])
GO

ALTER TABLE [Venta_Producto]
ADD CONSTRAINT [FK_Venta_Producto_Venta] 
FOREIGN KEY ([Id_Venta]) 
REFERENCES [Venta] ([Id_Venta])
GO

ALTER TABLE [Venta] 
ADD CONSTRAINT [FK_Venta_Cliente] 
FOREIGN KEY ([Id_Cliente]) 
REFERENCES [Cliente] ([Id_Cliente])
GO

ALTER TABLE [Venta] 
ADD CONSTRAINT [FK_Venta_Empleado] 
FOREIGN KEY ([Id_Empleado])
REFERENCES [Empleado] ([Id_Empleado])
GO

ALTER TABLE [Producto]
ADD CONSTRAINT [FK_Producto_Categoria] 
FOREIGN KEY ([Id_Categoria])
REFERENCES [Categoria] ([Id_Categoria])
GO

ALTER TABLE [Producto]
ADD CONSTRAINT [FK_Productos_Laboratorio] 
FOREIGN KEY ([Id_Laboratorio]) 
REFERENCES [Laboratorio] ([Id_Laboratorio])
GO
	

ALTER TABLE [Producto]
ADD CONSTRAINT [FK_Presentacion_Producto ]
FOREIGN KEY ([Id_Presentacion]) 
REFERENCES [Presentacion] ([Id_Presentacion])
GO



ALTER TABLE [Compra_Producto]
ADD CONSTRAINT [FK_Compra_Producto_Producto] 
FOREIGN KEY ([Id_Producto])
REFERENCES [Producto] ([Id_Producto])
GO

ALTER TABLE [Compra_Producto]
ADD CONSTRAINT [FK_Compra_Producto_Compra] 
FOREIGN KEY ([Id_Compra])
REFERENCES [Compra] ([Id_Compra])
GO


ALTER TABLE [Producto_Proveedor]
ADD CONSTRAINT FK_Producto_Proveedor_Producto
FOREIGN KEY ([Id_Producto])
REFERENCES [Producto]([Id_Producto])
GO

ALTER TABLE [Producto_Proveedor]
ADD CONSTRAINT FK_Producto_Proveedor_Proveedor
FOREIGN KEY ([Id_Proveedor])
REFERENCES [Proveedor]([Id_Proveedor])
GO



--Procedimientos de Empleado----------------------------------------------------------------------


----Procedimiento para Insertar Empleado-----------------------------------------

CREATE PROCEDURE InsertarEmpleado
(
    @Nombre_1 VARCHAR(32),
    @Nombre_2 VARCHAR(32),
    @Apellido_1 VARCHAR(32),
    @Apellido_2 VARCHAR(32),
    @Numero_Celular VARCHAR(8),
    @Gmail NVARCHAR(50),
    @Direccion VARCHAR(200),
    @Hora_entrada TIME,
    @Hora_salida TIME
)
AS
    INSERT INTO [Empleado] ([Nombre_1], [Nombre_2], [Apellido_1], [Apellido_2], [Numero_Celular], [Gmail], [Direccion], [Hora_Entrada], [Hora_Salida])
    VALUES (@Nombre_1, @Nombre_2, @Apellido_1, @Apellido_2, @Numero_Celular, @Gmail, @Direccion, @Hora_Entrada, @Hora_Salida);
	
 GO

EXEC InsertarEmpleado @Nombre_1 = 'Juan', @Nombre_2 = 'Pérez', @Apellido_1 = 'Gómez', @Apellido_2 = 'López', @Numero_Celular = '98765432', @Gmail = 'juanperez@example.com', @Direccion = '456 Calle Principal',
    @Hora_Entrada = '09:00:00', @Hora_Salida = '18:00:00';


SELECT *FROM [Empleado]
GO


---Procedimiento para Actualizar Empleado-----------------------------------------------------------

CREATE PROCEDURE ActualizarEmpleado
(
    @Id_Empleado INT,
    @Nombre_1 VARCHAR(32),
    @Nombre_2 VARCHAR(32),
    @Apellido_1 VARCHAR(32),
    @Apellido_2 VARCHAR(32),
    @Numero_Celular VARCHAR(8),
    @Gmail NVARCHAR(50),
    @Direccion VARCHAR(200),
    @Hora_Entrada TIME,
    @Hora_Salida TIME
)
AS
    UPDATE [Empleado]
    SET
        [Nombre_1] = @Nombre_1,
        [Nombre_2] = @Nombre_2,
        [Apellido_1] = @Apellido_1,
        [Apellido_2] = @Apellido_2,
        [Numero_Celular] = @Numero_Celular,
        [Gmail] = @Gmail,
        [Direccion] = @Direccion,
        [Hora_Entrada] = @Hora_Entrada,
        [hora_salida] = @Hora_Salida
    WHERE
        [Id_Empleado] = @Id_Empleado
GO 

EXEC ActualizarEmpleado @Id_Empleado = 1,  @Nombre_1 = 'Pedro', @Nombre_2 = 'González',  @Apellido_1 = 'Ramírez', @Apellido_2 = 'Martínez', 
    @Numero_Celular = '12345678', @Gmail = 'pedrogonzalez@example.com', @Direccion = '789 Calle Secundaria', @Hora_Entrada = '10:00:00',
    @Hora_Salida = '19:00:00'; 

GO

SELECT * FROM Empleado
GO

---Procedimiento para Buscar Empleado-----------------------------------------------

CREATE PROCEDURE BuscarEmpleado
(
    @Id_Empleado INT = NULL,
    @Nombre_1 VARCHAR(32) = NULL,
    @Nombre_2 VARCHAR(32) = NULL,
    @Apellido_1 VARCHAR(32) = NULL,
    @Apellido_2 VARCHAR(32) = NULL
)
AS
	SELECT *
    FROM [Empleado]
   WHERE (@Id_Empleado IS NULL OR [Id_Empleado] = @Id_Empleado)
        OR (@Nombre_1 IS NULL OR TRIM([Nombre_1]) LIKE '%' + TRIM(@Nombre_1) + '%')
        OR (@Nombre_2 IS NULL OR TRIM([Nombre_2]) LIKE '%' + TRIM(@Nombre_2) + '%')
        OR (@Apellido_1 IS NULL OR TRIM([Apellido_1]) LIKE '%' + TRIM(@Apellido_1) + '%')
        OR (@Apellido_2 IS NULL OR TRIM([Apellido_2]) LIKE '%' + TRIM(@Apellido_2) + '%'); 
 GO

  EXEC BuscarEmpleado @Id_Empleado = 1, @Nombre_1 = 'Juan', @Nombre_2 = 'Carlos', @Apellido_1 = 'Ga', @Apellido_2 = 'L'



 EXEC BuscarEmpleado @Id_Empleado = 2
 GO

EXEC BuscarEmpleado 2;

GO

---Procedimiento para consulta toda la tabla de empleado----------------------------------------------------------------------------
CREATE PROCEDURE ConsultarDatosEmpleado
AS
    SELECT [Id_Empleado], [Nombre_1], [Nombre_2], [Apellido_1], [Apellido_2], [Numero_Celular], [Gmail], [Direccion], [Hora_Entrada], [Hora_Salida]
    FROM [Empleado];
GO


----Procedimiento para Eliminar Empleado-------------------------------------------------------------

CREATE PROCEDURE EliminarEmpleado
(
    @Id_Empleado INT
)
AS
    DELETE FROM [Empleado]
    WHERE [Id_Empleado] = @Id_Empleado
Go

EXEC EliminarEmpleado 
    @Id_Empleado = 2; 
	
GO

SELECT * FROM Empleado

GO















--Procedimientos de Cliente--------------------------------------------------------------------------------------------------------------



---Procedimiento para Insertar Cliente---------------------------------------------
CREATE PROCEDURE InsertarCliente
(
    @Nombre_1 VARCHAR(32),
    @Nombre_2 VARCHAR(32),
    @Apellido_1 VARCHAR(32),
    @Apellido_2 VARCHAR(32),
    @Numero_Celular VARCHAR(8),
    @Direccion VARCHAR(200)
)
AS
    INSERT INTO [Cliente] ([Nombre_1],[Nombre_2],[Apellido_1],[Apellido_2],[Numero_Celular],[Direccion])
    VALUES (@Nombre_1,@Nombre_2,@Apellido_1,@Apellido_2,@Numero_Celular,@Direccion)
GO

EXEC InsertarCliente 'Juan', 'Carlos', 'García', 'López', '12345678', 'Calle Principal 123'
GO

SELECT *FROM [Cliente]

GO


----Procedimiento para Actualizar Cliente----------------------------------------------------------

CREATE PROCEDURE ActualizarCliente
(
    @Id_Cliente INT,
    @Nombre_1 VARCHAR(32),
    @Nombre_2 VARCHAR(32),
    @Apellido_1 VARCHAR(32),
    @Apellido_2 VARCHAR(32),
    @Numero_Celular VARCHAR(8),
    @Direccion VARCHAR(200)
)
AS
    UPDATE [Cliente]
    SET [Nombre_1] = @Nombre_1,
        [Nombre_2] = @Nombre_2,
        [Apellido_1] = @Apellido_1,
        [Apellido_2] = @Apellido_2,
        [Numero_Celular] = @Numero_Celular,
        [Direccion] = @Direccion
    WHERE [Id_Cliente] = @Id_Cliente
GO

EXEC ActualizarCliente 1, 'Pedro', 'Pablo', 'Sánchez', 'Martínez', '87654321', 'Avenida Central 456'
GO

Select * FROM Cliente
 GO


---Procedimiento para Buscar Cliente-----------------------------------------------------------

CREATE PROCEDURE BuscarCliente
  @Id_Cliente INT,
  @Nombre_1 VARCHAR(32),
  @Nombre_2 VARCHAR(32),
  @Apellido_1 VARCHAR(32),
  @Apellido_2 VARCHAR(32)
AS
  SELECT * 
  FROM [Cliente]
   WHERE ([Id_Cliente] = @Id_Cliente OR @Id_Cliente IS NULL)
        OR (@Nombre_1 IS NULL OR TRIM([Nombre_1]) LIKE '%' + TRIM(@Nombre_1) + '%')
        OR (@Nombre_2 IS NULL OR TRIM([Nombre_2]) LIKE '%' + TRIM(@Nombre_2) + '%')
        OR (@Apellido_1 IS NULL OR TRIM([Apellido_1]) LIKE '%' + TRIM(@Apellido_1) + '%')
        OR (@Apellido_2 IS NULL OR TRIM([Apellido_2]) LIKE '%' + TRIM(@Apellido_2) + '%');

 GO

 EXEC BuscarCliente @Id_cliente = 1, @Nombre_1 = 'Juan', @Nombre_2 = 'Carlos', @Apellido_1 = 'Ga', @Apellido_2 = 'L'
 GO

----Procedimiento para consulta toda la tabla de Cliente----------------------------------------------------

CREATE PROCEDURE ConsultarDatosCliente
AS
    SELECT [Id_Cliente], [Nombre_1], [Nombre_2], [Apellido_1], [Apellido_2], [Numero_Celular], [Direccion]
    FROM Cliente;
GO



----Procedimiento para Eliminar Cliente---------------------------------------------------------------

CREATE PROCEDURE EliminarCliente
(
    @Id_Cliente INT
)
AS
    DELETE FROM [Cliente]
    WHERE[Id_Cliente] = @Id_Cliente
GO

EXEC EliminarCliente 2
Go

Select * From Cliente
GO













--Procedimientos de Venta-----------------------------------------------------------------------------------


----Procedimiento para Insertar Venta-----------------------------------------------------------

CREATE PROCEDURE InsertarVenta
(
    @Fecha_Hora DATETIME,
    @Id_Cliente INT,
    @Id_Empleado INT
)
AS
    INSERT INTO [Venta] ([Fecha_Hora],[Id_Cliente],[Id_Empleado])
    VALUES (@Fecha_Hora,@Id_Cliente,@Id_Empleado)
GO

EXEC InsertarVenta @Fecha_Hora = '2023-05-22 10:00:00', @Id_Cliente = 1, @Id_Empleado = 1
GO

Select * FROM Venta

GO

----Procedimiento para ActualizarVentas--------------------------------------------------------------

CREATE PROCEDURE ActualizarVenta
(
    @Id_Venta INT,
    @Fecha_Hora DATETIME
)
AS
    UPDATE [Venta]
    SET[Fecha_Hora] = @Fecha_Hora
    WHERE [Id_Venta] = @Id_Venta
GO

EXEC ActualizarVenta @Id_Venta = 1, @Fecha_Hora = '2023-05-22 11:00:00'
GO

SELECT * FROM Venta

GO

---Procedimiento para BuscarVenta---------------------------------

CREATE PROCEDURE BuscarVenta
(
    @Id_Venta INT
)
AS
    SELECT *
    FROM [Venta]
    WHERE [Id_Venta] = @Id_Venta
GO

EXEC BuscarVenta @Id_Venta = 1
GO

---Procedimiento para consultar tabla venta --------------------------------------------------------

CREATE PROCEDURE ConsultarDatosVenta
AS
    SELECT [Id_Venta], [Fecha_Hora], [Id_Cliente], [Id_Empleado]
    FROM Venta;
GO


---Procedimiento para EliminarVenta-------------------------------------------------

CREATE PROCEDURE EliminarVenta
(
    @Id_Venta INT
)
AS

    DELETE FROM [Venta]
    WHERE[Id_Venta] = @Id_Venta
GO

EXEC EliminarVenta @Id_Venta = 2


SELECT * FROM Venta
GO













--Procedimientos de presentaciones -----------------------------------------------------------



---Procedimiento de InsertarPresentacion----------------------------------------

CREATE PROCEDURE InsertarPresentacion
(
    @Nombre_Presentacion VARCHAR(50),
    @Detalle VARCHAR(70)
)
AS
    INSERT INTO [Presentacion] ([Nombre_Presentacion],[Detalle])
    VALUES (@Nombre_Presentacion,@Detalle)
GO

EXEC InsertarPresentacion @Nombre_Presentacion = 'Capsula', @Detalle = 'Solida'
GO 

Select * FROM Presentacion

GO

---Procedimiento de ActualizarPresentacion----------------------------------------------------------

CREATE PROCEDURE ActualizarPresentacion
(
    @Id_Presentacion INT,
    @Nombre_Presentacion VARCHAR(50),
    @Detalle VARCHAR(70)
)
AS
    UPDATE [Presentacion]
    SET[Nombre_Presentacion] = @Nombre_Presentacion,
       [Detalle] = @Detalle
    WHERE[Id_Presentacion] = @Id_Presentacion
GO

EXEC ActualizarPresentacion @Id_Presentacion = 1, @Nombre_Presentacion = 'Enpoya', @Detalle = '12 kg'
GO

SELECT * FROM Presentacion
GO



---Procedimiento de BuscarProducto------------------------------------------------

CREATE PROCEDURE BuscarPresentacion
(
    @Id_Presentacion INT = NULL,
    @Nombre_Presentacion VARCHAR(50) = NULL,
    @Detalle VARCHAR(70) = NULL
)
AS

    SELECT *
    FROM Presentacion
    WHERE 
        ([Id_Presentacion] = @Id_Presentacion OR @Id_Presentacion IS NULL)
        OR (TRIM([Nombre_Presentacion]) LIKE '%' + TRIM(@Nombre_Presentacion) + '%' OR @Nombre_Presentacion IS NULL)
        OR (TRIM([Detalle]) LIKE '%' + TRIM(@Detalle) + '%' OR @Detalle IS NULL);
GO

EXEC BuscarPresentacion @Id_Presentacion = 1, @Nombre_Presentacion = 'E', @Detalle = '1'
GO

------------------------------------------------------------------------

CREATE PROCEDURE ConsultarDatosPresentacion
AS
    SELECT [Id_Presentacion], [Nombre_Presentacion], [Detalle]
    FROM Presentacion;
GO

SELECT * FROM Presentacion
GO


---Procedimiento de Eliminarpresentacion---------------------------------------------------

CREATE PROCEDURE EliminarPresentacion
(
    @Id_Presentacion INT
)
AS
    DELETE FROM [Presentacion]
    WHERE[Id_Presentacion] = @Id_Presentacion
GO

EXEC EliminarPresentacion @Id_Presentacion = 2
GO

SELECT * FROM Presentacion
GO












--Procedimientos de Categoria-----------------------------------------------------------------------


---Procedimiento de InsertarCategoria---------------------------------------------

CREATE PROCEDURE InsertarCategoria
(

    @Nombre_Categoria VARCHAR(50),
    @Descripcion VARCHAR(70)
   
)
AS
    INSERT INTO [Categoria] ([Nombre_Categoria],[Descripcion])
    VALUES (@Nombre_Categoria,@Descripcion)
GO

EXEC InsertarCategoria 'Vacuna', 'Para calmar el dolor de muela'
GO

Select * FROM Categoria
GO
---Procedimiento almacenado de ActualizarCategoria---------------------------------------------------

CREATE PROCEDURE ActualizarCategoria
(
    @Id_Categoria INT,
	@Nombre_Categoria VARCHAR(50),
    @Descripcion VARCHAR(70)
    
)
AS
    UPDATE [Categoria]
    SET   [Nombre_Categoria] = @Nombre_Categoria,
	      [Descripcion] = @Descripcion  
    WHERE [Id_Categoria] = @Id_Categoria
GO

EXEC ActualizarCategoria 1, 'Vacuna', 'Para el dolor de hueso'
GO

SELECT * FROM Categoria
GO


---Procedimiento de BuscarCategoria------------------------------------------------

CREATE PROCEDURE BuscarCategoria
(
    @Id_Categoria INT = NULL,
    @Nombre_Categoria VARCHAR(50) = NULL,
    @Descripcion VARCHAR(70) = NULL
)
AS


    SELECT *
    FROM [Categoria]
    WHERE 
        ([Id_Categoria] = @Id_Categoria OR @Id_Categoria IS NULL)
        OR (TRIM([Nombre_Categoria]) LIKE '%' + TRIM(@Nombre_Categoria) + '%' OR @Nombre_Categoria IS NULL)
        OR (TRIM([Descripcion]) LIKE '%' + TRIM(@Descripcion) + '%' OR @Descripcion IS NULL);


GO

EXEC BuscarCategoria @Id_Categoria = 1, @Nombre_Categoria = 'V', @Descripcion = 'P'
GO

SELECT * FROM Categoria
GO



------------------------------------------------------------------------------------------------

CREATE PROCEDURE ConsultarDatosCategoria
AS
    SELECT [Id_Categoria],[Nombre_Categoria], [Descripcion]
    FROM Categoria;
GO


----Procedimiento almacenado de EliminarCategoria-------------------------------------------

CREATE PROCEDURE EliminarCategoria
(
    @Id_Categoria INT
)
AS
    DELETE FROM [Categoria]
    WHERE[Id_Categoria] = @Id_Categoria
GO

EXEC EliminarCategoria @Id_Categoria = 2
GO

SELECT * FROM Categoria
GO














--Procedimientos de laboratorio --------------------------------------------------


---Procedimiento de InsertarLaboratorio------------------------------------------------------

CREATE PROCEDURE InsertarLaboratorio
(
    @Nombre VARCHAR(50)
)
AS
    INSERT INTO [Laboratorio] ([Nombre])
    VALUES (@Nombre)
GO

EXEC InsertarLaboratorio 'Ramos'
GO

SELECT * FROM Laboratorio
GO

----Procedimiento de ActualizarLaboratorio-------------------------------------------------------

CREATE PROCEDURE ActualizarLaboratorio
(
    @Id_Laboratorio INT,
    @Nombre VARCHAR(50)
)
AS
    UPDATE [Laboratorio]
    SET[Nombre] = @Nombre
    WHERE[Id_Laboratorio] = @Id_Laboratorio
GO

EXEC ActualizarLaboratorio @Id_Laboratorio = 1, @Nombre = 'Nueva Esperanza'
GO

SELECT * FROM Laboratorio
GO


---Procedimiento para BuscarLaboratorio---------------------------------
CREATE PROCEDURE BuscarLaboratorio
(
    @Id_Laboratorio INT
)
AS
    SELECT *
    FROM [Laboratorio]
    WHERE [Id_Laboratorio] = @Id_Laboratorio
GO

EXEC BuscarLaboratorio @Id_Laboratorio = 1
GO

--Procedimiento para Consultar tabla laboratorio ------------------------------------------------
CREATE PROCEDURE ConsultarDatosLaboratorio
AS
    SELECT [Id_Laboratorio], [Nombre]
    FROM Laboratorio;
GO



----Procedimiento de EliminarLaboratorio-------------------------------------------------------

CREATE PROCEDURE EliminarLaboratorio
(
    @Id_Laboratorio INT
)
AS
    DELETE FROM [Laboratorio]
    WHERE [Id_Laboratorio] = @Id_Laboratorio
GO

EXEC EliminarLaboratorio @Id_Laboratorio = 2
GO

SELECT * FROM Laboratorio
GO












--Procedimientos de producto----------------------------------------


---Procedimiento de InsertarProducto------------------------------------------------

CREATE PROCEDURE InsertarProducto
(
    @Nombre VARCHAR(50),
    @Descripcion VARCHAR(200),
    @Cantidad_Producto INT,
    @Precio_Compra DECIMAL(8,2),
    @Precio_Venta DECIMAL(8,2),
    @Imagen_Producto IMAGE,
    @Fecha_Caducidad DATE,
    @Id_Categoria INT,
    @Id_Presentacion INT,
    @Id_Laboratorio INT
)
AS
    INSERT INTO [Producto] ([Nombre], [Descripcion], [Cantidad_Producto], [Precio_Compra], [Precio_Venta], [Imagen_Producto], [Fecha_Caducidad], [Id_Categoria], [Id_Presentacion], [Id_Laboratorio])
    VALUES (@Nombre, @Descripcion, @Cantidad_Producto, @Precio_Compra, @Precio_Venta, @Imagen_Producto, @Fecha_Caducidad, @Id_Categoria, @Id_Presentacion, @Id_Laboratorio)
GO

EXEC InsertarProducto 'Acetominofen', 'Para la calentura', 10, 10.99, 19.99, NULL, '2023-05-22', 1, 1,1
GO

SELECT * FROM [Producto]
GO

---Procedimiento de ActualizarProducto---------------------------------------------------------

CREATE PROCEDURE ActualizarProducto
(
    @Id_Producto INT,
    @Nombre VARCHAR(50),
    @Descripcion VARCHAR(200),
    @Cantidad_Producto INT,
    @Precio_Compra DECIMAL(8,2),
    @Precio_Venta DECIMAL(8,2),
    @Imagen_Producto IMAGE,
    @Fecha_Caducidad DATE,
    @Id_Categoria INT,
    @Id_Presentacion INT,
    @Id_Laboratorio INT
)
AS
    UPDATE [Producto]
    SET [Nombre] = @Nombre,
        [Descripcion] = @Descripcion,
        [Cantidad_Producto] = @Cantidad_Producto,
        [Precio_Compra] = @Precio_Compra,
        [Precio_Venta] = @Precio_Venta,
        [Imagen_Producto] = @Imagen_Producto,
        [Fecha_Caducidad] = @Fecha_Caducidad,
        [Id_Categoria] = @Id_Categoria,
        [Id_Presentacion] = @Id_Presentacion,
        [Id_Laboratorio] = @Id_Laboratorio
    WHERE [Id_Producto] = @Id_Producto
GO

EXEC ActualizarProducto 1, 'Dolofin', 'Para el dolor', 15, 12.99, 22.99, NULL, '2023-05-23', 1, 1,1
GO

SELECT * FROM [Producto]
GO


---Procedimiento de BuscarProducto----------------------------------------------------

CREATE PROCEDURE BuscarProducto
(
    @Id_Producto INT = NULL,
    @Nombre VARCHAR(50) = NULL,
    @Descripcion VARCHAR(200) = NULL
)
AS
    SELECT *
    FROM [Producto]
    WHERE 
        (@Id_Producto IS NULL OR [Id_Producto] = @Id_Producto)
        OR (@Nombre IS NULL OR TRIM([Nombre]) LIKE '%' + @Nombre + '%')
        OR (@Descripcion IS NULL OR TRIM([Descripcion]) LIKE '%' + @Descripcion + '%');
GO


EXEC BuscarProducto 2
GO

SELECT * FROM [Producto]
GO

---Procedimiento de ConsultarDatosProducto----------------------------------------------------

CREATE PROCEDURE ConsultarDatosProducto
AS
    SELECT [Id_Producto], [Nombre], [Descripcion], [Cantidad_Producto], [Precio_Compra], [Precio_Venta], [Imagen_Producto], [Fecha_Caducidad], [Id_Categoria], [Id_Presentacion], [Id_Laboratorio]
    FROM [Producto]
GO


---Procedimiento de EliminarProducto-------------------------------------------------------------------

CREATE PROCEDURE EliminarProducto
(
    @Id_Producto INT
)
AS
    DELETE FROM [Producto]
    WHERE [Id_Producto] = @Id_Producto
GO

EXEC EliminarProducto 3
GO

SELECT * FROM [Producto]
GO











-- Procedimientos de Proveedor -----------------------------------------------------------------------------------



-----Procedimiento para InsertarProveedor------------------------------------------------------------

CREATE PROCEDURE InsertarProveedor
(
    @Nombre_1 VARCHAR(32),
    @Nombre_2 VARCHAR(32),
    @Apellido_1 VARCHAR(32),
    @Apellido_2 VARCHAR(32),
    @Gmail NVARCHAR(50),
    @Numero_Celular VARCHAR(8),
    @Direccion VARCHAR(200)
)
AS
    INSERT INTO [Proveedor] ([Nombre_1],[Nombre_2],[Apellido_1],[Apellido_2],[Gmail],[Numero_Celular],[Direccion])
    VALUES (@Nombre_1,@Nombre_2,@Apellido_1,@Apellido_2,@Gmail,@Numero_Celular,@Direccion)
GO

EXEC InsertarProveedor @Nombre_1 = 'Juan', @Nombre_2 = 'Pablo', @Apellido_1 = 'Gómez', @Apellido_2 = 'López', @Gmail = 'juan.pablo@example.com',
   @Numero_Celular = '12345678', @Direccion = 'Calle Principal 123'
GO

SELECT * FROM Proveedor
GO

---Procedimiento para  ActualizarProveedor-------------------------------------------------

CREATE PROCEDURE ActualizarProveedor
(
    @Id_Proveedor INT,
    @Nombre_1 VARCHAR(32),
    @Nombre_2 VARCHAR(32),
    @Apellido_1 VARCHAR(32),
    @Apellido_2 VARCHAR(32),
    @Gmail NVARCHAR(50),
    @Numero_Celular VARCHAR(8),
    @Direccion VARCHAR(200)
)
AS
    UPDATE [Proveedor]
    SET [Nombre_1] = @Nombre_1,
        [Nombre_2] = @Nombre_2,
        [Apellido_1] = @Apellido_1,
        [Apellido_2] = @Apellido_2,
        [Gmail] = @Gmail,
        [Numero_Celular] = @Numero_Celular,
        [Direccion] = @direccion
   WHERE[Id_Proveedor] = @Id_Proveedor
GO

EXEC ActualizarProveedor @Id_Proveedor = 1, @Nombre_1 = 'Pedro', @Nombre_2 = 'Pablo',  @Apellido_1 = 'González', @Apellido_2 = 'López', @Gmail = 'pedro.pablo@example.com',
    @Numero_Celular = '87654321', @Direccion = 'Calle Secundaria 456'
GO

SELECT * FROM Proveedor
GO
----Procedimiento para  BuscarProveedor-------------------------------------------------------
CREATE PROCEDURE BuscarProveedor
(
    @Id_Proveedor INT = NULL,
    @Nombre_1 VARCHAR(32) = NULL,
    @Nombre_2 VARCHAR(32) = NULL,
    @Apellido_1 VARCHAR(32) = NULL,
    @Apellido_2 VARCHAR(32) = NULL
)
AS
    SELECT *
    FROM [Proveedor]
    WHERE 
        (@Id_Proveedor IS NULL OR [Id_Proveedor] = @Id_Proveedor)
        OR (@Nombre_1 IS NULL OR TRIM([Nombre_1]) LIKE '%' + @Nombre_1 + '%')
        OR (@Nombre_2 IS NULL OR TRIM([Nombre_2]) LIKE '%' + @Nombre_2 + '%')
        OR (@Apellido_1 IS NULL OR TRIM([Apellido_1]) LIKE '%' + @Apellido_1 + '%')
        OR (@Apellido_2 IS NULL OR TRIM([Apellido_2]) LIKE '%' + @Apellido_2 + '%');
GO


EXEC BuscarProveedor @Id_Proveedor = 1;
GO

---Procedimiento para consultar tabla Proveedor------------------------------------------------------------------
CREATE PROCEDURE ConsultarDatosProveedor
AS
    SELECT [Id_Proveedor], [Nombre_1], [Nombre_2], [Apellido_1], [Apellido_2], [Gmail], [Numero_Celular], [Direccion]
    FROM Proveedor;
GO



---Procedimiento para  EliminarProveedor-------------------------------------------------------

CREATE PROCEDURE EliminarProveedor
(
    @Id_Proveedor INT
)
AS
    DELETE FROM [Proveedor]
    WHERE[Id_Proveedor] = @Id_Proveedor
GO

EXEC EliminarProveedor @Id_Proveedor = 2;
GO

SELECT * FROM Proveedor
GO












--Pocedimiento de Producto_Proveedor -----------------------------------------------------------------



-- Procedimiento para Insertar Producto_Proveedor--------------------------------------

CREATE PROCEDURE InsertarProductoProveedor
(
    @Id_Proveedor INT,
    @Id_Producto INT
   
   
)
AS
    INSERT INTO [Producto_Proveedor] ([Id_Proveedor],[Id_Producto])
    VALUES (@Id_Proveedor , @Id_Producto)

GO

EXEC InsertarProductoProveedor   @Id_Producto = 2 , @Id_Proveedor = 1 
GO

SELECT * FROM Producto_Proveedor
GO


-- Procedimiento para Actualizar Producto_Proveedor---------------------

CREATE PROCEDURE ActualizarProductoProveedor
(
    @Id_Producto_Proveedor INT,
    @Id_Proveedor INT,
    @Id_Producto INT
)
AS
    UPDATE [Producto_Proveedor]
    SET   [Id_Proveedor] = @Id_Proveedor,
          [Id_Producto] = @Id_Producto
    WHERE [Id_Producto_Proveedor] = @Id_Producto_Proveedor
GO

EXEC ActualizarProductoProveedor @Id_Producto_Proveedor = 1, @Id_Proveedor = 1, @Id_Producto = 2
GO

SELECT * FROM Producto_Proveedor
GO


-- Procedimiento para buscar Producto_Proveedor---------------------------

CREATE PROCEDURE BuscarProductoProveedor
(
    @Id_Producto_Proveedor INT
)
AS
    SELECT *
    FROM [Producto_Proveedor]
    WHERE [Id_Producto_Proveedor] = @Id_Producto_Proveedor
GO

EXEC BuscarProductoProveedor @Id_Producto_Proveedor = 4
GO

SELECT * FROM Producto_Proveedor
GO



-- Procedimiento  consultar Tabla Producto_Proveedor-------------------------------
CREATE PROCEDURE ConsultarTablaProductoProveedor
AS
    SELECT *
    FROM [Producto_Proveedor]
GO

EXEC ConsultarTablaProductoProveedor
GO


-- Procedimiento para  eliminarProducto_Proveedor----------------------------------------------

CREATE PROCEDURE EliminarProductoProveedor
(
    @Id_Producto_Proveedor INT
)
AS
    DELETE FROM [Producto_Proveedor]
    WHERE [Id_Producto_Proveedor] = @Id_Producto_Proveedor
GO

EXEC EliminarProductoProveedor @Id_Producto_Proveedor = 5
GO

SELECT * FROM Producto_Proveedor
GO











--Procedimientos de ventas producto------------------------------------------------------------------------



----Procedimiento para InsertarVentaProducto----------------------------------------------

CREATE PROCEDURE InsertarVentaProducto
(
    @Cantidad INT,
    @Descuento DECIMAL(8,2),
    @Id_Venta INT,
    @Id_Producto INT
)
AS
    INSERT INTO [Venta_Producto] ([cantidad],[descuento],[Id_venta],[Id_Producto])
    VALUES (@cantidad,@descuento,@Id_venta,@Id_Producto)
GO

 EXEC InsertarVentaProducto 10, 0.5, 1, 2
GO

SELECT * FROM Venta_Producto
GO

----Procedimiento para ActualizarVentaProducto------------------------------------------------------------------

CREATE PROCEDURE ActualizarVentaProducto
(
    @Id_Venta_Producto INT,
    @Cantidad INT,
    @Descuento DECIMAL(8,2),
    @Id_Venta INT,
    @Id_Producto INT
)
AS
    UPDATE [Venta_Producto]
    SET [Cantidad] = @Cantidad,
        [Descuento] = @Descuento,
        [Id_Venta] = @Id_Venta,
        [Id_Producto] = @Id_Producto
    WHERE[Id_Venta_Producto] = @Id_Venta_Producto
GO

EXEC ActualizarVentaProducto 1, 5, 14.2, 1, 2
GO 

SELECT * FROM Venta_Producto
GO

-----Procedimiento para BuscarVentaProducto--------------------------------------------------------------------------

CREATE PROCEDURE BuscarVentaProducto
(
    @Id_Venta_Producto INT
)
AS
    SELECT *
    FROM [Venta_Producto]
    WHERE [Id_Venta_Producto] = @Id_Venta_Producto
GO

EXEC BuscarVentaProducto @Id_Venta_Producto= 1
GO 

SELECT * FROM Venta_Producto
GO

---Procedimiento para consultar tabla Venta Producto-------------------------------------------------------------------


CREATE PROCEDURE ConsultarDatosVentaProducto
AS
    SELECT [Id_Venta_Producto], [cantidad], [descuento], [Id_venta], [Id_Producto]
    FROM Venta_Producto;
GO



---Procedimiento para EliminarVentaProducto------------------------------------------------------------------

CREATE PROCEDURE EliminarVentaProducto
(
    @Id_Venta_Producto INT
)
AS
    DELETE FROM [Venta_Producto]
    WHERE[Id_Venta_Producto] = @Id_Venta_Producto
GO

EXEC EliminarVentaProducto 2
GO 

SELECT * FROM Venta_Producto
GO















--Procedimientos de compra--------------------------------------------------------------------------------------------



---Procedimiento para InsertarCompra-----------------------------------------------------

CREATE PROCEDURE InsertarCompra 
  @Fecha_Compra DATE,
  @Id_Proveedor INT
AS
  INSERT INTO Compra (fecha_compra, Id_Proveedor)
  VALUES (@Fecha_Compra, @Id_Proveedor)
GO

EXEC InsertarCompra @Fecha_Compra = '2023-05-22', @Id_Proveedor = 1
GO

SELECT * FROM Compra
GO


--Procedimiento para  ActualizarCompra----------------------------------------------------------------

CREATE PROCEDURE ActualizarCompra
  @Id_Compra INT,
  @Fecha_Compra DATE,
  @Id_Proveedor INT
AS
  UPDATE [Compra]
  SET fecha_compra = @Fecha_Compra, Id_proveedor = @Id_Proveedor
  WHERE Id_Compra = @Id_Compra
GO

EXEC ActualizarCompra 1, '2023-05-23',1
GO

SELECT * FROM Compra
GO

 

--Procedimiento para BuscarCompra----------------------------------------------------------------

CREATE PROCEDURE BuscarCompra
  @Id_Compra INT
AS
  SELECT *
  FROM Compra
  WHERE Id_Compra = @Id_Compra
GO

EXEC BuscarCompra 1
GO

SELECT * FROM Compra
GO

--Procedimiento para Consultar tabla compra ---------------------------------------------------------------

CREATE PROCEDURE ConsultarDatosCompra
AS
    SELECT [Id_compra], [Fecha_Compra], [Id_Proveedor]
    FROM Compra;
GO


----Procedimiento de EliminarCompra---------------------------------------------------------------------------
CREATE PROCEDURE EliminarCompra
  @Id_Compra INT
AS
  DELETE FROM Compra
  WHERE Id_compra = @Id_Compra
GO

EXEC EliminarCompra 2
GO 

SELECT * FROM Compra
GO 











--Procedimientos Compra Producto




---Procedimiento de InsertarCompraProducto---------------------------------------------------

CREATE PROCEDURE InsertarCompraProducto
  @Id_Compra INT,
  @Id_Producto INT
AS
  INSERT INTO Compra_Producto (Id_compra, Id_Producto)
  VALUES (@Id_Compra, @Id_Producto)
GO

EXEC InsertarCompraProducto 1,2
GO

SELECT * FROM Compra_Producto
GO


----Procedimiento de ActualizarCompraProducto------------------------------------------------------

CREATE PROCEDURE ActualizarCompraProducto
  @Id_Compra_Producto INT,
  @Id_Compra INT,
  @Id_Producto INT
AS
  UPDATE [Compra_Producto]
  SET Id_compra = @Id_Compra, Id_Producto = @Id_Producto
  WHERE Id_Compra_Producto = @Id_Compra_Producto
GO

EXEC ActualizarCompraProducto 1, 1, 2
GO 

SELECT * FROM Compra_Producto
GO



---Procedimiento de BuscarCompraProducto--------------------------------------------------------------
CREATE PROCEDURE BuscarCompraProducto
  @Id_Compra_Producto INT
AS
  SELECT *
  FROM Compra_Producto
  WHERE Id_Compra_Producto = @Id_Compra_Producto
GO

EXEC BuscarCompraProducto 1
GO

------------------------------------------------------------------------------

CREATE PROCEDURE ConsultarDatosCompraProducto
AS
    SELECT [Id_Compra_Producto], [Id_Compra], [Id_Producto]
    FROM Compra_Producto;
GO



---Procedimiento de EliminarCompraProducto------------------------------------------------------------

CREATE PROCEDURE EliminarCompraProducto
  @Id_Compra_Producto INT
AS
  DELETE FROM Compra_Producto
  WHERE Id_Compra_Producto = @Id_Compra_Producto
GO

EXEC EliminarCompraProducto 2
GO

SELECT * FROM Compra_Producto
GO