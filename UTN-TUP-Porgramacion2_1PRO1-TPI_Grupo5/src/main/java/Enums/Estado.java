package Enums;

public enum Estado {
    PENDIENTE(1),
    CONFIRMADO(2),
    TERMINADO(3),
    CANCELADO(4);

    private final int codigo;

    Estado(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Estado fromCodigo(int codigo) {
        for (Estado e : Estado.values()) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        throw new IllegalArgumentException("Código de estado inválido: " + codigo);
    }

}
