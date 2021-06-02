insert into memo_amautas.rol values('11111111','Alumno');
insert into memo_amautas.rol values('22222222','Profesor');

insert into memo_amautas.etiqueta values ('10000','1', 'ciclo');
insert into memo_amautas.etiqueta values ('20000', 'Matemáticas', 'materia');
insert into memo_amautas.curso values ('10000000','Introduccion a la Computacion',2);
insert into memo_amautas.curso values ('10000030', 'Programacion Orientada a Objetos', 3);
insert into memo_amautas.curso values ('10000001', 'Calculo Diferencial', 5);
insert into memo_amautas.etiqueta_curso values ('10000001','10000');
insert into memo_amautas.etiqueta_curso values ('10000000','10000');
insert into memo_amautas.etiqueta_curso values ('10000001','20000');

insert into memo_amautas.modulo (id_modulo, tema_modulo, cod_curso, orden) values ('20000000', 'Fundamentos de Programación', '10000000',1);
insert into memo_amautas.modulo (id_modulo, tema_modulo, cod_curso, orden) values ('20000001', 'Instrucciones de Entrada-Salida', '10000000',2);
insert into memo_amautas.modulo (id_modulo, tema_modulo, cod_curso, orden) values ('20000002', 'Instruccciones lógicas', '10000000',3);
insert into memo_amautas.modulo (id_modulo, tema_modulo, cod_curso, orden) values ('20000003', 'Instrucciones de control y selección', '10000000',4);
insert into memo_amautas.modulo (id_modulo, tema_modulo, cod_curso, orden) values ('20000004', 'Arreglos', '10000000',5);
insert into memo_amautas.modulo (id_modulo, tema_modulo, cod_curso, orden) values ('20000005', 'Funciones', '10000000',6);

insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000000', 'Concepto de Programa e Instrucción', '20000000',1);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000001', 'Lenguajes de Programación y Código Fuente', '20000000',2);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000002', 'Algoritmos: Conceptos y Características', '20000000',3);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000003', 'Diagramas de Flujo', '20000000',4);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000004', 'Estructura de un programa, tipos y métodos', '20000001',1);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000005', 'Dato, Variable y Constante', '20000001',2);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000006', 'Tipos de dato: Declaración', '20000001',3);
insert into memo_amautas.sesion (id_sesion, tema_sesion, cod_modulo, orden) values ('30000007', 'Tipos de dato: Declaración', '20000000',3);
