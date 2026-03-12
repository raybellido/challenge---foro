package ForoHub.demo.Domain.topico;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        Estado status,
        String autor,
        String curso)
    {
        public DatosDetalleTopico(Topico datos){
            this(datos.getId(),
                    datos.getTitulo(),
                    datos.getMensaje(),
                    datos.getStatus(),
                    datos.getAutor().getNombre(),
                    datos.getCurso());
        }
    }
