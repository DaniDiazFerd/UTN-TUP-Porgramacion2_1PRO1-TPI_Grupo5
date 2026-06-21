package Menu;
import Entities.Categoria;
import Services.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuCRUDCategorias {

    public static void menu(){

        System.out.println("\n====== MENÚ CATEGORÍAS ======");

        int opcion;

        do {

            System.out.println("\n1. Listar\n2. Crear\n3. Editar\n4. Eliminar\nSeleccione: ");

            Scanner scanner = new Scanner(System.in);

            CategoriaService cservice = new CategoriaService();

            opcion = scanner.nextInt();

            switch (opcion){

                case 1:

                    cservice.listarCategorias();

                    return;

                case 2:

                    System.out.println("Ingrese el id de la nueva categoría: ");

                    Long id_newCategoria = scanner.nextLong();

                    System.out.println("Ingrese el nombre de la nueva categoría: ");

                    String nombre_Categoria = scanner.nextLine();

                    System.out.println("Ingrese la descripción de la nueva categoría: ");

                    String descripcion_Categoria = scanner.nextLine();

                    Categoria categoria = new Categoria(id_newCategoria, false, LocalDateTime.now(), nombre_Categoria, descripcion_Categoria);

                    cservice.crearCategoria(categoria);

                    break;

                case 3:

                    System.out.println("Ingrese el id de la categoría que desee editar: ");

                    Long id_edCategoria = scanner.nextLong();

                    System.out.println("Ingrese el nuevo nombre de la categoría: ");

                    String nombre_edCategoria = scanner.nextLine();

                    System.out.println("Ingrese la nueva descripción de la categoría: ");

                    String descripcion_edCategoria = scanner.nextLine();

                    cservice.editarCategoria(id_edCategoria, nombre_edCategoria, descripcion_edCategoria);

                    return;

                case 4:

                    System.out.println("Ingrese el id de la categoría que desee eliminar: ");

                    Long id_delCategoria = scanner.nextLong();

                    cservice.eliminarCategoria(id_delCategoria);

                    return;

                default:

                    System.out.println("\nPor favor, ingrese una instrucción válida.");

            }

        } while (opcion < 0 || opcion > 4);

    }

}
