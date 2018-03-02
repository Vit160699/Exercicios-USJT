CREATE DATABASE IF NOT EXISTS Pais;

USE Pais;

CREATE TABLE IF NOT EXISTS pais (
    idPais int auto_increment primary key not null,
    nomePais varchar(100) not null,
    populacaoPais bigint not null,
    areaPais decimal(15,2) not null
    );


INSERT INTO pais (nomePais,populacaoPais,areaPais) VALUES ('Alemanha', '82521700','357051');
INSERT INTO pais (nomePais,populacaoPais,areaPais) VALUES ('Holanda', '17100475','41528');
INSERT INTO pais (nomePais,populacaoPais,areaPais) VALUES ('Japão', '126730000 ','377873');
INSERT INTO pais (nomePais,populacaoPais,areaPais) VALUES ('Irlanda', '4761865','70273');
INSERT INTO pais (nomePais,populacaoPais,areaPais) VALUES ('China', '1379302771','9596961');

SELECT * FROM pais;