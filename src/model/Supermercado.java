package model;

public class Supermercado {
	
	//Estos dos son las listas enlazadas.
	private Proveedor primerProveedor;
	private Aspirante primerAspirante;
	
	//Estos dos son los arboles binarios.
	private Cliente raizCliente;
	private Gerencia raizGerencia;
	
	public Supermercado() {
		primerProveedor = null;
		primerAspirante = null;
		raizCliente = null;
		raizGerencia = null;
	}

	public Proveedor getPrimerProveedor() {
		return primerProveedor;
	}

	public Aspirante getPrimerAspirante() {
		return primerAspirante;
	}

	public Cliente getRaizCliente() {
		return raizCliente;
	}

	public Gerencia getRaizGerencia() {
		return raizGerencia;
	}
	
	

}
