create schema carro;

use carro;

create table pessoas(
 idPessoa int primary key auto_increment,
		nome varchar(60),
        cpf varchar (14) not null unique,
        endereco varchar(60),
        telefone varchar(11)
);

create	table	carros(
	idCarro int PRIMARY key auto_increment,
	 placa varchar(7) not null,
	 marca varchar (30),
     modelo varchar (30),
	 anoFab int (4) #check(anoMod >= anoFab or anoMod - anoFab = 1),
	 anoMod int (4),
	 cor varchar (30),
	 tpCambio varchar(30),
	 combustivel varchar (30),
     proprietario int,
     foreign key (proprietario) references pessoa(idPessoa)
);
       
        