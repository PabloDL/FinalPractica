package funciones;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;  

public class Funciones {
		
	public static boolean esBisiesto(int anio) {
		return ((anio % 4 == 0) && (anio % 100 != 0)) || (anio % 400 == 0); 
	}
	
	public static String traerFechaCorta(LocalDate fecha) {
		return fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
	
	public static String traerHoraCorta(LocalTime hora) {
		return hora.format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public static boolean esDiaHabil(LocalDate fecha) {
		DayOfWeek dia = fecha.getDayOfWeek();
		return dia != DayOfWeek.SUNDAY && dia != DayOfWeek.SATURDAY;
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha) {
		String dia ="";
		switch (fecha.getDayOfWeek()) {
		case MONDAY:
			dia = "Lunes";
			break;
		case TUESDAY:
			dia = "Martes";
			break;
		case WEDNESDAY:
			dia = "Miercoles";
			break;
		case THURSDAY:
			dia = "Jueves";
			break;
		case FRIDAY:
			dia = "Viernes";
			break;
		case SATURDAY:
			dia = "Sabado";
			break;
		case SUNDAY:
			dia = "Domingo";
			break;
		}
		return dia;
	}

	public static String traerMesEnLetras(LocalDate fecha) {
		String meses [] = {"Enero", "Febrero", "Marzo", "Abril", 
				"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"} ;
		
		return meses[fecha.getMonthValue()-1];
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		String dia = Funciones.traerDiaDeLaSemana(fecha);
		String mes = Funciones.traerMesEnLetras(fecha);
		return  dia + fecha.getDayOfMonth() + " de "+ mes + " del " + fecha.getYear();  
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		return LocalDate.of(anio, mes, 1).lengthOfMonth();
	}
	
	public static boolean esNumero(char c) {
		return Character.isDigit(c);
	}
	
	public static boolean esLetra(char c) {
		return Character.isAlphabetic(c);
	}
	
	public static boolean esCadenaNros(String cadena) {
		boolean esNumero = true;
		for(int i= 0; i < cadena.length()-1; i++) {
			if (! Funciones.esNumero(cadena.charAt(i))) {
				esNumero = false;
			}
		}
		return esNumero;
	}
	
	public static boolean esCadenaLetra(String cadena) {
		boolean esLetra = true;
		for(int i= 0; i < cadena.length()-1; i++) {
			if (! Funciones.esLetra(cadena.charAt(i))) {
				esLetra = false;
			}
		}
		return esLetra;
	}
	
}
