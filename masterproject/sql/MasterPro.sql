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
  Num_Tarjeta INT NOT NULL,
  PRIMARY KEY (IdClasica),
  FOREIGN KEY (Num_Tarjeta) REFERENCES Tarjetas_de_credito(Num_Tarjeta)
);

CREATE TABLE Tarjeta_Oro
(
  IdOro INT NOT NULL,
  Num_Tarjeta INT NOT NULL,
  PRIMARY KEY (IdOro),
  FOREIGN KEY (Num_Tarjeta) REFERENCES Tarjetas_de_credito(Num_Tarjeta)
);

CREATE TABLE Tarjeta_Platino
(
  IdPlatino INT NOT NULL,
  Num_Tarjeta INT NOT NULL,
  PRIMARY KEY (IdPlatino),
  FOREIGN KEY (Num_Tarjeta) REFERENCES Tarjetas_de_credito(Num_Tarjeta)
);

CREATE TABLE Administrador
(
  ID_Admin INT NOT NULL,
  Nombre VARCHAR(64) NOT NULL,
  Direccion VARCHAR(50) NOT NULL,
  Telefono VARCHAR(10) NOT NULL,
  Correo VARCHAR(50) NOT NULL,
  Fecha_Registro INT NOT NULL,
  PRIMARY KEY (ID_Admin)
);

CREATE TABLE Gestiona
(
  Num_Tarjeta INT NOT NULL,
  ID_Admin INT NOT NULL,
  PRIMARY KEY (Num_Tarjeta, ID_Admin),
  FOREIGN KEY (Num_Tarjeta) REFERENCES Tarjetas_de_credito(Num_Tarjeta),
  FOREIGN KEY (ID_Admin) REFERENCES Administrador(ID_Admin)
);

CREATE TABLE Clientes_Otros_datos
(
  Otros_datos VARCHAR(100) NOT NULL,
  ID_Cliente INT NOT NULL,
  PRIMARY KEY (Otros_datos, ID_Cliente),
  FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);