package model;

public class Proveedor extends Trabajador{
	
	private String tipoProductoSolicitado;
	private String nombreEmpresaTrabaja;
	private int numeroProductosEncargados;
	
	public Proveedor(String nombre, String apellido, int edad, String numeroDocumento, int aniosExperiencia) {
		super(nombre, apellido, edad, numeroDocumento, aniosExperiencia);
	}

	public String getTipoProductoSolicitado() {
		return tipoProductoSolicitado;
	}

	public String getNombreEmpresaTrabaja() {
		return nombreEmpresaTrabaja;
	}

	public int getNumeroProductosEncargados() {
		return numeroProductosEncargados;
	}
	
	

}
