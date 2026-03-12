package ForoHub.demo.Domain.topico;


public record DatosActualizarForo(
        String titulo,
        String mensaje,
        Estado status,
        String curso
){
    public DatosActualizarForo(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getStatus(), topico.getCurso());
    }
}