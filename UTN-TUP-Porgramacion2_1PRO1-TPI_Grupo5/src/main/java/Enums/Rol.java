package Enums;

public enum Rol {
    ADMIN(1),
    USUARIO(2);

    private final int codigo;

    Rol(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static Rol fromCodigo(int codigo) {
        for (Rol r : Rol.values()) {
            if (r.getCodigo() == codigo) {
                return r;
            }
        }
        throw new IllegalArgumentException("Código de estado inválido: " + codigo);
    }

}
