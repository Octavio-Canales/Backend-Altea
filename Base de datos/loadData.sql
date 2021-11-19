--Empresa
INSERT INTO Empresa (Nombre, Correo, Contrasenia , loginToken)
VALUES ('Empresa X','empresax@correo.cl','empresax',1);
INSERT INTO Empresa (Nombre, Correo, Contrasenia , loginToken)
VALUES ('Empresa Y','empresay@correo.cl','empresay',1);
INSERT INTO Empresa (Nombre, Correo, Contrasenia , loginToken)
VALUES ('Empresa Z','empresaz@correo.cl','empresaz',1);
INSERT INTO Empresa (Nombre, Correo, Contrasenia , loginToken)
VALUES ('Empresa W','empresaw@correo.cl','empresaw',1);
INSERT INTO Empresa (Nombre, Correo, Contrasenia , loginToken)
VALUES ('Empresa B','empresab@correo.cl','empresab',1);
--Patologia
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres X','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres Y','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres Z','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres W','blablabla','blablabla');
INSERT INTO Patologia (Nombre, Descripcion, recomendacion)
VALUES ('Estres B','blablabla','blablabla');
--Superusuario
INSERT INTO Superusuario (Nombre, Apellido, Correo, Contrasenia, loginToken)
VALUES ('Florencia', 'Anguita','florencia@correo.cl','florencia', 1);
INSERT INTO Superusuario (Nombre, Apellido, Correo, Contrasenia, loginToken)
VALUES ('Consuelo', 'Lastra','consuelo@correo.cl','consuelo', 1);
INSERT INTO Superusuario (Nombre, Apellido, Correo, Contrasenia, loginToken)
VALUES ('Magdalena', 'Serrano','magda@correo.cl','magda', 1);
INSERT INTO Superusuario (Nombre, Apellido, Correo, Contrasenia, loginToken)
VALUES ('Varinnia', 'Frank','vari@correo.cl','vari', 1);
--Noticia
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Robot emocional','Robot que refleja y muestra emociones humanas.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Estado emocional','Nuevos estudios del estado emocional de las personas con insomnio.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Clima','El clima de hoy esta fresco como lechuga.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Psicologia','Estudio de unidad de universidad reconocida.');
INSERT INTO Noticia (Nombre, Descripcion)
VALUES ('Pandemia','Los nuevos problemas psicologicos que pueden traer los problemas de la pandemia.');
--Chatbot
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Lucy','Afectividad en las personas y el trato de estas.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Mario','Responde de forma concreta y honesta.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Maria','Entrega información valiosa para el usuario.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Luciano','Se pone en el lugar de cada usuario.');
INSERT INTO Chatbot (Nombre, Descripcion)
VALUES ('Ariel','Un poco de todos los chatbots anteriores.');
--Consejo
INSERT INTO Consejo (Nombre, Descripcion)
VALUES ('Agua','Si respiras en el agua, te ahogas.');
INSERT INTO Consejo (Nombre, Descripcion)
VALUES ('Pistola','Si aprietas el gatillo de una pistola, disparas.');
INSERT INTO Consejo (Nombre, Descripcion)
VALUES ('Matar','Si te matan, te mueres.');
INSERT INTO Consejo (Nombre, Descripcion)
VALUES ('Caminar','Si caminas, avanzas.');
INSERT INTO Consejo (Nombre, Descripcion)
VALUES ('Pajaro','Mas vale pajaro en mano que mil picoteandote la cabeza.');
--Sintoma
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Estres','No es dos.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Cansancio','Mucho ejercicio. Ya vaya a descanzar.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Sabrosura','Es un viejo sabroso.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Somnolencia','Duerma bien.');
INSERT INTO Sintoma (Nombre, Descripcion)
VALUES ('Tick nervioso','No sea nervioso.');

