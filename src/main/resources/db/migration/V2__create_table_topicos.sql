
create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(300) not null unique,
    fecha datetime not null,
    estatus boolean not null,
    autor_id bigint not null,
    curso varchar(100) not null,
    primary key (id)


);