CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    message VARCHAR(300) NOT NULL,
    fecha DATETIME NOT NULL,
    solucion BOOLEAN NOT NULL,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);