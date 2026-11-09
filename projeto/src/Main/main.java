package Main;

import Controll.UsuarioControll;
import Model.Usuario;
import View.TelaCadastro;

import java.awt.EventQueue;

public class main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaCadastro view = new TelaCadastro();
                Usuario model = new Usuario();
                
                // Inicializa o Controller passando a View e o Model
                new UsuarioControll(view, model);
                
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}