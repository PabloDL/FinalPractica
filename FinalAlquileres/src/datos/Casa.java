package datos;

import java.util.Objects;

public class Casa extends Propiedad {
	private boolean tienePatio;

	public Casa() {
	}

	public Casa(double precioBase, String direccion,boolean tienePatio) {
		super(precioBase, direccion);
		this.tienePatio = tienePatio; 
	}

	public boolean isTienePatio() {
		return tienePatio;
	}

	public void setTienePatio(boolean tienePatio) {
		this.tienePatio = tienePatio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(tienePatio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casa other = (Casa) obj;
		return tienePatio == other.tienePatio;
	}

	@Override
	public String toString() {
		return super.toString() + "Casa [tienePatio=" + tienePatio + "]";
	}
	

}
