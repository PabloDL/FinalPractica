package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Alquiler {
	private int idAlquiler;
	private Propiedad propiedad;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;
	private int cantidadNoches;
	
	public Alquiler() {
	}
	
	public Alquiler(Propiedad propiedad, LocalDate fechaDesde, LocalDate fechaHasta,
			int cantidadNoches) {
		super();
		this.propiedad = propiedad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.cantidadNoches = cantidadNoches;
	}

	public int getIdAlquiler() {
		return idAlquiler;
	}

	protected void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public LocalDate getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(LocalDate fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(LocalDate fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public int getCantidadNoches() {
		return cantidadNoches;
	}

	public void setCantidadNoches(int cantidadNoches) {
		this.cantidadNoches = cantidadNoches;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cantidadNoches, fechaDesde, fechaHasta, idAlquiler, propiedad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return cantidadNoches == other.cantidadNoches && Objects.equals(fechaDesde, other.fechaDesde)
				&& Objects.equals(fechaHasta, other.fechaHasta) && idAlquiler == other.idAlquiler
				&& Objects.equals(propiedad, other.propiedad);
	}

	@Override
	public String toString() {
		return "Alquiler [idAlquiler=" + idAlquiler + ", fechaDesde=" + fechaDesde
				+ ", fechaHasta=" + fechaHasta + ", cantidadNoches=" + cantidadNoches + "]" + this.propiedad.toString();
	}

	public double precioPorNoche() {
		double precio = 0;
		
		if(this.propiedad instanceof Departamento) {
			precio = propiedad.getPrecioBase() + ((Departamento) propiedad)
					.getCantidadAmbientes() * 100;
		}
		else if(this.getPropiedad() instanceof Casa) {
			if(((Casa) propiedad).isTienePatio()) {
				precio = propiedad.getPrecioBase() * 1.1;
			}
			else{
				precio = propiedad.getPrecioBase();
			}
		}
		
		
		return precio;
	}
	
	public double precioFinal(){
		return this.precioPorNoche() * cantidadNoches;
	}
	
}
