package Enums;

public enum FormaPago {
    TARJETA(1),
    TRANSFERENCIA(2),
    EFECTIVO(3);

    private final int codigo;

    FormaPago(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static FormaPago fromCodigo(int codigo) {
        for (FormaPago f : FormaPago.values()) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        throw new IllegalArgumentException("Código de estado inválido: " + codigo);
    }

}
