package Model;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public static void salvar(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public static List<Usuario> listar() {
        return listaUsuarios;
    }
}