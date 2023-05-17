package datos;

import java.util.Objects;

public abstract class Propiedad {
	protected int idPropiedad;
	protected double precioBase;
	protected String direccion;
	
	public Propiedad() {
	}

	public Propiedad(double precioBase, String direccion) {
		super();
		this.precioBase = precioBase;
		this.direccion = direccion;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(double precioBase) {
		this.precioBase = precioBase;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, idPropiedad, precioBase);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(direccion, other.direccion) && idPropiedad == other.idPropiedad
				&& Double.doubleToLongBits(precioBase) == Double.doubleToLongBits(other.precioBase);
	}

	@Override
	public String toString() {
		return "Propiedad [idPropiedad=" + idPropiedad + ", precioBase=" + precioBase + ", direccion=" + direccion
				+ "]";
	}
	
}
