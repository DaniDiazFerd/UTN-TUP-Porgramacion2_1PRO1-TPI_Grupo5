package Services;

import Entities.Usuario;
import Exceptions.MailDuplicadoException;

import java.util.List;
import java.util.ArrayList;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService() { usuarios = new ArrayList<>(); }

    // Metodos

    // Crear Usuario
    public void crearUsuario(Usuario usuario) throws MailDuplicadoException {
        for (Usuario u : usuarios) {
            if (!u.isEliminado() && u.getMail().equalsIgnoreCase(usuario.getMail())) {
                throw new MailDuplicadoException(usuario.getMail());
            }
        }

        usuarios.add(usuario);
    }

    // Listar Usuarios
    public void listarUsuarios() {
        boolean hayUsuarios = false;

        for (Usuario usuario : usuarios) {
            if (!usuario.isEliminado()) {
                System.out.println(usuario);
                hayUsuarios = true;
            }
        }

        if (!hayUsuarios) {
            System.out.println("No hay usuarios cargados.");
        }
    }

    // Buscar por ID
    public Usuario buscarPorId(Long id){
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id) && !usuario.isEliminado()) {
                return usuario;
            }
        }

        return null;
    }

    // Buscar por Mail
    public Usuario buscarPorMail(String mail) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMail().equalsIgnoreCase(mail) && !usuario.isEliminado()) {
                return usuario;
            }
        }

        return null;
    }

    // Editar Usuario
    public boolean editarUsuario(Long id,
                                 String nombre,
                                 String apellido,
                                 String mail,
                                 String celular,
                                 String contraseña) throws MailDuplicadoException {
        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return false;
        }

        for (Usuario u : usuarios) {
            if (!u.isEliminado()
                    && !u.getId().equals(id)
                    && u.getMail().equalsIgnoreCase(mail)) {
                throw new MailDuplicadoException(mail);
            }
        }

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setMail(mail);
        usuario.setCelular(celular);
        usuario.setContraseña(contraseña);

        return true;
    }

    // Eliminar Usuario
    public boolean eliminarUsuario(Long id) {

        Usuario usuario = buscarPorId(id);

        if (usuario == null) {
            return false;
        }

        usuario.setEliminado(true);

        return true;
    }

    // Get Lista
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
