package model;

public abstract class Trabajador {
	
	private String nombre;
	private String apellido;
	private int edad;
	private String numeroDocumento;
	private int aniosExperiencia;
	
	public Trabajador(String nombre, String apellido, int edad, String numeroDocumento, int aniosExperiencia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.numeroDocumento = numeroDocumento;
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	
	

}
