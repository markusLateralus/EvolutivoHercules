package utiles.componentesDelPdf;

public enum Usuario {

	 USUARIO_PRL1 ("Tecnico de cental"),
	 USUARIO_PRL2 ("Tecnico de zona"),
	 USUARIO_PRL3 ("Responsable"),
	 USUARIO_PRL4 ("Responsable de Impresion");
	 
	public static Usuario USUARIOS[] = { USUARIO_PRL1, USUARIO_PRL2, USUARIO_PRL3, USUARIO_PRL4 };

	 
	 private String usuario;
	Usuario(String string) {
		// TODO Auto-generated constructor stub
		this.usuario=string;
	}
	
	public String getTexto() {
		return usuario;
	}
}
