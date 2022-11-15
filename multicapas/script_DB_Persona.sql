create database crudPersona;

use crudPersona;

create table persona(

    ocupacion varchar(50) not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    telefono varchar(50) not null,
    tipodedocumento varchar(50) not null,
    numerodedocumento varchar(50) not null,
    ciudad varchar(50) not null
    
);