package jcolonia.daw2020.mayo;

import static java.lang.System.out;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;


public class VistaMenúGeneral {
	
	private ArrayList<Double> listopciones;
	private String[] arrayopciones;
	private Scanner sc;
	
	public VistaMenúGeneral (Scanner sc, ArrayList<Double> lista) {
		this.sc = sc;
		this.listopciones = lista;
	}
	
	public VistaMenúGeneral (Scanner sc, String[] opciones) {
		this.sc = sc;
		this.arrayopciones = opciones;
	}
	
	public int elegirOpción() {
		int n=1;
		String texto = "\n";
		if(arrayopciones!=null) {
			for(String a:arrayopciones) {
				texto += String.format(n+")%s  ", a);
				n++;
			}
			System.out.println(texto);
		}
		
		if(listopciones!=null) {
			for(Double l:listopciones) {
				texto += String.format(n+")%s  ", l);
				n++;
			}
			System.out.println(texto);
		}
		return n;
		
	}

	public int mostrarOpción() {
		int entrada = 0;
		String s;
		boolean entradaValidada = false;
		do {
			s = sc.nextLine();
			//para arraylist
			if(listopciones!=null) {
				try {
					entrada = Integer.parseInt(s);
					if (entrada < 0 || entrada > listopciones.size()) {
						throw new SumatorioNumberException();
					}
					entradaValidada = true;
				} catch (NumberFormatException e) {
					out.println("***Solo se permiten numeros enteros***");
					out.print("Introduzca una opcion valida: ");
				} catch (SumatorioNumberException e) {
					out.printf("***Por favor introduzca una opcion valida [%d-%d] %n", 1, listopciones.size());
					out.print("Introduzca una opcion valida: ");
				}
			}
			//para array
			if(arrayopciones!=null) {
				try {
					entrada = Integer.parseInt(s);
					if (entrada < 0 || entrada > arrayopciones.length) {
						throw new SumatorioNumberException();
					}
					entradaValidada = true;
				} catch (NumberFormatException e) {
					out.println("***Solo se permiten numeros enteros***");
					out.print("Introduzca una opcion valida: ");
				} catch (SumatorioNumberException e) {
					out.printf("***Por favor introduzca una opcion valida [%d-%d] %n***", 1, arrayopciones.length);
					out.print("Introduzca una opcion valida: ");
				}
			}
		
		} while (!entradaValidada);
		return entrada;
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.printf(" *** %s%n%n", mensaje);
	}
	
	public static void getNúmRespuestas() {
		
	}

}
