package Services;

import Entities.Categoria;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class CategoriaService {

    private List<Categoria> categorias;

    public CategoriaService() {
        categorias = new ArrayList<>();
    }

    // Metodos

    // Crear Categoria

    public void crearCategoria(Categoria categoria) {

        if (categoria.getNombre() == null
                || categoria.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de la categoría no puede estar vacío."
            );
        }

        if (categoria.getDescripcion() == null
                || categoria.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía."
            );
        }

        for (Categoria c : categorias) {
            if (!c.isEliminado()
                    && c.getNombre().equalsIgnoreCase(categoria.getNombre())) {

                throw new IllegalArgumentException(
                        "Ya existe una categoría con ese nombre."
                );
            }
        }

        categorias.add(categoria);
    }

    // Listar Categorias

    public void listarCategorias() {

        boolean hayCategorias = false;

        for (Categoria categoria : categorias) {

            if (!categoria.isEliminado()) {
                System.out.println(categoria);
                hayCategorias = true;
            }
        }

        if (!hayCategorias) {
            System.out.println("No hay categorías cargadas.");
        }
    }

    // Buscar por ID

    public Categoria buscarPorId(Long id) {

        for (Categoria categoria : categorias) {

            if (categoria.getId().equals(id)
                    && !categoria.isEliminado()) {

                return categoria;
            }
        }

        return null;
    }

    // Editar Categorias

    public boolean editarCategoria(Long id,
                                   String nombre,
                                   String descripcion) {

        Categoria categoria = buscarPorId(id);

        if (categoria == null) {
            return false;
        }

        for (Categoria c : categorias) {

            if (!c.isEliminado()
                    && !c.getId().equals(id)
                    && c.getNombre().equalsIgnoreCase(nombre)) {

                throw new IllegalArgumentException(
                        "Ya existe una categoría con ese nombre."
                );
            }
        }

        categoria.setNombre(nombre);
        categoria.setDescripcion(descripcion);

        return true;
    }

    // Obtener Lista
    public List<Categoria> getCategorias() {
        return categorias;
    }

    // Eliminar Categoria

    public boolean eliminarCategoria(Long id) {

        Categoria categoria = buscarPorId(id);

        if (categoria == null) {
            return false;
        }

        categoria.setEliminado(true);

        return true;
    }
}
