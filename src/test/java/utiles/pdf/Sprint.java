package utiles.pdf;

public enum Sprint {

	Sprint1("Sprint 1"),
	Sprint3("Sprint 3");

	
	private String titulo;
	Sprint(String titulo) {
		// TODO Auto-generated constructor stub
		this.titulo=titulo;
	}
	
	public String getTexto() {
		return titulo;
	}
}
