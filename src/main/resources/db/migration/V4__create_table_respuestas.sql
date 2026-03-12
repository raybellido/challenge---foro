CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    usuario_id BIGINT,
    topico_id BIGINT,
    CONSTRAINT fk_respuesta_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuarios(id),
    CONSTRAINT fk_respuesta_topico
        FOREIGN KEY (topico_id)
        REFERENCES topicos(id)
);