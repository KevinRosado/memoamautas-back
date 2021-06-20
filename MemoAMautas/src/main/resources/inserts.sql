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

-- 1 CICLO
insert into memo_amautas.curso values ('BIC01','Introduccion a la Computacion',2);
insert into memo_amautas.curso values ('BMA01', 'Calculo Diferencial', 5);
insert into memo_amautas.curso values ('FB101','Geometría Analítica',3);
insert into memo_amautas.curso values ('BRN01','Redacción y Comunicación',2);
insert into memo_amautas.curso values ('SI101','Introducción a la Ingeniería de Sistemas',3);
insert into memo_amautas.curso values ('BQU01', 'Química I', 5);
-- 2 CICLO
insert into memo_amautas.curso values ('BMA02','Cálculo Integral',5);
insert into memo_amautas.curso values ('BMA03', 'Álgebra Lineal', 4);
insert into memo_amautas.curso values ('BEF01', 'Ética y Filosofía', 2);
insert into memo_amautas.curso values ('SI205', 'Algoritmia y Estructura de Datos', 3);
insert into memo_amautas.curso values ('SI203', 'Teoría y Ciencia de Sistemas', 3);
insert into memo_amautas.curso values ('SI207', 'Sistemas Biológicos y Ecológicos', 2);
insert into memo_amautas.curso values ('SI201', 'Psicología Sistémica', 3);
-- 3 CICLO
insert into memo_amautas.curso values ('SI302', 'Programacion Orientada a Objetos', 3);
insert into memo_amautas.curso values ('BFI01', 'Física I', 5);
insert into memo_amautas.curso values ('HU301', 'Metodología de la Investigación', 3);
insert into memo_amautas.curso values ('FB303', 'Cálculo Multivariable', 5);
insert into memo_amautas.curso values ('SI301', 'Teoría y Ciencia de Sistemas Aplicada', 3);
insert into memo_amautas.curso values ('FB301', 'Matemática Discreta', 3);
insert into memo_amautas.curso values ('FB305', 'Estadística y Probabilidades', 3);
-- 4 CICLO
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI403','Metodología de Sistemas Blandos',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('FB401','Fisica II',5);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI405','Modelado Conceptual de Datos',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('FB403','Ecuaciones Diferenciales',5);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('FB405','Estadística Aplicada',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('HU102','Desarrollo Personal',2);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('FB402','Calculo Numérico',3);
-- 5 CICLO
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('BEG01','Economía General',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('BRN01','Realidad Nacional, Constitución y Derechos Humanos',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('FB501','Matematica Aplicada',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('GE501','Teoría Organizacional',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI503','Ingeniería de Procesos',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI501','Investigación de Operaciones I',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI505','Diseño de Base de Datos',3);
-- 6 CICLO
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('GE605','Sistema y Gestión Financiera',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI601','Investigación de Operaciones II',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI602','Dinamica de Sistemas',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI603','Modelado de Procesos de Ciclo de Vida de Sistemas',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI604','Analisis y Diseño de Sistemas',4);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI605','Arquitectura Empresarial',3);
insert into memo_amautas.curso (id_curso,nombre_curso,creditos) values ('SI607','Arquitectura Computacional y Redes',3);
-- 7 CICLO
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('GE709', 'Sistemas de Calidad', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI701', 'Modelado Sistémico y Simulación', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI702', 'Taller de Dinámica de Sistemas', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI704', 'Gestión de la Ingeniería de Sistemas', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI705', 'Estándares de la Ingeniería de Sistemas', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI707', 'Ingeniería de Sofware', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('GE703', 'Sistemas Integrados Empresariales', 3);
-- 8 CICLO
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('GE801', 'Planeamiento y Gestión Estratégica', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('GE803', 'Sistemas Analíticos', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI801', 'Modelos del Sistema Viable', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI805', 'Integración de Sistemas', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI806', 'Desarrollo Adaptativo e Integrado del Software', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI807', 'Sistemas de Inteligencia de Negocio', 3);
-- 9 CICLO
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('GE902', 'Diseño y Evaluación de Proyectos', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI901', 'Proyectos de Tesis en Ingeniería de Sistemas I', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI902', 'Ingeniería de Sistemas de Servicio', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI903', 'Implementación de Sistemas', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI904', 'Seguridad de Sistemas', 3);
-- 10 CICLO
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('HU200', 'Idioma Extranjero', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('HU300', 'Actividades Diversas I', 1);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('HU400', 'Prácticas Pre-Profesionales', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI035', 'Proyecto de Tesis en Ingeniería de Sistemas II', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI055', 'Gestión de Proyectos', 2);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI075', 'Auditoría de Sistemas', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI085', 'Aplicación de Negocios Electrónicos', 3);
insert into memo_amautas.curso (id_curso, nombre_curso, creditos) values ('SI095', 'Ingeniería Empresarial', 3);

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
