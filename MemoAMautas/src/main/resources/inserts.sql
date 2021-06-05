insert into memo_amautas.rol values('11111111','Alumno');
insert into memo_amautas.rol values('22222222','Profesor');

insert into memo_amautas.tipo_etiqueta values ('01','Ciclo Sistemas');
insert into memo_amautas.tipo_etiqueta values ('02','Ciclo Industrial');
insert into memo_amautas.tipo_etiqueta values ('03','Materia');
insert into memo_amautas.tipo_etiqueta values ('04','Departamento');

insert into memo_amautas.valor_etiqueta values ('100','Primer Ciclo');
insert into memo_amautas.valor_etiqueta values ('101','Segundo Ciclo');
insert into memo_amautas.valor_etiqueta values ('102','Tercer Ciclo');
insert into memo_amautas.valor_etiqueta values ('103','Cuarto Ciclo');
insert into memo_amautas.valor_etiqueta values ('200', 'Ciencias Básicas');
insert into memo_amautas.valor_etiqueta values ('201', 'Sistemas y Telemática');
insert into memo_amautas.valor_etiqueta values ('202', 'Humanidades y Ciencias Sociales');
insert into memo_amautas.valor_etiqueta values ('203', 'Gestión de la Producción');
insert into memo_amautas.valor_etiqueta values ('204', 'Tecnología de la Producción');

insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('100','01');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('100','02');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('101','01');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('101','02');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('102','01');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('102','02');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('103','01');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('103','02');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('200','04');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('201','04');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('202','04');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('203','04');
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('204','04');

insert into memo_amautas.curso values ('1000','Introduccion a la Computacion',2);
insert into memo_amautas.curso values ('1001', 'Calculo Diferencial', 5);
insert into memo_amautas.curso values ('1002','Geometría Analítica',3);
insert into memo_amautas.curso values ('1003','Redacción y Comunicación',2);
insert into memo_amautas.curso values ('1004','Introducción a la Ingeniería de Sistemas',3);
insert into memo_amautas.curso values ('1005', 'Química I', 5);
insert into memo_amautas.curso values ('1010','Cálculo Integral',5);
insert into memo_amautas.curso values ('1011', 'Álgebra Lineal', 4);
insert into memo_amautas.curso values ('1012', 'Ética y Filosofía', 2);
insert into memo_amautas.curso values ('1013', 'Algoritmia y Estructura de Datos', 3);
insert into memo_amautas.curso values ('1014', 'Teoría y Ciencia de Sistemas', 3);
insert into memo_amautas.curso values ('1015', 'Sistemas Biológicos y Ecológicos', 2);
insert into memo_amautas.curso values ('1016', 'Psicología Sistémica', 3);
insert into memo_amautas.curso values ('1020', 'Programacion Orientada a Objetos', 3);
insert into memo_amautas.curso values ('1021', 'Física I', 5);
insert into memo_amautas.curso values ('1022', 'Metodología de la Investigación', 3);
insert into memo_amautas.curso values ('1023', 'Cálculo Multivariable', 5);
insert into memo_amautas.curso values ('1024', 'Teoría y Ciencia de Sistemas Aplicada', 3);
insert into memo_amautas.curso values ('1025', 'Matemática Discreta', 3);
insert into memo_amautas.curso values ('1026', 'Estadística y Probabilidades', 3);

insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1000','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1001','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1002','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1003','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1004','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1005','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1010','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1011','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1012','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1013','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1014','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1015','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('1016','101', '01');

/*
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
*/
