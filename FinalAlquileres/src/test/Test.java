package test;

import java.time.LocalDate;
import java.util.List;

import datos.Alquiler;
import datos.Propiedad;
import negocio.AlquilerAbm;
import negocio.PropiedadAbm;

public class Test {

	public static void main(String[] args) {
		PropiedadAbm propAbm = new PropiedadAbm();
//punto 1			
		try {
			List<Propiedad> propiedades = propAbm.traerPropiedad();
			System.out.println("\n\n1-");
			for (Propiedad propiedadActual : propiedades) {
				System.out.println(propiedadActual.toString());
			}
		} catch (Exception e) {
			e.getMessage();
		}

//punto 2		
		System.out.println("\n\n2-");
		AlquilerAbm alqAbm = new AlquilerAbm();
		try {
			// System.out.println(alqAbm.traerAlquiler(1).toString());
			Alquiler alquiler1 = alqAbm.traerAlquiler(1);
			System.out.println(alquiler1.toString());

		} catch (Exception e) {
			e.getMessage();
		}

//punto 3
		System.out.println("\n\n3-");
		try {
			List<Propiedad> propiedades = propAbm.traerPropiedad(true);
			for (Propiedad propiedadActual : propiedades) {
				System.out.println(propiedadActual.toString());
			}
		} catch (Exception e) {
			e.getMessage();
		}

//punto 4
		System.out.println("\n\n4-");
		try {
			Alquiler alquiler1 = alqAbm.traerAlquiler(1);
			System.out.println(alquiler1.getPropiedad());
			
			System.out.println(alquiler1.precioFinal());
		} catch (Exception e) {
			e.getMessage();
		}

// punto 5
		System.out.println("\n\n5-");
		try {
			LocalDate desde = LocalDate.parse("2022-03-02");
			LocalDate hasta = LocalDate.parse("2022-03-09");
			System.out.println(alqAbm.calcularPrecioFinal(desde, hasta));
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Lazy no trae con objetos anidados
	// trae automaticamente objetos por clase padre

}
