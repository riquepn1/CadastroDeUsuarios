package Model;

public class Usuario {
	private String nome;
	private String biografia;
	private String genero;
	private String curso;
	private String fase;
	private String caminhoFoto;
	private String caminhoBanner;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public String getCaminhoFoto() {
		return caminhoFoto;
	}

	public void setCaminhoFoto(String caminhoFoto) {
		this.caminhoFoto = caminhoFoto;
	}

	public String getCaminhoBanner() {
		return caminhoBanner;
	}

	public void setCaminhoBanner(String caminhoBanner) {
		this.caminhoBanner = caminhoBanner;
	}
}