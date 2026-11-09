package Controll;

import Model.Usuario;
import Model.UsuarioRepositorio;
import View.TelaCadastro;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.io.File;

public class UsuarioControll {
    private TelaCadastro view;
    private Usuario model;
    private String caminhoFotoSelecionada;
    private String caminhoBannerSelecionado;

    public UsuarioControll(TelaCadastro view, Usuario model) {
        this.view = view;
        this.model = model;
        initController();
    }

    private void initController() {
        view.getBtnEscolherFoto().addActionListener(e -> escolherImagem(true));
        view.getBtnEscolherBanner().addActionListener(e -> escolherImagem(false));
        view.getBtnSalvar().addActionListener(e -> salvarCadastro());
    }

    private void escolherImagem(boolean ehFoto) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens (JPG, PNG)", "jpg", "png", "gif");
        chooser.setFileFilter(filter);

        int returnVal = chooser.showOpenDialog(view);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            
            if (ehFoto) {
                caminhoFotoSelecionada = file.getAbsolutePath();
                ImageIcon icon = new ImageIcon(caminhoFotoSelecionada);
                Image img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                view.getLblFotoPreview().setText("");
                view.getLblFotoPreview().setIcon(new ImageIcon(img));
            } else {
                caminhoBannerSelecionado = file.getAbsolutePath();
                ImageIcon icon = new ImageIcon(caminhoBannerSelecionado);
                Image img = icon.getImage().getScaledInstance(400, 90, Image.SCALE_SMOOTH);
                view.getLblBannerPreview().setText("");
                view.getLblBannerPreview().setIcon(new ImageIcon(img));
            }
        }
    }

    private void salvarCadastro() {
        if (view.getTxtNome().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "O campo Nome é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        model.setNome(view.getTxtNome().getText());
        model.setBiografia(view.getTxtBiografia().getText());
        model.setGenero((String) view.getCbGenero().getSelectedItem());
        model.setCurso(view.getTxtCurso().getText());
        model.setFase((String) view.getCbFase().getSelectedItem());
        model.setCaminhoFoto(caminhoFotoSelecionada);
        model.setCaminhoBanner(caminhoBannerSelecionado);

        // Salva no repositório opcional
        UsuarioRepositorio.salvar(model);

        String resumo = "Cadastro realizado com sucesso!\n\n" +
                "Nome: " + model.getNome() + "\n" +
                "Curso: " + model.getCurso() + " (" + model.getFase() + ")\n" +
                "Gênero: " + model.getGenero() + "\n" +
                "Biografia: " + model.getBiografia() + "\n" +
                "Foto: " + (model.getCaminhoFoto() != null ? "Selecionada" : "Não informada") + "\n" +
                "Banner: " + (model.getCaminhoBanner() != null ? "Selecionado" : "Não informado");

        JOptionPane.showMessageDialog(view, resumo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}