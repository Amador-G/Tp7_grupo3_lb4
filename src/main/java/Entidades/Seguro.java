package Entidades;

public class Seguro {
	int ID;
	String descripcion;
	int tipo;
	float costoContratacion;
	float costoMaximo;
	
	public Seguro() {}
	public Seguro(int i,String d,int t,float cc,float cm)
	{
		this.ID = i;
		this.descripcion = d;
		this.tipo = t;
		this.costoContratacion = cc;
		this.costoMaximo = cm;		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getCostoContratacion() {
		return costoContratacion;
	}
	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}
	public float getCostoMaximo() {
		return costoMaximo;
	}
	public void setCostoMaximo(float costoMaximo) {
		this.costoMaximo = costoMaximo;
	}
	@Override
	public String toString() {
		return ID + " " + descripcion + " " + tipo + " "+ costoContratacion + " " + costoMaximo ;
	}
	

}
