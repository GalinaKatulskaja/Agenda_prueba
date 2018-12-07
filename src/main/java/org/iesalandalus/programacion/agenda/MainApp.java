package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

    private static final String ERROR = "ERROR! Vuelva a intentarlo";
    private static final String EXITO = "La operación se realizo con ÉXITO";
    private static Agenda agenda;
    private static Contacto contacto;
    
        public static void main(String[] args) throws OperationNotSupportedException
        {
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
        private static void ejecutarOpcion(int opcion) throws OperationNotSupportedException
        {
            switch(opcion)
            {
                case 1:
                    aniadirContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:   
                    borrarContacto();
                    break;
                case 4:
                    listarAgenda();
                    break;
                    
            }        
            
        }

    private static void aniadirContacto() throws OperationNotSupportedException
    {
        agenda = new Agenda();
        try{
            agenda.aniadir(contacto);
        
         }catch (IllegalArgumentException e) {
                    System.out.println("Operación  no soportada"+ e.getMessage());
                  
                }   
    }

    private static void buscarContacto() 
    {
        try{
        agenda.buscar(EXITO);
        }catch (IllegalArgumentException e) {
                    System.out.println("Operación  no soportada");
                    e.getMessage();
        }
        
    }

    private static void borrarContacto() throws OperationNotSupportedException {
        try{
        agenda.borrar(EXITO);
        }catch (IllegalArgumentException e) {
                    System.out.println("Operación  no soportada");
                    e.getMessage();
        }
    }

    private static void listarAgenda() {
        
        
        /*for (int i=0;i<contactos.length;i++)
        {
            if(contactos[i] !=null)
                System.out.println(contactos[i]);
        }*/
            
    }
    
}
