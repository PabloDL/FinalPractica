package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AlquilerDao;
import datos.Alquiler;

public class AlquilerAbm {
	private AlquilerDao dao = new AlquilerDao();

	public Alquiler traerAlquiler(int idAlquiler) {
		return dao.traer(idAlquiler);
	}
	
	public List<Alquiler> traerAlquiler() {
		return dao.traer();
	}
	
	public double calcularPrecioFinal(Alquiler alquiler) {
		return dao.traer(alquiler.getIdAlquiler()).precioFinal();
	}
	
	public List<Double> calcularPrecioFinal(LocalDate desde, LocalDate hasta) {
		List<Alquiler> alquileres = dao.traer(desde, hasta);
		List<Double> lista = new ArrayList<Double>();
		for(Alquiler alquilerActual : alquileres) {
			lista.add(alquilerActual.precioFinal());
		}
		return lista;
	}
	
//	public Map<List<Alquiler>,List<Double>> calcularPrecioFinalPorAlquiler(LocalDate desde, LocalDate hasta) {
//		List<Alquiler> alquileres = dao.traer(desde, hasta);
//		List<Double> precios = new ArrayList<Double>();
//		
//		for(Alquiler alquilerActual : alquileres) {
//			precios.add(alquilerActual.precioFinal());
//			
//		}
//		
//		Map<List<Alquiler>,List<Double>> preciosPorAlquiler = new HashMap();
//		preciosPorAlquiler.put(alquileres, precios);
//		
//		return preciosPorAlquiler;
//	}
//	
}
