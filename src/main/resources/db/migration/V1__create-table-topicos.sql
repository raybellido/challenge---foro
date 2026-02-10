create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(255) not null unique,
    autor varchar(100) not null,
    curso varchar(12) not null,
    status varchar(100) not null,
    fecha_de_creacion datetime not null,

   primary key(id)
);