package Exceptions;

/**
 * Se lanza cuando se intenta crear o editar un Producto con valores
 * inválidos de stock o precio (menores a 0), o cuando se intenta
 * agregar a un pedido una cantidad mayor al stock disponible.
 *
 * Ejemplos de uso:
 *   throw new StockInvalidoException("El precio no puede ser negativo.");
 *   throw new StockInvalidoException("Hamburguesa", 2, 1);
 */
public class StockInvalidoException extends Exception {

    /**
     * Constructor con mensaje libre. Usar para precio negativo, stock < 0, etc.
     *
     * @param mensaje Descripción del error.
     */
    public StockInvalidoException(String mensaje) {
        super(mensaje);
    }

    /**
     * Constructor específico para cuando la cantidad pedida supera el stock.
     *
     * @param nombreProducto  Nombre del producto afectado.
     * @param cantidadPedida  Unidades que se intentaron agregar al pedido.
     * @param stockDisponible Stock real disponible en ese momento.
     */
    public StockInvalidoException(String nombreProducto, int cantidadPedida, int stockDisponible) {
        super("Stock insuficiente para '" + nombreProducto + "': "
                + "se solicitaron " + cantidadPedida + " unidades "
                + "pero solo hay " + stockDisponible + " disponibles.");
    }
}
