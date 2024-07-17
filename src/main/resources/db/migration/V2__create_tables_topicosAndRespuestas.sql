create table respuestas(
    id bigint not null auto_increment,
    message varchar(300) not null,
    fecha datetime not null,
    solucion boolean not null,
    topic_id bigint not null,
    autor_id bigint not null,

    primary key (id)
);

create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(300) not null unique,
    fecha datetime not null,
    estatus boolean not null,
    autor_id bigint not null,
    curso_id varchar(100) not null,

    primary key(id),

}