-- Usuario
INSERT INTO Usuario (Nombre, Apellido, edad, Correo, Contrasenia, loginToken, id_chatbot)
VALUES ('Octavio', 'Canales','22','octavio@correo.cl','octavio',1,1);
INSERT INTO Usuario (Nombre, Apellido, edad, Correo, Contrasenia, loginToken, id_chatbot)
VALUES ('Martin', 'Ormazabal','22','martin@correo.cl','martin',1,2);
INSERT INTO Usuario (Nombre, Apellido, edad, Correo, Contrasenia, loginToken, id_chatbot)
VALUES ('Juan', 'Arreondo','22','juan@correo.cl','juan',1,3);
INSERT INTO Usuario (Nombre, Apellido, edad, Correo, Contrasenia, loginToken, id_chatbot)
VALUES ('Hugo', 'Arenas','22','hugo@correo.cl','hugo',1,4);
INSERT INTO Usuario (Nombre, Apellido, edad, Correo, Contrasenia, loginToken, id_chatbot)
VALUES ('Michael', 'Aguilera','22','michael@correo.cl','michael',1,5);
--RespChat
INSERT INTO RespChat(Descripcion, id_chatbot)
VALUES ('Sus necesidades no son problema mio.',1);
INSERT INTO RespChat(Descripcion, id_chatbot)
VALUES ('Suavamente besame que quiero sentir tus labios besandome otra vez....SUAVE',2);
INSERT INTO RespChat(Descripcion, id_chatbot)
VALUES ('Albion Online es un mmorpg no lineal en el que puedes escribir tu propia historia',3);
INSERT INTO RespChat(Descripcion, id_chatbot)
VALUES ('¿Esto en que afecta huachipato?',4);
INSERT INTO RespChat(Descripcion, id_chatbot)
VALUES ('Estuve bajo la lluvia 2 horas, 1000 horas, como un perro',5);
--RespUs
INSERT INTO RespUs(Descripcion,id_Usuario,id_RespChat)
VALUES ('Eso tilin, baila tilin',1,1);
INSERT INTO RespUs(Descripcion,id_Usuario,id_RespChat)
VALUES ('MIMAMAMEMIMA',2,2);
INSERT INTO RespUs(Descripcion,id_Usuario,id_RespChat)
VALUES ('Entonces dave inteligentemente armo un megafono con una ardilla, una cuerda y un megafono',3,3);
INSERT INTO RespUs(Descripcion,id_Usuario,id_RespChat)
VALUES ('Dime, ¿cuanto es 5 + 6?',4,4);
INSERT INTO RespUs(Descripcion,id_Usuario,id_RespChat)
VALUES ('Flores azules espinas rojas flores azules espinas rojas, seria mas facil si no fuera daltonico',5,5);
--Estadistica
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Corrupción latina','Acenso indiscriminado');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Peso venezolano','Descadencia absoluta');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Actividades de la usach','Esta en paro, no se puede');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Habia una vez','truz');
INSERT INTO Estadistica(Nombre, Descripcion)
VALUES ('Calidad estudiantil gringa','tiroteo');

/* TABLA CON LLAVES FORANEAS*/


--Usuario_Empresa
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('1','1');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('2','1');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('3','2');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('4','2');
INSERT INTO Usuario_Empresa(id_Usuario, id_Empresa)
VALUES ('5','3');
--Empresa_Estadistica
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('1','1');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('1','2');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('1','3');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('2','4');
INSERT INTO Empresa_Estadistica(id_Empresa, id_Estadistica)
VALUES ('2','5');
--Patologia_Sintoma
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('1','2');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('3','4');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('5','2');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('4','3');
INSERT INTO Patologia_Sintoma(id_Patologia, id_Sintoma)
VALUES ('1','5');
--Usuario_Sintoma
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('1','2');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('3','4');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('5','2');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('4','3');
INSERT INTO Usuario_Sintoma(id_Usuario, id_Sintoma)
VALUES ('1','5');
--Usuario_Patologia
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('1','2');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('3','4');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('5','2');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('4','3');
INSERT INTO Usuario_Patologia(id_Usuario, id_Patologia)
VALUES ('1','5');
--Usuario_Noticia
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('1','2');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('3','4');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('5','2');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('4','3');
INSERT INTO Usuario_Noticia(id_Usuario, id_Noticia)
VALUES ('1','5');
--Superusuario_Estadistica
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('1','2');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('3','4');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('3','2');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('4','3');
INSERT INTO Superusuario_Estadistica(id_Superusuario, id_Estadistica)
VALUES ('1','4');
--Usuario_Consejo
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('1','2');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('3','4');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('5','2');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('4','3');
INSERT INTO Usuario_Consejo(id_Usuario, id_Consejo)
VALUES ('1','5');