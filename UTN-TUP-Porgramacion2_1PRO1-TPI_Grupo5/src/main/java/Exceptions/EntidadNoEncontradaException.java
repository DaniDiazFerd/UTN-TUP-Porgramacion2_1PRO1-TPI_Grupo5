package Exceptions;

/**
 * Se lanza cuando se busca una entidad por ID y no existe en la colección,
 * o existe pero tiene eliminado = true (baja lógica).
 *
 * Ejemplos de uso:
 *   throw new EntidadNoEncontradaException("Producto", 5L);
 *   throw new EntidadNoEncontradaException("Usuario", id);
 */
public class EntidadNoEncontradaException extends RuntimeException {

    private final String tipoEntidad;
    private final Long id;

    /**
     * @param tipoEntidad Nombre de la clase buscada (ej: "Producto", "Categoria").
     * @param id          ID que no se encontró.
     */
    public EntidadNoEncontradaException(String tipoEntidad, Long id) {
        super("No se encontró " + tipoEntidad + " con id = " + id + ".");
        this.tipoEntidad = tipoEntidad;
        this.id = id;
    }

    /**
     * Constructor alternativo con mensaje libre.
     * Útil cuando el error no gira en torno a un ID numérico.
     *
     * @param mensaje Descripción personalizada del error.
     */
    public EntidadNoEncontradaException(String mensaje) {
        super(mensaje);
        this.tipoEntidad = null;
        this.id = null;
    }

    public String getTipoEntidad() {
        return tipoEntidad;
    }

    public Long getId() {
        return id;
    }
}
