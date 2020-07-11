create database proyecto;
use proyecto;

create table Proveedor(idproveedor int KEY AUTO_INCREMENT, NombreProveedor varchar(20), DirProveedor Varchar(20),
TelfProveedor int(15));

create table Insumo(idInsumo int KEY AUTO_INCREMENT, nombreInsumo varchar(20), cantidadInsumo float(20),
unidadMedida varchar(20));

create table Mesa(idMesa int(2) primary key, CantComensales int(10), Ubicacion Varchar(15));

create table cliente(idCliente int(8) primary key, Nombre varchar(20),ApePaterno varchar(15),
ApeMaterno varchar(15), telefono int(9));

create table Personal(idpersonal varchar(10) primary key, NombrePersonal Varchar (20), apellidoPers varchar(20),
 TelfPersonal Varchar(15), turno varchar(25));

create table Plato(idplato int  key auto_increment, PrecioPlato float(5),NombrePlato Varchar(20),
idpersonal varchar(10),
foreign key (idpersonal) references Personal(idpersonal));

create table InsumoPlato(idInsumoPlato int KEY AUTO_INCREMENT, idInsumo int not null, idplato int not null,
cantInsumoUsado varchar(20),
foreign key (idInsumo) references Insumo(idInsumo),
foreign key (idplato) references Plato(idplato));

create table ProveedorInsumo(idProveedorInsumo varchar(10) primary key, idProveedor int not null,
idInsumo int not null, PrecioInsumo float(15),
foreign key (idProveedor) references Proveedor(idProveedor),
foreign key (idInsumo) references Insumo(idInsumo));

create table pedido(idpedido varchar(10) primary key, idcliente int not null, idmesa int not null,
FechaPedido Date,
foreign key (idcliente) references cliente(idcliente),
foreign key (idmesa) references mesa(idmesa));

create table Recibo(idRecibo varchar(10) primary key, subtotal float(8), IGV float(8), 
total float(10), idpedido varchar(10),
foreign key (idpedido) references pedido(idpedido));

create table PlatoPedido(idPlatoPedido int key auto_increment, idpedido varchar(10), 
idplato int not null,
foreign key (idpedido) references pedido(idpedido),
foreign key (idplato) references plato(idplato));

create table usuario(idUsuario int primary key auto_increment, Nombre varchar(20));



