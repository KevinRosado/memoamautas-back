create table memo_amautas.rol(
                                 id_rol varchar(8) primary key,
                                 nombre_rol varchar(8)
);
create table memo_amautas.persona(
                                     id_persona SERIAL primary key,
                                     rol_persona varchar(8),
                                     nombre varchar(30),
                                     ape_pat varchar(30),
                                     ape_mat varchar(30),
                                     fecha_nac date,
                                     foreign key (rol_persona) references memo_amautas.rol (id_rol)
);
create table memo_amautas.etiqueta(
                                      id_etiqueta varchar(5) primary key,
                                      nombre_etiqueta varchar(20)
);
create table memo_amautas.materia(
                                     id_materia varchar(5) primary key,
                                     nombre_materia varchar(60)
);
create table memo_amautas.curso(
                                   id_curso varchar(8) primary key,
                                   nombre_curso varchar(200),
                                   creditos int,
                                   cod_materia varchar (5),
                                   foreign key (cod_materia) references memo_amautas.materia(id_materia)
);
create table memo_amautas.modulo(
                                    id_modulo varchar(8) primary key,
                                    tema_modulo varchar(100),
                                    orden int,
                                    cod_curso varchar(8),
                                    foreign key (cod_curso) references memo_amautas.curso (id_curso)
);
create table memo_amautas.sesion(
                                    id_sesion varchar(8) primary key,
                                    cod_modulo varchar(8),
                                    tema_sesion varchar(100),
                                    orden int,
                                    foreign key (cod_modulo) references memo_amautas.modulo (id_modulo)
);
create table memo_amautas.usuario (
                                      username varchar(30) unique,
                                      contrasenia varchar(8) unique,
                                      cod_persona SERIAL,
                                      foreign key (cod_persona) references memo_amautas.persona (id_persona)
);
create table memo_amautas.curso_matriculado (
                                                id_curso_matriculado varchar(8) primary key,
                                                cod_curso varchar(8),
                                                cod_persona SERIAL,
                                                fecha_inscripcion date,
                                                progreso_curso int,
                                                foreign key (cod_curso) references memo_amautas.curso (id_curso),
                                                foreign key (cod_persona) references memo_amautas.persona (id_persona)
);
create table memo_amautas.progreso_sesion(
                                             id_progreso varchar(8) primary key,
                                             cod_persona SERIAL,
                                             cod_sesion varchar(8),
                                             puntuacion int,
                                             cant_progreso int,
                                             foreign key (cod_persona) references memo_amautas.persona (id_persona),
                                             foreign key (cod_sesion) references memo_amautas.sesion (id_sesion)
);
create table memo_amautas.mazo(
                                  id_mazo varchar(9) primary key,
                                  cod_autor SERIAL,
                                  cant_votos int default 0 not null,
                                  cant_vistas int default 0 not null,
                                  cod_sesion varchar(8),
                                  nombre_mazo varchar(30),
                                  mazo_default boolean default false,
                                  foreign key (cod_autor) references memo_amautas.persona (id_persona),
                                  foreign key (cod_sesion) references memo_amautas.sesion (id_sesion)
);
create table memo_amautas.tarjeta(
                                     id_tarjeta varchar(9) primary key,
                                     color_tarjeta varchar(7) not null,
                                     cod_mazo varchar(9),
                                     txt_pregunta varchar(255),
                                     txt_respuesta varchar(255),
                                     color_pregunta varchar(7) not null,
                                     color_respuesta varchar(7) not null,
                                     path_imagen_pregunta varchar(255),
                                     path_imagen_respuesta varchar(255),
                                     foreign key (cod_mazo) references memo_amautas.mazo (id_mazo)
);
create table memo_amautas.mazo_seguido(
                                          id_mazo_seguido varchar(8) primary key,
                                          cod_seguidor SERIAL,
                                          cod_mazo varchar(9),
                                          puntuacion_mazo int not null,
                                          foreign key (cod_seguidor) references memo_amautas.persona(id_persona),
                                          foreign key (cod_mazo) references memo_amautas.mazo (id_mazo)
);
create table memo_amautas.etiqueta_curso(
                                            cod_curso varchar(9),
                                            cod_etiqueta varchar(5),
                                            foreign key (cod_curso) references memo_amautas.curso (id_curso),
                                            foreign key (cod_etiqueta) references memo_amautas.etiqueta (id_etiqueta)
);
