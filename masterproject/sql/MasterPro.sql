create database Banco;
use Banco;
CREATE TABLE Clientes
(
  Nombre VARCHAR(64) NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Telefono VARCHAR(10) NOT NULL,
  Correo VARCHAR(50) NOT NULL,
  ID_Cliente INT NOT NULL,
  PRIMARY KEY (ID_Cliente)
);

CREATE TABLE Tarjetas_de_credito
(
  Num_Tarjeta INT NOT NULL,
  Id_TarjetaCredito INT NOT NULL,
  Fecha_Expiracion DATE NOT NULL,
  CVV INT NOT NULL,
  ID_Cliente INT NOT NULL,
  PRIMARY KEY (Num_Tarjeta),
  FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente),
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
  ID_Admin INT NOT NULL,
  Nombre VARCHAR(64) NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Telefono VARCHAR(10) NOT NULL,
  Correo VARCHAR(50) NOT NULL,
  Fecha_Registro DATE NOT NULL,
  PRIMARY KEY (ID_Admin)
);