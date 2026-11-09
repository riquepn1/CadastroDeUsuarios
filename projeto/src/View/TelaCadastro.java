package View;

import java.awt.Dimension;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class TelaCadastro extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField txtNome;
    private JTextArea txtBiografia;
    private JComboBox<String> cbGenero;
    private JTextField txtCurso;
    private JComboBox<String> cbFase;
    
    private JLabel lblFotoPreview;
    private JButton btnEscolherFoto;
    
    private JLabel lblBannerPreview;
    private JButton btnEscolherBanner;
    
    private JButton btnSalvar;

    public TelaCadastro() {
        setTitle("Cadastro de Perfil - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 750);
        getContentPane().setLayout(new MigLayout("", "[grow,fill]", "[][][][][][][][][][][]"));

        // 1. Banner (Opcional)
        getContentPane().add(new JLabel("Banner (Opcional):"), "cell 0 0");
        lblBannerPreview = new JLabel("Sem banner", JLabel.CENTER);
        lblBannerPreview.setPreferredSize(new Dimension(400, 90));
        lblBannerPreview.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(lblBannerPreview, "cell 0 1, alignx center");
        
        btnEscolherBanner = new JButton("Selecionar Banner");
        getContentPane().add(btnEscolherBanner, "cell 0 2, alignx center");

        // 2. Foto de Perfil (Opcional)
        getContentPane().add(new JLabel("Foto de Perfil (Opcional):"), "cell 0 3");
        lblFotoPreview = new JLabel("Sem foto", JLabel.CENTER);
        lblFotoPreview.setPreferredSize(new Dimension(100, 100));
        lblFotoPreview.setBorder(BorderFactory.createEtchedBorder());
        getContentPane().add(lblFotoPreview, "cell 0 4, alignx center");
        
        btnEscolherFoto = new JButton("Selecionar Foto");
        getContentPane().add(btnEscolherFoto, "cell 0 5, alignx center");

        // 3. Nome
        getContentPane().add(new JLabel("Nome:"), "cell 0 6");
        txtNome = new JTextField();
        getContentPane().add(txtNome, "cell 0 6");

        // 4. Biografia
        getContentPane().add(new JLabel("Biografia:"), "cell 0 7");
        txtBiografia = new JTextArea(4, 20);
        txtBiografia.setLineWrap(true);
        txtBiografia.setWrapStyleWord(true);
        JScrollPane scrollBio = new JScrollPane(txtBiografia);
        getContentPane().add(scrollBio, "cell 0 7");

        // 5. Gênero
        getContentPane().add(new JLabel("Gênero:"), "cell 0 8");
        cbGenero = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro", "Prefiro não informar"});
        getContentPane().add(cbGenero, "cell 0 8");

        // 6. Curso
        getContentPane().add(new JLabel("Curso:"), "cell 0 9");
        txtCurso = new JTextField();
        getContentPane().add(txtCurso, "cell 0 9");

        // 7. Fase
        getContentPane().add(new JLabel("Fase:"), "cell 0 10");
        cbFase = new JComboBox<>(new String[]{"1ª Fase", "2ª Fase", "3ª Fase", "4ª Fase", "5ª Fase", "6ª Fase", "7ª Fase", "8ª Fase", "9ª Fase", "10ª Fase"});
        getContentPane().add(cbFase, "cell 0 10");

        // Botão Salvar
        btnSalvar = new JButton("Salvar Cadastro");
        getContentPane().add(btnSalvar, "cell 0 11, alignx center, gaptop 10");
    }

    // Getters para o Controller acessar os componentes
    public JTextField getTxtNome() { return txtNome; }
    public JTextArea getTxtBiografia() { return txtBiografia; }
    public JComboBox<String> getCbGenero() { return cbGenero; }
    public JTextField getTxtCurso() { return txtCurso; }
    public JComboBox<String> getCbFase() { return cbFase; }
    public JLabel getLblFotoPreview() { return lblFotoPreview; }
    public JButton getBtnEscolherFoto() { return btnEscolherFoto; }
    public JLabel getLblBannerPreview() { return lblBannerPreview; }
    public JButton getBtnEscolherBanner() { return btnEscolherBanner; }
    public JButton getBtnSalvar() { return btnSalvar; }
}