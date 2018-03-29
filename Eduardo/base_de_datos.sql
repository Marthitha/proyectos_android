create database login;
	use login;
	create table registros(
		nombre varchar (255) not null,
		apellidop varchar (255) not null,
		apellidom varchar (255) not null,
		email varchar (255) not null,
		passwor varchar(255) not null
		)Engine InnoDB default charset=latin1;

	create table admin(
		nombre varchar (255) not null,
		passwor varchar(255) not null
		)Engine InnoDB default charset=latin1;