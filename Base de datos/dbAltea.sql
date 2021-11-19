/* Proyecto Altea Emotional
    GRUPO 2
    Script base de datos 
*/

/* Método de limpieza por buena practica */

DROP TABLE IF EXISTS Empresa;
DROP TABLE IF EXISTS Patologia;
DROP TABLE IF EXISTS Superusuario;
DROP TABLE IF EXISTS Chatbot;
DROP TABLE IF EXISTS Consejo;
DROP TABLE IF EXISTS Sintoma;
DROP TABLE IF EXISTS RespChat;
DROP TABLE IF EXISTS RespUs;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS Estadistica;
DROP TABLE IF EXISTS Usuario_Empresa;
DROP TABLE IF EXISTS Patologia_Sintoma;
DROP TABLE IF EXISTS Usuario_Sintoma;
DROP TABLE IF EXISTS Usuario_Noticia;
DROP TABLE IF EXISTS Superusuario_Estadistica;
DROP TABLE IF EXISTS Usuario_Consejo;

/* Creación de tabla */

CREATE TABLE IF NOT EXISTS Empresa(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Correo varchar(100),
    Contrasenia varchar(100),
    loginToken int
);


CREATE TABLE IF NOT EXISTS Patologia(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100),
    Recomendacion varchar(100)
);

CREATE TABLE IF NOT EXISTS Superusuario(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Apellido varchar(100),
    Correo varchar(100),
    Contrasenia varchar(100),
    loginToken int
);

CREATE TABLE IF NOT EXISTS Noticia(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS Chatbot(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS Usuario(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Apellido varchar(100),
    edad int,
    Correo varchar(100),
    Contrasenia varchar(100),
    loginToken int,
    id_chatbot SERIAL
);

CREATE TABLE IF NOT EXISTS RespChat(
    ID SERIAL PRIMARY KEY,
    Descripcion varchar(100),
    id_chatbot SERIAL
);

CREATE TABLE IF NOT EXISTS RespUs(
    ID SERIAL PRIMARY KEY,
    Descripcion varchar(100),
    id_RespChat SERIAL,
    id_Usuario SERIAL
);

CREATE TABLE IF NOT EXISTS Consejo(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS Sintoma(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

CREATE TABLE IF NOT EXISTS Estadistica(
    ID SERIAL PRIMARY KEY,
    Nombre varchar(100),
    Descripcion varchar(100)
);

/* TABLA CON LLAVES FORANEAS*/

CREATE TABLE IF NOT EXISTS Usuario_Empresa(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Empresa SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Empresa) REFERENCES Empresa (id)
);

CREATE TABLE IF NOT EXISTS Empresa_Estadistica(
    id SERIAL PRIMARY KEY,

    id_Empresa SERIAL,
    id_Estadistica SERIAL,
    FOREIGN KEY (id_Empresa) REFERENCES Empresa (id),
    FOREIGN KEY (id_Estadistica) REFERENCES Estadistica (id)
);


CREATE TABLE IF NOT EXISTS Patologia_Sintoma(
    id SERIAL PRIMARY KEY,

    id_Patologia SERIAL,
    id_Sintoma SERIAL,
    FOREIGN KEY (id_Patologia) REFERENCES Patologia (id),
    FOREIGN KEY (id_Sintoma) REFERENCES Sintoma (id)
);

CREATE TABLE IF NOT EXISTS Usuario_Sintoma(
    id SERIAL PRIMARY KEY,
    id_Usuario SERIAL,
    id_Sintoma SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Sintoma) REFERENCES Sintoma (id)
);

CREATE TABLE IF NOT EXISTS Usuario_Patologia(
    id SERIAL PRIMARY KEY,
    id_Usuario SERIAL,
    id_Patologia SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Patologia) REFERENCES Patologia (id)
);

CREATE TABLE IF NOT EXISTS Usuario_Noticia(
    id SERIAL PRIMARY KEY,
    id_Usuario SERIAL,
    id_Noticia SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Noticia) REFERENCES Noticia (id)
);

CREATE TABLE IF NOT EXISTS Superusuario_Estadistica(
    id SERIAL PRIMARY KEY,
    id_Superusuario SERIAL,
    id_Estadistica SERIAL,
    FOREIGN KEY (id_Superusuario) REFERENCES Superusuario (id),
    FOREIGN KEY (id_Estadistica) REFERENCES Estadistica (id)
);

CREATE TABLE IF NOT EXISTS Usuario_Consejo(
    id SERIAL PRIMARY KEY,

    id_Usuario SERIAL,
    id_Consejo SERIAL,
    FOREIGN KEY (id_Usuario) REFERENCES Usuario (id),
    FOREIGN KEY (id_Consejo) REFERENCES Consejo (id)
);

ALTER TABLE RespUs
ADD FOREIGN KEY (id_RespChat) REFERENCES RespChat(ID);

ALTER TABLE RespUs
ADD FOREIGN KEY (id_Usuario) REFERENCES Usuario(ID);

ALTER TABLE Usuario
ADD FOREIGN KEY (id_chatbot) REFERENCES Chatbot(ID);

ALTER TABLE RespChat
ADD FOREIGN KEY (id_chatbot) REFERENCES Chatbot(ID);

