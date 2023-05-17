package negocio;

import java.util.List;

import dao.PropiedadDao;
import datos.Alquiler;
import datos.Propiedad;

public class PropiedadAbm {
	private PropiedadDao dao = new PropiedadDao();

	public Propiedad traerPropiedad(int idPropiedad) {
		return dao.traer(idPropiedad);
	}
	
	public List<Propiedad> traerPropiedad() {
		return dao.traer();
		
	}

	public List<Propiedad> traerPropiedad(boolean tieneAscensor) {
		return dao.traer(tieneAscensor);	
	}
	
	
}
