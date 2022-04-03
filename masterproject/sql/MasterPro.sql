create database Banco;
use Banco;
CREATE TABLE Clientes
(
  Nombre VARCHAR(64) NOT NULL,
  Usuario VARCHAR(50) NOT NULL,
  Contrasena VARCHAR(20) NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Telefono VARCHAR(10) NOT NULL,
  Correo VARCHAR(50) NOT NULL,
  Id_Cliente INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (Id_Cliente)
);

CREATE TABLE Tarjetas_de_credito
(
  Id_TarjetaCredito INT NOT NULL,
  Num_Tarjeta INT NOT NULL,
  Fecha_Expiracion DATE NOT NULL,
  CVV INT NOT NULL,
  Id_Cliente INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (Id_TarjetaCredito),
  FOREIGN KEY (Id_Cliente) REFERENCES Clientes(Id_Cliente),
  UNIQUE (Id_TarjetaCredito),
  UNIQUE (Fecha_Expiracion),
  UNIQUE (CVV)
);

CREATE TABLE Tarjeta_Clasica
(
  IdClasica INT NOT NULL,
  Id_TarjetaCredito INT NOT NULL,
  PRIMARY KEY (IdClasica),
  FOREIGN KEY (Id_TarjetaCredito) REFERENCES Tarjetas_de_credito(Id_TarjetaCredito)
);

CREATE TABLE Tarjeta_Oro
(
  IdOro INT NOT NULL,
  Id_TarjetaCredito INT NOT NULL,
  PRIMARY KEY (IdOro),
  FOREIGN KEY (Id_TarjetaCredito) REFERENCES Tarjetas_de_credito(Id_TarjetaCredito)
);

CREATE TABLE Tarjeta_Platino
(
  IdPlatino INT NOT NULL,
  Id_TarjetaCredito INT NOT NULL,
  PRIMARY KEY (IdPlatino),
  FOREIGN KEY (Id_TarjetaCredito) REFERENCES Tarjetas_de_credito(Id_TarjetaCredito)
);

CREATE TABLE Administrador
(
  Id_Admin INT NOT NULL,
  Nombre VARCHAR(64) NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Telefono VARCHAR(10) NOT NULL,
  Correo VARCHAR(50) NOT NULL,
  Fecha_Registro DATE NOT NULL,
  PRIMARY KEY (Id_Admin)
);

CREATE TABLE Gestiona
(
  Tarjetas_de_credito_Id_TarjetaCredito INT NOT NULL,
  Administrador_Id_Admin INT NOT NULL,
  PRIMARY KEY (Tarjetas_de_credito_Id_TarjetaCredito, Administrador_Id_Admin),
  FOREIGN KEY (Tarjetas_de_credito_Id_TarjetaCredito) 
  REFERENCES Tarjetas_de_credito (Id_TarjetaCredito),
  FOREIGN KEY (Administrador_Id_admin) REFERENCES Administrador (Id_Admin)
)