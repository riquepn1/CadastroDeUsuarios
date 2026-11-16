package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaCadastroDeUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblFoto;
	private JLabel lblBanner;
	private JLabel lblBannerImage;
	private JButton btnCarregarImagemBanner;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroDeUsuarios frame = new TelaCadastroDeUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroDeUsuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][]", "[][]"));
		
		JLabel lblFotoDePerfilTXt = new JLabel("Foto de Perfil(Opcional): ");
		contentPane.add(lblFotoDePerfilTXt, "cell 0 0");
		
		lblFoto = new JLabel("Sem foto");
		lblFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		contentPane.add(lblFoto, "cell 1 0, width 120!, height 120!");
		
		JButton btnLoadImage = new JButton("Carregar Imagem");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seletor = new JFileChooser();
				seletor.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens (JPG, PNG)", "jpg", "jpeg", "png"));

				int resultado = seletor.showOpenDialog(null);

				if (resultado == JFileChooser.APPROVE_OPTION) {
				    File arquivoSelecionado = seletor.getSelectedFile();
				    
				    try {
				        BufferedImage img = ImageIO.read(arquivoSelecionado);
				        
				        Image imgAjustada = img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
				        
				        lblFoto.setText("");
				        lblFoto.setIcon(new ImageIcon(imgAjustada));
				        
				    } catch (IOException ex) {
				        JOptionPane.showMessageDialog(null, "Erro ao abrir a imagem: " + ex.getMessage());
				    }
				}
			}
		});
		contentPane.add(btnLoadImage, "cell 2 0");
		
		lblBanner = new JLabel("Banner do Perfil(Opcional):");
		contentPane.add(lblBanner, "cell 0 1");
		
		lblBannerImage = new JLabel("Sem foto");
		lblBannerImage.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBannerImage, "cell 1 1,alignx center,aligny center");
		lblBannerImage.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		contentPane.add(lblBannerImage, "cell 1 1, width 120!, height 120!");
		
		btnCarregarImagemBanner = new JButton("Carregar Imagem");
		contentPane.add(btnCarregarImagemBanner, "cell 2 1,alignx center");
		btnCarregarImagemBanner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser seletor = new JFileChooser();
				seletor.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imagens (JPG, PNG)", "jpg", "jpeg", "png"));

				int resultado = seletor.showOpenDialog(null);

				if (resultado == JFileChooser.APPROVE_OPTION) {
				    File arquivoSelecionado = seletor.getSelectedFile();
				    
				    try {
				        BufferedImage img = ImageIO.read(arquivoSelecionado);
				        
				        Image imgAjustada = img.getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
				        
				        lblBannerImage.setText("");
				        lblBannerImage.setIcon(new ImageIcon(imgAjustada));
				        
				    } catch (IOException ex) {
				        JOptionPane.showMessageDialog(null, "Erro ao abrir a imagem: " + ex.getMessage());
				    }
				}
			}
		});
	}
}
