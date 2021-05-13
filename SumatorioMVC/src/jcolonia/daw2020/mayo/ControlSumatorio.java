package jcolonia.daw2020.mayo;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Gestión de números «decimales»: recogida y visualización de la suma
 * 
 * @versión 2021.2.1
 * @author <a href="dmartin.jcolonia@gmail.com">David H. Martín</a>
 */
public class ControlSumatorio {
	/**
	 * Texto identificativo de las funciones de la aplicación que aparecerán en el
	 * menú principal.
	 */
	private static final String[] OPCIONES_MENÚ_PRINCIPAL = { "Agregar valor", "Mostrar valores", "Mostrar suma",
			"Restablecer", "SALIR" };

	/**
	 * Título de la aplicación. Se mostrará como encabezado del menú principal.
	 */
	private static final String TÍTULO_MENÚ_PRINCIPAL = "Sumatorio";

	/**
	 * Recurso asociado a la entrada estándar de la aplicación. Debe ser un objeto
	 * único a compartir con las diferentes vistas creadas.
	 */
	private Scanner sc;

    ListaNúmeros conjunto;

	private VistaMenúGeneral menúPrincipal;

	public ControlSumatorio(Scanner sc) {
		this.sc = sc;
		conjunto = new ListaNúmeros();
	}

	private void buclePrincipal() {
		menúPrincipal = new VistaMenúGeneral(sc, OPCIONES_MENÚ_PRINCIPAL);

		int entrada = -1;

		// Bucle general
		do {
		System.out.println("==========");
		System.out.println("SUMATORIO");
		System.out.println("==========");
			entrada = menúPrincipal.elegirOpción();
			
			switch (entrada) {
			case 0: // Salir
				menúPrincipal.mostrarMensaje("¡¡¡A-D-I-O-S!!");
				break;
			case 1: // Opción 1: Entrada datos
				cargarSumando();
				break;
			case 2: // Opción 2: Mostrar sumandos
				mostrarSumandos(conjunto.toListaString());
				break;
			case 3: // Opción 3: Mostrar suma
				mostrarSuma(conjunto.toString());
				break;
			case 4: // Opción 4: Reset
				restablecer();
				break;
			default: // Opción no esperada: abortar
				ejecutarGenérico(entrada);
				System.err.println("Error interno de programa - operación pendiente de desarrollo");
				System.exit(1);
			}
		} while (entrada != 0);
	}

	private void ejecutarGenérico(int id) {
		String mensaje;
		mensaje = String.format("%n  [%03d] Ha elegido la opción %d: «%s»", VistaMenúGeneral.getNúmRespuestas(), id,
				OPCIONES_MENÚ_PRINCIPAL[id - 1]);
		menúPrincipal.mostrarMensaje(mensaje);
	}
	
	private void cargarSumando() {
		VistaMenúGeneral menu = new VistaMenúGeneral(sc, conjunto.lista);
		
		System.out.println("Nuevo numero:");
		String nNumero = sc.nextLine();
	    conjunto.lista.add(nNumero);
		System.out.println("Numero guardado:\n" + nNumero.toString());
		System.out.println("-----------");
	}
	
	private void mostrarSumandos(ArrayList<String> lista) {
		if(lista.isEmpty()) {
			System.out.println("----------");
		}else {
			for (String r : lista) {
				System.out.println(r.toString()+"\n");
			}
		}
	}
	
	private void mostrarSuma(String h) {
		
	}
	
	private void restablecer() {
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ControlSumatorio control = new ControlSumatorio(sc);
		control.buclePrincipal();
		sc.close();
	}
}
