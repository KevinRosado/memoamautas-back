insert into memo_amautas.rol values('11111111','Alumno');
insert into memo_amautas.rol values('22222222','Profesor');
insert into memo_amautas.rol values('33333333','Memo');

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


insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('100','01'); --pk = 10001
insert into memo_amautas.etiqueta (cod_etiqueta, cod_tipo_etiqueta) values('100','02'); --pk = 10002
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


insert into memo_amautas.curso values ('BIC01','Introduccion a la Computacion',2);
insert into memo_amautas.curso values ('BMA01', 'Calculo Diferencial', 5);
insert into memo_amautas.curso values ('FB101','Geometría Analítica',3);
insert into memo_amautas.curso values ('BRN01','Redacción y Comunicación',2);
insert into memo_amautas.curso values ('SI101','Introducción a la Ingeniería de Sistemas',3);
insert into memo_amautas.curso values ('BQU01', 'Química I', 5);
insert into memo_amautas.curso values ('BMA02','Cálculo Integral',5);
insert into memo_amautas.curso values ('BMA03', 'Álgebra Lineal', 4);
insert into memo_amautas.curso values ('BEF01', 'Ética y Filosofía', 2);
insert into memo_amautas.curso values ('SI205', 'Algoritmia y Estructura de Datos', 3);
insert into memo_amautas.curso values ('SI203', 'Teoría y Ciencia de Sistemas', 3);
insert into memo_amautas.curso values ('SI207', 'Sistemas Biológicos y Ecológicos', 2);
insert into memo_amautas.curso values ('SI201', 'Psicología Sistémica', 3);
insert into memo_amautas.curso values ('SI302', 'Programacion Orientada a Objetos', 3);
insert into memo_amautas.curso values ('BFI01', 'Física I', 5);
insert into memo_amautas.curso values ('HU301', 'Metodología de la Investigación', 3);
insert into memo_amautas.curso values ('FB303', 'Cálculo Multivariable', 5);
insert into memo_amautas.curso values ('SI301', 'Teoría y Ciencia de Sistemas Aplicada', 3);
insert into memo_amautas.curso values ('FB301', 'Matemática Discreta', 3);
insert into memo_amautas.curso values ('FB305', 'Estadística y Probabilidades', 3);

insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BIC01','100', '01'); --fk = 10001 ; pk = BIC0110001
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BMA01','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('FB101','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BRN01','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('SI101','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BQU01','100', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BMA02','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BMA03','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('BEF01','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('SI205','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('SI203','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('SI207','101', '01');
insert into memo_amautas.etiqueta_curso (cod_curso, cod_etiqueta, cod_tipo_etiqueta) values ('SI201','101', '01');
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
