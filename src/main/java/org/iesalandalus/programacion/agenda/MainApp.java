package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para gestionar una agenda de contactos");
                
            int opcion;
                do 
                {
                    mostrarMenu();
                    opcion = elegirOpcion();
                    ejecutarOpcion(opcion);
                } while (opcion != 0);

                System.out.println("Fin del trabajo con Agenda!!!!");
            }
        private static void mostrarMenu() 
    {
        System.out.println("");
        System.out.println("");
        System.out.println("--------------------------------------------------");
	System.out.println("Elige la opción que desear realizar");
	System.out.println("--------------------------------------------------");
	System.out.println("");
        System.out.println("1.- Añadir contacto");
        System.out.println("2.- Buscar contacto");
        System.out.println("3.- Borrar contacto");
	System.out.println("4.- Listar Agenda");	
	System.out.println("");
	System.out.println("0.- Salir.");
	System.out.println("");
    }
        private static int elegirOpcion() 
    {
	int opcion;
	do 
        {
            System.out.println("Elige una opción (0-6): ");
            opcion = Entrada.entero();
	} while (opcion < 0 || opcion > 4);

        return opcion;
    }
        private static void ejecutarOpcion(int opcion)
        {
            switch(opcion)
            {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:   
                    
                    break;
                case 4:
                    
                    break;
                    
            }        
            
        }
}
