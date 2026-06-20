import Entities.*;
import Enums.*;
import Exceptions.*;
import Interfaces.*;
import Services.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        Usuario usuario = new Usuario(1L, false, LocalDateTime.of(2026, 6, 20, 0, 0), "Juan", "Ignacio", "juanigna@gmail.com", "2610010001", "Contraseña123", Rol.USUARIO);

        UsuarioService uservice = new UsuarioService();

        uservice.crearUsuario(usuario);

    }

}
